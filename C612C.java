import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C612C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		boolean[] used = new boolean[n];
		int[] g = new int[n];
		int[][] besto = new int[n][n];
		int[][] beste = new int[n][n];
		int maxeven = (n-1)/2 + 1;
		int maxodd = (n)/2;
		
		if(n == 1) {
			System.out.print(0);
			return;
		}
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				besto[x][y] = 999;
				beste[x][y] = 999;
			}
		}
		besto[0][0] = 0;
		beste[0][0] = 0;
		
		for(int y=0; y<n; y++){
			int x = sc.nextInt()-1;
			g[y] = x;
			if(x>=0) {
				used[x] = true;
			}
		}
		
		//System.out.println(maxeven + " " + maxodd);
		
		for(int x=1; x<=n; x++) {
			if(g[x-1] >= 0) { //set
				for (int i=0; i<=x; i++) {
					int nodd = i;
					int neven = x-i;
					
					//System.out.println(nodd + " ff " + neven);
					
					if(nodd > maxodd || neven > maxeven) {
						continue;
					}
					
					if (g[x-1] % 2 == 1) {
						if (nodd > 0) {
							int opt1 = besto[nodd-1][neven];
							int opt2 = beste[nodd-1][neven] + 1;
							besto[nodd][neven] = Math.min(opt1, opt2);
						}
						beste[nodd][neven] = 10000;
					} else {
						if (neven > 0) {
							int opt1 = besto[nodd][neven-1] + 1;
							int opt2 = beste[nodd][neven-1];
							beste[nodd][neven] = Math.min(opt1, opt2);
						}
						besto[nodd][neven] = 10000;
					}
				}
			} else { //free
				for (int i=0; i<=x; i++) {
					int nodd = i;
					int neven = x-i;
					
					//System.out.println(nodd + " ff " + neven);
					
					if(nodd > maxodd || neven > maxeven) {
						continue;
					}
					
					if (nodd > 0) {
						int opt1 = besto[nodd-1][neven];
						int opt2 = beste[nodd-1][neven] + 1;
						besto[nodd][neven] = Math.min(opt1, opt2);
					}
					if (neven > 0) {
						int opt1 = besto[nodd][neven-1] + 1;
						int opt2 = beste[nodd][neven-1];
						beste[nodd][neven] = Math.min(opt1, opt2);
					}
				}
			}
			
			
		}
//		System.out.println(Arrays.deepToString(besto));
//		System.out.println(Arrays.deepToString(beste));
		
		System.out.print(Math.min(besto[maxodd][maxeven], beste[maxodd][maxeven]));
		
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in));}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}

/* 
int n = sc.nextInt();

for(int y=0; y<n; y++){
	int x = sc.nextInt();
}

int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
int d = sc.nextInt();
int e = sc.nextInt();
*/
