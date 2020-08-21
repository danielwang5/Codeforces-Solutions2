import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C663D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		//out.println(dist(1,3));
		
		
		
		boolean[][] bits = new boolean[rows][cols];
		for(int r=0; r<rows; r++) {
			char[] ch = sc.next().toCharArray();
			for(int c=0; c<cols; c++) {
				if(ch[c] == '1') {
					bits[r][c] = true;
				}
			}
		}
		
		if(rows >= 4 && cols >= 4) {
//			for(int r=0; r<rows; r++) {
//				sc.next();
//			}
			out.println(-1);
			out.flush();
			return;
		}
		
		if(rows == 1 || cols == 1) {
			out.println(0);
			out.flush();
			return;
		}
		
		if(cols < rows) {
			boolean[][] newbits = new boolean[cols][rows];
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					if(bits[r][c]) {
						newbits[c][r] = true;
					}
				}
			}
			
			bits = newbits;
			int tmp = cols;
			cols = rows;
			rows = tmp;
		}
		
		if(rows == 2) {
			int[][] dp = new int[4][cols];
			
			int c0 = (bits[0][0] ? 2 : 0) + (bits[1][0] ? 1 : 0);
			//out.println(c0);
			for(int r=0; r<4; r++) {
				dp[r][0] = dist(c0,r);
			}
			
			for(int c=1; c<cols; c++) {
				
				int cval = (bits[0][c] ? 2 : 0) + (bits[1][c] ? 1 : 0);
				for(int r=0; r<4; r++) {
					int min = 999999999;
					for(int rprev=0; rprev<4; rprev++) {
						if((cntbits(r)+cntbits(rprev))%2 == 0) {
							continue;
						}
						int newval = dist(r,cval) + dp[rprev][c-1];
						if(newval < min) {
							min = newval;
						}
					}
					dp[r][c] = min;
				}
			}
			
			int ans = 999999999;
			for(int r=0; r<4; r++) {
				if(dp[r][cols-1] < ans) {
					ans = dp[r][cols-1];
				}
			}
			//out.println(Arrays.deepToString(dp));
			out.println(ans);
			out.flush();
			return;
		}
		
		if(rows == 3) {
			int[][] dp = new int[8][cols];
			
			int c0 = (bits[0][0] ? 4 : 0) + (bits[1][0] ? 2 : 0) + (bits[2][0] ? 1 : 0);
			for(int r=0; r<8; r++) {
				dp[r][0] = dist(c0,r);
			}
			
			for(int c=1; c<cols; c++) {
				
				int cval = (bits[0][c] ? 4 : 0) + (bits[1][c] ? 2 : 0) + (bits[2][c] ? 1 : 0);
				for(int r=0; r<8; r++) {
					int min = 999999999;
					for(int rprev=0; rprev<8; rprev++) {
						if((cntbits(r%4)+cntbits(rprev%4))%2 == 0) {
							continue;
						}
						if((cntbits(r/2)+cntbits(rprev/2))%2 == 0) {
							continue;
						}
						int newval = dist(r,cval) + dp[rprev][c-1];
						if(newval < min) {
							min = newval;
						}
					}
					dp[r][c] = min;
				}
			}
			
			int ans = 999999999;
			for(int r=0; r<8; r++) {
				if(dp[r][cols-1] < ans) {
					ans = dp[r][cols-1];
				}
			}
			//out.println(Arrays.deepToString(dp));
			out.println(ans);
			out.flush();
			return;
		}
		
		out.println(-1);
		return;
		
	}
	
	static int cntbits(int n) {
		int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count;
	}
	
	static int dist(int a, int b) {
		int n = a^b;
		int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count;
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
