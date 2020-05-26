import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C530C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String s = sc.readLine();
		int n = Integer.parseInt(sc.readLine());
		
		String[] sp = s.split("");
		
		int chars = 0;
		int cane = 0;
		int flake = 0;
		
		for(String ch: sp) {
			if(ch.equals("?")) {
				cane++;
			}
			else if(ch.equals("*")) {
				flake++;
			}
			else {
				chars++;
			}
		}
		
		
		int low = 0;
		int high = 0;
		
		if(flake > 0) {
			low = chars - cane - flake;
			high = 99999;
		}
		else {
			low = chars - cane - flake;
			high = chars;
		}
		
		if(n < low || n > high) {
			System.out.print("Impossible");
			return;
		}
		
		ArrayList<String> ans = new ArrayList<String>();
		
		int diff = n - low;
		
		if(flake > 0) {
			for(String ch: sp) {
				if(ch.equals("?")) {
					ans.remove(ans.size() - 1);
				}
				else if(ch.equals("*")) {
					if(diff > 0) {
						String last = ans.get(ans.size() - 1);
						for(int h=1; h<diff; h++) {
							ans.add(last);
						}
						diff = 0;
					}
					else {
						ans.remove(ans.size() - 1);
					}
				}
				else {
					ans.add(ch);
				}
			}
		}
		else {
			for(String ch: sp) {
				if(ch.equals("?")) {
					if(diff <= 0) {
						ans.remove(ans.size() - 1);
					}
					diff--;
				}
				else {
					ans.add(ch);
				}
			}
		}
		
		System.out.print(String.join("", ans));
		
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
