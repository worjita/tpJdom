package heritage;



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
	public class Heritage { 
		
		
		  public String convertType(String a){
			
			  if (a.equals("_qxt6oKEYEeWB35I-2f8kMw"))
			return "int";
			  else  if (a.equals("_qyA1kaEYEeWB35I-2f8kMw"))
				  return "String";
			  else if (a.equals("_qyUXkKEYEeWB35I-2f8kMw"))
				  return "float";
			  else return "void";
			  
			  
			  
		  }
		public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException { 
			//partie 1
			String[] attribut=new String[80]; int k=0;
			SAXBuilder builder = new SAXBuilder();
		
			Document doc = builder.build(new FileInputStream("heritage.xml"));
			Element root = doc.getRootElement();
			Element child = root.getChild("packagedElement");
			
			
			// GENERER LE  NOM DE LA CLASS
			Attribute nomclasse = child.getAttribute("name");
			    String a="public class "+nomclasse.getValue()+"{";
			  
			    System.out.println(a);
			 //GENERER LES ATTRIBUTS   
			    Element childa = child.getChild("ownedAttribute");
			    List<Element> attrLISTE=child.getChildren("ownedAttribute");
			    for (int i = 0; i < attrLISTE.size(); i++) {
					Element elattr=attrLISTE.get(i);
					Heritage c=new Heritage(); 
		attribut[k]=""+elattr.getAttributeValue("visibility")+" "+c.convertType(elattr.getAttributeValue("type"))+" "+elattr.getAttributeValue("name")+";\n";
		
		System.out.println(attribut[k]);
		k++;}
			    
			    //GENERER LES operation   
			    Element childa1 = child.getChild("ownedOperation");
			    List<Element> opera=child.getChildren("ownedOperation");
			    for (int i = 0; i < opera.size(); i++) {
					Element elattr=opera.get(i);
					 
		attribut[k]=""+elattr.getAttributeValue("visibility")+"void "+elattr.getAttributeValue("name")+"()"+"\n";
		
		System.out.println(attribut[k]);
		k++;}
			    System.out.println("}");
			    //partie extend
			    List<Element> he=root.getChildren("packagedElement");
			    
			    for (int i = 0; i < he.size(); i++) 
			    	{Element el=he.get(i);
			    	   //System.out.println(he.get(i).getChild("generalization"));
			    	Element b =el.getChild("generalization");
			    	
			    	     if (b!=null)
			    	     {     
			    	    	 String[] pop=new String[66];int j=0;
			    	    	 String  s =el.getAttributeValue("name");
			    	    	 attribut[k]="public class "+s+" extend "+nomclasse.getValue()+" { ";
			    				    	System.out.println(attribut[k]);
			    				    	k++;
			    				    	 Element childs = el.getChild("ownedAttribute");
			    						    List<Element> attrLISTEe=el.getChildren("ownedAttribute");
			    						    for (int i1 = 0; i1 < attrLISTEe.size(); i1++) {
			    								Element elattr=attrLISTEe.get(i1);
			    								Heritage c=new Heritage(); 
			    					attribut[k]=""+elattr.getAttributeValue("visibility")+" "+c.convertType(elattr.getAttributeValue("type"))+" "+elattr.getAttributeValue("name")+";\n";
			    					
			    					System.out.println(attribut[k]);
			    					k++;}
			    						    Element childa11 = child.getChild("ownedOperation");
			    						    List<Element> opera1=el.getChildren("ownedOperation");
			    						    for (int i1 = 0; i1 < opera1.size(); i1++) {
			    								Element elattr=opera1.get(i1);
			    								 
			    					attribut[k]=""+elattr.getAttributeValue("visibility")+"void "+elattr.getAttributeValue("name")+"()"+"\n";
			    					
			    					System.out.println(attribut[k]);
			    					k++;}
			    						    System.out.println("}");
			    	    		
			    	     }
			    	}
			    
			    
			    
				 //partie ecrire daans un fichier
			    String path="C:\\Users\\USER\\Desktop\\classe.java";
			    try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)))) {
		            writer.write(a+" \n");
		            for (int i = 0; i < k; i++) {
						writer.write(attribut[i]);
						
					}
		            
		            writer.write("}");
		            System.out.print("fichier creer a l'emplacement :"+path+"\n");
		                        }
		            
		        catch (IOException e)
		            {
		            e.printStackTrace();
		            }
			
			
			
		}}

