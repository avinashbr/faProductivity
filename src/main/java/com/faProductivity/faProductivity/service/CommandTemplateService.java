package com.faProductivity.faProductivity.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faProductivity.faProductivity.model.CommandTemplate;
import com.faProductivity.faProductivity.model.ProcessTemplateRequest;

public interface CommandTemplateService {

	public ResponseEntity<List<CommandTemplate>> listCommandTemplates();

	public ResponseEntity<String> processTemplate(ProcessTemplateRequest request);


}
