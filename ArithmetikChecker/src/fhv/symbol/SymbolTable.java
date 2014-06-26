package fhv.symbol;

import java.util.ArrayList;
import java.util.HashMap;

import at.fhv.arithmetik.ParseException;

public class SymbolTable {

	HashMap<String, Integer> vars=new HashMap<String,Integer>();
	ArrayList<String> usedVars=new ArrayList<String>();
	
	public void addVar(String var,Integer value) throws ParseException
	{
		if(!vars.containsKey(var))
		{
		vars.put(var, value);
		addUsedVar(var);
		}
		else
		{
		throw new ParseException("Variable is already defined "+ var);
		}
	}
	
	private void addUsedVar(String var){
		if(!usedVars.contains(var))
		usedVars.add(var);
	}
	
	private void removedUsedVar(String var){
		if(usedVars.contains(var))
		usedVars.remove(var);
	}
	
	public double lookUp(String var) throws ParseException{
		
		if(vars.containsKey(var))
		{
			usedVars.remove(var);
			return (double)vars.get(var);
		}
		
		throw new ParseException("Used not defined variable "+ var);
	}
	
	public void checkIfAllVariablesBeenUsed() throws ParseException
	{
		if(usedVars.size()>0)
		{
			
			throw new ParseException("Not all vars are used "+ usedVars.toString());
		}
	}
	
	
	
}
