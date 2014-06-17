//
//  OtherCipher.java
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

public class QuadraticForumula
{
  /* Name of Function
  // Description of function.
  */
  public static String calculate(String[] in)
  {
    String r = ""; //Result
    double a,b,c;
    try
    {
      a = Double.parseDouble(in[0]);
      b = Double.parseDouble(in[1]);
      c = Double.parseDouble(in[2]);

      r += "Solution #1 (+): "+(((-1.0*b)+Math.sqrt(Math.pow(b,2.0)-(4.0*a*c)))/2.0*a)+"\n";
      r += "Solution #2 (-): "+(((-1.0*b)-Math.sqrt(Math.pow(b,2.0)-(4.0*a*c)))/2.0*a)+"\n";
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
