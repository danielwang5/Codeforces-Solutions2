import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class C641C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		
		int[] vals = new int[n];
		//boolean[] seen = new boolean[n];
		//boolean[] comp = new boolean[n];
		
		//int largeprime = 0;
		int numcomp = 0;
		Set<Integer> primeset = new HashSet<Integer>();
		
		List<Integer> primes = primeNumbersBruteForce(447);
		
		//out.println(primes);
		
		int[] mins = new int[primes.size()];
		int[] mins2 = new int[primes.size()];
		
		for(int x=0; x<primes.size(); x++) {
			mins[x] = 999;
			mins2[x] = 999;
		}
		
		for(int x=0; x<n; x++) {
			int s = sc.nextInt();
			vals[x] = s;
		}
		
		for(int x=0; x<n; x++) {
			int num = vals[x];
			
			int pi = 0;
			boolean prime = true;
			
			for (int p: primes) {
				if (num%p == 0) {
					prime = false;
					break;
				}
			}
			
			if (prime) {
				primeset.add(num);
				if (primeset.size() >= 3) {
					break;
				}
			} else {
				
				for (int p: primes) {
					int cnt = 0;
					while (num % p == 0) {
						prime = false;
						num /= p;
						cnt += 1;
					}
					
//					if(p == 3) {
//						out.println(cnt);
//					}
					
					if (cnt <= mins[pi]) {
						mins2[pi] = mins[pi];
						mins[pi] = cnt;
					} else if (cnt < mins2[pi]) {
						mins2[pi] = cnt;
					}
					
					pi += 1;
				}
			}
			
			if (num > 1) {
				primeset.add(vals[x]);
				if (primeset.size() >= 3) {
					break;
				}
			} else {
				numcomp++;
			}
			
			
		}
		
		out.println(Arrays.toString(mins));
		out.println(Arrays.toString(mins2));
		
		int ans = 1;
		
		
		if (primeset.size() == 3) {
			out.print(1);
		} else if (primeset.size() == 2) {
			if(numcomp == 0) {
				out.println("hablah");
				out.print((long)primeset.iterator().next() * (long)primeset.iterator().next());
			} else {
				out.print(1);
			}
		} else if (primeset.size() == 1) {
			for(int x=0; x<primes.size(); x++) {
				int p = primes.get(x);
				if (mins[x] == 999) {
					continue;
				}
				for(int i=0; i<mins[x]; i++) {
					ans *= p;
				}
			}
			
			out.print((long)ans * (long)primeset.iterator().next());
		} else {
			for(int x=0; x<primes.size(); x++) {
				int p = primes.get(x);
				if (mins2[x] == 999) {
					continue;
				}
				for(int i=0; i<mins2[x]; i++) {
					ans *= p;
				}
			}
			
			out.print(ans);
		}
		
		
		
		out.flush();
	}
	
	public static List<Integer> primeNumbersBruteForce(int n) {
	    List<Integer> primeNumbers = new LinkedList<>();
	    if (n >= 2) {
	        primeNumbers.add(2);
	    }
	    for (int i = 3; i <= n; i += 2) {
	        if (isPrimeBruteForce(i)) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	public static boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i*i < number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
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
