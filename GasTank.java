//Author: Khaled Ras Guerriche
//Assignment2

import java.util.logging.Level;

public class GasTank {
	//instance variables
	private int capacity;
	private double currentLevel;
	
	//Constructor
	//setter
	public GasTank(int setCapacity) {
		
		if(setCapacity<0) {
			this.capacity=0;
			this.currentLevel=0.0;
		}else {
			capacity=setCapacity;
		}
	}
	
	//getters
	public int getCapacity() {
		return capacity;
	}
	public double getLevel() {

		return currentLevel;
	}
	//setter
	public void setLevel(double levelIn) {
		//if the argument below 0 (negative)
		if(levelIn<0) {
			this.currentLevel=0.0; //set to zero
		}
		//if the argument is above capacity
		else if(levelIn>capacity) {
			this.currentLevel=capacity; // set to capacity
		}
		else {
			this.currentLevel=levelIn;
		}
	}
	

}

