import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C647A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			
			if(a==b) {
				out.println(0);
				continue;
			} else if(a < b) {
				long aa = a;
				int cnt = 0;
				while(aa < b) {
					aa *= 2;
					cnt++;
				}
				if(aa != b) {
					out.println(-1);
					continue;
				}
				out.println((cnt+2)/3);
				
			} else {
				long bb = b;
				int cnt = 0;
				while(bb < a) {
					bb *= 2;
					cnt++;
				}
				if(bb != a) {
					out.println(-1);
					continue;
				}
				out.println((cnt+2)/3);
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
