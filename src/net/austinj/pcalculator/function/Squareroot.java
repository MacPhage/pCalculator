//
//  Squareroot.java
//
//  Java Source File
//
//  Created by Austin Jackson,
//
//  Further updates
//  http://srchub.org/u/mac
//

package net.austinj.pcalculator.function;

import com.ruthlessphysics.util.Debug;

public class Squareroot
{
  /* Squareroot
  // Finds the squareroot of things
  */
  public static String calculate(String[] c)
  {
    double a = 0.0; //Result
    String r = "";
    try
    {
      for(int i = 0; i < c.length; i++)
      {
        a = Math.sqrt(Double.parseDouble(c[i]));
        r += "Squareroot of "+c[i]+" is "+a+".\n";
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
    }
    return r;
  }

}
