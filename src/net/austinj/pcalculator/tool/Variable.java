package net.austinj.pcalculator.tool;

public class Variable
{
	
	public String id;
	public String value;
	
	Variable(String id, String value)
	{
		this.id = id;
		this.value = value;
	}
	
	public String getId()
	{
		return this.id;
	}
	public String getValue()
	{
		return this.value;
	}
}