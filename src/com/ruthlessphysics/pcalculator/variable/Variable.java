package com.ruthlessphysics.pcalculator.variable;

import com.ruthlessphysics.util.Debug;

public class Variable
{
	public boolean constant;
	
	private String name;
	private String value;
	public String dataType = "undefined";
	
	public Variable(String NAME, String VALUE)
	{
		name = NAME;
		value = VALUE;
	}
	public Variable(String NAME, int VALUE)
	{
		name = NAME;
		value = Integer.toString(VALUE);
		dataType = "int";
	}
	public Variable(String NAME, double VALUE)
	{
		name = NAME;
		value = Double.toString(VALUE);
		dataType = "double";
	}
	public Variable(String NAME, long VALUE)
	{
		name = NAME;
		value = Long.toString(VALUE);
		dataType = "long";
	}
	
	public Variable(String NAME, String VALUE, boolean c)
	{
		name = NAME;
		value = VALUE;
		constant = c;
	}
	public Variable(String NAME, int VALUE, boolean c)
	{
		name = NAME;
		value = Integer.toString(VALUE);
		dataType = "int";
		constant = c;
	}
	public Variable(String NAME, double VALUE, boolean c)
	{
		name = NAME;
		value = Double.toString(VALUE);
		dataType = "double";
		constant = c;
	}
	public Variable(String NAME, long VALUE, boolean c)
	{
		name = NAME;
		value = Long.toString(VALUE);
		dataType = "long";
		constant = c;
	}
	
	public void setName(String NAME)
	{
		name = NAME;
	}
	public String getName()
	{
		return name;
	}
	public void setValue(String VALUE)
	{
		if(!constant)
		{
			value = VALUE;
		}
		else
		{
			Debug.alert(name+" is a constant and can\'t be overwritten.");
		}
	}
	public String getValue()
	{
		return value;
	}
	public int getInt() throws Exception
	{
		try
		{
			return Integer.parseInt(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Debug.displayError(e);
			throw new Exception("Couldn\'t parse "+value+"as a long.");
		}
	}
	public double getDouble() throws Exception
	{
		try
		{
			return Double.parseDouble(value);
		}
		catch(Exception e)
		{
			throw new Exception("Couldn\'t parse "+value+"as a double.");
		}
	}
	public long getLong() throws Exception
	{
		try
		{
			return Long.parseLong(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Debug.displayError(e);
			throw new Exception("Couldn\'t parse "+value+"as a long.");
		}
	}
	
}
