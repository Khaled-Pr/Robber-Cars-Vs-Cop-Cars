import java.awt.Graphics;
import java.util.Random;

//author: Khaled Ras guerriche

public class RobberCar extends Car {
	//creating private integer instance variables for the xRatio and yRatio
	private static int xRatio;
	private static int yRatio;

	public RobberCar() {
		super("copCar ", 20, new Engine("V6", 20, 200), "red-car.jpg" );
		Random rand = new Random();
		xRatio=0;
		yRatio=0;
		
		while(xRatio ==0 && yRatio ==0) {
			xRatio = rand.nextInt(5+5+1)-5;
			yRatio = rand.nextInt(5+5+1)-5;
			//note: randomNum =  rand.nextInt(max-min +1) + minimum
			

		}
		fillUp();
	}
	
	@Override
	public void update(Graphics g) {
		drive(40,xRatio,yRatio);
		super.update(g);
	}
}
