import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C662D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		char[][] a = new char[rows][cols];
		int[][] nw = new int[rows][cols];
		int[][] sw = new int[rows][cols];
		int[][] ne = new int[rows][cols];
		int[][] se = new int[rows][cols];
		
		for(int r=0; r<rows; r++) {
			char[] ch = sc.next().toCharArray();
			for(int c=0; c<cols; c++) {
				a[r][c] = ch[c];
			}
		}
		
		//nw
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				if(r == 0 || c == 0) {
					nw[r][c] = 1;
				} else {
					if(a[r-1][c] != a[r][c] || a[r][c-1] != a[r][c]) {
						nw[r][c] = 1;
					} else {
						nw[r][c] = Math.min(nw[r-1][c],nw[r][c-1]) + 1;
					}
				}
			}
		}
		
		//ne
		for(int r=0; r<rows; r++) {
			for(int c=cols-1; c>=0; c--) {
				if(r == 0 || c == cols-1) {
					ne[r][c] = 1;
				} else {
					if(a[r-1][c] != a[r][c] || a[r][c+1] != a[r][c]) {
						ne[r][c] = 1;
					} else {
						ne[r][c] = Math.min(ne[r-1][c],ne[r][c+1]) + 1;
					}
				}
			}
		}
		
		//sw
		for(int r=rows-1; r>=0; r--) {
			for(int c=0; c<cols; c++) {
				if(r == rows-1 || c == 0) {
					sw[r][c] = 1;
				} else {
					if(a[r+1][c] != a[r][c] || a[r][c-1] != a[r][c]) {
						sw[r][c] = 1;
					} else {
						sw[r][c] = Math.min(sw[r+1][c],sw[r][c-1]) + 1;
					}
				}
			}
		}
		
		//se
		for(int r=rows-1; r>=0; r--) {
			for(int c=cols-1; c>=0; c--) {
				if(r == rows-1 || c == cols-1) {
					se[r][c] = 1;
				} else {
					if(a[r+1][c] != a[r][c] || a[r][c+1] != a[r][c]) {
						se[r][c] = 1;
					} else {
						se[r][c] = Math.min(se[r+1][c],se[r][c+1]) + 1;
					}
				}
			}
		}
		
		long ans = 0;
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				ans += Math.min(Math.min(nw[r][c], sw[r][c]),Math.min(ne[r][c], se[r][c]));
			}
		}
		
		out.println(ans);
		
		//out.print(Arrays.deepToString(se));
		//out.print(Arrays.deepToString(ne));
		
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
