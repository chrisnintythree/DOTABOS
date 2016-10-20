import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CombatLogParser {
	public static ArrayList<Hero> heroes = new ArrayList<Hero>(); 

	public static void main(String[] args) {
		int count = 0;
		
		findHeroes();
		try (BufferedReader br = new BufferedReader(new FileReader("combatlog.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {

		    	// Create a pattern to match spaces, commas, and fullstops.
		        Pattern p = Pattern.compile("[,.\\s]+");
		        // Split bigString into words with the pattern
		        String[] result = p.split(line);
		        // find strings matching smallString
		        
		        for(int i =0; i < result.length; i++)
		        {
		          if( result[i].equals("killed") )
		            count++;
		        } 
		       
		    		
		      
		    }//end main while loop 
		    System.out.println( count ); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void findHeroes() {
		int j = 0; 
		boolean match = true;
		Pattern p = Pattern.compile("[',.\\s]+");
		try (BufferedReader br = new BufferedReader(new FileReader("combatlog.txt"))) {
		    String line;
		    while (j < 10 && (line = br.readLine()) != null) {
		    	
		    	if(line.contains("npc_dota_hero_")){
		    	String[] result = p.split(line);
		        for(int i =0; i < result.length; i++)
		        {
		        	if(result[i].contains("npc_dota_hero_")){
		        		System.out.println(result[i]);
		        		if(heroes.isEmpty())
		        			heroes.add(new Hero(result[i]));
		        		for(int k = 0; k < heroes.size(); k++){
		        				match = result[i].equals(heroes.get(k).heroName);
		        				if(match == true)
		        					k = 100; 
		        		}
		        		System.out.println(match);
		        		if(match == false){
		        			heroes.add(new Hero(result[i]));
		        			j++;
		        		}
		        	}
		        } 
		    	}
		    }
		    for(int v = 0; v < heroes.size(); v++)
		    	System.out.println(heroes.get(v).heroName);
		    br.close();}
		    catch (FileNotFoundException e) {
			e.printStackTrace();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
	}
}