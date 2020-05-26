import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C637C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int prev = n+100;
			int min = prev;
			boolean ans = true;
			for(int x=0; x<n; x++) {
				int next = sc.nextInt();
				int diff = next-prev;
				if (diff == 1) {
					
				} else if (diff < 0) {
					if (next >= min) {
						ans = false;
					}
					min = next;
				} else {
					ans = false;
				}
				
				prev = next;
			}
			
			if(ans) {
				out.println("Yes");
			} else {
				out.println("No");
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
