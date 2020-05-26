import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C638C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] chr = new int[26];
			char[] c = sc.next().toCharArray();
			for(int x=0; x<n; x++) {
				chr[c[x]-'a']++;
			}
			
			//out.print(Arrays.toString(chr));
			
			boolean even = true;
			boolean excess = false;
			
			for(int i=0; i<26; i++) {
				if(chr[i]>0) {
					if(excess) {
						even = false;
						break;
					}
					if(chr[i] > k) {
						excess = true;
					} else if(chr[i] < k) {
						even = false;
						break;
					}
				}	
			}
			// T,F  T,T   F,_
			if(even && !excess) {
				for(int i=0; i<26; i++) {
					for(int x=0; x<chr[i]/k; x++) {
						out.print((char)(i+'a'));
					}
				}
			} else if(even && excess) {
				for(int i=0; i<26; i++) {
					for(int x=0; x<(chr[i]+k-1)/k; x++) {
						out.print((char)(i+'a'));
					}
				}
			} else {
				int first = 0;
				int last = 0;
				int ind = 0;
				
				for(int i=0; i<k; i++) {
					if(ind >= 26) {
						break;
					}
					if(chr[ind] > 0) {
						if(i==0) {
							first = ind;
						}
						last = ind;
						chr[ind]--;
					} else {
						while(ind<26 && chr[ind] <= 0) {
							ind ++;
						}
						if(ind < 26) {
							if(i==0) {
								first = ind;
							}
							last = ind;
							chr[ind]--;
						}
						
					}
				}
				
				if(first == last) {
					out.print((char)(last+'a'));
					for(int i=0; i<26; i++) {
						for(int x=0; x<chr[i]; x++) {
							out.print((char)(i+'a'));
						}
					}
					
				} else {
					out.print((char)(last+'a'));
				}
			}
			
			out.println();
		}
		
		out.flush();
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
