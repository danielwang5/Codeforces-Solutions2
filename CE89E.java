import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CE89E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int aa = sc.nextInt();
		int bb = sc.nextInt();
		
		int[] a = new int[aa];
		int[] b = new int[bb];
		int min = -9;
		int[] mins = new int[bb];
		int[] lastkind = new int[bb];
		
		for(int i=0; i<aa; i++) {
			a[i] = sc.nextInt();
			if(a[i] > min) {
				min = a[i];
			}
		}
		for(int i=0; i<bb; i++) {
			b[i] = sc.nextInt();
		}
		
		int mindex = bb-1;
		int seenindex = bb-1;
		for(int i=aa-1; i>=0; i--) {
			if(seenindex >= 0 && a[i] == b[seenindex]) {
				lastkind[seenindex] = i;
				seenindex--;
			}
			
			if(a[i] < min) {
				min = a[i];
			}
			if(b[mindex] > min) {
				mins[mindex] = i+1;
				mindex--;
				if(mindex < 0) {
					out.print(0);
					out.flush();
					return;
				}
			}
			
		}
		
		if (seenindex > -1) {
			out.print(0);
			out.flush();
			return;
		}
		
		for(int i=0; i<bb; i++) {
			if(lastkind[i] < mins[i]) {
				out.print(0);
				out.flush();
				return;
			}
		}
		
		long ans = 1;
		long mod = 998244353;
		
		for(int i=1; i<bb; i++) {
			ans *= lastkind[i] - mins[i] + 1;
			ans %= mod;
		}
		
//		out.println(Arrays.toString(mins));
//		out.println(Arrays.toString(lastkind));
		out.print(ans);
		
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
