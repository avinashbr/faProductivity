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

@Component
@Slf4j
public class AccountBalanceTemplate implements ProcessTemplateCommand {

	@Autowired
	private CommandTemplateService commandTemplateService;
	
	@Override
	public String executeTemplateCommand(ProcessTemplateRequest request) {
		log.info("Inside AccountBalanceTemplate::executeTemplateCommand");
		String customerName=Utility.findRequiredValueFromPattern(request.getTemplateName(),5,"savings");
		log.info("customer name is : "+customerName);		
		Account account=commandTemplateService.findAccountByCustomerName(customerName);
		if(account!=null) {
			return "Balance for "+customerName + " is : "+account.getAccountValue() +"$";
		}else {
			throw new AccountNotFoundException("account details not found for customer : "+customerName);
		}
		
	}
	
}
