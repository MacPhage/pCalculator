//
//  Debug.java
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

/*

EXCEPTION TEMPLATE

try
{
  //code
}
catch (Exception e)
{
  e.printStackTrace();
  if(Debug.displayDebug())
  {
    JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
  }
}

*/

public class Debug
{
  public static void setDefault()
  {
    Properties config = new Properties();
    OutputStream output = null;
    try
    {
      output = new FileOutputStream("pcalculator.properties");
      config.setProperty("displayDebug", "no");
      config.setProperty("alertAlwaysAs", "pass");
      config.store(output, null);
    }
    catch (IOException io)
    {
      io.printStackTrace();
    }
    finally
    {
      if (output != null)
      {
        try
        {
          output.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
  public static boolean displayDebug()
  {
    Properties prop = new Properties();
	  InputStream input = null;
	  try
    {
  		input = new FileInputStream("pcalculator.properties");
  		prop.load(input);
  		String should = prop.getProperty("displayDebug");
      if(should.equals("yes"))
      {
        return true;
      }
      else
      {
        return false;
      }
	  }
    catch (IOException ex)
    {
		ex.printStackTrace();
    return false;
	  }
    finally
    {
  		if (input != null)
      {
  			try
        {
  				input.close();
  			}
        catch (IOException e)
        {
  				e.printStackTrace();
          return false;
  			}
  		}
	  }
  }
  public static String alertAlwaysAs()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator.properties");
      prop.load(input);
      String type = prop.getProperty("alertAlwaysAs");
      return type;
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return "pass";
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return "pass";
        }
      }
    }
  }
  public static boolean debugFileExists()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator.properties");
      prop.load(input);
      return true;
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return false;
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return false;
        }
      }
    }
  }

}
