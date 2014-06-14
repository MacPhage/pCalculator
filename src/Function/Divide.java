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
    double r = 0; //Result
    for(int i = 0; i < c.length; i++)
    {
      //Adds each number in every index together to form the sum
      try
      {
        r /= Double.parseDouble(c[i]);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        if(Errors.shouldDisplayErrors())
        {
          JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
        }
        break;
      }
    }
    return Double.toString(r);
  }



}
