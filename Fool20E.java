import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Fool20E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		File file= new File("smile.jpg");
		//BufferedImage image = ImageIO.read("smile.jpg");
		// Getting pixel color by position x and y 
		//int clr=  image.getRGB(x,y); 
		//int red   = (clr & 0x00ff0000) >> 16;
//		int green = (clr & 0x0000ff00) >> 8;
//		int blue  =  clr & 0x000000ff;
//		
//		if(red + green + blue < 10) {
//			System.out.print("IN");
//		} else {
//			System.out.print("OUT");
//		}
		
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
