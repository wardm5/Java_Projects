/**
* NAME:   Michael Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
* This code was written to describe a creature "Bear" for the Critter simulation based on guidelines provided.
*/

import java.awt.*;

public class Bear extends Critter{
	//initializes the variables for counting moves for the simulation and the boolean value.
	boolean polar;
	int moveCount;

	public Bear (boolean polar){
		this.polar = polar;
		this.moveCount = 0;
	}

	// this method provides the action of the Bear per the instructions provided.
    public Action getMove(CritterInfo info) {
    	moveCount++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
        	
            return Action.HOP;
        } else {
        	return Action.LEFT;
        }
    }

	// this method provides the color of the Bear per the instructions provided (based on a boolean value) with if statements.
    public Color getColor() {
        if (polar){
        	return Color.WHITE;
        } else {
        	return Color.BLACK;
        }
    }

	// this method provides the shape of the Bear for the simulation per the instructions provided with the use of if statements.
    public String toString() {
        if (moveCount % 2 == 1) {
        	return "/";
        } else {
        	return "\\";
        }
    }
}
