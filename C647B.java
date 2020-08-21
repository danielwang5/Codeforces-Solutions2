import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C647B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			short[] vals = new short[n];
			boolean[] seen = new boolean[1024];
			for(int x=0; x<n; x++) {
				int s = sc.nextInt();
				vals[x] = (short) s;
				seen[s] = true;
			}
			boolean ook = false;
			for(short xor = 1; xor < 1024; xor++) {
				boolean ok = true;
				for(short v: vals) {
					if(!seen[v ^ xor]) {
						ok = false;
						break;
					}
				}
				if(ok) {
					out.println(xor);
					ook = true;
					break;
				}
			}
			if(!ook) {
				out.println(-1);
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
