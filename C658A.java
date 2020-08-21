import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C658A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			boolean[] a = new boolean[n];
			boolean[] b = new boolean[n];
			
			char[] aa = sc.next().toCharArray();
			char[] bb = sc.next().toCharArray();
			
			for(int i=0; i<n; i++) {
				a[i] = (aa[i] == '1');
				b[i] = (bb[i] == '1');
			}
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			
			for(int i=0; i<n; i++) {
				int ai=0;
				if(i%2 == 0) {
					ai = i/2;
				} else {
					ai = (n-1) - i/2;
				}
				int bi = (n-1)-i;
				
				if((i%2==0 && a[ai] == b[bi]) || (i%2==1 && a[ai] != b[bi])) {
					ans.add(1);
				}
				ans.add(bi+1);
			}
			
			out.print(ans.size());
			out.print(" ");
			
			for(int an: ans) {
				out.print(an);
				out.print(" ");
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
