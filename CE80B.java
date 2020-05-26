import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CE80B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		
//		for(long x=1; x<200; x++) {
//			for(long y=1; y<200; y++) {
//				if(x*y + x + y == concat(x,y)) {
//					System.out.println(x + " "+ y);
//				}
//			}
//		}
		
		for(int x=0; x<t; x++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			
			long ans = 0;
			
			long nine = 9;
			while (nine <= b) {
				ans += a;
				nine = nine*10 + 9;
			}
			
			System.out.println(ans);
		}
	}
	
	public static long concat(long a, long b) {
		return Long.valueOf(String.valueOf(a) + String.valueOf(b));
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
