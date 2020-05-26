import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C637D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		String[] nums = new String[] {"1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010", "1111111", "1111011"};
		
		int[][] need = new int[n][10];
		
		for(int x=0; x<n; x++) {
			String s = sc.next();
			
			for(int d=0; d<=9; d++) {
				int needed = 0;
				for(int p=0; p<7; p++) {
					char c1 = nums[d].charAt(p);
					char c2 = s.charAt(p);
					
					if (c1 == '1' && c2 == '0') {
						needed ++;
					} else if (c1 == '0' && c2 == '1') {
						need[x][d] = -999;
						break;
					}
				}
				
				if(need[x][d] != -999) {
					need[x][d] = needed;
				}
			}
		}
		
		int[] ans = new int[n];
		
		out.println(Arrays.deepToString(need));
		
		int used = 0;
		for(int x=0; x<n; x++) {
			int req = 0;
			for(int d=9; d>=0; d--) {
				if (need[x][d] > -500) {
					ans[x] = d;
					req = need[x][d];
					used += req;
					break;
				}
			}
			
			for(int d=0; d<=9; d++) {
				if (need[x][d] > -500) {
					need[x][d] -= req;
				}
			}
		}
		
		int diff = k - used;
		if (diff == 0) {
			out.print(ans);
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
