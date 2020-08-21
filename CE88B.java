import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE88B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int one = sc.nextInt();
			int two = sc.nextInt();
			
			int ans = 0;
			boolean wp = false;
			
			if (one * 2 <= two) {
				for(int i=0; i<n; i++) {
					char[] s = sc.next().toCharArray();
					for(int j=0; j<m; j++) {
						char c = s[j];
						if(c == '.') {
							ans += one;
						}
					}
				}
				out.println(ans);
			} else {
				for(int i=0; i<n; i++) {
					char[] s = sc.next().toCharArray();
					for(int j=0; j<m; j++) {
						char c = s[j];
						if(c == '.') {
							if (!wp) {
								ans += one;
								wp = true;
							} else {
								wp = false;
								ans += two - one;
							}
						} else {
							wp = false;
						}
					}
					wp = false;
				}
				out.println(ans);
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
