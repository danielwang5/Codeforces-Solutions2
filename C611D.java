import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C611D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int ntrees = Integer.parseInt(dir[0]);
		int npeople = Integer.parseInt(dir[1]);
		
		String[] t = sc.readLine().split(" ");
		int[] trees = new int[ntrees];
		for(int x=0; x<ntrees; x++) {
			trees[x] = Integer.parseInt(t[x]);
		}
		
		Arrays.sort(trees);
		
		int remain = npeople;
		int dist = 1;
		
//		boolean before[] = new boolean[ntrees];
//		boolean after[] = new boolean[ntrees];
//		Arrays.fill(before, true);
//		Arrays.fill(after, true);
		
		int totdist = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		ArrayList<Integer> place = new ArrayList<Integer>();
		for (int p = 0; p<ntrees*2; p++) {
			place.add(p);
		}
		
		int d,n,z;
		
		woop:
		while (remain > 0) {
			for (int l=0; l<place.size(); l++) {
				z = place.get(l);
				n = z/2;
				if (z%2==0) {
					if (n == 0) {
						d = trees[n] - dist;
						totdist += dist;
						ans.add(d);
						remain--;
						if(remain == 0) {
							break woop;
						}
					} else {
						if (trees[n] - dist - dist > trees[n-1]) {
							d = trees[n] - dist;
							totdist += dist;
							ans.add(d);
							remain--;
							if(remain == 0) {
								break woop;
							}
						} else {
							place.remove(l);
							l--;
						}
					}
				} else {
					if (n == ntrees-1) {
						d = trees[ntrees-1] + dist;
						totdist += dist;
						ans.add(d);
						remain--;
						if(remain == 0) {
							break woop;
						}
					} else {
						if (trees[n] + dist + dist - 1 < trees[n+1]) {
							d = trees[n] + dist;
							totdist += dist;
							ans.add(d);
							remain--;
							if(remain == 0) {
								break woop;
							}
						} else {
							place.remove(l);
							l--;
						}
					}
				}
			}
			dist++;
		}
		System.out.println(totdist);
		for (int i : ans) {
			System.out.print(i + " ");
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
