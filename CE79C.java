import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE79C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int l = Integer.parseInt(sc.readLine());
		
		for(int x=0; x<l; x++){
			String[] dir = sc.readLine().split(" ");
			int n = Integer.parseInt(dir[0]);
			int m = Integer.parseInt(dir[1]);
			
			int[] ind = new int[n+1];
			
			String[] t = sc.readLine().split(" ");
			int[] list = new int[n];
			for(int y=0; y<n; y++){
				list[y] = Integer.parseInt(t[y]);
				ind[list[y]] = y;
			}
			
			String[] f = sc.readLine().split(" ");
			int[] queue = new int[m];
			for(int y=0; y<m; y++){
				queue[y] = Integer.parseInt(f[y]);
			}
			
			
			int magic = 0;
			long time = 0;
			
			for (int y=0; y<m; y++) {
				int next = queue[y];
				if (ind[next] > magic) {
					magic = ind[next];
					time += (2 * (magic - y)) + 1;
				} else {
					time += 1;
				}
			}
			
			System.out.println(time);
		}
	}
}

/* 
BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(sc.readLine());

String[] t = sc.readLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++){
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
