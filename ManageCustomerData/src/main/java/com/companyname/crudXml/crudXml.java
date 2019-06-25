package com.companyname.crudXml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class crudXml {
	public static void Update(String xPath, String value, File file, int temp)
			throws XPathExpressionException, TransformerFactoryConfigurationError, SAXException, IOException,
			ParserConfigurationException, TransformerException {
		if (temp == 0) {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(file));

			XPath xpath = XPathFactory.newInstance().newXPath();
			Object obj = xpath.evaluate(xPath, doc, XPathConstants.NODESET);

			NodeList nodes = (NodeList) obj;

			for (int idx = 0; idx < nodes.getLength(); idx++) {
				nodes.item(idx).setTextContent(value);
			}

			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File("C:\\ProjectM1\\FINAL\\newest.xml")));
		} else {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new FileInputStream("C:\\ProjectM1\\FINAL\\newest.xml"));

			XPath xpath = XPathFactory.newInstance().newXPath();
			Object obj = xpath.evaluate(xPath, doc, XPathConstants.NODESET);

			NodeList nodes = (NodeList) obj;

			for (int idx = 0; idx < nodes.getLength(); idx++) {
				nodes.item(idx).setTextContent(value);
			}

			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File("C:\\ProjectM1\\FINAL\\newest.xml")));
		}
	}

	public static void Delete(String xPath, File file, int temp) throws SAXException, IOException,
			ParserConfigurationException, XPathExpressionException, TransformerException {
		if (temp == 0) {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(file));

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate(xPath, doc, XPathConstants.NODESET);
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				node.getParentNode().removeChild(node);
			}
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File("C:\\ProjectM1\\FINAL\\newest.xml")));

		} else {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new FileInputStream("C:\\ProjectM1\\FINAL\\newest.xml"));

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate(xPath, doc, XPathConstants.NODESET);
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				node.getParentNode().removeChild(node);
			}
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File("C:\\ProjectM1\\FINAL\\newest.xml")));

		}

	}

	public static void saveChild(String xPath, String TagName, String TagValue, int temp, File file)
			throws SAXException, IOException, ParserConfigurationException, XPathExpressionException,
			TransformerException {
		if (temp == 0) {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(file));

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate(xPath, doc, XPathConstants.NODESET);
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				Element new_element = doc.createElement(TagName);
				new_element.setTextContent(TagValue);
				node.getParentNode().appendChild(new_element);
			}
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File("C:\\ProjectM1\\FINAL\\newest.xml")));
		} else {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new FileInputStream("C:\\ProjectM1\\FINAL\\newest.xml"));

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate(xPath, doc, XPathConstants.NODESET);
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				Element new_element = doc.createElement(TagName);
				new_element.setTextContent(TagValue);
				node.getParentNode().appendChild(new_element);
			}
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(doc), new StreamResult(new File("C:\\ProjectM1\\FINAL\\newest.xml")));
		}

	}

}
