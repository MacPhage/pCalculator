package com.ruthlessphysics.pcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ruthlessphysics.pcalculator.function.Add;
import com.ruthlessphysics.pcalculator.function.Count;
import com.ruthlessphysics.pcalculator.function.Divide;
import com.ruthlessphysics.pcalculator.function.Factorial;
import com.ruthlessphysics.pcalculator.function.GreatestCommonDivisor;
import com.ruthlessphysics.pcalculator.function.LeastCommonMultiple;
import com.ruthlessphysics.pcalculator.function.Multiply;
import com.ruthlessphysics.pcalculator.function.NRoot;
import com.ruthlessphysics.pcalculator.function.Power;
import com.ruthlessphysics.pcalculator.function.QuadraticFormula;
import com.ruthlessphysics.pcalculator.function.Squareroot;
import com.ruthlessphysics.pcalculator.function.Subtract;
import com.ruthlessphysics.pcalculator.function.simplify.Fraction;
import com.ruthlessphysics.pcalculator.tool.Var;
import com.ruthlessphysics.util.Debug;

public class pCalculator 
{
	
	static String titleText = "pCalculator";
	static String version = "1.2.1, last updated September 21, 2014.";
	static String changes = "- Variable functionality\n"+
			"- NRoot function (find the nth root of things)\n"+
			"- Count function\n"+
			"- Added command aliases (\'+ 2 2\' instead of \'add 2 2\')\n"+
			"- Plenty under-the-hood changes!\n"+
			"PATCH #1:"+
			"- Added commandline support"+
			"\n";
	
	static String[] input = {"",""}; //Direct input from JOptionPane, then splitted
    static java.util.List<String> tempList; //input[] passes through this to remove the first index
    static String[] baton = {"",""}; //Passed data after being processed through tempList
    static String command; //Actual command (input[0])
    
    static boolean debug;
    public static String mode;
	
    static Scanner console = new Scanner(System.in);
    
	public static void main(String args[])
	{
		
	    //Process the arguments
		try
		{
			if(args[0].toLowerCase().equals("--cli"))
			{
				System.out.println("Command-line interface selected.");
				mode = "CLI";
			}
			else
			{
				mode = "GUI";
			}
		}
		catch(Exception e)
		{
			System.out.println("Zero or invalid arugments entered.");
			System.out.println("Using GUI instead.");
			mode = "GUI";
		}
		
		//Pass the baton
		try
		{	
			while(true)
			{
				
				if(mode.equals("CLI"))
				{
					System.out.print("Enter command: ");
					input[0] = console.nextLine();
				    input = input[0].split(" ");
				    command = input[0];
				    tempList = new ArrayList<String>(Arrays.asList(input));
				    tempList.remove(0);
				    baton = (String[]) tempList.toArray(baton);
				}
				else if(mode.equals("GUI"))
				{
					input[0] = JOptionPane.showInputDialog(null,"Enter a command: ","help");
				    input = input[0].split(" ");
				    command = input[0];
				    tempList = new ArrayList<String>(Arrays.asList(input));
				    tempList.remove(0);
				    baton = (String[]) tempList.toArray(baton);
				}
				
				
				if(command.equals("add") || command.equals("+"))
			      {
					output("Result: \n"+Add.calculate(baton));
			      }
			      else if(command.equals("subtract") || command.equals("-"))
			      {
			    	  output("Result: \n"+Subtract.calculate(baton));
			      }
			      else if(command.equals("multiply") || command.equals("*"))
			      {
			    	  output("Result: \n"+Multiply.calculate(baton));
			      }
			      else if(command.equals("divide") || command.equals("/"))
			      {
			    	  output("Result: \n"+Divide.calculate(baton));
			      }
			      else if(command.equals("power") || command.equals("pow") || command.equals("^"))
			      {
			    	  output("Result: \n"+Power.calculate(baton));
			      }
			      else if(command.equals("squareroot") || command.equals("sqrt"))
			      {
			    	  output("Result: \n"+Squareroot.calculate(baton));
			      }
			      else if(command.equals("factorial"))
			      {
			    	  output("Result: \n"+Factorial.calculate(baton));
			      }
			      else if(command.equals("quadraticFormula"))
			      {
			    	  output("Result: \n"+QuadraticFormula.calculate(baton));
			      }
			      else if(command.equals("gcd"))
			      {
			    	  output("Result: \n"+GreatestCommonDivisor.calculate(baton));
			      }
			      else if(command.equals("lcm"))
			      {
			    	  output("Result: \n"+LeastCommonMultiple.calculate(baton));
			      }
			      else if(command.equals("simplify"))
			      {
			    	  output("Result: \n"+Fraction.calculate(baton));
			      }
			      else if(command.equals("count"))
			      {
			        output("Result: \n"+Count.calculate(baton));
			      }
			      else if(command.equals("nroot"))
			      {
			        output("Result: \n"+NRoot.calculate(baton));
			      }
			      else if(command.equals("variable") || command.equals("var"))
			      {
			        Var.menu(baton);
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showInfo()
	  {
	    System.out.println(
	    "pCalculator is a light-weight Java application for convenient calculation.\n"+
	    "The functions it supports can be found using the command \"help\".\n"+
	    "\n"+
	    "Version: "+version+"\n"+
	    "Author: Austin Jackson\n"+
	    "Website: http://austinj.net/pCalculator\n"+
	    "Changes in this version: \n"+changes);
	  }
	  public static void showCommands()
	  {
	    System.out.println(
	    "Guide:\n"+
	    "- List = multiple inputs seperated by spaces\n"+
	    "- Commands ARE case-sensitive! Typing \"add\" is different from \"ADD\"\n"+
	    "\n"+
	    "Commands: (full list at http://austinj.net/pCalculator)\n"+
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
	  
	  public static void output(String s)
	  {
		  if(mode.equals("CLI"))
		  {
			  System.out.println(s);
		  }
		  else if(mode.equals("GUI"))
		  {
			  Debug.alert(s);
		  }
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
