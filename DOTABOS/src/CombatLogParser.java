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
		        Pattern p = Pattern.compile("[',.\\s]+");
		        // Split bigString into words with the pattern
		        String[] result = p.split(line);
		        // find strings matching smallString
		        
		        for(int i =0; i < result.length; i++)
		        {
		        	//System.out.println(result[i]);
		          if( result[i].equals(heroes.get(0).heroName) )
		        	  	heroes.get(0).addLog(line);
		          if( result[i].equals(heroes.get(1).heroName) )
			            heroes.get(1).addLog(line);
		          if( result[i].equals(heroes.get(2).heroName) )
			            heroes.get(2).addLog(line);
		          if( result[i].equals(heroes.get(3).heroName) )
			            heroes.get(3).addLog(line);
		          if( result[i].equals(heroes.get(4).heroName) )
			            heroes.get(4).addLog(line);
		          if( result[i].equals(heroes.get(5).heroName) )
			            heroes.get(5).addLog(line);
		          if( result[i].equals(heroes.get(6).heroName) )
			            heroes.get(6).addLog(line);
		          if( result[i].equals(heroes.get(7).heroName) )
			            heroes.get(7).addLog(line);
		          if( result[i].equals(heroes.get(8).heroName) )
			            heroes.get(8).addLog(line);
		          if( result[i].equals(heroes.get(9).heroName) )
			            heroes.get(9).addLog(line);
		          count++;
		        } 
		       
		    		
		      
		    }//end main while loop 
		    for(int s = 0; s < heroes.size(); s++){
		    	System.out.println(heroes.get(s).heroName + ": ");
		    	heroes.get(s).showOrgLogs();
		    }
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
		        		if(heroes.isEmpty())
		        			heroes.add(new Hero(result[i]));
		        		for(int k = 0; k < heroes.size(); k++){
		        				match = result[i].equals(heroes.get(k).heroName);
		        				if(match == true)
		        					k = 100; 
		        		}
		        		if(match == false){
		        			heroes.add(new Hero(result[i]));
		        			j++;
		        		}
		        	}
		        } 
		    	}
		    }
		    br.close();}
		    catch (FileNotFoundException e) {
			e.printStackTrace();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		return;
	}
}