import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class C630B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		
		int[] factors = new int[]{2,3,5,7,11,13,17,19,23,29,31};
		
		
		
		for(int i=0; i<t; i++) {
			boolean[] used = new boolean[11];
			int[] reindex = new int[11];
			
			int n = sc.nextInt();
			int[] store = new int[n];
			
			for (int x=0; x<n; x++) {
				int v = sc.nextInt();
				for(int p=0; p<11; p++) {
					int d = factors[p];
					if(v%d == 0) {
						store[x] = p;
						used[p] = true;
						break;
					}
				}
				
			}
			
			int cnt = 1;
			for (int y=0; y<11; y++) {
				if(used[y]) {
					reindex[y] = cnt;
					cnt++;
				} else {
					reindex[y] = -1;
				}
			}
			
			System.out.println(cnt - 1);
			
			for(int x=0; x<n; x++) {
				System.out.print(reindex[store[x]] + " ");
			}
			System.out.println();
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
