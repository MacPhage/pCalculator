//
//  Calculator.java
//
//  Java Source File
//
//  Created by Austin Jackson,
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator;

import javax.swing.*;

import java.util.*;
import java.io.*;

import com.ruthlessphysics.util.Debug;
import com.ruthlessphysics.util.Version;
import com.ruthlessphysics.pcalculator.function.*;
import com.ruthlessphysics.pcalculator.function.simplify.*;
import com.ruthlessphysics.pcalculator.variable.*;

public class Calculator
{
	static String titleText = "pCalculator";
	static String version = "1.2.0, last updated July 2, 2014.";
	static String changes = "- Variable functionality\n"+
	"- NRoot function (find the nth root of things)\n"+
	"- Count function\n"+
	"- Added command aliases (\'+ 2 2\' instead of \'add 2 2\')\n"+
	"- Plenty under-the-hood changes!\n"+
	"\n";
	static String commonType = "information";
	
	Version ver = new Version("MacPhage","pCalculator","v1.1.0");
  public static void main(String args[])
  {

    //VariableManager.setup();

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
            File fileTemp = new File("pcalculator-debug.properties");
            if (fileTemp.exists())
            {
              fileTemp.delete();
            }
          }
          catch(Exception e)
          {
            e.printStackTrace();
            Debug.displayError(e);
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

      /*if(command.equals("add") || command.equals("+"))
      {
        end = Add.calculate(baton);
        fin = end.split(Debug.sep());
        Header.message("Result: \n"+fin[0],fin[1]);
      }*/
      if(command.equals("add") || command.equals("+"))
      {
        Debug.alert("Result: \n"+Add.calculate(baton));
      }
      else if(command.equals("subtract") || command.equals("-"))
      {
    	  Debug.alert("Result: \n"+Subtract.calculate(baton));
      }
      else if(command.equals("multiply") || command.equals("*"))
      {
    	  Debug.alert("Result: \n"+Multiply.calculate(baton));
      }
      else if(command.equals("divide") || command.equals("/"))
      {
    	  Debug.alert("Result: \n"+Divide.calculate(baton));
      }
      else if(command.equals("power") || command.equals("pow") || command.equals("^"))
      {
    	  Debug.alert("Result: \n"+Power.calculate(baton));
      }
      else if(command.equals("squareroot") || command.equals("sqrt"))
      {
    	  Debug.alert("Result: \n"+Squareroot.calculate(baton));
      }
      else if(command.equals("factorial"))
      {
    	  Debug.alert("Result: \n"+Factorial.calculate(baton));
      }
      else if(command.equals("quadraticFormula"))
      {
    	  Debug.alert("Result: \n"+QuadraticFormula.calculate(baton));
      }
      else if(command.equals("gcd"))
      {
    	  Debug.alert("Result: \n"+GreatestCommonDivisor.calculate(baton));
      }
      else if(command.equals("lcm"))
      {
    	  Debug.alert("Result: \n"+LeastCommonMultiple.calculate(baton));
      }
      else if(command.equals("simplify"))
      {
    	  Debug.alert("Result: \n"+Fraction.calculate(baton));
      }
      else if(command.equals("count"))
      {
        Debug.alert("Result: \n"+Count.calculate(baton));
      }
      else if(command.equals("nroot"))
      {
        Debug.alert("Result: \n"+NRoot.calculate(baton));
      }
      else if(command.equals("variable") || command.equals("var"))
      {
        VariableManager.menu(baton);
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
      else if(command.equals("kill"))
      {
        System.exit(0);
      }
      else if(command.equals("debug"))
      {
        try
        {
          if(baton[0].equals("reset"))
          {
            Debug.alert("Debugging file (pcalculator.properties) will be reset to its default state.","warning");
          }
          else if(baton[0].equals("delete"))
          {
            Debug.alert("Debugging file (pcalculator.properties) will be deleted if it isn\'t already.","warning");
          }
          else
          {
            Debug.alert("Debugging file (pcalculator.properties) will be created if one doesn\'t exists already.\nDelete it to stop its effects on this program.","warning");
          }
          debug = true;
        }
        catch (Exception e)
        {
          e.printStackTrace();
          Debug.displayError(e);
          Debug.alert("Debugging file (pcalculator.properties) will be created if one doesn\'t exists already.\nDelete it to stop its effects on this program.","warning");
          debug = true;
        }
      }
      else
      {
        Debug.alert("That wasn\'t a valid command.","warning");
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
    "- Count\n"+
    "  - Use \"count [from] [to] [increment]\"\n"+
    "- NRoot\n"+
    "  - Use \"nroot [degree] [radicand]\"\n"+
    "  - Allows for multiple inputs at once.\n"+
    "- Variable\n"+
    "  - Use \"var [set OR get OR remove] (value)\"\n"+
    "  - Allows you to store constants for mathematical use later.\n"+
    "  - Values stored in \'pcalculator-variables.properties\' and are editable.\n"+
    "\n",
    "pCalculator Command List",JOptionPane.INFORMATION_MESSAGE);
  }
  public static String trim(String input)
  {
    try
    {
      String[] fix = input.split(" ");
      return fix[0];
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
      return input;
    }
  }
}
