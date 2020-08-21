import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C648A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			int[][] mat = new int[r][c];
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			int er = 0;
			int ec = 0;
			
			for(int i=0; i<r; i++) {
				boolean empty = true;
				for(int j=0; j<c; j++) {
					if(mat[i][j] == 1) {
						empty = false;
						break;
					}
				}
				if(empty) {
					er++;
				}
			}
			for(int j=0; j<c; j++) {
				boolean empty = true;
				for(int i=0; i<r; i++) {
					if(mat[i][j] == 1) {
						empty = false;
						break;
					}
				}
				if(empty) {
					ec++;
				}
			}
			
			int a = Math.min(er, ec);
			if (a % 2 == 0) {
				out.println("Vivek");
			} else {
				out.println("Ashish");
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
