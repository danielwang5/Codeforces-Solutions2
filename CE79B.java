import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE79B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int k = Integer.parseInt(sc.readLine());
		
		for(int x=0; x<k; x++){
			String[] dir = sc.readLine().split(" ");
			int n = Integer.parseInt(dir[0]);
			int s = Integer.parseInt(dir[1]);
			
			//System.out.println(n + "ggg" + s);
			
			String[] t = sc.readLine().split(" ");
			int[] list = new int[n];
			for(int y=0; y<n; y++){
				list[y] = Integer.parseInt(t[y]);
			}
			
			int sum = 0;
			int max = 0;
			int mindex = 0;
			int tot = 0;
			boolean skip = false;
			int sol = 0;
			
			for(int y=0; y<n; y++) {
				int cur = list[y];
				if (cur > max) {
					max = cur;
					mindex = y+1;
				}
				
				sum += cur;
				
				if (sum > s) {
					if (!skip) {
						if (sum - max <= s) {
							sum -= max;
							skip = true;
							sol = mindex;
							//System.out.println(tot);
						} else {
							//System.out.println(tot);
							break;
						}
					} else {
						//System.out.println(tot);
						break;
					}
				} else {
					tot += 1;
				}
				
				if (y == n - 1) {
					//System.out.println(tot);
					break;
				}
			}
			
			System.out.println(sol);
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
