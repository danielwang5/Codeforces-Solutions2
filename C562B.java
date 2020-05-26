import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C562B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int n = Integer.parseInt(dir[0]);
		int m = Integer.parseInt(dir[1]);
		
		int a1s = 0;
		int a2s = 0;
		
		boolean[] a1 = new boolean[300000];
		boolean[] a2 = new boolean[300000];
		
		int spare = -1;
		
		String[] l = sc.readLine().split(" ");
		int d1 = Integer.parseInt(dir[0]);
		int d2 = Integer.parseInt(dir[1]);
		
		if(d1 == d2) {
			a1s = 1;
			a1[d1] = true;
		}
		else {
			a1s = 1;
			a2s = 1;
			a1[d1] = true;
			a2[d2] = true;
		}
		
		for(int i=1; i<m; i++) {
			l = sc.readLine().split(" ");
			d1 = Integer.parseInt(dir[0]);
			d2 = Integer.parseInt(dir[1]);
			
			if(d1 == d2) {
				
			}
			else {
				
			}
		}
		
		
//		String[] l = sc.readLine().split(" ");
//		int d1 = Integer.parseInt(dir[0]);
//		int d2 = Integer.parseInt(dir[1]);
//		int d3 = 0;
//		int d4 = 0;
//		
//		
//		int phase = 0;
//		boolean ans = true;
//		
//		for(int i=1; i<m; i++) {
//			l = sc.readLine().split(" ");
//			int a = Integer.parseInt(dir[0]);
//			int b = Integer.parseInt(dir[1]);
//			
//			if(phase == 0) {
//				if(a == d1) {
//					if(b == d2 || b == d1) {
//						continue;
//					}
//					else {
//						d3 = d2;
//						d4 = b;
//						phase = 1;
//					}
//				}
//				if(a == d2) {
//					if(b == d1 || b == d2) {
//						continue;
//					}
//					else {
//						d3 = d1;
//						d4 = 
//					}
//				}
//			}
//		}
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
