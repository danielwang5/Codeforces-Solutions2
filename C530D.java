import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C530D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		long sum = 0;
		
		ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>();
		for(int x=0; x<n; x++) {
			ArrayList<Integer> y = new ArrayList<Integer>();
			children.add(y);
		}
		
		
		//System.out.print(children);
		
		String[] t = sc.readLine().split(" ");
		int[] parents = new int[n];
		for(int x=0; x<n-1; x++){
			parents[x+1] = Integer.parseInt(t[x]) - 1;
		}
		
		t = sc.readLine().split(" ");
		int[] values = new int[n];
		for(int x=0; x<n; x++){
			values[x] = Integer.parseInt(t[x]);
		}
		
		for(int x=1; x<n; x++){
			int ch = x;
			int p = parents[x];
			children.get(p).add(ch);
		}
		
		boolean ok = true;
		
		//System.out.println(children);
		
		for(int x=1; x<n; x++) {
			ArrayList<Integer> chs = children.get(x);
			if(values[x] == -1) {
				
				int old = values[parents[x]];

				if(chs.size() == 0) {
					
				}
				else if(chs.size() == 1) {
					if(values[chs.get(0)] < old) {
						ok = false;
					}
					sum += (long)(values[chs.get(0)] - old);
				}
				else{
					long min = 1999999999999l;
					for(int k: chs) {
						if(values[k] < old) {
							ok = false;
						}
						if(values[k] < min) {
							min = values[k];
						}
					}
					int target = (int) (min - old);
					sum += (long)target;
					
					for(int k:chs) {
						sum += values[k] - (old+target);
					}
					
				}
			}
			else {
				
			}
		}
		if(ok) {
			sum += values[0];
			
			System.out.print(sum);
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
