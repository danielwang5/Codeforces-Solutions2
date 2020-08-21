import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C648E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		long[] arr = new long[n];
		boolean[] used = new boolean[n];
		
		long ans = 0;
		
		int maxdex = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextLong();
			if(arr[i] > ans) {
				ans = arr[i];
				maxdex = i;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(ans < arr[i]) {
				ans = arr[i];
			}
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(ans < (arr[i]|arr[j])) {
					ans = arr[i]|arr[j];
				}
			}
		}
		
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					if(ans < (arr[i] | arr[j] | arr[k])) {
						ans = (arr[i] | arr[j] | arr[k]);
					}
				}
			}
		}
		
		out.print(ans);
		
//		used[maxdex] = true;
//		int[] bitcount = new int[60];
//		
//		long a = ans;
//		int place = 0;
//		while(a > 0) {
//			if(a%2==1) {
//				bitcount[place]++;
//			}
//			place++;
//			a /= 2;
//		}
//		
//		int iter = 2;
//		
//		while(true) {
//		
//			long next = -1;
//			
//			long max = -1;
//			maxdex = -1;
//			
//			for(int i=0; i<n; i++) {
//				if(used[i]) {
//					continue;
//				}
//				
//				long nval = 0;
//				place = 0;
//				a = arr[i];
//				long pow = 1;
//				
//				for(int it = 0; it<60; it++) {
//					if(a%2==1) {
//						if(bitcount[place] + 1 >= Math.max(1, iter-2)) {
//							nval += pow;
//						}
//					} else {
//						if(bitcount[place] >= Math.max(1, iter-2)) {
//							nval += pow;
//						}
//					}
//					pow *= 2;
//					place++;
//					a /= 2;
//				}
//				
//				//out.println(arr[i] + " " + nval);
//				
//				
//				if(next < nval || (next == nval && arr[i] > max)) {
//					next = nval;
//					maxdex = i;
//					max = arr[i];
//				}
//			}
//			
//			if(ans >= next) {
//				break;
//			}
//			
//			a = max;
//			place = 0;
//			while(a > 0) {
//				if(a%2==1) {
//					bitcount[place]++;
//				}
//				place++;
//				a /= 2;
//			}
//			
//			
//			
//			iter++;
//			ans = next;
//		}
		
		//out.print(ans);
		
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
