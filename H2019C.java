import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H2019C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		int total = 0;
		
		int[] counts = new int[1000001];
		
		for(int x=0; x<n; x++){
			String s = sc.readLine();
			
			int d = depth(s);
			
			if(d != 9999999) {
				counts[d+500000]++;
			}
		}
		
		//System.out.println(counts[49997]);
		//System.out.println(counts[49998]);
		//System.out.println(counts[49999]);
		//System.out.println(counts[50000]);
		//System.out.println(counts[50001]);
		//System.out.println(counts[50002]);
		//System.out.println(counts[50003]);
		
		for(int i=0; i<500000; i++) {
			total += Math.min(counts[i],counts[1000000-i]);
		}
		
		total += counts[500000]/2;
		
		System.out.print(total);
	}
	
	public static int depth(String s) {
		int df = 0;
		int db = 0;
		boolean forward = true;
		boolean backward = true;
		String[] ss = s.split("");
		for(String p:ss) {
			if(p.equals("(")) {
				df++;
			}
			else{
				df--;
			}
			if(df<0) {
				forward = false;
				break;
			}
		}
		
		for(int i=ss.length-1; i>=0; i--) {
			String p = ss[i];
			
			if(p.equals(")")) {
				db++;
			}
			else{
				db--;
			}
			if(db<0) {
				backward = false;
				break;
			}
		}
		
		if(!forward && !backward) {
			return 9999999;
		}
		if(forward) {
			return df;
		}
		if(backward) {
			return -db;
		}
		return 0;
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
