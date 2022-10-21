package com.faProductivity.faProductivity.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faProductivity.faProductivity.model.Account;
import com.faProductivity.faProductivity.model.CommandTemplate;
import com.faProductivity.faProductivity.model.ProcessTemplateRequest;
import com.faProductivity.faProductivity.model.ProcessTemplateResponse;

public interface CommandTemplateService {

	public ResponseEntity<List<CommandTemplate>> listCommandTemplates();

	public ResponseEntity<ProcessTemplateResponse> processTemplate(ProcessTemplateRequest request);
	
	public Account findAccountByCustomerName(String customerName);


}
