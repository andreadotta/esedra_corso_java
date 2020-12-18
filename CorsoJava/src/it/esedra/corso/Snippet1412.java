package it.esedra.corso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.esedra.corso.helpers.PrintHelper;



public class Snippet1412 {

	public static void main(String args[]) {
		
		
		// Corrispondenza precisa 
		Pattern p = Pattern.compile("esedra1\nx");
		
		String toSearch = "esedra1"
				+ "\n"
				+ "x";
			
		
		
		Snippet1412.match(toSearch, p);
		p = Pattern.compile("^abc");
		
		toSearch = "abc";
		Snippet1412.match(toSearch, p);				
		
		

		// corrispondenze con classi NON predefinite
		
		p = Pattern.compile("[^abc]");
		toSearch = "abc";
		Snippet1412.match(toSearch, p);				
		
		p = Pattern.compile("[abc]");
		toSearch = "abc";
		Snippet1412.match(toSearch, p);						
		
		
		p = Pattern.compile("[a-zA-Z]");
		toSearch = "abc";
		Snippet1412.match(toSearch, p);						
		
		toSearch = "abc123";
		Snippet1412.match(toSearch, p);						
		
		toSearch = "123";
		Snippet1412.match(toSearch, p);						
		
		p = Pattern.compile("[a-d[m-n]]");
		toSearch = "1233";
		Snippet1412.match(toSearch, p);						
		
		toSearch = "n12";
		Snippet1412.match(toSearch, p);						
		
		
		p = Pattern.compile("[a-z&&[^bc]]");
		toSearch = "c";
		Snippet1412.match(toSearch, p);						
		
		p = Pattern.compile("[a-z&&[bc]]");
		toSearch = "b";
		Snippet1412.match(toSearch, p);						
		
		
		p = Pattern.compile("[a-z&&[^b-e]]");  //tra a e z esclusi quelli tra b ed e
		toSearch = "cd";
		Snippet1412.match(toSearch, p);
		
		//corrispondenze con classi di carattere predefinita
		
		p = Pattern.compile("\\d"); //carattere numerico tra 0 e 9
		toSearch = "3";
		Snippet1412.match(toSearch, p);
		
		p = Pattern.compile("\\D"); //carattere NON numerico 
		toSearch = "f";
		Snippet1412.match(toSearch, p);
		
		
		/**
		 * CORRISPONDENZE DI RIGA
		 * ^ carattere inizio stringa
		 * $ carattere fine stringa
		 * \b carattere al limite della parola
		 * \B carattere NON al limite della parola
		 * \A inizio riga di input
		 * \Z carattere a fine riga di input
		 * \G carattere all'inizio della stringa del primo match
		 * 
		 */
		
		
		/**
		 * 
		 * Estrarre le URL 
		 * 
		 * <html>
			<head>
			  <title>Hi there</title>
			</head>
			<body>
			  This <a href="http://www.google.it">is</a> a page 
			  a <a href="http://www.amazon.it">simple</> page
			</body>
			</html>

		 * 
		 */
		
		String htmlStr = "<html>\n" + 
				"			<head>\n" + 
				"			  <title>Hi there</title>\n" + 
				"			</head>\n" + 
				"			<body>\n" + 
				"			  This <a href=\"http://www.google.it\">is</a> a page \n" + 
				"			  a <a href=\"http://www.amazon.it\">simple</> page\n" + 
				"			</body>\n" + 
				"			</html>";
		
		String regex = "(?<=href=\").*?(?=\")"; //"\"([^\"]*)\"";
		
		//(?<=y)x il carattere x è preceduto dal carattere y
			//(?<=href=\").*? tutto il contenuto preceduta da href=
		//x(?!y) il carattere x NON è seguito dal carattere y
		//x(?=y) il carattere x è seguito dal carattere y
			//.*?(?=\") tutto  il contenuto che è seguito da "
		
		p = Pattern.compile(regex); //carattere NON numerico 

		
		
		/*Matcher m = p.matcher(htmlStr);
		
		while(m.find()) {
			System.out.println(m.group(1));			
		}*/

		PrintHelper.out(htmlStr.replaceAll(regex, "http://www.esedra.com"));
		
		String[] telNumber = { "06/56565", "06/01564", "06/563456" , "081-556674"};
		
		String regexForTel = "0\\d/\\d{5}";
		
		String[] telValid = validate(telNumber, regexForTel);
		
		for (String tel : telValid) {
			PrintHelper.out(tel);
		}
		
	}

	public static String[] validate(String toSearch[], String regex) {
		
		String found[] = new String[toSearch.length];
		Pattern re_p = Pattern.compile(regex);
				
	    for (int i = 0; i < toSearch.length; i++) {
			String comp = toSearch[i];
			Matcher m = re_p.matcher(comp);
			if (m.find()) {
				found[i] =  m.group();
			} else {
				found[i] = null;
			}	    
	    }

		return found;
			
	}
	
	
	public static boolean match(String toSearch, Pattern p) {
		
		Matcher m = p.matcher(toSearch);

		if (m.find()) {
			PrintHelper.out("FOUND: " + toSearch);
			return true;	
		} else {
			PrintHelper.out("NOT FOUND: " + p.toString());			
			return false;	
		}
			
	}
}
