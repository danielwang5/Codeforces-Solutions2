import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CE90D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			long[] a = new long[n];
			
			long currsum = 0;
			
			for(int x=0; x<n; x++) {
				a[x] = sc.nextInt();
				if(x%2 == 0) {
					currsum += a[x];
				}
			}
			
			long[] diff1 = new long[n/2];
			long[] diff2 = new long[(n-1)/2];
			
			for(int x=0; x<n-1; x++) {
				if(x%2==0) {
					diff1[x/2] = a[x+1] - a[x];
				} else {
					diff2[x/2] = a[x] - a[x+1];
				}
			}
			
//			out.println(Arrays.toString(diff1));
//			out.println(Arrays.toString(diff2));
			
			long extra1 = 0;
			long extra2 = 0;
			
			long max1 = 0;
			for(int x=0; x<diff1.length; x++) {
				if(diff1[x] > max1) {
					max1 = diff1[x];
					break;
				}
			}
			if(max1 > 0) {
				max1 = Math.max(diff1[0],0);
				for(int x=1; x<diff1.length; x++) {
					if(diff1[x-1] > 0) {
						diff1[x] += diff1[x-1];
					}
					if(max1 < diff1[x]) {
						max1 = diff1[x];
					}
				}
				
				extra1 = max1;
			}
			
			long max2 = 0;
			for(int x=0; x<diff2.length; x++) {
				if(diff2[x] > max2) {
					max2 = diff2[x];
					break;
				}
			}
			if(max2 > 0) {
				max2 = Math.max(diff2[0],0);
				for(int x=1; x<diff2.length; x++) {
					if(diff2[x-1] > 0) {
						diff2[x] += diff2[x-1];
					}
					if(max2 < diff2[x]) {
						max2 = diff2[x];
					}
				}
				
				extra2 = max2;
			}
			
//			out.println(Arrays.toString(diff1));
//			out.println(Arrays.toString(diff2));
			
			out.println(currsum + Math.max(0,Math.max(extra1, extra2)));
			
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
