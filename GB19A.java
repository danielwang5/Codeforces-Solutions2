import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GB19A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(sc.readLine());
		for(int x=0; x<t; x++) {
			String[] dir = sc.readLine().split(" ");
			int n = Integer.parseInt(dir[0]);
			int k1 = Integer.parseInt(dir[1]);
			int k2 = Integer.parseInt(dir[2]);
			
			boolean first = false;
			
			String[] g = sc.readLine().split(" ");
			for(int y=0; y<g.length; y++) {
				int l = Integer.parseInt(g[y]);
				if (l==n) {
					first = true;
					//System.out.println("YES");
				}
			}
			
			sc.readLine();
			
			if(first) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}

/* 
BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(sc.readLine());

String[] t = sc.readLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++) {
	list[x] = Integer.parseInt(t[x]);
}
		
String[] dir = sc.readLine().split(" ");
int a = Integer.parseInt(dir[0]);
int b = Integer.parseInt(dir[1]);
int c = Integer.parseInt(dir[2]);
int d = Integer.parseInt(dir[3]);
int e = Integer.parseInt(dir[4]);
int n = Integer.parseInt(sc.readLine());
*/
