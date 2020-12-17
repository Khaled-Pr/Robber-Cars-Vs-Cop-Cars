import java.awt.Graphics;

//author: Khaled Ras guerriche

public class Car  extends Sprite{
	//instance variables
	private String description;
	private GasTank varGasTank;
	private Engine varEngine;
	
	//constructor
	public Car(String mDescription, int maxFuel, Engine varEngine, String jpgName) {
		super(jpgName);
		//description 
		if(mDescription.length()==0) {
			this.description="Generic car";
		}else {
			this.description=mDescription;
		}
		
		//maximum fuel
		if(maxFuel<0) {
			this.varGasTank=new GasTank(0);
		}else {
			this.varGasTank=new GasTank(maxFuel);
		}
		
		//engine 
		if(varEngine==null) {
			this.varEngine= new Engine("",0,0);
		}else {
			this.varEngine=varEngine;
		}
	}
		
		//getters
		public String getmDescription() {
			return description;
		}
		

		
		public double getFuelLevel() {
			return varGasTank.getLevel();
		}
		public int getMPG() {
			return varEngine.getMpg();
		}
		public void fillUp() {
		    varGasTank.setLevel(varGasTank.getCapacity());
		}
		public int getMaxSpeed() {
			return varEngine.getMaxSpeed();
		}
		public double drive(int distance, double xRatio, double yRatio) {
			
			/* x and y form a right triangle so we will find the hypotenuse 
			 * in the aim to find the rate between the disered distance
			 * and the hypotenuse, so we will find x, and y coordinations for the position 
			 */
			/*pythagorem: 
			 * X(square)+Y(square)=Hypotenuse(square)
			 */
			double hypotenuse =Math.sqrt(Math.pow(xRatio, 2)+Math.pow(yRatio, 2));
			double rate1=distance/hypotenuse;
			double xValue =xRatio*rate1;
			double yValue =yRatio*rate1;
			
			//miles will drive until we ran out of gas 
			double milesUntilOutOfGas;
			/* from the website learneartheasy.com 
			 * "miles driven = gallons fueled * Mpg" */
			 
			milesUntilOutOfGas= varEngine.getMpg()*varGasTank.getCapacity();
			milesUntilOutOfGas= (double)varEngine.getMpg()*varGasTank.getLevel();
			
			//how much gas needed to travel
			double neededGas=(double)distance/(double)varEngine.getMpg();
			
			if(milesUntilOutOfGas>distance) {
				//coordinations
				
				setX(getX()+(int)xValue);
				setY(getY()+(int)yValue);
				
				//gas tank level updates
				double gasUpdatedLevel=varGasTank.getLevel()-neededGas;
				varGasTank.setLevel(gasUpdatedLevel);
				
			}else {
				double Rate2=milesUntilOutOfGas/hypotenuse;
				xValue= xRatio* Rate2;
				yValue= yRatio* Rate2;
				
				
				setX(getX()+(int)xValue);
				setY(getY()+(int)yValue);
				
				System.out.println("Ran out of gas after driving" + milesUntilOutOfGas + "miles");
				neededGas=distance/varEngine.getMpg();
				
				double gasUpdatedLevel=(double)varGasTank.getLevel()-neededGas;
				varGasTank.setLevel(gasUpdatedLevel);
				return milesUntilOutOfGas;
			}
			
			
			return distance;
			
			

		}
		public String getDescription() {
			String summary1,summary2,summary3;
			summary1= getmDescription() + "(engine: " + varEngine.getDescription();
			summary2= ", Max speed:" + getMaxSpeed() +"))," + "fuel: " + String.format("%.2f",getFuelLevel()) ;
			summary3= "/" +varGasTank.getCapacity()+ ", location: " + "(" + getX() + "," + getY() + ")";
			return summary1+summary2+summary3;
		}
public void update(Graphics g) {
		//the update method
		super.update(g);
		

		//g.drawImage(getImage(), getX(), getY(), 60, 60, null);
		
}
	
	
	
	

}
