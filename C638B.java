import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C638B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] arr = new int[n];
			boolean[] seen = new boolean[n+1];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
				seen[arr[i]] = true;
			}
			
			int cnt = 0;
			
			ArrayList<Integer> a = new ArrayList<Integer>();
			
			for(int i=1; i<=n; i++) {
				if (seen[i]) {
					a.add(i);
					cnt++;
				}
			}
			
			if(cnt>k) {
				out.println(-1);
				continue;
			}
			
			out.println(n*k);
			
			for(int i=0; i<n; i++) {
				int ind = 0;
				for(int z=0; z<k; z++) {
					if (ind < a.size()) {
						out.print(a.get(ind)+" ");
						ind++;
					} else {
						out.print(1+" ");
					}
				}
			}
			out.println();
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
