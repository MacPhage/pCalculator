//
//  Calculator.java
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

import Function.Debug;

import Function.Add;
import Function.Subtract;
import Function.Multiply;
import Function.Divide;
import Function.Power;
import Function.Squareroot;
import Function.Factorial;
import Function.QuadraticFormula;
import Function.GreatestCommonDivisor;
import Function.LeastCommonMultiple;
import Function.Simplify;
import Function.Count;

public class Calculator
{
  static String titleText = "pCalculator";
  static String version = "1.1.0, last updated June 20, 2014.";
  static String changes = "- Added Factorial support\n"+
  "- Added Quadratic Formula support\n"+
  "- Added Greatest Common Divisor support\n"+
  "- Added Least Common Multiple support\n"+
  "- Added Simplify function (fractions only, for now)\n"+
  "\n";

  public static void main(String args[])
  {
    boolean debug = false;

    String[] input = {"",""}; //Direct input from JOptionPane, then splitted
    java.util.List<String> tempList; //input[] passes through this to remove the first index
    String[] baton = {"",""}; //Passed data after being processed through tempList
    String command; //Actual command (input[0])
    while(true)
    {
      if(debug == true)
      {
        if(Debug.debugFileExists() == false || baton[0].equals("reset"))
        {
          Debug.setDefault();
        }
        else if(baton[0].equals("delete"))
        {
          try
          {
            File fileTemp = new File("pcalculator.properties");
            if (fileTemp.exists())
            {
              fileTemp.delete();
            }
          }
          catch(Exception e)
          {
            e.printStackTrace();
            if(Debug.displayDebug())
            {
              JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
            }
          }
        }
        debug = false;
      }
      input[0] = JOptionPane.showInputDialog(null,"Enter a command: ",Debug.defaultCommand());
      input = input[0].split(" ");
      command = input[0];
      tempList = new ArrayList<String>(Arrays.asList(input));
      tempList.remove(0);
      baton = (String[]) tempList.toArray(baton);
      String end = "";
      String fin[];
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

      if(command.equals("add") || command.equals("+"))
      {
        end = Add.calculate(baton);
        fin = end.split(Debug.sep());
        message("Result: \n"+fin[0],fin[1]);
      }
      else if(command.equals("subtract") || command.equals("-"))
      {
        message("Result: \n",Subtract.calculate(baton));
      }
      else if(command.equals("multiply") || command.equals("*"))
      {
        message("Result: \n",Multiply.calculate(baton));
      }
      else if(command.equals("divide") || command.equals("/"))
      {
        message("Result: \n",Divide.calculate(baton));
      }
      else if(command.equals("power") || command.equals("pow") || command.equals("^"))
      {
        message("Result: \n",Power.calculate(baton));
      }
      else if(command.equals("squareroot") || command.equals("sqrt"))
      {
        message("Result: \n",Squareroot.calculate(baton));
      }
      else if(command.equals("factorial"))
      {
        message("Result: \n",Factorial.calculate(baton));
      }
      else if(command.equals("quadraticFormula"))
      {
        message("Result: \n",QuadraticFormula.calculate(baton));
      }
      else if(command.equals("gcd"))
      {
        message("Result: \n",GreatestCommonDivisor.calculate(baton));
      }
      else if(command.equals("lcm"))
      {
        message("Result: \n",LeastCommonMultiple.calculate(baton));
      }
      else if(command.equals("simplify"))
      {
        message("Result: \n",Simplify.calculate(baton));
      }
      else if(command.equals("count"))
      {
        message("Result: \n",Count.calculate(baton));
      }
      else if(command.equals("info"))
      {
        showInfo();
      }
      else if(command.equals("?") || command.equals("help"))
      {
        showCommands();
      }
      else if(command.equals("quit") || command.equals("stop") || command.equals("end") || command.equals("close"))
      {
        break;
      }
      else if(command.equals("debug"))
      {
        try
        {
          if(baton[0].equals("reset"))
          {
            alert("Debugging file (pcalculator.properties) will be reset to its default state.","warning");
          }
          else if(baton[0].equals("delete"))
          {
            alert("Debugging file (pcalculator.properties) will be deleted if it isn\'t already.","warning");
          }
          else
          {
            alert("Debugging file (pcalculator.properties) will be created if one doesn\'t exists already.\nDelete it to stop its effects on this program.","warning");
          }
          debug = true;
        }
        catch (Exception e)
        {
          e.printStackTrace();
          if(Debug.displayDebug())
          {
            JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
          }
          alert("Debugging file (pcalculator.properties) will be created if one doesn\'t exists already.\nDelete it to stop its effects on this program.","warning");
          debug = true;
        }
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
    "Guide:\n"+
    "- List = multiple inputs seperated by spaces\n"+
    "- Commands ARE case-sensitive! Typing \"add\" is different from \"ADD\"\n"+
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
    "- Factorial\n"+
    "  - Use \"factorial [list]\"\n"+
    "- Quadratic Formula\n"+
    "  - Use \"quadraticFormula [a] [b] [c]\"\n"+
    "- Greatest Common Divisor\n"+
    "  - Use \"gcd [list]\"\n"+
    "- Least Common Multiple\n"+
    "  - Use \"lcm [list]\"\n"+
    "- Simplify\n"+
    "  - Use \"simplify [type] [list]\"\n"+
    "  - Valid types: \"fraction, (none)\"\n"+
    "  - Example: \"simplify fraction 5 10 5 15\"\n"+
    "\n",
    "pCalculator Command List",JOptionPane.INFORMATION_MESSAGE);
  }
  public static void alert(String message, String type) //Just like JavaScript :P
  {
    type = type.toLowerCase();
    String newType = Debug.alertAlwaysAs();
    if(newType.equals("pass"))
    {
      //Purposely nothing
    }
    else
    {
      type = newType;
    }
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
      JOptionPane.showMessageDialog(null,message,titleText,JOptionPane.PLAIN_MESSAGE);
      System.out.println("Attempted to alert() with invalid type: \'"+type+"\', went with plain instead.");
    }
  }
  public static void message(String message,String output) //Just like JavaScript :P
  {
    JOptionPane.showInputDialog(null,message,output);
  }
}
