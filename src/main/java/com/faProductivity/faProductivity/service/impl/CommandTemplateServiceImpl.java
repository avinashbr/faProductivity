package com.faProductivity.faProductivity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faProductivity.faProductivity.exception.TemplateNotFoundException;
import com.faProductivity.faProductivity.model.CommandTemplate;
import com.faProductivity.faProductivity.model.ProcessTemplateRequest;
import com.faProductivity.faProductivity.repository.TemplateRepository;
import com.faProductivity.faProductivity.service.CommandTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandTemplateServiceImpl implements CommandTemplateService {
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Override
	public ResponseEntity<List<CommandTemplate>> listCommandTemplates() {
	
		return new ResponseEntity(templateRepository.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> processTemplate(ProcessTemplateRequest request) {
		log.info("input template is : "+request.getTemplateName());
		boolean isAnyTemplateMatched=false;
		for(CommandTemplate template : templateRepository.findAll()) {
			if(isTemplateMatched(request.getTemplateName(),template.getRegex())) {
				isAnyTemplateMatched=true;
			}
		}
		if(!isAnyTemplateMatched) {
			throw new TemplateNotFoundException("required template not found");
		}
		return new ResponseEntity(request,HttpStatus.OK);
		
	}
	
	private boolean isTemplateMatched(String templateName,String regex) {
		String[] patterns=regex.split("\\s+");		
		for(String pattern : patterns) {
			//log.info("pattern : "+patterns);
			if(!templateName.contains(pattern)) return false;
		}		
		return true;		
	}



}
