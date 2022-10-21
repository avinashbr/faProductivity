package com.faProductivity.faProductivity.delegate.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faProductivity.faProductivity.delegate.ProcessTemplateCommand;
import com.faProductivity.faProductivity.exception.AccountNotFoundException;
import com.faProductivity.faProductivity.model.Account;
import com.faProductivity.faProductivity.model.ProcessTemplateRequest;
import com.faProductivity.faProductivity.service.CommandTemplateService;
import com.faProductivity.faProductivity.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientManagementTemplate implements ProcessTemplateCommand{

	@Autowired
	private CommandTemplateService commandTemplateService;
	
	@Override
	public String executeTemplateCommand(ProcessTemplateRequest request) {
		log.info("Inside ClientManagementTemplate::executeTemplateCommand");
		String customerName=Utility.findRequiredValueFromPattern(request.getTemplateName(),1,"profile");
		log.info("customer name is : "+customerName);
		Account account=commandTemplateService.findAccountByCustomerName(customerName);
		if(account!=null) {
			return "client link url for customer "+customerName + " is <a>www.clientlink.com</a>";
		}else {
			throw new AccountNotFoundException("account details not found for customer : "+customerName);
		}
	}

}
