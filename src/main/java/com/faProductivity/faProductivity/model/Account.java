package com.faProductivity.faProductivity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	private int accountNumber;	
	private String customerName;	
	private int accountValue;
	

}
