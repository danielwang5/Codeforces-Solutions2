import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C648B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			int[] val = new int[n];
			for(int i=0; i<n; i++) {
				val[i] = sc.nextInt();
			}
			
			int t0 = 0;
			int t1 = 0;
			
			for(int i=0; i<n; i++) {
				if(sc.nextInt() == 0) {
					t0++;
				} else {
					t1++;
				}
			}
			
			if(t0 == 0 || t1 == 0) {
				boolean inc = true;
				int last = val[0];
				for(int i=1; i<n; i++) {
					if(val[i] < last) {
						inc = false;
						break;
					} else {
						last = val[i];
					}
				}
				if(inc) {
					out.println("Yes");
				} else {
					out.println("No");
				}
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
