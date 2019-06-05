package com.app.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.SocietyService;

import pojos.ComplainList;
import pojos.HouseList;
import pojos.SocietyList;
import pojos.UserList;
import utils.PasswordUtils;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final byte[] NULL = null;
	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);
	static int id=1;
	
	@Autowired
	private SocietyService service;
	
	public AdminController() {
		System.out.println("hello cnstr");
	}
	
	@GetMapping("/login")
	public String showLogin(Model map) {
		System.out.println("in login");
		return "/admin/login";
	}
	
	@GetMapping("/home")
	public String adminHome(Model map) {
		System.out.println("in login");
		return "/admin/home";
	}
	
	@PostMapping("/login")
	public String processlogin(Model map,@RequestParam String userName,
			@RequestParam String password,HttpSession hs)
	{
		UserList u=null;
//		String hashedPassword=null;
//		//Hashing Password for match:
//		try {
//			hashedPassword=PasswordUtils.hashPassword(password);
//		} catch (NoSuchAlgorithmException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		System.out.println("in process login");
		try{
			u=service.getUserEntity(userName);
		}
		catch(RuntimeException e)
		{
			System.out.println("err in process form "+e);
			map.addAttribute("error","Invalid login , pls retry");
			return "/admin/login";
		}
		   String secureUserPassword = null;
	        try {
	            secureUserPassword = PasswordUtils.
	                    generateSecurePassword(password, u.getSalt());
	        } catch (Exception ex) {
	        	java.util.logging.Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
//	            throw new AuthenticationException(ex.getLocalizedMessage());
	        }
	        boolean authenticated = false;
	        if (secureUserPassword != null && secureUserPassword.equalsIgnoreCase(u.getPassword())) {
	            if (userName != null && userName.equalsIgnoreCase(u.getUserName())) {
	                authenticated = true;
	            }
	        }
	        if (!authenticated) {
//	          throw new AuthenticationException("Authentication failed");
	        	map.addAttribute("error","Invalid login , pls retry");
				return "/user/login";
			}
		hs.setAttribute("msg","successful login");
		hs.setAttribute("myadmin",u);
		return "/admin/home";
		
	}


	@GetMapping("/addSociety")
	public String SocietyRegister(SocietyList c,Model map)
	{
		map.addAttribute("societylist", c);
		System.out.println("in add Society");
		return "admin/addSociety";
	}
	
