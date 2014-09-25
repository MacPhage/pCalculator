//
//  Add.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.VarOld;

import com.ruthlessphysics.util.Debug;

public class Add
{
  /* Add
  // Finds the sum of all the items in the given array
  */
  public static String calculate(String[] c) //Input command
  {
    double var = 0.0;
    String choose = "default";
    double r = 0; //Result
    String m = "The sum of ";
    for(int i = 0; i < c.length; i++)
    {
      //Adds each number in every index together to form the sum
      try
      {
        if(VarOld.isOccupied(c[i]) && VarOld.isValidDouble(VarOld.getVar(c[i])))
        {
          var = VarOld.d(VarOld.getVar(c[i]));
          r += var;
          choose = "var";
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
        Debug.displayError(e);
      }
      if(choose.equals("default"))
      {
        try
        {
          r += Double.parseDouble(c[i]);
        }
        catch (Exception e)
        {
          e.printStackTrace();
          Debug.displayError(e);
        }
      }
      if(c.length-i == 2) //Make a message of the end result while it's being calculated
      {
        if(choose.equals("var"))
        {
          m += "(variable) ";
        }
        m += c[i]+", and ";
      }
      else if(c.length-i == 1)
      {
        if(choose.equals("var"))
        {
          m += "(variable) ";
        }
        m += c[i];
      }
      else
      {
        if(choose.equals("var"))
        {
          m += "(variable) ";
        }
        m += c[i]+", ";
      }
      choose = "default";
    }
    m += " equals "+Double.toString(r);
    return m;
  }

}
