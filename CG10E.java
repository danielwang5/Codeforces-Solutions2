import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CG10E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		
		long[][] grid = new long[n][n];
		for(int r=n-2; r>=0; r--) {
			for(int c=n-1; c>=1; c--) {
				long sumdown = 0;
				for(int rr=r+1; rr<n; rr++) {
					sumdown += grid[rr][c];
				}
				
				long sumacross = 0;
				for(int cc=c-1; cc<n; cc++) {
					sumacross += grid[r+1][cc];
				}
				for(int rr=r+2; rr<n; rr++) {
					sumacross += grid[rr][n-1];
				}
				grid[r][c] = sumacross - sumdown + 1;
			}
		}
		
		//out.print(Arrays.deepToString(grid));
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				out.print(grid[r][c]+" ");
			}
			out.println();
		}
		out.println();
		out.flush();
		
		long[][] pascal = new long[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if (r == 0 || c == 0) {
					pascal[r][c] = 1;
				} else {
					pascal[r][c] = pascal[r-1][c] + pascal[r][c-1];
				}
			}
		}
		
//		out.println(Arrays.deepToString(pascal));
//		out.flush();
		
		int t = sc.nextInt();
		for(int tt=0; tt<t; tt++) {
			long sum = sc.nextLong();
			
			int r_left = n-1;
			int d_left = n-1;
			
			char[] path = new char[2*(n-1)];
			
			for(int it=0; it<2*(n-1); it++) {
				//out.println(r_left + "/"+d_left);out.flush();
				long combi = pascal[d_left][r_left];
				long mid = d_left*combi/(r_left+d_left);
				//out.println(sum + ":"+mid);out.flush();
				if(sum >= mid) {
					sum -= mid;
					path[it] = 'R';
					r_left--;
				} else {
					path[it] = 'D';
					d_left--;
				}
			}
			
			//out.println(Arrays.toString(path));
			out.println("1 1");
			int r = 1;
			int c = 1;
			for(int i=0; i<path.length; i++) {
				if(path[i] == 'D') {
					r++;
				} else {
					c++;
				}
				out.println(r+" "+c);
			}
			out.println();
			out.flush();
		}
		out.close();
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
