import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CE85B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		for(int z=0; z<t; z++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			int[] l = new int[n];
			
			long total = 0;
			int cnt = 0;
			
			for(int y=0; y<n; y++) {
				int m = sc.nextInt();
				
				l[y] = m-x;
			}
			
			Arrays.sort(l);
			
			for(int y=n-1; y>=0; y--) {
				int m = l[y];
				total += m;
				cnt += 1;
				if(m >= 0) {
					if(y == 0) {
						out.println(cnt);
					}
					continue;
				}
				if (total >= 0) {
					if(y == 0) {
						out.println(cnt);
					}
				} else {
					out.println(cnt-1);
					break;
				}
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
