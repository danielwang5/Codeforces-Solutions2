import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class C631D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			long d = sc.nextLong();
			long m = sc.nextLong();
			
			long ans = 1;
			
			ArrayList<Long> a = new ArrayList<Long>();
			
			long p=1;
			while(true) {
				if (p*2<d) {
					a.add((long) (p+1));
				} else if(p*2 == d){
					a.add((long) (p+1));
					a.add((long) (2));
					break;
				} else {
					a.add(d-p+2);
					break;
				}
				p *= 2;
			}
			
			for(long x:a) {
				ans *= x;
				ans %= m;
			}
			ans -= 1;
			ans %= m;
			if(ans < 0)
				ans += m;
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
