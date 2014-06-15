//
//  Divide.java
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
import java.util.*;

public class Divide
{
  /* Divide
  // Finds the quotient of all the items in the given array
  */
  public static String calculate(String[] c)
  {
    double r; //Result
    try
    {
      r = Double.parseDouble(c[0]); //Result;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return c[0];
    }

    for(int i = 1; i < c.length; i++)
    {
      //Adds each number in every index together to form the sum
      try
      {

        r /= Double.parseDouble(c[i]);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        if(Debug.displayDebug())
        {
          JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
        }
        break;
      }
    }
    return Double.toString(r);
  }



}
