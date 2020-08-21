import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C664A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int d = sc.nextInt();
		long m = sc.nextLong();
		
		long ans = 0;
		
		ArrayList<Integer> less = new ArrayList<>();
		ArrayList<Integer> more = new ArrayList<>();
		
		for(int x=0; x<n; x++) {
			int val = sc.nextInt();
			if(val <= m) {
				less.add(val);
			} else {
				more.add(val);
			}
		}
		
		long unbansum = 0;
		int uptr = 0;
		int mptr = 0;
		
		int left = n;
		
		Collections.sort(less,Collections.reverseOrder());
		Collections.sort(more,Collections.reverseOrder());
		
		while(left > 0) {
			if(less.size()-uptr >= d+1) {
				for(int x=0; x<d+1; x++) {
					unbansum += less.get(uptr);
					uptr++;
				}
			}
			
			if(mptr >= more.size()) {
				ans += unbansum;
				unbansum = 0;
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
