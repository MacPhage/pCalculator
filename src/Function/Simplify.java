//
//  Simplify.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Editted with Atom
//  https://atom.io/
//
//  Further updates
//  http://srchub.org/u/mac
//

package Function;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Simplify
{
  /* Name of Function
  // Description of function.
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    String type = c[0];
    long a,b,gcd;
    try
    {
      if(type.equals("fraction"))
      {
        for(int i = 1; i < c.length; i+=2)
        {
          a = Long.parseLong(c[i]);
          b = Long.parseLong(c[i+1]);
          gcd = GreatestCommonDivisor.gcd(a, b);
          r += (c[i]+"/"+c[i+1]+" simplified to "+(a / gcd)+"/"+(b / gcd)+"\n");
        }
      }
      else
      {
        r = "I can't simplify those.";
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug() == true)
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
    }
    return r;
  }
}
