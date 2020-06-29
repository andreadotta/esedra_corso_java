package it.esedra.corso.oussein;




		import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTable;


		public class Tablebis {

		     public static void main(String[] args) {

		    JFrame Frame= new JFrame("JTable Demo");
		    String[] tittles= { "id","Materiels informatiques", "quantites"};
		    
		    Object[] [] data= {
		  
		    		{1,"PC","30"},
		    		{2,"imprimantes","45"},
		    		{3,"Tablettes","12"},
		    };
		    
		    JTable table=new JTable(data,tittles); 
		 
		 Frame.getContentPane().add(table.getTableHeader(),BorderLayout.NORTH);
		 Frame.getContentPane().add(table);
		    
		    Frame.setSize(450,250);
		    Frame.setVisible(true);
		  
		    
			}

		
	}


