import java.util.regex.Pattern;

public class Kills {
	String time;
	String killer;
	String killed;

	int i = 0; 
	
	public Kills(String x){
		// Create a pattern to match spaces, commas, and fullstops.
        Pattern p = Pattern.compile("[',.\\s+]");
        // Split bigString into words with the pattern
        String[] result = p.split(x);
        this.time = result[0] + ":" + result[1];
       findKilled:
        for(i = 2; i < result.length; i++)
        {
        	if(result[i].contains("npc_dota")){
        		this.killed = result[i];
        		break findKilled;
        		}
        }
       findKiller:
        for(int j = i+1; j < result.length; j++)
        {
        	if(result[j].contains("npc_dota")){
        		this.killer = result[j];
        		break findKiller;
        		}
        }
	}
}
