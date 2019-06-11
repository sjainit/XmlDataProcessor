package com.companyname.data.service;
import java.util.TreeMap;

import javax.lang.model.element.Element;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.companyname.domain.XmlNode;

public class XmlParserService {
	
	public static void convertXMLToJavaObject(Document doc)
	{
		
		TreeMap<Integer,Object> hmap = new TreeMap<>();		
		NodeList nodeList = doc.getChildNodes();
		for(int i=0; i<childNodes.getLength();i++){
			doSomething(childNodes.item(i));
		}               
	}
	
//	public static void doSomething(Node node) {
//	    // do something with the current node instead of System.out
//	    System.out.println(node.getNodeName());
//	    System.out.println(node.getNodeValue());
//
//	    NodeList nodeList = node.getChildNodes();
//	    for (int i = 0; i < nodeList.getLength(); i++) {
//	        Node currentNode = nodeList.item(i);
//	        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
//	            //calls this method for all the children which is Element
//	            //doSomething(currentNode);
//	        }
//	    }
	
	public static Element getParent(Document xmlDoc)
	{
		Element element = null;

	    NodeList list = xmlDoc.getChildNodes();
	    for (int i = 0; i < list.getLength(); i++) {
	      if (list.item(i) instanceof Element) {
	    	  element = (Element) list.item(i);
	        XmlNode xmlNode = new XmlNode(null,"","");
	      }
	    }
	     return root;
	  }
	}
