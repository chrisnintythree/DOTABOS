import java.util.ArrayList;

public class Hero {

 String heroName;
 ArrayList<String> logs = new ArrayList<String>();
 ArrayList<String> kills = new ArrayList<String>();
 ArrayList<String> hits = new ArrayList<String>();
 ArrayList<String> receives = new ArrayList<String>();
 ArrayList<String> buys = new ArrayList<String>();
 ArrayList<String> loses = new ArrayList<String>();
 ArrayList<String> casts = new ArrayList<String>();
	
	public Hero(String x){
		this.heroName = x;
	}
	
	public void addLog(String x){
		this.logs.add(x);
		if(x.contains("killed"))
			this.kills.add(x);
		if(x.contains("buys"))
			this.buys.add(x);
		if(x.contains("hits"))
			this.hits.add(x);
		if(x.contains("receives"))
			this.receives.add(x);
		if(x.contains("loses"))
			this.loses.add(x);
		if(x.contains("casts"))
			this.casts.add(x);
		return;
	}
	
	public void showOrgLogs(){
		System.out.println("KILLS: ");
		for(int i = 0; i < kills.size(); i++)
		{
		System.out.println(this.kills.get(i));
		}
		System.out.println("HITS: ");
		for(int i = 0; i < hits.size(); i++)
		{
		System.out.println(this.hits.get(i));
		}
		System.out.println("RECEIVES: ");
		for(int i = 0; i < receives.size(); i++)
		{
		System.out.println(this.receives.get(i));
		}
		System.out.println("CASTS: ");
		for(int i = 0; i < casts.size(); i++)
		{
		System.out.println(this.casts.get(i));
		}
		System.out.println("BUYS: ");
		for(int i = 0; i < buys.size(); i++)
		{
		System.out.println(this.buys.get(i));
		}
		System.out.println("LOSES: ");
		for(int i = 0; i < loses.size(); i++)
		{
		System.out.println(this.loses.get(i));
		}
		return;
	}
}
