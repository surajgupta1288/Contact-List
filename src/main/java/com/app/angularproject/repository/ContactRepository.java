package com.app.angularproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.angularproject.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
