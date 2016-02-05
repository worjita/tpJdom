package vue;


import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import uneclasse.classeUne;;
public class Interfaces extends Frame {

	public static void main(String[] args) {
		Frame jf = new Frame("Et hop!");
	    FlowLayout s=new FlowLayout();
	    jf.setLayout(s);
	    TextField d =new  TextField();
	        d.setPreferredSize(new Dimension(200,50));
	      jf.add(d);
	      Button browse=new Button("browse");
			
			browse.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fileChooser = new JFileChooser();
					String path = "";
					
					int rVal = fileChooser.showOpenDialog(null);
			        
					if (rVal == JFileChooser.APPROVE_OPTION) {
			          path = fileChooser.getSelectedFile().toString();
			          d.setText(path);
			        }
				};
			});
			jf.add(browse); 
			
		
			
		Button GB=new Button("generation de base de donne");
		jf.add(GB);
		GB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				   classeUne k= new classeUne(d.getText());
				k.afficherPath();
				
				
			};
		});
		Button JAVA=new Button("generation de code java");
		jf.add(JAVA);
		
		jf.setSize(400, 400);
		
		
		
		jf.setVisible(true);

	}

}
