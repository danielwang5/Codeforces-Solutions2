import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class C630C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			char[] c = s.toCharArray();
			
			int chunks = n/k;
			int types = (n+1)/2;
			
			List<HashMap<Character, Integer>> mapArray = new ArrayList<HashMap<Character, Integer>>();
			
			for(int x=0; x<types; x++) {
				mapArray.add(new HashMap<Character, Integer>());
				mapArray.get(x).put('+', 0);
			}
			
			for(int ind=0; ind<n; ind++) {
				char chr = c[ind];
				int chunkno = ind/k;
				int remain = ind%k;
				int type = Math.min(remain, k-1-remain);
				HashMap<Character, Integer> m = mapArray.get(type);
				
				if(!m.containsKey(chr)) {
					m.put(chr, 1);
				} else {
					m.put(chr, m.get(chr) + 1);
				}
				m.put('+', m.get('+') + 1);
			}
			
			int ans = 0;
			char[] letters = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
			
			for(int z=0; z<types; z++) {
				HashMap<Character, Integer> m = mapArray.get(z);
				int max = 0;
				for(int l=0; l<letters.length; l++) {
					char letter = letters[l];
					if(m.containsKey(letter)) {
						if(m.get(letter) > max) {
							max = m.get(letter);
						}
					}
				}
				ans += m.get('+') - max;
				
			
			}
			
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
