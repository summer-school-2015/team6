import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Regex{
	
	static String temp = "\\w+\\.\\w+\\.(com|ru|ua)";	

	static boolean ok(String s){
		Pattern p = Pattern.compile(temp);
		Matcher m = p.matcher(s);
		return m.matches();
	}	

	public static void main(String args[]){
		Scanner in;
		PrintWriter out;
		boolean bin = false, bout = false;
		String fin = "", fout = "";
		for (String s: args){
			if (s.length() > 3 && s.charAt(1) == 'f' && s.charAt(2) == '='){
				if (s.charAt(0) == 'i'){
					bin = true;
					fin = s.substring(3);		
				}
				else if(s.charAt(0) == 'o'){
					bout = true;					
					fout = s.substring(3);
				}
				else if(s.charAt(0) == 'r'){
					temp = s.substring(3);				
				}
			}
		}
		if (bin){
			try{
				in = new Scanner(new FileReader(fin));
			}
			catch(FileNotFoundException e){
				System.err.format("FNFE%s%d", e);
				return;
			}
		}
		else{
			in = new Scanner(System.in);
		}
		if (bout){
			try{
				out = new PrintWriter(fout);
			}
			catch(FileNotFoundException e){
				System.err.format("FNFE%s%d", e);
				return;
			}
		}
		else{
			out = new PrintWriter(System.out);
		}		
		while (in.hasNext()){
			String s = in.next();
			if (ok(s)){
				out.println(s);
			}
		}
		out.close();
	}
}