//
//  Var.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.tool;

import com.ruthlessphysics.util.Debug;
import com.ruthlessphysics.pcalculator.*;

import java.io.*;
import java.util.*;

public class Var
{
  /* Variable Manager
  // Provides the methods to manage variables
  */
  static String err = "error";

  public static void setup()
  {
    Properties prop = new Properties();
    OutputStream output = null;
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      Debug.displayError(ex);
    }
    try
    {
      output = new FileOutputStream("pcalculator-variables.properties");
      prop.setProperty("E", Double.toString(Math.E));
      prop.setProperty("PI", Double.toString(Math.PI));
      prop.store(output, null);
    }
    catch (IOException io)
    {
      io.printStackTrace();
      Debug.displayError(io);
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
          Debug.displayError(e);
        }
      }
    }
  }

  public static boolean setVar(String id, String value)
  {
    Properties prop = new Properties();
    OutputStream output = null;
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      Debug.displayError(ex);
    }
    try
    {
      output = new FileOutputStream("pcalculator-variables.properties");
      prop.setProperty(id,value);
      prop.store(output, null);
      return true;
    }
    catch (IOException io)
    {
      io.printStackTrace();
      Debug.displayError(io);
      return false;
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
          Debug.displayError(e);
          return false;
        }
      }
    }

  }
  public static String getVar(String id)
  {
    id = Calculator.trim(id);
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
      String content = prop.getProperty(id);
      return content;
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      Debug.displayError(ex);
      return err;
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
          Debug.displayError(e);
          return err;
        }
      }
    }
  }
  public static boolean forceSetVar(String id,String value)
  {
    id = Calculator.trim(id);
    value = Calculator.trim(value);
    Properties config = new Properties();
    OutputStream output = null;
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      config.load(input);
      input.close();
      config.remove(id);
      output = new FileOutputStream("pcalculator-variables.properties");
      config.setProperty(id, value);
      config.store(output, null);
      return true;
    }
    catch (IOException io)
    {
      io.printStackTrace();
      Debug.displayError(io);
      return false;
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
          Debug.displayError(e);
        }
      }
    }
  }

  public static boolean removeVar(String id)
  {
    id = Calculator.trim(id);
    Properties config = new Properties();
    OutputStream output = null;
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      config.load(input);
      input.close();
      config.remove(id);
      output = new FileOutputStream("pcalculator-variables.properties");
      config.store(output, null);
      return true;
    }
    catch (IOException io)
    {
      io.printStackTrace();
      Debug.displayError(io);
      return false;
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
          Debug.displayError(e);
        }
      }
    }
  }

  public static boolean isValidDouble(String value)
  {
    value = Calculator.trim(value);
    try
    {
      Double.parseDouble(value);
      return true;
    }
    catch(Exception e)
    {
      return false;
    }
  }

  public static boolean isValidInt(String value)
  {
    value = Calculator.trim(value);
    try
    {
      Integer.parseInt(value);
      return true;
    }
    catch(Exception e)
    {
      return false;
    }
  }

  public static boolean isValidLong(String value)
  {
    value = Calculator.trim(value);
    try
    {
      Long.parseLong(value);
      return true;
    }
    catch(Exception e)
    {
      return false;
    }
  }

  public static String whatIsValid(String value)
  {
    value = Calculator.trim(value);
    String r = "";
    boolean check_d = true;
    boolean check_i = true;
    boolean check_l = true;
    try
    {
      Double.parseDouble(value);
    }
    catch(Exception e)
    {
      check_d = false;
    }
    try
    {
      Integer.parseInt(value);
    }
    catch(Exception e)
    {
      check_i = false;
    }
    try
    {
      Long.parseLong(value);
    }
    catch(Exception e)
    {
      check_l = false;
    }

    if(check_d == false || check_i == false || check_l == false)
    {
      r += "False. ";
    }
    if(check_d == false)
    {
      r += "Variable couldn\'t parse as Double. ";
    }
    if(check_i == false)
    {
      r += "Variable couldn\'t parse as Integer. ";
    }
    if(check_l == false)
    {
      r += "Variable couldn\'t parse as Long. ";
    }
    return r;
  }

  public static boolean isOccupied(String id)
  {
    id = Calculator.trim(id);
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
      String content = prop.getProperty(id);
      if(content != null)
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
      Debug.displayError(ex);
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
          Debug.displayError(e);
          return false;
        }
      }
    }
  }

  public static double d(String value)
  {
    value = Calculator.trim(value);
    try
    {
      return Double.parseDouble(value);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
      return 0.0;
    }
  }

  public static int i(String value)
  {
    value = Calculator.trim(value);
    try
    {
      return Integer.parseInt(value);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
      return 0;
    }
  }

  public static long l(String value)
  {
    value = Calculator.trim(value);
    try
    {
      return Long.parseLong(value);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
      return 0L;
    }
  }

  public static void menu(String[] c)
  {
    try
    {
      if(c.length < 2)
      {
        Debug.alert("You need to enter a command after that!\n");
      }
      else if(c[0].equals("set"))
      {
        if(isOccupied(c[1]))
        {
          String old = getVar(c[1]);
          if(forceSetVar(c[1],c[2]))
          {
            Debug.alert("Variable \'"+c[1]+"\' was successfully changed from "+old+
            " to "+c[2]+" .");
          }
        }
        else
        {
          if(setVar(c[1],c[2]))
          {
            Debug.alert("Variable \'"+c[1]+"\' was successfully set as "+c[2]+".");
          }
        }
      }
      else if(c[0].equals("remove"))
      {
        if(removeVar(c[1]))
        {
          Debug.alert("Variable \'"+c[1]+"\' was successfully removed.");
        }
        else
        {
          Debug.alert("A problem removing Variable \'"+c[1]+"\' occured.\n");
        }
      }

      else if(c[0].equals("get"))
      {

        if(isOccupied(c[1]))
        {
          Debug.alert("Variable under "+c[1]+" is "+getVar(c[1]));
        }
        else
        {
          Debug.alert("Variable under "+c[1]+" doesn\'t exist.");
        }
      }
      else
      {
        Debug.alert(c[0]+" isn\'t actually a command. Try \'help\'.");
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
    }
  }

}
