package uneclasse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class uneClasseBD {

	public String convertType2(String a){
		   
		  if (a.equals("_qxt6oKEYEeWB35I-2f8kMw"))
		return "integer";
		  else  if (a.equals("_qyA1kaEYEeWB35I-2f8kMw"))
			  return "varchar(45)";
		  else if (a.equals("_qyUXkKEYEeWB35I-2f8kMw"))
			  return "float";
		  else return "no determine";
		  
	  }
	  
	public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException { 
		//partie 1
		String[] attribut=new String[80]; int k=0;
		SAXBuilder builder = new SAXBuilder();
	
		Document doc = builder.build(new FileInputStream("produit.xml"));
		Element root = doc.getRootElement();
		Element child = root.getChild("packagedElement");
		
		
		// GENERER LE  NOM DE LA CLASS
		Attribute nomclasse = child.getAttribute("name");
		    String a="creat table "+nomclasse.getValue()+"(\n";
		    
		    System.out.println(a);
		 //GENERER LES ATTRIBUTS   
		    Element childa = child.getChild("ownedAttribute");
		    List<Element> attrLISTE=child.getChildren("ownedAttribute");
		    for (int i = 0; i < attrLISTE.size(); i++) {
				Element elattr=attrLISTE.get(i);
				uneClasseBD d=new uneClasseBD(); 
	attribut[k]=""+elattr.getAttributeValue("name")+" "+d.convertType2(elattr.getAttributeValue("type"))+",\n";
	
	System.out.println(attribut[k]);
	k++;
	}
		    
		    System.out.println(")");	    
			 //partie ecrire daans un fichier
		    String path="C:\\Users\\USER\\Desktop\\bd.java";
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)))) {
	            writer.write(a+" \n");
	            for (int i = 0; i < k; i++) {
					writer.write(attribut[i]);
					
				}
	            
	            writer.write(")");
	            System.out.print("fichier creer a l'emplacement :"+path+"\n");
	                        }
	            
	        catch (IOException e)
	            {
	            e.printStackTrace();
	            }
		
		
		
	}
	}

