import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CE84E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		long mod = 998244353l;
		
		long p10 = 1;
		long tot = 0;
		long cum = 0;
		long cum2 = 0;
		long next;
		
		long[] ans = new long[n+1];
		
		for(int y=1; y<=n; y++) {
			p10 *= 10; p10 %= mod;
			tot = p10 * y; tot %= mod;
			
			next = (tot - cum - cum2) % mod;
			if(next < 0) {
				next += mod;
			}
			ans[y] = next;
			
			cum += ans[y]; cum %= mod;
			cum2 += cum; cum2 %= mod;
			//System.out.println(tot + " " + cum + " " + cum2);
		}
		
		//System.out.print(Arrays.toString(ans));
		
		for(int y=n; y>=1; y--) {
			System.out.print(ans[y] + " ");
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
