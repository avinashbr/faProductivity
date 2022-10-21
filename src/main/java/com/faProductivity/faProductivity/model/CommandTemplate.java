package com.faProductivity.faProductivity.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "Command_Template")
public class CommandTemplate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;	
	@Column(name="template_Name")
	private String templateName;
	@Column(name="regex")
	private String regex;

}
