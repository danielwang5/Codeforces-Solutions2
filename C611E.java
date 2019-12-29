import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C611E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		int[] counts = new int[n];
		
		String[] t = sc.readLine().split(" ");
		for(int x=0; x<n; x++){
			int p = Integer.parseInt(t[x]);
			if ((counts[p-1] < 3)) {
				counts[p-1]++;
			}
		}
		
		//System.out.println(Arrays.toString(counts));
		
		int minocc = 0;
		int maxocc = 0;
		int min = 0;
		int max = 0;
		
		for(int x=0; x<n; x++) {
			int cnt = counts[x];
			//System.out.println(min + " " + max);
			if (cnt > 0) {
				if (minocc == 0) {
					minocc = 3;
					min++;
				}
				
				if (maxocc == 0) {
					maxocc += cnt;
					max += cnt;
				} else if (maxocc == 1) {
					maxocc += Math.min(cnt, 2);
					max += Math.min(cnt, 2);
				} else if (maxocc == 2) {
					maxocc += Math.min(cnt, 1);
					max += Math.min(cnt, 1);
				}
			}
			
			if (minocc > 0) {
				minocc--;
			}
			if (maxocc > 0) {
				maxocc--;
			}
		}
		
		System.out.println(min + " " + max);
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
