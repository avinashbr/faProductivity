package com.faProductivity.faProductivity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faProductivity.faProductivity.model.CommandTemplate;
import com.faProductivity.faProductivity.model.ProcessTemplateRequest;
import com.faProductivity.faProductivity.service.CommandTemplateService;

@RestController
@CrossOrigin
@RequestMapping("/command")

public class CommandTemplateController {
	
	@Autowired
	private CommandTemplateService commandTemplateService;
	
	@PostMapping(value="/listTemplates")
	public ResponseEntity<List<CommandTemplate>> listCommandTemplates() {		
		return commandTemplateService.listCommandTemplates();		
		
	}
	
	@PostMapping(value="/processTemplate")
	public ResponseEntity<String> processTemplate(@Valid @RequestBody ProcessTemplateRequest request) {		
		 return commandTemplateService.processTemplate(request);
		
		
	}

}
