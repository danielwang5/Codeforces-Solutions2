import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class C612A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		for(int y=0; y<n; y++){
			int nn = sc.nextInt();
			int ans = 0;
			int cnt = 0;
			boolean ang = false;
			String[] s = sc.next().split("");
			for(String ss: s) {
				if(ss.equals("A")) {
					if (!ang) {
						ang = true;
						
					} else {
						cnt = 0;
					}
				} else {
					if(ang) {
						cnt++;
						if(cnt>ans) {
							ans = cnt;
						}
					}
				}
			}
			System.out.println(ans);
		}
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
