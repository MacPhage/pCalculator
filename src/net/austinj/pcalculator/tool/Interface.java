//
//  Interface.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import net.austinj.pcalculator.pCalculator;

public class Interface 
{
	
	static String titleText = "pCalculator";
	static String version = "1.3.0, last updated October 2, 2014.";
	static String changes = ""
	+ "- Major core and interface rework\n"
	+ ""
	+ "\n";
	
	private static Scanner console = new Scanner(System.in);
	
	public static void logError(Exception e)
	{
		String detailed = "[ERROR At "+(System.currentTimeMillis()*1000)+" ]\n"
				+ "  LocalizedMessage: \n    "+e.getLocalizedMessage()+"\n"
				+ "  Message: \n    "+e.getMessage()+"\n"
				+ "  StackTrace: \n    ";
		if(pCalculator.debugging)
		{
			System.err.println(detailed);
			e.printStackTrace();
		}
		else
		{
			try 
			{
				FileWriter errorlog = new FileWriter(new File("pcalculator-errors.txt"));
				errorlog.append(detailed);
				errorlog.close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	public static String prompt(String m)
	{
		alert(m);
		String s = console.next();
		return s;
	}
	public static String promptLine(String m)
	{
		alert(m);
		String s = console.nextLine();
		return s;
	}
	public static void alert(String m)
	{
		System.out.println(m);
	}
	public static void pause()
	{
		//boolean flag = false;
		System.out.println("Press Enter/Return to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	public static void showInfo()
	  {
	    alert(
	    "pCalculator is a light-weight Java application for convenient calculation.\n"+
	    "The functions it supports can be found using the command \"help\".\n"+
	    "\n"+
	    "Version: "+version+"\n"+
	    "Author: Austin Jackson\n"+
	    "Source code: http://github.com/MacPhage/pCalculator\n"+
	    "Changes in this version: \n"+changes);
	  }
	public static void showCommands()
	{
		//Woot, just like the trusty C++ version!
		alert(""
				+ "Now showing BASIC MATH functions.\n"
				+ "  To perform addition, type \'add\' without quotes.\n"
				+ "  To perform subtraction, type \'subtract\' without quotes.\n"
				+ "  To perform multiplication, type \'multiply\' without quotes.\n"
				+ "  To perform division, type \'divide\' without quotes.\n"
				+ "  To perform exponents, type \'power\' without quotes.\n"
				+ "  To perform squareroot, type \'squareroot\' without quotes.\n"
				+ "  To perform factorials, type \'factorial\' without quotes.\n");
	}
	public static void showHelp()
	{
		alert(
	    "Guide:\n"+
	    "- List = multiple inputs seperated by spaces\n"+
	    "- Commands ARE case-sensitive! Typing \"add\" is different from \"ADD\"\n"+
	    "\n"+
	    "Commands: (full list at http://github.com/MacPhage/pCalculator)\n"+
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
	    "\n");
	}

}
