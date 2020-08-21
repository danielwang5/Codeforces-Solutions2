import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C648D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		test:
		for(int tt=0; tt<t; tt++) {
			
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			char[][] maze = new char[row][col];
			
			int numgood = 0;
			
			for(int i=0; i<row; i++) {
				String next = sc.next();
				char[] nxt = next.toCharArray();
				for(int j=0; j<col; j++) {
					maze[i][j] = nxt[j];
					if(nxt[j] == 'G') {
						numgood++;
					}
				}
			}
			
			if(numgood == 0) {
				out.println("Yes");
				continue test;
			}
			
			int[][] delta = new int[4][2];
			delta[0][0] = 1;
			delta[0][1] = 0;
			delta[1][0] = -1;
			delta[1][1] = 0;
			delta[2][0] = 0;
			delta[2][1] = -1;
			delta[3][0] = 0;
			delta[3][1] = 1;
			
			
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(maze[i][j] == 'B') {
						for(int[] d: delta) {
							int nrow = i+d[0];
							int ncol = j+d[1];
							
							//out.println(nrow + " " + ncol);
							
							if (nrow < 0 || nrow >= row || ncol < 0 || ncol >= col) {
								continue;
							}
							
							if(maze[nrow][ncol] == 'G') {
								out.println("No");
								continue test;
							}
							if(maze[nrow][ncol] == '.') {
								if(nrow == row-1 && ncol == col-1) {
									out.println("No");
									continue test;
								}
								maze[nrow][ncol] = '#';
							}
						}
					}
				}
			}
			
			//out.println(Arrays.deepToString(maze));
			
			// dfs time
			boolean[][] seen = new boolean[row][col];
			
			seen[row-1][col-1] = true;
			Queue<Integer> q = new LinkedList<>();
			
			int goodfound = 0;
			
			q.add((row-1)*col + (col-1));
			while(!q.isEmpty()) {
				int til = q.poll();
				int rr = til/col;
				int cc = til%col;
				
				for(int[] d: delta) {
					int nrow = rr+d[0];
					int ncol = cc+d[1];
					if (nrow < 0 || nrow >= row || ncol < 0 || ncol >= col) {
						continue;
					}
					if(seen[nrow][ncol]) {
						continue;
					}
					
					seen[nrow][ncol] = true;
					
					if(maze[nrow][ncol] == '#') {
						continue;
					}
					
					if(maze[nrow][ncol] == 'G') {
						goodfound++;
					}
					
					q.add((nrow*col) + ncol);
				}
			}
			
			if(goodfound == numgood) {
				out.println("Yes");
			} else {
				out.println("No");
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
