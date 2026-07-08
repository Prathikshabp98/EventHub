package practise.testcases;

import java.util.HashMap;

public class GIT {

	public static void main(String[] args) {
		
		String name = "prathiksha";
		
		HashMap<Character,Integer> map = new HashMap<>();
		
		for(int i=0 ; i<name.length(); i++)
		{
			
			char c = name.charAt(i);
			
			if(map.containsKey(c))
			{
				map.put(c,map.get(c)+1);
			}
			
			else
			{
				map.put(c, 1);
			}
			
		}
		
		System.out.println(map);
		
		

	}

}
