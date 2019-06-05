package com.app.controllers;

import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.UserService;

import pojos.ComplainList;
import pojos.UserList;
import utils.PasswordUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	public UserController() {
		System.out.println("user cnstr");
	}
	
	@GetMapping("/login")
	public String showLogin(Model map) {
		System.out.println("in login");
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String processlogin(Model map,@RequestParam String userName,
			@RequestParam String password,HttpSession hs)
	{
		UserList u=null;
		System.out.println("in process login");
		try{
			u=service.getUserEntity(userName);
		}
		catch(RuntimeException e)
		{
			System.out.println("err in process form "+e);
			map.addAttribute("error","Invalid login , pls retry");
			return "/user/login";
		}
//		String hashedPassword=null;
//		//Hashing Password for match:
//		try {
//			hashedPassword=PasswordUtils.hashPassword(password);
//		} catch (NoSuchAlgorithmException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		// Here we perform authentication business logic
        // If authentication fails, we throw new AuthenticationException
        // other wise we return UserProfile Details
        String secureUserPassword = null;
        try {
            secureUserPassword = PasswordUtils.
                    generateSecurePassword(password, u.getSalt());
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//            throw new AuthenticationException(ex.getLocalizedMessage());
        }
        boolean authenticated = false;
        if (secureUserPassword != null && secureUserPassword.equalsIgnoreCase(u.getPassword())) {
            if (userName != null && userName.equalsIgnoreCase(u.getUserName())) {
                authenticated = true;
            }
        }
        if (!authenticated) {
//          throw new AuthenticationException("Authentication failed");
        	map.addAttribute("error","Invalid login , pls retry");
			return "/user/login";
		}

		hs.setAttribute("msg","successful login");
		hs.setAttribute("user",u);
		return "/user/home";
		
	}
	
	@GetMapping("/home")
	public String adminHome(Model map) {
		System.out.println("in login");
		return "/user/home";
	}
	
	@PostMapping("/rentHouse")
	public String rentHouse(Model map,@RequestParam int rentPrice,@RequestParam int rentId)
	{
		System.out.println("in rent house");
		service.getHouseById(rentId,rentPrice);
		map.addAttribute("success","House posted for Rent!");
		return "user/home";
	}

	@PostMapping("/sellHouse")
	public String sellHouse(Model map,@RequestParam int rentPrice,@RequestParam int rentId)
	{
		System.out.println("in rent house");
		service.sellHouse(rentId,rentPrice);
		map.addAttribute("success","House posted for Sell!");
		return "user/home";
	}
	
	@GetMapping("/makeComplaint")
	public String makeComplaint(Model map)
	{
		System.out.println("in make complaint");
		return "user/makeComplaint";
	}

	@GetMapping("/myComplaint")
	public String myComplaint(Model map,@RequestParam int id)
	{
		System.out.println("in my complaint");
		
		map.addAttribute("complaint",service.getComplaintById(id));
		return "user/myComplaint";
	}
	

	@PostMapping("/makeComplaint")
	public String addComplaint(Model map,@RequestParam String subject,
			@RequestParam int userid,
			@RequestParam String complaint)
	{
		System.out.println("in add complaint");
		ComplainList c=new ComplainList(subject, complaint, null, "pending", new Date());
		String s=service.makeComplaint(c,userid);
		map.addAttribute("complaint",s);
		map.addAttribute("success","Complaint raised !!");
		return "user/home";
	}
	
	@GetMapping("/logout")
	public String logMeOut(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("in logout method");
		//retrieve user dtls from sesion scope & add it to model
		map.addAttribute("user_dtls",hs.getAttribute("user_dtls"));
		//discard session
		hs.invalidate();
		response.setHeader("refresh", "2;url="+request.getContextPath());
			
		return "/user/logout";
	}

}
