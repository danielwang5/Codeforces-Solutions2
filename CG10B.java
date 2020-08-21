import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CG10B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			
			long[] a = new long[n];
			
			for(int i=0; i<n; i++) {
				a[i] = sc.nextLong();
			}
			
			long min = a[0];
			long max = a[0];
			
			for(int i=0; i<n; i++) {
				if (a[i] < min) {
					min = a[i];
				}
				if (a[i] > max) {
					max = a[i];
				}
			}
			
			if(k%2 == 0) {
				for(int i=0; i<n; i++) {
					out.print((a[i]-min)+" ");
				}
				out.println();
			} else {
				for(int i=0; i<n; i++) {
					out.print((max - a[i])+" ");
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
