import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CE89C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
//			out.println(row + " " + col);
//			out.flush();
			
			int[][] mat = new int[row][col];
			for(int r=0; r<row; r++) {
				for(int c=0; c<col; c++) {
					mat[r][c] = sc.nextInt();
				}
			}
			
			int ans = 0;
			int[] cnt0 = new int[(row+col)/2];
			int[] cnt1 = new int[(row+col)/2];
			
//			out.println(Arrays.deepToString(mat));
//			out.flush();
			
			for(int sum=0; sum<=row+col-2; sum++) {
				if((row+col-2)%2 == 0 && sum*2 == (row+col-2)) {
					continue;
				}
				int r = 0;
				int c = sum;
				while(c >= 0) {
//					out.println(r + " " + c);
//					out.flush();
					if(r < row && c < col) {
						if(mat[r][c] == 0) {
							cnt0[Math.min(sum, row+col-2-sum)]++;
						} else {
							cnt1[Math.min(sum, row+col-2-sum)]++;
						}
					}
					r++;
					c--;
				}
			}
			
//			out.println(Arrays.toString(cnt0));
//			out.println(Arrays.toString(cnt1));
			
			for(int i=0; i<(row+col)/2; i++) {
				ans += Math.min(cnt0[i], cnt1[i]);
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
