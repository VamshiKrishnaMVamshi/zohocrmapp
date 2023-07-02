package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.services.ContactService;

@Controller
public class ContactController {
	
	private ContactService contactService;
	
	
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}


	@GetMapping("/listAllContacts")
	public String listAllLeads(Model model) {
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "list_all_contacts";
	}
	
	@RequestMapping("/contactInfo")
	public String contactInfo(@RequestParam("id")long id, Model model) {
		Contacts contact = contactService.getContactById(id);
		model.addAttribute("contact",contact);
		return "contact_info";
		
	}
}
