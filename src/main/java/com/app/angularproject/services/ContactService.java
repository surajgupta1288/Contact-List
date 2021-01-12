package com.app.angularproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.angularproject.model.Contact;
import com.app.angularproject.repository.ContactRepository;



@Service
public class ContactService {

	@Autowired  ContactRepository contactRepository;  

	public List<Contact> getAllContact()   
	{  
	List<Contact> contact = new ArrayList<Contact>();  
	contactRepository.findAll().forEach(contact1 -> contact.add(contact1));  
	return contact;  
	}  

	public Contact getContactById(int id)   
	{  
	return contactRepository.findById(id).get();  
	}  
	  
	public Contact saveOrUpdate(Contact contact)   
	{  
		return contactRepository.save(contact);  
	} 
	  
	public void update(Contact contact, int id)   
	{  
		contactRepository.save(contact);  
	}

	public void delete(int id)   
	{  
		contactRepository.deleteById(id);  
	}
	
}
