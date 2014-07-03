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

package com.ruthlessphysics.pcalculator.tool;

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
  public static void println(String text)
  {
    if(shouldLog())
    {
      System.out.println("[Debug.java]: "+text);
    }
  }
  public static void print(String text)
  {
    if(shouldLog())
    {
      System.out.print(text);
    }
  }
  public static void displayError(Exception e)
  {
    if(displayDebug())
    {
      JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
    }
  }
  public static void setDefault()
  {
    Properties config = new Properties();
    OutputStream output = null;
    try
    {
      output = new FileOutputStream("pcalculator-debug.properties");
      config.setProperty("displayDebug", "yes");
      config.setProperty("alertAlwaysAs", "pass");
      config.setProperty("defaultCommand","help");
      config.setProperty("shouldLog","yes");
      config.setProperty("seperator",Character.toString('\u1337'));
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
  		input = new FileInputStream("pcalculator-debug.properties");
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
      input = new FileInputStream("pcalculator-debug.properties");
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
  public static String defaultCommand()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-debug.properties");
      prop.load(input);
      String type = prop.getProperty("defaultCommand");
      return type;
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return "help";
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
          return "help";
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
      input = new FileInputStream("pcalculator-debug.properties");
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
  public static boolean shouldLog()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-debug.properties");
      prop.load(input);
      String should = prop.getProperty("shouldLog");
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
}
