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

public class Count
{
  /* Name of Function
  // Description of function.
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    try
    {
      double from = Double.parseDouble(c[0]); //Supposedly a smaller number
      double to = Double.parseDouble(c[1]); //Supposedly a larger number
      double inc = Double.parseDouble(c[2]); //Doesn't matter the size
      r += "Counting from "+from+" to "+to+", incrementing "+inc+" each time...\n\n";
      for(double i = from; i < to; i += inc)
      {
          r += Double.toString(i)+", ";
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
