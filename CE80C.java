import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CE80C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		long n = sc.nextLong();
		long m = sc.nextLong();
		long mod = 1000000007;
		
		n = n-1;
		m = 2*m;
		n += m;
		//System.out.println(n);
		//System.out.println(m);
		
		long ans = 1;
		
		for(long x=n; x>n-m; x--) {
			ans *= x;
			ans %= mod;
		}
		
		//System.out.println(ans);
		
		for(long x=m; x>1; x--) {
			ans = div(ans, x, mod);
		}
		
		System.out.print(ans);
	}
	
	static long div(long a, long b, long m) {
		long inv = inverse(b, m);
		return (inv * a) % m;
	}
	
	static long inverse(long k, long n) {
      long[] vals = gcd(k, n);
      long d = vals[0];
      long a = vals[1];
      long b = vals[2];
      if (d > 1) return 0;
      if (a > 0) return a;
      return n + a;
   }
	
	static long[] gcd(long p, long q) {
      if (q == 0)
         return new long[] { p, 1, 0 };
      long[] vals = gcd(q, p % q);
      long d = vals[0];
      long a = vals[2];
      long b = vals[1] - (p / q) * vals[2];
      return new long[] { d, a, b };
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
