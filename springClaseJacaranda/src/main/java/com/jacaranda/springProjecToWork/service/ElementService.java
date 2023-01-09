package com.jacaranda.springProjecToWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jacaranda.springProjecToWork.model.Element;
import com.jacaranda.springProjecToWork.repository.ElementRepository;

@Service
public class ElementService {
	@Autowired
	private ElementRepository repository;
	
	public Element add(Element s) {
		return repository.save(s);
	}

	public Page<Element> findAll(int pageNum, int pageSize){
		Pageable pageable = PageRequest.of(pageNum -1, pageSize);
		return repository.findAll(pageable);
	}

	public Element findById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Element save(Element e) {
		return repository.save(e);
	}

	public void delete(Element e) {
		repository.delete(e);
	}
}
