//Author: Khaled Ras Guerriche
//Assignment2

public class Engine {
	private String type;
	private int mpg;
	private int maxSpeed;
	
	//constructor
	public Engine(String type, int mpg, int maxSpeed) {
		//if the type length is zero, engine type will
		//be "Generic engine"
		if(type.length()==0) {
			this.type="Generic engine";
		}else {
		this.type = type;}
		if(mpg<0) {
			this.mpg=0;
		}else {
		this.mpg = mpg;}
		if(maxSpeed<0) {
			this.maxSpeed=0;
		}else {
		this.maxSpeed = maxSpeed;}
	}
	
	//getters
	public String getType() {
		return type;
	}

	public int getMpg() {
		return mpg;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public String getDescription() {
		String summary;
		summary=getType() + "(MPG: " + getMpg() + ", Max speed: " + getMaxSpeed() + ")";
		return summary;
	}


	

}
