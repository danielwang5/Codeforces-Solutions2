import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C631B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		
		for(int x=0; x<t; x++) {
			int n = sc.nextInt();
			
			boolean[] b = new boolean[n+1];
			int max = 0;
			
			int[] aa = new int[n];
			
			boolean[] ans = new boolean[n];
			boolean done = false;
			
			for(int i=0; i<=n-1; i++) {
				int a = sc.nextInt();
				aa[i] = a;
				if(a<=n && !b[a]) {
					b[a] = true;
				} else {
					done = true;
				}
				if(a > max) {
					max = a;
				}
				
				if(!done && max == i+1) {
					ans[i] = true;
				}
				
			}
			
			//System.out.println(Arrays.toString(ans));
			
			b = new boolean[n+1];
			max = 0;
			done = false;
			
			
			
			for(int i=n-1; i>=1; i--) {
				int a = aa[i];
				if(a<=n && !b[a]) {
					b[a] = true;
				} else {
					done = true;
				}
				
				if(a > max) {
					max = a;
				}
				
				if(!done && max == n-i) {
					
				} else {
					ans[i-1] = false;
				}
				
				//System.out.println(Arrays.toString(ans));
			}
			
			ArrayList<Integer> aans = new ArrayList<Integer>();
			int cnt = 0;
			for(int i=0; i<n-1; i++) {
				if(ans[i]) {
					cnt++;
					aans.add(i+1);
				}
			}
			
			System.out.println(cnt);
			for(int num: aans) {
					System.out.println(num+" "+(n-num));
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
