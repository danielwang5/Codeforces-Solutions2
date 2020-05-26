import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GB19B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		blah:
		for(int x=0; x<n; x++) {
			int l = Integer.parseInt(sc.readLine());
			
			String[] t = sc.readLine().split(" ");
			int prev = 0;
			for(int y=0; y<l; y++) {
				int curr = Integer.parseInt(t[y]);
				if (y>0) {
					if (curr-prev>=2 || prev-curr>=2) {
						System.out.println("YES");
						System.out.println((y)+" "+(y+1));
						continue blah;
					}
				}
				
				prev = curr;
			}
			System.out.println("NO");
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
