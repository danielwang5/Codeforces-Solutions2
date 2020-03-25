import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CE80A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		
		for(int x=0; x<t; x++) {
			long n = sc.nextLong();
			long d = sc.nextLong();
			
			long s = (long) Math.floor(Math.sqrt(d));
			long min = 0;
			if(d == 1) {
				min = 1;
			} else if (d == 2) {
				min = 2;
			}else if(s*s == d) {
				min = 2*s-1;
			} else {
				min = (long) (s + Math.ceil((double)d/(double)(s+1)));
			}
			
			//System.out.println(min);
			if(min <= n) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
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
