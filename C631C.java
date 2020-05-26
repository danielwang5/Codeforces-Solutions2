import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class C631C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] lens = new int[m];
		long sum = 0;
		for(int i=0; i<m; i++) {
			int l = sc.nextInt();
			lens[i] = l;
			sum += l;
			
			if(l > n-i) {
				System.out.print(-1);
				return;
			}
		}
		
		if(sum < n) {
			System.out.print(-1);
			return;
		}
		
		System.out.print(1+" ");
		int mark = lens[0];
		
		int last = lens[0]-1;
		long leeway = sum - n;
		for(int i=1; i<m; i++) {
			int l = lens[i];
			int freedom = last;
			if(leeway <= 0) {
				System.out.print((mark+1)+" ");
				mark += lens[i];
			} else if (leeway < freedom) {
				mark -= leeway;
				System.out.print((mark+1)+" ");
				mark += lens[i];
				leeway = 0;
			} else {
				mark -= freedom;
				System.out.print((mark+1)+" ");
				mark += lens[i];
				leeway -= freedom;
			}
			
			last = lens[i] - 1;
			
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
