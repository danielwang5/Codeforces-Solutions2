import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C654D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			byte[][] a = new byte[n][n];
			
			if(k%n == 0) {
				out.println(0);
			} else {
				out.println(2);
			}
			
			if (k>0) {
				outer:
				for(int c=0; c<n; c++) {
					for(int r=0; r<n; r++) {
						a[r][(r+c)%n] = 1;
						k--;
						if(k == 0) {
							break outer;
						}
					}
				}
			}
			
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					out.print(a[r][c]);
				}
				out.println();
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
