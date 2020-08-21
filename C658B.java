import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C658B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt()*2;
			
			//int[] ind = new int[n];
			int[] a = new int[n];
			boolean[] used = new boolean[n];
			int mi = n-1;
			
			for(int i=0; i<n; i++) {
				int v = sc.nextInt()-1;
				a[i] = v;
			}
			
			ArrayList<Integer> c = new ArrayList<Integer>();
			
			int chunk = 0;
			for(int i=n-1; i>=0; i--) {
				chunk++;
				used[a[i]] = true;
				
				if (a[i] == mi) {
					c.add(chunk);
					chunk = 0;
					while(true) {
						mi--;
						if (mi == -1 || !used[mi]) {
							break;
						}
					}
				}
			}
			//out.println(c);
			
			boolean[] dp = new boolean[n/2+1];
			dp[0] = true;
			boolean found = false;
			
			outer:
			for(int cc:c) {
				for(int i=n/2; i>=cc; i--) {
					if(dp[i-cc]) {
						dp[i] = true;
						if(i == n/2) {
							found = true;
							break outer;
						}
					}
				}
			}
			if(found) {
				out.println("YES");
			} else {
				out.println("NO");
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
