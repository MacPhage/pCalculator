//
//  Errors.java
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

public class Errors
{
  public static boolean shouldDisplayErrors()
  {
    Properties prop = new Properties();
	  InputStream input = null;
	  try
    {
  		input = new FileInputStream("config.properties");
  		prop.load(input);
  		String should = prop.getProperty("displayErrors");
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
