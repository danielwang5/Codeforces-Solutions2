import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C654E2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		int[] a = new int[n];
		
		for(int x=0; x<n; x++) {
			a[x] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
	
		int min = -9;
		int max = 2000000000;
		
		for(int i=0; i<n; i++) {
			int val = a[i];
			
			int newmin = val-i;
			if(min < newmin) {
				min = newmin;
			}
		}
		
		for(int i=0; i<n-p+1; i++) {
			int val2 = a[i+p-1];
			
			int newmax = val2 - i - 1;
			if(max > newmax) {
				max = newmax;
				if(max < min) {
					break;
				}
			}
		}
		
		if(max-min+1>0) {
			out.println(max-min+1);
			
			for(int i=min; i<=max; i++) {
				out.print(i);
				out.print(" ");
			}
			out.println();
		} else {
			out.println(0);
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
