//
//  Header.java
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

package com.ruthlessphysics.pcalculator;

import com.ruthlessphysics.pcalculator.tool.Debug;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Header
{

  static String titleText = "pCalculator";
  static String version = "1.1.0, last updated June 20, 2014.";
  static String changes = "- Added Factorial support\n"+
  "- Added Quadratic Formula support\n"+
  "- Added Greatest Common Divisor support\n"+
  "- Added Least Common Multiple support\n"+
  "- Added Simplify function (fractions only, for now)\n"+
  "\n";

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
