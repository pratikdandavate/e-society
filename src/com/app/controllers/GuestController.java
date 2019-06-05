package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.GuestService;
import com.app.service.SocietyService;

@Controller
@RequestMapping("/guest")
public class GuestController {
	@Autowired
	private GuestService service;
	
	public GuestController() {
	System.out.println("in guest constr");
	}
	
	
	@GetMapping("/sellHouse")
	public String showSellHouse(Model map) {
		System.out.println("in sell house");
		map.addAttribute("sellHouse",service.fetchSellHouse());
		System.out.println(service.fetchSellHouse());
		return "/guest/sellHouse";
	}
	
	@GetMapping("/rentHouse")
	public String showRentHouse(Model map) {
		System.out.println("in sell house");
		map.addAttribute("rentHouse",service.fetchRentHouse());
		System.out.println(service.fetchSellHouse());
		return "/guest/rentHouse";
	}
	
	@GetMapping("/view")
	public String viewRentHouse(Model map,@RequestParam int id)
	{
		System.out.println("in view");
		map.addAttribute("views",service.fetchRentHouseByID(id));
		return "/guest/view";
	}
	
	
	
	
	
}










