import java.util.ArrayList;


public class Hero {

 String heroName;
 ArrayList<String> logs = new ArrayList<String>();
 ArrayList<String> creepKills = new ArrayList<String>();
 ArrayList<String> heroKills = new ArrayList<String>();
 ArrayList<String> buildingKills = new ArrayList<String>();
 ArrayList<Kills> kills = new ArrayList<Kills>();
 ArrayList<String> hits = new ArrayList<String>();
 ArrayList<String> receives = new ArrayList<String>();
 ArrayList<String> buys = new ArrayList<String>();
 ArrayList<String> loses = new ArrayList<String>();
 ArrayList<String> casts = new ArrayList<String>();
 String[] creepsList = new String[20];
	
	public Hero(String x){
		this.heroName = x;
	}
	
	public void addLog(String x){
		this.logs.add(x);
		if(x.contains("killed"))
		{
			this.kills.add(new Kills(x));
		}
		if(x.contains("buys"))
		{
			this.buys.add(x);
		}
		if(x.contains("hits"))
		{
			this.hits.add(x);
		}
		if(x.contains("receives"))
		{
			this.receives.add(x);
		}
		if(x.contains("loses"))
		{
			this.loses.add(x);
		}
		if(x.contains("casts"))
		{
			this.casts.add(x);
		}
		return;
	}
	
	public void showOrgLogs(){
		String killType;
		if(kills.size() >= 1){
			System.out.println("DEATHS: ");
		for(int i = 0; i < kills.size(); i++)
		{
		if(this.kills.get(i).killed.equals(this.heroName)){
		System.out.println("Killer: " + this.kills.get(i).killer + " Kills: " + this.kills.get(i).killed +
				" At Time: " + this.kills.get(i).time);
		this.kills.remove(i);
		System.out.println(kills.size());
		}		
		}}
		System.out.println("KILLS: ");
		while(kills.size() > 0){
			killType = kills.get(0).killed;
			System.out.println(killType + " KILLS: ");
			for(int j = 0; j < kills.size(); j++){
				if(kills.get(j).killed.equals(killType)){
					System.out.println("Killer: " + this.kills.get(j).killer + " Kills: " + this.kills.get(j).killed +
							" At Time: " + this.kills.get(j).time);
					kills.remove(j);
					System.out.println(kills.size());
				}
			}
		}
		
		//System.out.println("HITS: ");
		for(int i = 0; i < hits.size(); i++)
		{
		//System.out.println(this.hits.get(i));
		}
		//System.out.println("RECEIVES: ");
		for(int i = 0; i < receives.size(); i++)
		{
		//System.out.println(this.receives.get(i));
		}
		//System.out.println("CASTS: ");
		for(int i = 0; i < casts.size(); i++)
		{
		//System.out.println(this.casts.get(i));
		}
		//System.out.println("BUYS: ");
		for(int i = 0; i < buys.size(); i++)
		{
		//System.out.println(this.buys.get(i));
		}
		//System.out.println("LOSES: ");
		for(int i = 0; i < loses.size(); i++)
		{
		//System.out.println(this.loses.get(i));
		}
		return;
	}
}
