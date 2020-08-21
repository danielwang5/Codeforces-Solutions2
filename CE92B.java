import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE92B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int z = sc.nextInt();
			
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			long sum = 0;
			for(int i=0; i<=k; i++) {
				sum += a[i];
			}
			
			long ans = sum;
			
			
			
			for(int zz=0; zz<z; z++) {
				int len = k-2;
				int zsum = a[k] + a[k-1];
				int max = -zsum;
				int newval = 0;
				int del = 0;
				
				for(int x=0; x<len-1; x++) {
					newval = a[x] + a[x+1] - zsum;
					if(newval > max) {
						max = newval;
						del = 2;
					}
				}
//				newval = a[len-2] - a[len];
//				if(newval > max) {
//					max = newval;
//					del = 1;
//				}
				
				if(sum + zz*newval > ans) {
					ans = sum + zz*newval;
				}
			}
			
			for(int zz=0; zz<z-1; z++) {
				int len = k-4;
				int zsum = a[k] + a[k-1];
				int max = -zsum;
				int newval = 0;
				int del = 0;
				
				for(int x=0; x<len-1; x++) {
					newval = a[x] + a[x+1] - zsum;
					if(newval > max) {
						max = newval;
						del = 2;
					}
				}
				int dif = a[len] - a[len+2];
				
				if(sum + zz*newval + dif > ans) {
					ans = sum + zz*newval;
				}
			}
			
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