/*	@PostMapping("/addSociety")
	public String processsRegForm(SocietyList v,Model map) {// populated
																			// POJO
																			// directly
		System.out.println("in process reg " + v);
		try {
			
			//System.out.println("I am kiran"+service.AddSociety(v));
			map.addAttribute("societylist", service.AddSociety(v));
			
		} catch (RuntimeException e) {
			System.out.println("err in add " + e);
			map.addAttribute("error", "Society registration failed!");
			//flashMap.addFlashAttribute("status", "Vendor registration Failed : " + e.getMessage());
			return "/admin/addSociety";
		}
		map.addAttribute("success","Society added successfully!");
		return "/admin/home";
	}
*/
	@PostMapping("/addSociety")
	public String processsRegForm(@RequestParam String societyName,@RequestParam String address,
			@RequestParam String city, @RequestParam String pinCode, @RequestParam Integer noOfhouse,
			@RequestParam String entryDate,Model map ) throws ParseException 
	{
		
		System.out.println("in process reg ");
		if(societyName.equals("") || address.equals("") || city.equals("") || pinCode.equals("")  || noOfhouse.equals("") ||
				entryDate.equals(""))
		{
			map.addAttribute("societyerror", "Fill All Details");
			return "/admin/addSociety";
		}
		if(pinCode.length()!=6)
		{
			map.addAttribute("pinerror", "Length must be 6");
			return "/admin/addSociety";
		}
		try {
			//Integer noHouse=Integer.parseInt(noOfhouse);
			Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(entryDate);
			SocietyList s=new SocietyList(societyName, address, city, pinCode, noOfhouse, null, date1);
			map.addAttribute("societylist", service.AddSociety(s));
			
			
		} catch (RuntimeException e) {
			System.out.println("err in add " + e);
			//flashMap.addFlashAttribute("status", "Vendor registration Failed : " + e.getMessage());
			return "/admin/addSociety";
		}
		map.addAttribute("success", "Society Added Sucessfully..");
		return "/admin/home";
	}

	@GetMapping("/addHouse")
	public String fetchSociety(Model ms,HttpSession hs) {
		System.out.println("in show process form ");
		ms.addAttribute("society_details", service.getSociety());
		hs.setAttribute("society", service.getSociety());
		return "/admin/addHouse";
	}

	@PostMapping("/addHouse")
	public String addHouse(Model map,@RequestParam String sname,@RequestParam Integer blockno,@RequestParam String houseType,
			@RequestParam String details,HttpSession hs) {
	try{
		System.out.println("in society details ");
		HouseList h=new HouseList(blockno, houseType, details, sname, new Date());
		service.AddHouse(sname,h);
		map.addAttribute("success","House added successfully!");
		return "/admin/home";
	}
	catch(Exception e)
	{
		map.addAttribute("error","All fields are mandatory");
		return "redirect:/admin/addHouse";
	}
	}
	
	@GetMapping("/addUser1")
	public String addUser(Model ms,HttpSession hs) {
		System.out.println("in add user form ");
		ms.addAttribute("society_details", service.getSociety());
		//hs.setAttribute("society_details", service.getSociety());
		//return "/admin/selectmenu";
		return "/admin/addUser1";
	}
	
	@PostMapping("/addUser1")
	public String getUser(Model ms,HttpSession hs,RedirectAttributes flashmap,
			@RequestParam String firstName,@RequestParam String lastName,
			@RequestParam String email,@RequestParam String mobileNo,
			@RequestParam String birthDate,@RequestParam int totalMember,
			@RequestParam String societyName,@RequestParam String houseId,
			@RequestParam MultipartFile uploadImage,
			@RequestParam String userName,@RequestParam String password){
		
		System.out.println("in get user form ");
		String hashedPassword=null;
	    // Generate secure user password 
        String secureUserPassword = null;
        // Generate salt
        String salt = null;
		//Hashing Password for match:
		try {
			if(societyName.equals("-1") || houseId.equals("-1"))
			{
				//ms.addAttribute("mandatory", "Fill All the details");
				flashmap.addFlashAttribute("mandatory", "Fill All the details");
				return "redirect:/admin/addUser1";
			}
		    salt = PasswordUtils.getSalt(30);
	        	    
	        secureUserPassword = PasswordUtils.generateSecurePassword(password, salt);
	       
			System.out.println(secureUserPassword);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ms.addAttribute("error","Failed to allocate user");
			return "/admin/addUser1";
		}
		MultipartFile file = uploadImage;
		//Upload Code here
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				String path = this.getClass().getClassLoader().getResource("").getPath();
				
				String fullPath = URLDecoder.decode(path, "UTF-8");
				String pathArr[] = fullPath.split("/WEB-INF/classes/");
				System.out.println(fullPath);
				System.out.println(pathArr[0]);
				fullPath = pathArr[0];
				File dirsmall = new File(fullPath + File.separator + "resource/img");
				//System.out.println(dirsmall);
				if (!dirsmall.exists())
					dirsmall.mkdirs();

				// Create the file on serve
				File serverFileSmall = new File(dirsmall.getAbsolutePath()
						+ File.separator +firstName+".jpg");
				
				BufferedOutputStream streamSmall = new BufferedOutputStream(
						new FileOutputStream(serverFileSmall));
				
				
				streamSmall.write(bytes);
				streamSmall.close();
				
				logger.info("Server File Location="
						+ serverFileSmall.getAbsolutePath());
			} catch (Exception e) {
				return "You failed to upload " + societyName+".jpg" + " => " + e.getMessage();
			}
		} else {
			return "redirect:/admin/home";
		}
		
		//Upload Code ends here

		
		UserList u=new UserList(firstName, lastName, email, mobileNo, new Date(), 
				societyName, totalMember,firstName+".jpg", userName, secureUserPassword, new Date(),"N");
		u.setSalt(salt);
		System.out.println(u);
		int id=Integer.parseInt(houseId);
	    service.AddUser(u,id);
	    ms.addAttribute("success","User allocated successfully!");
		return "/admin/home";
	}
	
	@GetMapping("/selectmenu")
	public @ResponseBody List<Integer> showDropdownbrand(@RequestParam String name,
			Model ms, HttpSession hs)
	{
		System.out.println("in dropdown manufacturer ");
		//System.out.println(service.getHouseBySocietyName(name));
		System.out.println("after fetched");
		//ms.addAttribute("house_list", service.getHouseNoBySocietyName(name));
		System.out.println("after model");
		
		return service.getHouseNoBySocietyName(name);
	}
	
	
	@GetMapping("/houseReport")
	public String houseReport(Model ms)
	{
		System.out.println("in house report");
		ms.addAttribute("society_details", service.getSociety());
		return "/admin/houseReport";
	}
	
	@PostMapping("/houseReport")
	public String processHouse(Model ms,@RequestParam String societyName)
	{
		
		List<HouseList> hs=service.getHouseBySocietyName(societyName);
		if(!hs.isEmpty())
		{
		ms.addAttribute("houseList",service.getHouseBySocietyName(societyName));
		ms.addAttribute("society_details", service.getSociety());
		}
		else{
		ms.addAttribute("houseList","No record found!!");		
		}
		
		return "admin/houseReport";
	}

	
	@GetMapping("/newComplain")
	public String newComplain(Model ms)
	{
			List<ComplainList> u=service.fetchComplaints();
			if(u.isEmpty())
			{
				ms.addAttribute("no_record", "No complaint found");
			}
			ms.addAttribute("complaints",service.fetchComplaints());
            System.out.println("in new complain");
		
		return "admin/newComplain";
	}

	@GetMapping("/reply")
	public String replyComplaint(Model ms,@RequestParam int id,HttpSession hs)
	{
			ComplainList cs=service.fetchComplaintById(id);
			hs.setAttribute("complaintById", cs);
			System.out.println("in reply complain");
			
		return "admin/replyComplain";
	}
	
	@PostMapping("/reply")
	public String replyComplaintToUser(Model ms,@RequestParam String reply,@RequestParam int id)
	{
		System.out.println("in reply ");
		ms.addAttribute("success", "Complaint solved");
		service.updateComplaint(reply,id);
		return "redirect:/admin/newComplain";
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
			
		return "/admin/logout";
	}

}
