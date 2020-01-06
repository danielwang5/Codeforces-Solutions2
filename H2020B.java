import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class H2020B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		long good = 0;
		long ans = 0;
		ArrayList<Integer> mins = new ArrayList<Integer>();
		ArrayList<Integer> maxs = new ArrayList<Integer>();
		for(int y=0; y<n; y++){
			int l = sc.nextInt();
			int prev = 20000000;
			int min = 20000000;
			int max = -1;
			boolean done = false;
			for(int x=0; x<l; x++){
				int r = sc.nextInt();
				if (r > prev && !done) {
					good++;
					done = true;
				}
				if(x==0) {
					max = r;
				} 
				if(x==l-1) {
					min = r;
				}
				prev = r;
			}
			
			if(!done) {
				mins.add(min);
				maxs.add(max);
			}
		}
		
//		System.out.println(mins);
//		System.out.println(maxs);
		
		Collections.sort(mins);
		Collections.sort(maxs);
		
		int minp = 0;
		int maxp = 0;
		
		while(minp < mins.size() && maxp < maxs.size()) {
			int mmin = mins.get(minp);
			int mmax = maxs.get(maxp);
			if(mmin < mmax) {
				ans += (maxs.size() - maxp);
				minp++;
			} else {
				maxp++;
			}
		}
		
		ans += good*good + 2l*good*((long)maxs.size());
		//System.out.println(50000l*50000l+2l*50000l*50000l);
		System.out.println(ans);
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

while(n-- > 0){
	int x = s.nextInt();
}

int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
int d = sc.nextInt();
int e = sc.nextInt();
*/
