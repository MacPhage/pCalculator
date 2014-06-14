//
//  Obskewer.java
//
//  Java Source File
//
//  Created by Austin Jackson,
//
//  Editted with Atom
//  https://atom.io/
//
//  Further updates
//  http://srchub.org/u/mac
//

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;
import com.apple.eawt.Application;

import Function.Add;
import Function.Subtract;
import Function.Multiply;
import Function.Divide;
import Function.Power;
import Function.Squareroot;

public class Calculator
{
  static String titleText = "pCalculator";
  static String version = "1.0.0, last updated June 13, 2014.";
  static String changes = "- Initial release"+
  ""+
  "";
  static String operatingSystem = System.getProperty("os.name");
  //static JFrame frame = new JFrame();

  public static void main(String args[])
  {

    Properties config = new Properties();
    OutputStream output = null;

    try
    {

      output = new FileOutputStream("config.properties");

      // set the properties value
      config.setProperty("displayErrors", "no");

      // save properties to project root folder
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


    String[] input = {""}; //Direct input from JOptionPane, then splitted
    java.util.List<String> tempList; //input[] passes through this to remove the first index
    String[] baton = {""}; //Passed data after being processed through tempList
    String command; //Actual command (input[0])
    while(true)
    {
      input[0] = JOptionPane.showInputDialog(null,"Enter a command: ","help");
      input = input[0].split(" ");
      command = input[0];
      tempList = new ArrayList<String>(Arrays.asList(input));
      tempList.remove(0);
      baton = (String[]) tempList.toArray(baton);
      /*
      Using a String Array means we can store all potential input in one "baton".
      When we pass the baton, the class method .calculate() uses it how it wants to,
      and will even ignore extra arguments (unused indexes). This makes everything
      easier to manage and no extra prompts for more information and it can all
      be done at once, just like in the original C++ CLI versions.

      Only one line of code per function because all the String-Double-String
      conversion stuff is done per Function Class and is customized as needed
      per Function Class.
      */
      if(command.equals("add"))
      {
        alert("Result: \n"+Add.calculate(baton),"information");
      }
      else if(command.equals("subtract"))
      {
        alert("Result: \n"+Subtract.calculate(baton),"information");
      }
      else if(command.equals("multiply"))
      {
        alert("Result: \n"+Multiply.calculate(baton),"information");
      }
      else if(command.equals("divide"))
      {
        alert("Result: \n"+Divide.calculate(baton),"information");
      }
      else if(command.equals("power"))
      {
        alert("Result: \n"+Power.calculate(baton),"information");
      }
      else if(command.equals("squareroot"))
      {
        alert("Result: \n"+Squareroot.calculate(baton),"information");
      }
      else if(command.equals("info"))
      {
        showInfo();
      }
      else if(command.equals("?") || command.equals("help"))
      {
        showCommands();
      }
      else if(command.equals("quit"))
      {
        System.exit(0);
      }
      else
      {
        alert("That wasn\'t a valid command.","warning");
      }
    }
  }
  public static void showInfo()
  {
    JOptionPane.showMessageDialog(null,
    "pCalculator is a light-weight Java application for convenient calculation.\n"+
    "The functions it supports can be found using the command \"help\".\n"+
    "\n"+
    "Version: "+version+"\n"+
    "Author: Austin Jackson\n"+
    "Official website: http://srchub.org/p/pcalculator\n"+
    "Changes in this version: \n"+changes,
    "About pCalculator",JOptionPane.INFORMATION_MESSAGE);
  }
  public static void showCommands()
  {
    JOptionPane.showMessageDialog(null,
    "Terminology:\n"+
    "- List = multiple inputs seperated by spaces\n"+
    "\n"+
    "Commands: (full list at srchub.org/p/pcalculator)\n"+
    "- Help\n"+
    "  - Use \"help\"\n"+
    "- Info\n"+
    "  - Use \"info\"\n"+
    "- Add\n"+
    "  - Use \"add [list]\"\n"+
    "- Subtract\n"+
    "  - Use \"subtract [list]\"\n"+
    "- Multiply\n"+
    "  - Use \"multiply [list]\"\n"+
    "- Divide\n"+
    "  - Use \"divide [list]\"\n"+
    "- Power\n"+
    "  - Use \"power [list]\"\n"+
    "- Squareroot\n"+
    "  - Use \"squareroot [list]\"\n"+
    "\n",
    "pCalculator Command List",JOptionPane.INFORMATION_MESSAGE);
  }
  public static void alert(String message, String type) //Just like JavaScript :P
  {
    type = type.toLowerCase();
    if(type.equals("error"))
    {
      JOptionPane.showMessageDialog(null,message,titleText,JOptionPane.ERROR_MESSAGE);
    }
    else if(type.equals("information"))
    {
      JOptionPane.showMessageDialog(null,message,titleText,JOptionPane.INFORMATION_MESSAGE);
    }
    else if(type.equals("warning"))
    {
      JOptionPane.showMessageDialog(null,message,titleText,JOptionPane.WARNING_MESSAGE);
    }
    else if(type.equals("question"))
    {
      JOptionPane.showMessageDialog(null,message,titleText,JOptionPane.QUESTION_MESSAGE);
    }
    else if(type.equals("plain"))
    {
      JOptionPane.showMessageDialog(null,message,titleText,JOptionPane.PLAIN_MESSAGE);
    }
    else
    {
      System.out.println("Attempted to alert() with invalid type: "+type);
    }

  }
}
