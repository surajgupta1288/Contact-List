package com.app.angularproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.angularproject.model.Contact;
import com.app.angularproject.services.ContactService;
@RestController
public class ContactRestController {

	@Autowired  
	ContactService contactService;  


	@GetMapping("/contact")  
	private List<Contact> getAllContact()   
	{  
	return contactService.getAllContact();  
	}

	@GetMapping("/contact/{id}")  
	private Contact getContact(@PathVariable("id") int id)   
	{  
	return contactService.getContactById(id);  
	}  



	@PostMapping("/contact")  
	private Contact saveTicket(@RequestBody Contact contact)    
		{  
		Contact message = null;
	        try {
	            message = contactService.saveOrUpdate(contact);
	        } catch (Exception e) {
	         message = new Contact();
	        }
	    return message;
	    }  


	@PutMapping("/contact")  
	private Contact update(@RequestBody Contact contact)   
	{  
		contactService.saveOrUpdate(contact);   
	return contact;  
	}  

	@DeleteMapping("/deletecontact/{id}")  
	private void deleteBook(@PathVariable("id") int id)   
	{  
		contactService.delete(id);
	}
}
