import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CE91A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			//int[] a = new int[n];
			HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
			
			for(int i=0; i<n; i++) {
				h.put(sc.nextInt(),i+1);
			}
			
			int l = 1;
			int r = n;
			
			boolean found = false;
			
			for(int i=n; i>2; i--) {
				int ind = h.get(i);
				if(ind != l && ind != r) {
					found = true;
					out.println("YES");
					out.println((l)+" "+(ind)+" "+(r));
					break;
				} else {
					if (ind==l) {
						l++;
					} else {
						r--;
					}
				}
			}
			
			if (!found) {
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
