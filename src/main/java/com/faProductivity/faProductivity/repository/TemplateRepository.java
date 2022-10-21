package com.faProductivity.faProductivity.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faProductivity.faProductivity.model.CommandTemplate;  

@Repository
public interface TemplateRepository extends JpaRepository<CommandTemplate,Integer>  {

	
}
