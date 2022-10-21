package com.faProductivity.faProductivity.util;


public class Utility {
	
	public static String findRequiredValueFromPattern(String template,int startIndex,String stopPatternName) {
		String[] templates=template.split("\\s+");	
		StringBuilder customerName=new StringBuilder();
		customerName.append(templates[startIndex]);		
		int i=startIndex+1;
			while(!stopPatternName.equalsIgnoreCase(templates[i])) {
				customerName.append(" "+templates[i]);
				i++;
			}
		
		return customerName.toString();
	}

}
