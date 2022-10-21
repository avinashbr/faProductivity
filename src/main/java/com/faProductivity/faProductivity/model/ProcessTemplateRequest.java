package com.faProductivity.faProductivity.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProcessTemplateRequest {

	@NotBlank
	private String templateName;
}
