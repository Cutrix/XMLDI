package app;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class test {

	public static void main(String[] args) {
		try {
			File inputFile = new File("student.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			UserHandler userhandler = new UserHandler();
			saxParser.parse(inputFile, userhandler);			
						
						
			LinkedList<String> l = (LinkedList<String>) userhandler.getInstance();
			
			Class<?> c = Class.forName(userhandler.getClasse());
			Constructor<?> cons = c.getConstructor();
			Object obj = cons.newInstance();
			//System.out.println(obj.getClass());			
	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
		/*List<String> l = new LinkedList<String>();
		Pile<String> p = new Pile<String>(l);*/
		
	}
}
