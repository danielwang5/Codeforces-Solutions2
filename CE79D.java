import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
import java.util.Map;

public class CE79D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		long mod = 998244353l;
		
		int l = Integer.parseInt(sc.readLine());
		
		long ans = 0;
		HashMap<Integer, Long> prob = new HashMap<>();
		HashMap<Integer, Long> numppl = new HashMap<>();
		
		for(int x=0; x<l; x++){
			String[] t = sc.readLine().split(" ");
			int n = Integer.parseInt(t[0]);
			//int[] list = new int[n];
			for(int y=0; y<n; y++){
				int curnum = Integer.parseInt(t[y+1]);
				if(numppl.containsKey(curnum)) {
					numppl.put(curnum, numppl.get(curnum)+1);
				} else {
					numppl.put(curnum, 1l);
				}
				
				long frac = inverse(n, mod);
				
				//ans = (ans + frac) % mod;
				if(prob.containsKey(curnum)) {
					prob.put(curnum, (prob.get(curnum)+frac)%mod);
				} else {
					prob.put(curnum, frac);
				}
				
				
			}
		}
		
		for (int g: prob.keySet()) {
			ans = div((ans + prob.get(g)), numppl.get(g), mod) % mod;
		}
//		System.out.println(prob);
//		System.out.println(ans);
		System.out.println(div(ans, l, mod));
	}
	
	static long div(long a, long b, long m) {
		long inv = inverse(a, m);
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
}

/* 
BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(sc.readLine());

String[] t = sc.readLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++){
	list[x] = Integer.parseInt(t[x]);
}
		
String[] dir = sc.readLine().split(" ");
int a = Integer.parseInt(dir[0]);
int b = Integer.parseInt(dir[1]);
int c = Integer.parseInt(dir[2]);
int d = Integer.parseInt(dir[3]);
int e = Integer.parseInt(dir[4]);
int n = Integer.parseInt(sc.readLine());
*/
