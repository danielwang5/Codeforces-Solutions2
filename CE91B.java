import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE91B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			String s = sc.next();
			char[] c = s.toCharArray();
			int rock = 0;
			int paper = 0;
			int scissors = 0;
			for(char ch: c) {
				if(ch == 'R') {
					paper++;
				} else if(ch == 'P') {
					scissors++;
				} else {
					rock++;
				}
			}
			
			int tot = rock+paper+scissors;
			
			if (rock >= paper && rock >= scissors) {
				for(int i=0; i<tot; i++) {
					out.print("R");
				}
			} else if (paper >= scissors) {
				for(int i=0; i<tot; i++) {
					out.print("P");
				}
			} else {
				for(int i=0; i<tot; i++) {
					out.print("S");
				}
			}
			
			out.println();
			
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
