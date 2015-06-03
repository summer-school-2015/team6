import java.io.*;
import java.util.*;

public class Counter{
    public static void main(String[] args){
        PrintWriter out;
        BufferedReader in;
        String inf, ouf;
        inf = ouf = "";
        boolean bin = false, bout = false;
        for (String s1: args) {
            if (s1.length() > 3 && s1.charAt(1) == 'f' && s1.charAt(2) == '=') {
                if (s1.charAt(0) == 'i') {
                    bin = true;
                    inf = s1.substring(3);
                } else if (s1.charAt(0) == 'o') {
                    bout = true;
                    ouf = s1.substring(3);
                }
            }
        }
        if (bin){
            try {
                in = new BufferedReader(new FileReader(inf));
            }
            catch (FileNotFoundException x){
                System.err.format("Vy othvatili FileNotFoundException: %s%n", x);
                return;
            }
        }
        else{
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        if (bout){
            try {
                out = new PrintWriter(ouf);
            }
            catch (FileNotFoundException x){
                System.err.format("Vy othvatili FileNotFoundException: %s%n", x);
                return;
            }
        }
        else{
            out = new PrintWriter(System.out);
        }
        String line = null;
        int ct1 = 0, ct2 = 0, ct3 = 0;
        try {
            while ((line = in.readLine()) != null) {
                ct1++;
                ct3 += line.length();
                StringTokenizer tk = new StringTokenizer(line);
                while (tk.hasMoreTokens()) {
                    String s = tk.nextToken();
                    ct2++;
                }
            }
        }
        catch (IOException x){
            System.err.format("Vy othvatili IOException: %s%n", x);
        }
        out.printf("%d %d %d", ct1, ct2, ct3);
        out.close();
    }
}