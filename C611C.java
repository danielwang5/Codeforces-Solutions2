import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C611C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		boolean[] havenum = new boolean[n];
		boolean[] havepos = new boolean[n];
		
		String[] t = sc.readLine().split(" ");
		for(int x=0; x<n; x++){
			int p = Integer.parseInt(t[x]);
			if (p > 0) {
				havenum[p-1] = true;
				havepos[x] = true;
			}
		}
		ArrayList<Integer> othernum = new ArrayList<Integer>();
		ArrayList<Integer> cyclenum = new ArrayList<Integer>();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		for(int x=0; x<n; x++) {
			if (!havepos[x])
				pos.add(x);
			if (!havenum[x]) {
				if (havepos[x]) {
					othernum.add(x);
				} else {
					cyclenum.add(x);
				}
			}
		}
		
		int op = 0;
		int cp = 0;
		int pp = 0;

		for(int x=0; x<n; x++) {
			if (pp < pos.size() && pos.get(pp) == x) {
				if (cyclenum.size() == 1) {
					if (cp < cyclenum.size() && cyclenum.get(cp) != x) {
						System.out.print((cyclenum.get(cp)+1) +" ");
						cp++;
					} else {
						System.out.print((othernum.get(op)+1) + " ");
						op++;
					}
				} else {
					if (cp < cyclenum.size() && cyclenum.get(cp) == x) {
						System.out.print((cyclenum.get((cp+1)%cyclenum.size())+1) +" ");
						cp++;
					} else {
						System.out.print((othernum.get(op)+1) + " ");
						op++;
					}
				}
				
				pp++;
			} else {
				System.out.print(t[x] + " ");
			}
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
