import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C641B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			
			int[] vals = new int[n];
			int[] maxes = new int[n];
			
			int ans = 1;
			
			for(int x=0; x<n; x++) {
				int s = sc.nextInt();
				maxes[x] = 1;
				vals[x] = s;
			}
			
			for(int x=0; x<n; x++) {
				for(int y=x+x+1; y<n; y+=(x+1)) {
					if (vals[y] > vals[x] && maxes[x]+1 > maxes[y]) {
						maxes[y] = maxes[x]+1;
						if (maxes[y] > ans) {
							ans = maxes[y];
						}
					}
				}
			}
			
			//out.println(Arrays.toString(maxes));
			out.println(ans);
			
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
