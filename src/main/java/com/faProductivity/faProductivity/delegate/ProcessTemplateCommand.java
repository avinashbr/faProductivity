package com.faProductivity.faProductivity.delegate;

import com.faProductivity.faProductivity.model.ProcessTemplateRequest;

public interface ProcessTemplateCommand {

	public String executeTemplateCommand(ProcessTemplateRequest request);
}
