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

package com.ruthlessphysics.pcalculator;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;

import com.ruthlessphysics.pcalculator.Header;

import com.ruthlessphysics.pcalculator.tool.Debug;
import com.ruthlessphysics.pcalculator.tool.Var;

import com.ruthlessphysics.pcalculator.function.Add;
import com.ruthlessphysics.pcalculator.function.Subtract;
import com.ruthlessphysics.pcalculator.function.Multiply;
import com.ruthlessphysics.pcalculator.function.Divide;
import com.ruthlessphysics.pcalculator.function.Power;
import com.ruthlessphysics.pcalculator.function.Squareroot;
import com.ruthlessphysics.pcalculator.function.Factorial;
import com.ruthlessphysics.pcalculator.function.QuadraticFormula;
import com.ruthlessphysics.pcalculator.function.GreatestCommonDivisor;
import com.ruthlessphysics.pcalculator.function.LeastCommonMultiple;
import com.ruthlessphysics.pcalculator.function.Simplify;
import com.ruthlessphysics.pcalculator.function.Count;
import com.ruthlessphysics.pcalculator.function.NRoot;

public class Calculator
{
  public static void main(String args[])
  {

    Var.setup();

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
      String[] fin;
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
        Header.alert("Result: \n"+Add.calculate(baton));
      }
      else if(command.equals("subtract") || command.equals("-"))
      {
        Header.alert("Result: \n"+Subtract.calculate(baton));
      }
      else if(command.equals("multiply") || command.equals("*"))
      {
        Header.alert("Result: \n"+Multiply.calculate(baton));
      }
      else if(command.equals("divide") || command.equals("/"))
      {
        Header.alert("Result: \n"+Divide.calculate(baton));
      }
      else if(command.equals("power") || command.equals("pow") || command.equals("^"))
      {
        Header.alert("Result: \n"+Power.calculate(baton));
      }
      else if(command.equals("squareroot") || command.equals("sqrt"))
      {
        Header.alert("Result: \n"+Squareroot.calculate(baton));
      }
      else if(command.equals("factorial"))
      {
        Header.alert("Result: \n"+Factorial.calculate(baton));
      }
      else if(command.equals("quadraticFormula"))
      {
        Header.alert("Result: \n"+QuadraticFormula.calculate(baton));
      }
      else if(command.equals("gcd"))
      {
        Header.alert("Result: \n"+GreatestCommonDivisor.calculate(baton));
      }
      else if(command.equals("lcm"))
      {
        Header.alert("Result: \n"+LeastCommonMultiple.calculate(baton));
      }
      else if(command.equals("simplify"))
      {
        Header.alert("Result: \n"+Simplify.calculate(baton));
      }
      else if(command.equals("count"))
      {
        Header.alert("Result: \n"+Count.calculate(baton));
      }
      else if(command.equals("nroot"))
      {
        Header.alert("Result: \n"+NRoot.calculate(baton));
      }
      else if(command.equals("variable") || command.equals("var"))
      {
        Var.menu(baton);
      }
      else if(command.equals("info"))
      {
        Header.showInfo();
      }
      else if(command.equals("?") || command.equals("help"))
      {
        Header.showCommands();
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
            Header.alert("Debugging file (pcalculator.properties) will be reset to its default state.","warning");
          }
          else if(baton[0].equals("delete"))
          {
            Header.alert("Debugging file (pcalculator.properties) will be deleted if it isn\'t already.","warning");
          }
          else
          {
            Header.alert("Debugging file (pcalculator.properties) will be created if one doesn\'t exists already.\nDelete it to stop its effects on this program.","warning");
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
          Header.alert("Debugging file (pcalculator.properties) will be created if one doesn\'t exists already.\nDelete it to stop its effects on this program.","warning");
          debug = true;
        }
      }
      else
      {
        Header.alert("That wasn\'t a valid command.","warning");
      }
    }
  }
}
