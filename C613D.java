import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C613D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		long[] list = new long[n];
		
		for(int y=0; y<n; y++){
			list[y] = sc.nextLong();
		}
		
		long max = 99999999999999l;
		long c = (long) Math.pow(2, 30);
		for(int y=0; y<n; y++) {
			//long treeval = 0;
			long num = list[y];
			long rev = 0;
			int val = ((num & c)>0 ? 2 : 1);
			for(long bit = c; bit > 1; bit /= 2) {
				
				int nextval = ((num & (bit/2))>0 ? 2 : 1);
				rev += val;
				
				if (map.containsKey(rev)) {
					if (nextval == 1 && map.get(rev) == 2) {
						map.put(rev, 3);
					} else if (nextval == 2 && map.get(rev) == 1) {
						map.put(rev, 3);
					}
				} else {
					map.put(rev, nextval);
				}
				
//				if (map.get(rev) == 3) {
//					treeval += bit/2;
//				}
				
				val = nextval;
				
				rev *= 3;
			}
			
//			if(treeval > max) {
//				max = treeval;
//			}
		}
		
		for(int y=0; y<n; y++) {
			long treeval = 0;
			long num = list[y];
			long rev = 0;
			for(long bit = c; bit > 1; bit /= 2) {
				int val = ((num & bit)>0 ? 2 : 1);
				rev += val;
				
				if (map.get(rev) == 3) {
					treeval += bit/2;
				}
				
				rev *= 3;
			}
			
			//System.out.println(treeval);
			
			if(treeval < max) {
				max = treeval;
			}
		}
		System.out.print(max);
		//System.out.print(Arrays.toString(map.entrySet().toArray()));
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
