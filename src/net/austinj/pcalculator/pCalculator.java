//
//  pCalculator.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import net.austinj.pcalculator.function.Add;
import net.austinj.pcalculator.function.Count;
import net.austinj.pcalculator.function.Divide;
import net.austinj.pcalculator.function.Factorial;
import net.austinj.pcalculator.function.GreatestCommonDivisor;
import net.austinj.pcalculator.function.LeastCommonMultiple;
import net.austinj.pcalculator.function.Multiply;
import net.austinj.pcalculator.function.NRoot;
import net.austinj.pcalculator.function.Power;
import net.austinj.pcalculator.function.QuadraticFormula;
import net.austinj.pcalculator.function.Squareroot;
import net.austinj.pcalculator.function.Subtract;
import net.austinj.pcalculator.function.simplify.Fraction;
import net.austinj.pcalculator.tool.Interface;
import net.austinj.pcalculator.tool.VariableManager;

public class pCalculator 
{
	
	public static String inputMode = "";
	public static boolean debugging = false;
	
	private static String[] input = {"",""}; 
    private static java.util.List<String> tempList; 
    private static String[] baton = {"",""}; 
    private static String command;
    
	public static void main(String args[])
	{
		try
		{
			if(!args[0].isEmpty())
			{
				inputMode = "CLI";
				
				if(checkForArgument(args,"--debug"))
				{
					debugging = true;
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "pCalculator, currently, is only a command-line application.\nTry using an older version instead, or wait for the next version.\nTo use it by the commandline, use java -jar pCalculator.jar. If you don\'t know how to do that I\'m sorry.");
			inputMode = "GUI";
			System.exit(0);
		}
		//Temporary
		inputMode = "CLI";
		
		
		while(true)
		{
			
			Interface.showCommands();
			
			input[0] = Interface.promptLine("Choose operation: ");
		    input = input[0].split(" ");
		    command = input[0];
		    tempList = new ArrayList<String>(Arrays.asList(input));
		    tempList.remove(0);
		    baton = (String[]) tempList.toArray(baton);
			
		    //Commands
		    
			if(command.equals("add") || command.equals("+"))
			{
				Interface.alert("Result: \n"+Add.calculate(baton));
			}
			else if(command.equals("subtract") || command.equals("-"))
			{
				Interface.alert("Result: \n"+Subtract.calculate(baton));
			}
			else if(command.equals("multiply") || command.equals("*"))
			{
				Interface.alert("Result: \n"+Multiply.calculate(baton));
			}
			else if(command.equals("divide") || command.equals("/"))
			{
				Interface.alert("Result: \n"+Divide.calculate(baton));
			}
			else if(command.equals("power") || command.equals("pow") || command.equals("^"))
			{
				Interface.alert("Result: \n"+Power.calculate(baton));
			}
			else if(command.equals("squareroot") || command.equals("sqrt"))
			{
				Interface.alert("Result: \n"+Squareroot.calculate(baton));
			}
			else if(command.equals("factorial"))
			{
				Interface.alert("Result: \n"+Factorial.calculate(baton));
			}
			else if(command.equals("quadraticFormula"))
			{
				Interface.alert("Result: \n"+QuadraticFormula.calculate(baton));
			}
			else if(command.equals("gcd"))
			{
				Interface.alert("Result: \n"+GreatestCommonDivisor.calculate(baton));
			}
			else if(command.equals("lcm"))
			{
				Interface.alert("Result: \n"+LeastCommonMultiple.calculate(baton));
			}
			else if(command.equals("simplify"))
			{
				Interface.alert("Result: \n"+Fraction.calculate(baton));
			}
			else if(command.equals("count"))
			{
				Interface.alert("Result: \n"+Count.calculate(baton));
			}
			else if(command.equals("nroot"))
			{
				Interface.alert("Result: \n"+NRoot.calculate(baton));
			}
			else if(command.equals("variable") || command.equals("var"))
			{
				VariableManager.menu(baton);
			}
			else if(command.equals("info"))
			{
				Interface.showInfo();
			}
			else if(command.equals("?") || command.equals("help"))
			{
				Interface.showHelp();
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
				Interface.alert("In order to use debugging features, you need to run this with the --debug argument.");
			}
			else
			{
				Interface.alert("That wasn\'t a valid command.");
			}
			if(inputMode.equals("CLI"))
			{
				Interface.pause();
			}
		}
		System.exit(0);
	    
	}
	
	public static boolean checkForArgument(String[] args, String arg)
	{
		for(int i = 0; i < args.length; i++)
		{
			if(args[i].contains(arg))
			{
				return true;
			}
		}
		return false;
	}

}
