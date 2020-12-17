import java.awt.Graphics;
import java.util.Random;

//author: Khaled Ras guerriche

public class CopCar extends Car {
	//creating private integer instance variables for the xRatio and yRatio
	private static int xRatio;
	private static int yRatio;

	public CopCar() {
		super("copCar ", 30, new Engine("V6", 30, 100), "cop-car.jpg" );
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
		drive(20, xRatio, yRatio);
		super.update(g);
	}
}
