package com.qa.restAssured;



import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class  DeserilisationTest{

@Test
public void deserializationTest()  {
 
    String employeeString = "{\r\n"
            + "  \"firstName\" : \"Deserialization\",\r\n"
            + "  \"lastName\" : \"Test\",\r\n"
            + "  \"age\" : 30,\r\n"
            + "  \"salary\" : 75000.0,\r\n"
            + "  \"designation\" : \"Manager\",\r\n"
            + "  \"contactNumber\" : \"+919999988822\",\r\n"
            + "  \"emailId\" : \"abc@test.com\",\r\n"
            + "  \"gender\" : \"female\",\r\n"
            + "  \"maritalStatus\" : \"married\"\r\n"
            + " }";
     
 
    // Converting a JSON Payload to a JAVA Object
    ObjectMapper mapper = new ObjectMapper();
    Employee employee2 = null;
 
    try {
        employee2 = mapper.readValue(employeeString, Employee.class);
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
 
    System.out.println("First Name of employee : " + employee2.getFirstName());
    System.out.println("Last Name of employee : " + employee2.getLastName());
    System.out.println("Age of employee : " + employee2.getAge());
    System.out.println("Salary of employee : " + employee2.getSalary());
    System.out.println("Designation of employee : " + employee2.getDesignation());
    System.out.println("Contact Number of employee : " + employee2.getContactNumber());
    System.out.println("EmailId of employee : " + employee2.getEmailId());
    System.out.println("Marital Status of employee : " + employee2.getMaritalStatus());
    System.out.println("Gender of employee : " + employee2.getGender());
 
}}