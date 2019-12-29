import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE58B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] t = sc.readLine().split("");
		int[] j = new int[3];
		
		int phase = 1;
		
		for(String s: t) {
			if(phase == 1) {
				if(s.equals("[")) {
					phase++;
				}
			}
			else if(phase == 2) {
				if(s.equals(":")) {
					j[0] = 4;
					phase++;
				}
			}
			else if(phase == 3) {
				if(s.equals("|")) {
					j[0]++;
				}
				if(s.equals(":")) {
					j[1] = j[0];
				}
				if(s.equals("]")) {
					j[2] = j[1];
				}
			}
		}
		
		if(j[2] > 0) {
			System.out.print(j[2]);
		}
		else {
			System.out.print(-1);
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
