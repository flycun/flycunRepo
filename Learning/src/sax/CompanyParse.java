package sax;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CompanyParse extends DefaultHandler {
	private List<Company> companys = null;
	private Company company = null;
	private String preTag = null;

	@Override
	public void startDocument() throws SAXException {
		companys = new ArrayList<Company>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("company".equals(qName)) {
			company = new Company();
		}
		preTag = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("company".equals(qName)) {
			companys.add(company);
			company = null;
		}
		preTag = null;

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (preTag != null) {
			String content = new String(ch, start, length);
			if ("jydm".equals(preTag)) {
				company.setJydm(content);
			} else if ("jsp".equals(preTag)) {
				company.setJsp(content);
			} else if ("rzdf".equals(preTag)) {
				company.setRzdf(content);
			}
		}
	}

	public List<Company> getCompanys() {
		return companys;
	}

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		CompanyParse handler = new CompanyParse();
		parser.parse("company.xml", handler);
		for (Company comp : handler.getCompanys()) {
			System.out.println(comp);
		}
	}
}
