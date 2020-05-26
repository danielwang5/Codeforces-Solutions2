import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fool20F {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		String s = sc.next();
		String[] elem = new String[] {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"};
		
		int len = s.length();
		boolean[] ans = new boolean[len];
		
		for(int i=0; i<len; i++) {
			if (i==0) {
				for(String e: elem) {
					if (e.equals(s.substring(0, 1))) {
						ans[0] = true;
					}
				}
			} else if (i==1) {
				for(String e: elem) {
					e = e.toUpperCase();
					if(e.length() == 1) {
						if (ans[i-1] && e.equals(s.substring(i, i+1))) {
							ans[i] = true;
						}
					} else {
						if (e.equals(s.substring(i-1, i+1))) {
							ans[i] = true;
						}
					}
				}
			} else {
				for(String e: elem) {
					e = e.toUpperCase();
					if(e.length() == 1) {
						if (ans[i-1] && e.equals(s.substring(i, i+1))) {
							ans[i] = true;
						}
					} else {
						if (ans[i-2] && e.equals(s.substring(i-1, i+1))) {
							ans[i] = true;
						}
					}
				}
			}
		}
		
		//System.out.println(Arrays.toString(ans));
		
		if(ans[len-1]) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in));}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}

/* 
int n = sc.nextInt();

for(int y=0; y<n; y++){
	int x = sc.nextInt();
}

int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
int d = sc.nextInt();
int e = sc.nextInt();
*/



