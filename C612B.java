import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C612B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n < 3) {
			System.out.print(0);
			return;
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] list = new String[n];
		
		for(int y=0; y<n; y++){
			String s = sc.next();
			map.put(s, y);
			list[y] = s;
		}
		
		long ans = 0;
		
		for(int x=0; x<n-1; x++) {
			for(int y=x+1; y<n; y++) {
				String a = list[x];
				String b = list[y];
				
				char[] c = new char[k];
				
				for(int z=0; z<k; z++) {
					char aa = a.charAt(z);
					char bb = b.charAt(z);
					if(aa == bb) {
						c[z] = aa;
					} else {
						if ('S' != aa && 'S' != bb) {
							c[z] = 'S';
						} else if ('E' != aa && 'E' != bb) {
							c[z] = 'E';
						} else {
							c[z] = 'T';
						}
					}
				}
				String fin = new String(c);
				if(map.containsKey(fin) && map.get(fin) > y) {
					//System.out.println(a + " " + b + " " + fin);
					ans++;
				}
			}
		}
		
		System.out.print(ans);
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
