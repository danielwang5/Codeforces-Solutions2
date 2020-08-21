import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C646B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			String s = sc.next();
			char[] c = s.toCharArray();
			
			boolean[] b = new boolean[c.length];
			
			int bl = 0;
			int br = 0;
			int nl = 0;
			int nr = c.length;
			
			for(int i=0; i<c.length; i++) {
				if(c[i] == '1') {
					br++;
					b[i] = true;
				} else {
					b[i] = false;
				}
			}
			
			int ans = Math.min(br, nr-br);
			
			for(int i=0; i<b.length; i++) {
				nl++;
				nr--;
				if(b[i]) {
					bl++;
					br--;
				}
				
				int nxt = Math.min(bl + (nr - br), br + (nl - bl));
				
				if(ans > nxt) {
					ans = nxt;
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
