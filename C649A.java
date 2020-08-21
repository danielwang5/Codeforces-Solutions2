import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C649A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			int sum = 0;
			int emult = -1;
			int lmult = -1;
			
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				int v = sc.nextInt();
				if(v%x > 0) {
					if(emult == -1) {
						emult = i;
					}
					lmult = i;
				}
				sum += v;
				a[i] = v;
			}
			
			if(sum%x > 0) {
				out.println(n);
				continue;
			}
			
			if(emult == -1) {
				out.println(-1);
				continue;
			}
			
			int diff = Math.min(emult+1, n-lmult);
			out.println(n - diff);
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
