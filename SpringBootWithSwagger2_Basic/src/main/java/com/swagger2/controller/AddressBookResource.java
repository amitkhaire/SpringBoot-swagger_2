package com.swagger2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger2.model.Contact;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

	// this is in memory data will store
	ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();
	
	@GetMapping("/{id}")
	@ApiOperation(value = "find by contact id",
	notes = "providec an id to look up specific contact from the addres book",
	response = Contact.class)
	public Contact getContact(@ApiParam(value = "ID value for contact you nedd to return",required = true) @PathVariable String id) {
       return contacts.get(id);
	}

	@GetMapping("/")
	public List<Contact> getAllContact(){
      return new ArrayList<Contact>(contacts.values());
	}
//http://localhost:8080/
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}
	
	/*
	 * Post request addContact //http://localhost:8080/ { "id":"102",
	 * "name":"shamal", "addres":"osmanabad" }
	 */

	/*
	 * Get method getListOfcontact http://localhost:8080/ [ { "id": "101", "name":
	 * "Deepak", "addres": null }, { "id": "102", "name": "shamal", "addres":
	 * "osmanabad" } ]
	 */

	
	/*
	 * get specific ID http://localhost:8080/101 { "id": "101", "name": "Deepak",
	 * "addres": null }
	 */
}
