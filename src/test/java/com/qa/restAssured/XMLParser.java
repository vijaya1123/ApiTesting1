package com.qa.restAssured;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class XMLParser {
 
	@Test
    public void testXmlParsing() {
 
        try {
 
            //Create a DocumentBuilder
            File inputFile = new File("src/test/resources/testData/test.xml");
            System.out.println("Request :" + inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
 
            //Extract the root element
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
            NodeList nodeList = doc.getElementsByTagName("employee");
            System.out.println("Node Length :" + nodeList.getLength());
 
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
 
                Node node = nodeList.item(temp);
                System.out.println("\nCurrent Element :" + node.getNodeName());
 
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
 
                    //returns specific attribute
                    System.out.println("Employee Id : " + eElement.getAttribute("id"));
 
                    //returns a list of subelements of specified name
                    System.out.println("First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Salary: " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println("Age: " + eElement.getElementsByTagName("age").item(0).getTextContent());
 
                }
            }
 
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
 
}