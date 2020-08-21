import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE88C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int h = sc.nextInt();
			int c = sc.nextInt();
			int temp = sc.nextInt();
			
			h -= c;
			temp -= c;
			c = 0;
			
			if (temp == 0 || h/temp >= 2) {
				out.println(2);
				continue;
			}
			
			//double e = 1e-4;
			
			Fraction p = new Fraction(temp, h);
			Fraction extra = p.subtract(new Fraction(1,2));
			Fraction recip = new Fraction(extra.denominator, extra.numerator);
			Fraction index = (recip.add(new Fraction(2,1))).multiply(new Fraction(1,4));
			
			//long round = Math.round(index);
			
			if (index.denominator == 1l) {
				out.println(index.numerator * 2 - 1);
				continue;
			}
			
			double floor = Math.floor((double)index.numerator / (double)index.denominator);
			double ceil = Math.ceil((double)index.numerator / (double)index.denominator);
			long df = Math.round(floor)*4 - 2;
			long dc = Math.round(ceil)*4 - 2;
			Fraction avg = ((new Fraction(2,1).divide(new Fraction(1,df).add(new Fraction(1,dc)))).add(new Fraction(2,1))).multiply(new Fraction(1,4));
			
//			out.println(index);
//			out.println(floor);
//			out.println(ceil);
//			out.println(df);
//			out.println(dc);
//			out.println(avg);

			
			if (index.numerator * avg.denominator > index.denominator * avg.numerator) {
				out.println(Math.round(ceil) * 2 - 1);
			} else {
				out.println(Math.round(floor) * 2 - 1);
			}
		}
		
		out.flush();
	}
	
	/**********************************************************
	   Fraction.java - a Java representation of a fraction

	   Author: Diane Kramer
	   History:
	      Created:   9/25/01
	      Modified: 10/16/01 - added gcd method to reduce fraction
	      Modified: 02/19/06 - include licence terms in comments

	   Description:  This class provides storage for internal
	   representation of, and methods to manipulate fractions.
	   A fraction consists of two integers, one for numerator
	   and one for denominator.  An example fraction is 3/4.
	   A valid fraction must not have zero in the denominator.

	   This software is licensed "as-is" under a non-exclusive,
	   worldwide, royalty-free right to reproduce the software,
	   prepare derivative works of the software and distribute
	   the software or any derivative works created.  The user
	   bears the risk of using it.  No express warranties,
	   guarantees or conditions are implied.
	***********************************************************/

	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in), 32768);}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}

	}



class Fraction
{
   // member variables
   public long numerator, denominator;  // stores the fraction data

   /**********************************************************
    Method:         Default Constructor
    Purpose:        Create a new Fraction object and initialize it 
                    with "invalid" data
    Parameters:     None
    Preconditions:  None
    Postconditions: a new fraction object is created with numerator
                    and denominator set to 0
   ***********************************************************/
   public Fraction()
   {
      numerator = denominator = 0;
   }
   
   public Fraction(long n, long d) {
	   numerator = n;
	   denominator = d;
   }

   /********************************************/
   /* public accessor methods for private data */
   /********************************************/

   /**********************************************************
    Method:         getNumerator
    Purpose:        access data stored in numerator member variable
    Parameters:     None
    Preconditions:  None
    Postconditions: None
    Returns:        integer data stored in numerator member variable
   ***********************************************************/
   public long getNumerator()
   {
      return numerator;
   }

   /**********************************************************
    Method:         setNumerator
    Purpose:        provide data to store in numerator member variable
    Parameters:     num: an integer value
    Preconditions:  None
    Postconditions: the value of num will be stored in numerator 
                    member variable
   ***********************************************************/
   public void setNumerator(long num)
   {
      numerator=num;
   }

   /**********************************************************
    Method:         getDenominator
    Purpose:        access data stored in denominator member variable
    Parameters:     None
    Preconditions:  None
    Postconditions: None
    Returns:        integer data stored in denominator member variable
   ***********************************************************/
   public long getDenominator()
   {
      return denominator;
   }

   /**********************************************************
    Method:         setDenominator
    Purpose:        provide data to store in denominator member variable
    Parameters:     den: an integer value
    Preconditions:  None
    Postconditions: the value of den will be stored in denominator
                    member variable
   ***********************************************************/
   public void setDenominator(long den)
   {
      denominator=den;
   }

   /****************************************************/
   /* public action methods for manipulating fractions */
   /****************************************************/

   /**********************************************************
    Method:         add
    Purpose:        Add two fractions, a and b, where a is the "this"
                    object, and b is passed as the input parameter
    Parameters:     b, the fraction to add to "this"
    Preconditions:  Both fractions a and b must contain valid values
    Postconditions: None
    Returns:        A Fraction representing the sum of two
                    fractions a & b
   ***********************************************************/
   public Fraction add(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.denominator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // find lowest common denominator
      long common = lcd(denominator, b.denominator);
      // convert fractions to lcd
      Fraction commonA = new Fraction();
      Fraction commonB = new Fraction();
      commonA = convert(common);
      commonB = b.convert(common);
      // create new fraction to return as sum
      Fraction sum = new Fraction();
      // calculate sum
      sum.numerator = commonA.numerator + commonB.numerator;
      sum.denominator = common;
      // reduce the resulting fraction
      //sum = sum.reduce();
      return sum;
   }

