import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE86B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			String s = sc.next();
			char[] c = s.toCharArray();
			
			boolean found0 = false;
			boolean found1 = false;
			
			for(int i=0; i<c.length; i++) {
				if(c[i] == '0') {
					found0 = true;
				} else {
					found1 = true;
				}
			}
			
			if(!found0 || !found1) {
				out.println(s);
			} else {
				for(int x=0; x<s.length(); x++) {
					out.print("01");
				}
				out.println();
			}
		}
		
		out.flush();
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in), 32768);}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}
