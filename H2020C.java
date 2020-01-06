import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class H2020C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		long n = sc.nextLong();
		long p = sc.nextLong();
		
		long[] facs = new long[250001];
		facs[1] = 1;
		for (int x=2; x<facs.length; x++) {
			facs[x] = (facs[x-1]*(long)x)%p;
		}
		
		long ans = 0;
		
		for(int y=1; y<=n; y++) {
			long far = y;
			far *= facs[y];
			far %= p;
			far *= facs[(int)n-y+1];
			far %= p;
			ans += far;
			ans %= p;
		}
		System.out.print(ans);
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