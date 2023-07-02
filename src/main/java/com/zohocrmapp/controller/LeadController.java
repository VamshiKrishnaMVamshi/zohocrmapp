package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	//http://localhost:8080/zohocrmapp/viewCreateLead
	@GetMapping("/viewCreateLead")
	public String createNewLead() {
		return "create_lead";
	}
	
	@PostMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead") Lead lead, Model model) {
		leadService.saveLed(lead);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
	
	@PostMapping("/convertLead")
	public String convertLead(@RequestParam ("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		Contacts contact = new Contacts();
		contact.setEmail(lead.getEmail());
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContact(contact);
		leadService.deleteLeadById(id);
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "list_all_contacts";
	}
	
	//http://localhost:8080/zohocrmapp/listAllLeads
	@GetMapping("/listAllLeads")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "list_all_leads";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
	
}
