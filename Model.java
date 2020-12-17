import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//author: Khaled Ras guerriche


class Model
{

    
    //used it to make the class alternates between creating CopCar and RobberCar objects
    int alt=0;
    
    //creating the array (refer to)
    private ArrayList<Sprite> sprites;

    Model() throws IOException {
    	sprites=new ArrayList<>();
    	sprites.add((Sprite)new CopCar());

    }

    public void update(Graphics g) {

    	Iterator<Sprite> iterator = sprites.iterator();
    	
    	while(iterator.hasNext()){
    		Sprite tempSprite= iterator.next();
    		tempSprite.update(g);
    	}
		
    }
    public void addSprite(int x, int y) {
    	
    	// to create the car type alternitvely 
    	
    	Sprite carType;
    	
    	if(alt==0) {
    		carType= new CopCar();

    	}else {
    		carType= new RobberCar();

    	}
        alt=(alt+1)%2;
		carType.setX(x);
        carType.setY(y);
        sprites.add(carType);
        

    }
    public void fillUp() {
    	Iterator<Sprite> iterator = sprites.iterator();
    	while(iterator.hasNext()) {
    		
    		Sprite sprite = iterator.next();
    		((Car) sprite).fillUp();
    	}
    	
    }
    
}
