/**
* NAME:   Michael Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
*  This code was written to describe a creature "Lion" for the Critter simulation based on guidelines provided.
*/

import java.awt.*;

public class Lion extends Critter{
	//initializes the variables for counting moves for the simulation and the color value.
	int moveCount;
	Color temp;
	
	public Lion () {
		this.temp = null;
		this.moveCount = 0;
	}

	// this method provides the action of the Lion per the instructions provided by the use of if statements.
    public Action getMove(CritterInfo info) {
    	moveCount++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
        	return Action.HOP;
        }
    }

	// this method provides the color of the Lion per the instructions provided by using Math.random() method and if statements.
    public Color getColor() {
    	if (moveCount % 3 == 0){
		    if (Math.random() < (1/3.0)){
		    	temp = Color.RED;
		    	return Color.RED;
		    } else if (Math.random() < (2/3.0) ){
		    	temp = Color.BLACK;
		    	return Color.BLACK;
		    } else {
		    	temp = Color.GREEN;
		    	return Color.GREEN;
		    }
    	} else {
    		return temp;
    	}
    }

	// this method provides the string of the Lion for the simulation per the instructions provided.
    public String toString() {
        return "L";
    }
}
