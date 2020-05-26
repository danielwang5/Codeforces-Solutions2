import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C530A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int w = Integer.parseInt(dir[0]);
		int h = Integer.parseInt(dir[1]);
		
		dir = sc.readLine().split(" ");
		int u1 = Integer.parseInt(dir[0]);
		int d1 = Integer.parseInt(dir[1]);
		
		dir = sc.readLine().split(" ");
		int u2 = Integer.parseInt(dir[0]);
		int d2 = Integer.parseInt(dir[1]);
		
		while(h > 0) {
			w += h;
			if(d1 == h) {
				w -= u1;
				if(w<0) {
					w=0;
				}
			}
			else if(d2 == h) {
				w -= u2;
				if(w<0) {
					w=0;
				}
			}
			h -= 1;
		}
		
		System.out.print(w);
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
