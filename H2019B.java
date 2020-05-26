import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H2019B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		boolean[] b = new boolean[360];
		b[0] = true;
		
		for(int x=0; x<n; x++){
			int d = Integer.parseInt(sc.readLine());
			boolean[] next = new boolean[360];
			for(int l=0; l<360; l++) {
				if(b[l]) {
					next[shiftUp(l,d)] = true;
					next[shiftDown(l,d)] = true;
				}
			}
			b = next;
			
		}
		
		if(b[0]) {
			System.out.print("YES");
		}
		else {
			System.out.print("NO");
		}
	}
	
	public static int shiftUp(int a, int d) {
		return (a+d)%360;	
	}
	
	public static int shiftDown(int a, int d) {
		int p = a-d;
		if (p<0){
			p += 360;
		}
		return p;
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