   /**********************************************************
    Method:         subtract
    Purpose:        Subtract fraction b from a, where a is the "this"
                    object, and b is passed as the input parameter
    Parameters:     b, the fraction to subtract from "this"
    Preconditions:  Both fractions a and b must contain valid values
    Postconditions: None
    Returns:        A Fraction representing the differenct of the
                    two fractions a & b
   ***********************************************************/
   public Fraction subtract(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.denominator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // find lowest common denominator
      long common = lcd(denominator, b.denominator);
      // convert fractions to lcd
      Fraction commonA = new Fraction();
      Fraction commonB = new Fraction();
      commonA = convert(common);
      commonB = b.convert(common);
      // create new fraction to return as difference
      Fraction diff = new Fraction();
      // calculate difference
      diff.numerator = commonA.numerator - commonB.numerator;
      diff.denominator = common;
      // reduce the resulting fraction
      //diff = diff.reduce();
      return diff;
   }

   /**********************************************************
    Method:         multiply
    Purpose:        Multiply fractions a and b, where a is the "this"
                    object, and b is passed as the input parameter
    Parameters:     The fraction b to multiply "this" by
    Preconditions:  Both fractions a and b must contain valid values
    Postconditions: None
    Returns:        A Fraction representing the product of the
                    two fractions a & b
   ***********************************************************/
   public Fraction multiply(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.denominator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // create new fraction to return as product
      Fraction product = new Fraction();
      // calculate product
      product.numerator = numerator * b.numerator;
      product.denominator = denominator * b.denominator;
      // reduce the resulting fraction
      //product = product.reduce();
      return product;
   }

   /**********************************************************
    Method:         divide
    Purpose:        Divide fraction a by b, where a is the "this"
                    object, and b is passed as the input parameter
    Parameters:     The fraction b to divide "this" by
    Preconditions:  Both fractions a and b must contain valid values
    Postconditions: None
    Returns:        A Fraction representing the result of dividing
                    fraction a by b
   ***********************************************************/
   public Fraction divide(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.numerator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // create new fraction to return as result
      Fraction result = new Fraction();
      // calculate result
      result.numerator = numerator * b.denominator;
      result.denominator = denominator * b.numerator;
      // reduce the resulting fraction
      //result = result.reduce();
      return result;
   }

   /**********************************************************
    Method:         output
    Purpose:        Print the value of the "this" object to the screen.
                    Makes use of the toString() method.
                    Uses System.out.print, rather than println for flexibility
    Parameters:     None
    Preconditions:  User needs access to command line window to see output
    Postconditions: The value of the "this" object will be printed to
                    the screen
   ***********************************************************/
   public void output()
   {
       System.out.print(this);
   }

   /**********************************************************
    Method:         toString
    Purpose:        Convert the internal representation of a fraction,
                    which is stored in two integers, into a String
                    (which could then be printed to the screen)
    Parameters:     None
    Preconditions:  None
    Postconditions: The value of the "this" object will be converted
                    to a String
    Returns:        A String representation of the "this" fraction
   ***********************************************************/
   public String toString()
   {
      String buffer = numerator + "/" + denominator;
      return buffer;
   }

   /*****************************************************/
   /* private methods used internally by Fraction class */
   /*****************************************************/

   /**********************************************************
    Method:         lcd
    Purpose:        find lowest common denominator, used to add and
                    subtract fractions
    Parameters:     two integers, denom1 and denom2
    Preconditions:  denom1 and denom2 must be non-zero integer values
    Postconditions: None
    Returns:        the lowest common denominator between denom1 and
                    denom2
   ***********************************************************/
   private long lcd(long denom1, long denom2)
   {
	  return denom1*denom2;
//      long factor = denom1;
//      while ((denom1 % denom2) != 0)
//         denom1 += factor;
//      return denom1;
   }

   /**********************************************************
    Method:         gcd
    Purpose:        find greatest common denominator, used to reduce
                    fractions 
    Parameters:     two integers, denom1 and denom2
    Preconditions:  denom1 and denom2 must be positive integer values
                    denom1 is assumed to be greater than denom2
                    (denom1 > denom2 > 0)
    Postconditions: None
    Returns:        the greatest common denominator between denom1 and
                    denom2
    Credits:        Thanks to Euclid for inventing the gcd algorithm,
                    and to Prof. Joyce for explaining it to me.
   ***********************************************************/
   private long gcd(long denom1, long denom2)
   {
      long factor = denom2;
      while (denom2 != 0) {
         factor = denom2;
         denom2 = denom1 % denom2;
         denom1 = factor;
      }
      return denom1;
   }

   /**********************************************************
    Method:         convert
    Purpose:        convert a fraction to an equivalent one based on
                    a lowest common denominator
    Parameters:     an integer common, the new denominator
    Preconditions:  the "this" fraction must contain valid data for
                    numerator and denominator
                    the integer value common is assumed to be greater
                    than the "this" fraction's denominator
    Postconditions: None
    Returns:        A new fraction which is equivalent to the "this"
                    fraction, but has been converted to the new
                    denominator called common
   ***********************************************************/
   private Fraction convert(long common)
   {
      Fraction result = new Fraction();
      long factor = common / denominator;
      result.numerator = numerator * factor;
      result.denominator = common;
      return result;
   }

   /**********************************************************
    Method:         reduce
    Purpose:        convert the "this" fraction to an equivalent one
                    based on a greatest common denominator
    Parameters:     None
    Preconditions:  The "this" fraction must contain valid data for
                    numerator and denominator
    Postconditions: None
    Returns:        A new fraction which is equivalent to a, but has
                    been reduced to its lowest numerical form
   ***********************************************************/
   private Fraction reduce()
   {
      Fraction result = new Fraction();
      long common = 0;
      // get absolute values for numerator and denominator
      long num = Math.abs(numerator);
      long den = Math.abs(denominator);
      // figure out which is less, numerator or denominator
      if (num > den)
         common = gcd(num, den);
      else if (num < den)
         common = gcd(den, num);
      else  // if both are the same, don't need to call gcd
         common = num;

      // set result based on common factor derived from gcd
      result.numerator = numerator / common;
      result.denominator = denominator / common;
      return result;
   }
}
   
	
