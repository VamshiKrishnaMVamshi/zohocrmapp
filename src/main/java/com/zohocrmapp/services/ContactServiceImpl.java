package com.zohocrmapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.repositories.ContactsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactsRepository contactsRepo;

	@Override
	public void saveContact(Contacts contact) {
		contactsRepo.save(contact);
	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactsRepo.findAll();
		return contacts;
	}

	@Override
	public Contacts getContactById(long id) {
		Contacts contact = contactsRepo.findById(id).get();
		return contact;
	}

}
