import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C663B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			
			char[][] a = new char[rows][cols];
			
			for(int r=0; r<rows; r++) {
				char[] ch = sc.next().toCharArray();
				for(int c=0; c<cols; c++) {
					a[r][c] = ch[c];
				}
			}
			
			int ans = 0;
			
			for(int r=0; r<rows-1; r++) {
				if(a[r][cols-1] == 'R') {
					ans++;
				}
			}
			for(int c=0; c<cols-1; c++) {
				if(a[rows-1][c] == 'D') {
					ans++;
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
