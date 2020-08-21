import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C662E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		ArrayList<char[]> words = new ArrayList<>();
		
		for(int tt=0; tt<n; tt++) {
			words.add(sc.next().toCharArray());
		}
		
		out.flush();
		
		
	}
	
//	class StrComparator implements Comparator<char[]> {
//	// true if b later or equal
	static boolean compare(char[] a, char[] b, int ax, int bx) {
		int pa = 0;
		int pb = 0;
		
		int lena = a.length - ((ax == -1) ? 0 : 1);
		int lenb = b.length - ((bx == -1) ? 0 : 1);
		
		for(int it=0; it<Math.min(lena, lenb); it++) {
			if(pa == ax) {
				pa++;
			}
			if(pb == bx){
				pb++;
			}
			
			if(a[pa] > b[pb]) {
				return false;
			} else if(a[pa] < b[pb]) {
				return true;
			}
			
			pa++;
			pb++;
		}
		
		return b.length >= a.length;
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
