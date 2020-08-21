import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C646A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int x = sc.nextInt();
			int n = sc.nextInt();
			int odd = 0;
			int even = 0;
			int sum = 0;
			
			for(int i=0; i<x; i++) {
				int v = sc.nextInt();
				sum += v;
				
				if(v%2 == 0) {
					even++;
				} else {
					odd++;
				}
			}
			
			if(odd == 0) {
				out.println("No");
			} else if(even == 0 && n%2 == 0) {
				out.println("No");
			} else if(x == n && sum%2==0) {
				out.println("No");
			} else {
				out.println("Yes");
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
