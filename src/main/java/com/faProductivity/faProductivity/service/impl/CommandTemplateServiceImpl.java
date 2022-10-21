package com.faProductivity.faProductivity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faProductivity.faProductivity.delegate.ProcessTemplateCommand;
import com.faProductivity.faProductivity.exception.AccountNotFoundException;
import com.faProductivity.faProductivity.exception.TemplateNotFoundException;
import com.faProductivity.faProductivity.model.Account;
import com.faProductivity.faProductivity.model.CommandTemplate;
import com.faProductivity.faProductivity.model.ProcessTemplateRequest;
import com.faProductivity.faProductivity.model.ProcessTemplateResponse;
import com.faProductivity.faProductivity.repository.AccountRepository;
import com.faProductivity.faProductivity.repository.TemplateRepository;
import com.faProductivity.faProductivity.service.CommandTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandTemplateServiceImpl implements CommandTemplateService {
	
	@Autowired
	private TemplateRepository templateRepository;
	@Autowired
	private AccountRepository accountRepository;	
	
	@Autowired
	private ApplicationContext context;
	
	@Override
	public ResponseEntity<List<CommandTemplate>> listCommandTemplates() {
	
		return new ResponseEntity(templateRepository.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProcessTemplateResponse> processTemplate(ProcessTemplateRequest request) {
		log.info("input template is : "+request.getTemplateName());
		boolean isAnyTemplateMatched=false;
		CommandTemplate matchedTemplate=null;
		for(CommandTemplate template : templateRepository.findAll()) {
			if(isTemplateMatched(request.getTemplateName(),template.getRegex())) {
				isAnyTemplateMatched=true;
				matchedTemplate=template;
				break;
			}
		}
		if(!isAnyTemplateMatched) {
			throw new TemplateNotFoundException("required template not found");
		}	
		if(null==matchedTemplate.getBeanName()) {
			ProcessTemplateResponse response=new ProcessTemplateResponse();
			response.setStatusMessage("Not Implemented");
			return new ResponseEntity(response,HttpStatus.OK);
		}
		
		ProcessTemplateCommand processTemplateCommand=context.getBean(matchedTemplate.getBeanName(), ProcessTemplateCommand.class);
		String message=processTemplateCommand.executeTemplateCommand(request);
		ProcessTemplateResponse response=new ProcessTemplateResponse();
		response.setStatusMessage(message);
		return new ResponseEntity(response,HttpStatus.OK);
		
	}
	
	private boolean isTemplateMatched(String templateName,String regex) {
		String[] patterns=regex.split("\\s+");		
		for(String pattern : patterns) {
			//log.info("pattern : "+patterns);
			if(!templateName.contains(pattern)) return false;
		}		
		return true;		
	}
	
	public Account findAccountByCustomerName(String customerName) {
		Optional<Account> account=accountRepository.findByCustomerNameContainingIgnoreCase(customerName);
		if(account.isPresent()) {
			return account.get();
		}else {
			return null;
		}
	}



}
