package com.qa.restAssured;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
 
public class ChildNodes {
 
    public static void main(String[] args) {

        try {
            //Create a DocumentBuilder
            File inputFile = new File("src/test/resources/testData/test1.xml");
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
 
                NodeList childNodes = node.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node childNode = childNodes.item(i);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println("Child node name " + i + ":" + childNode.getNodeName());
                        System.out.println("Child node value: " + i + ":" + childNode.getTextContent());
 
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
 
    }
}