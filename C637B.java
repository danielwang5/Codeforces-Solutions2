import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C637B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			boolean[] peak = new boolean[n];
			
			int prev2 = 2000000000;
			int prev = sc.nextInt();
			
			for(int x=1; x<n; x++) {
				int h = sc.nextInt();
				if (prev2 < prev && prev > h) {
					peak[x-1] = true;
				}
				
				prev2 = prev;
				prev = h;
			}
			
			//out.println(Arrays.toString(peak));
			
			if(k <= 2) {
				out.println("0 1");
				continue;
			}
			
			int peaks = 0;
			int max = 0;
			int maxdex = 0;
			
			for(int x=1; x<k-1; x++) {
				if (peak[x]) {
					peaks++;
				}
				
				if(peaks > max) {
					max = peaks;
					maxdex = 0;
				}
			}
			
			for(int x=k-1; x<n-1; x++) {
				int xx = x-(k-2);
				
				if (peak[xx]) {
					peaks--;
				}
				if (peak[x]) {
					peaks++;
					if(peaks > max) {
						max = peaks;
						maxdex = xx;
					}
				}
				//out.println("davbgqwr" + x + " " + xx + " " + peaks);
			}
			
			out.println((max+1) + " "+ (maxdex+1));
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
