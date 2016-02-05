package vue;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Interface extends Frame {
	       
	      
	public static void main(String[] args) {
		
		JFrame jf = new JFrame("Et hop!");
		JButton a=new JButton("generation de base de donne");
		jf.add(a);
		JButton b=new JButton("generation de code java");
		jf.add(b);
		jf.setSize(400, 400);
		JButton lancerJFileCohooser = new JButton("lancer JFileChooser");
		lancerJFileCohooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int rVal = fileChooser.showOpenDialog(null);
		        
				if (rVal == JFileChooser.APPROVE_OPTION) {
		          
		        }
			};
		});
		
		jf.add(lancerJFileCohooser);
		
		jf.setVisible(true);
		//JFileChooser a=new JFileChooser();
         //.add(a);
}}
