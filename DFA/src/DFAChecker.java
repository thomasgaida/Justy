import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class DFAChecker {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> states=new ArrayList<String>();
		ArrayList<String> symbols=new ArrayList<String>();
		ArrayList<String> endStates= new ArrayList<String>();
		
		HashMap<String,HashMap<String,String>> map=new HashMap<String,HashMap<String,String>>();
		
		
		states.add("A");
		states.add("B");
		states.add("C");
		states.add("D");
		
		symbols.add("x");
		symbols.add("y");
		symbols.add("z");
		
		endStates.add("C");
		
		
		
		map.put("A", getHashMap("x","B"));
		map.get("A").put("y","");
		map.get("A").put("z","A");
		
		map.put("B", getHashMap("x",""));
		map.get("B").put("y","D");
		map.get("B").put("z","C");
		
		map.put("C", getHashMap("x",""));
		map.get("C").put("y","");
		map.get("C").put("z","");
		
		map.put("D", getHashMap("z","C"));
		map.get("D").put("x","");
		map.get("D").put("y","");
		
		
		
		String tape="zzzzxz";
		
		
		String startState="A";
		String state=startState;
		for(char c: tape.toCharArray())
		{
			String newState=map.get(state).get(String.valueOf(c));
			if(!newState.equals(""))
			{
				state=newState;
				continue;
			}
			else
			{
				System.err.println("Fehler. Es handelt sich um keine gültige Zeichenkette");
			}
		}
		
		if(endStates.contains(state))
		{
			System.out.println("Gültiger Endzustand. Zeichenkette OK");
		}
		else
		{
			System.err.println("Fehler. Kein gültiger Endzustand. Zeichenkette fehlerhaft");
		}

	}

	private static HashMap<String, String> getHashMap(String symbol,
			String newState) {
		HashMap tmp=new HashMap();
		tmp.put(symbol, newState);
		
		return tmp;
	}

}
