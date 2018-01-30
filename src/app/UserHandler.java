package app;

import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class UserHandler extends DefaultHandler{
	
	   private String _classe;	   
	   private String _injectName;	  
		   
	   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		   //System.out.println(qName);
		   if (qName.equals("injection")) {			   
			   this._classe = attributes.getValue("classe");
			   this._injectName = attributes.getValue("inject");
			   //System.out.println(this.getInjectName());			   
		   }
	   }
	   
	   public String getType() {
		   return this._classe.split(".")[2];
	   }
	  	 
	   public Object getInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		   	Class<?> c = Class.forName(this.getInjectName());
			Constructor<?> cons = c.getConstructor();
			Object obj = cons.newInstance();
			
			return obj;
	   }
	   
	   public Object getInstancePile() {
		   
	   }
	   /*public void endDocument() {
		   
	   }*/
	   public String getClasse() {
		   return this._classe;
	   }
	   
	   
	   public String getInjectName( ) {
		   return this._injectName;
	   }
	   
	   
	   
}
