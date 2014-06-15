//
//  Factorial.java
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

package Function; //as

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Factorial
{
  /* Factorial
  // Description of function.
  */
  public static String calculate(String[] c)
  {
    double a = 0;
    double b = 1; //Result
    String r = "";
    try
    {
      for(int i = 0; i < c.length; i++)
      {
        a = Double.parseDouble(c[i]);
        while(a > 1)
        {
          b *= a;
          a--;
        }
        r += "Factorial of "+c[i]+" is "+b+".\n";
        b = 1;
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Errors.shouldDisplayErrors() == true)
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
    }
    return r;
  }
}
