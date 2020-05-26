import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C638D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			if(n==2) {
				out.println(1);
				out.println(0);
				continue;
			}
			if(n==3) {
				out.println(1);
				out.println(1);
				continue;
			}
			if(n==4) {
				out.println(2);
				out.println("0 1");
				continue;
			}
			
			long v = 1;
			n--;
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			
			while(n > 6*v) {
				ans.add((int)v);
				v *= 2;
				n -= v;
			}
			
			//out.println("faef " + n + " " + v);
			
			if (n < 3*v) {
				ans.add(0);
				ans.add((int) (n-2*v));
			} else if (n < 4*v) {
				int p = (int)(v/2);
				ans.add(p);
				ans.add((int) (n-3*v));
			} else {
				ans.add((int) v);
				ans.add((int) (n-4*v));
			}
			
			out.println(ans.size());
			for(int h:ans) {
				out.print(h);
				out.print(" ");
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
