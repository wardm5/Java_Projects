/**
* NAME:   Michael Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
*  This code was written to describe a creature "Giant" for the Creature simulation based on guidelines provided.
*/

import java.awt.Color;

public class Giant extends Critter{
	//initializes the variables for counting moves for the simulation.
	int moveCount;
	
	public Giant () {
		this.moveCount = 0;
	}

	// this method provides the action of the Giant per the instructions provided.
    public Action getMove(CritterInfo info) {
    	moveCount++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
        	return Action.RIGHT;
        }
    }

	// this method provides the color of the Giant per the instructions provided.
    public Color getColor() {
		return Color.GRAY;
    }

	// this method provides the string of the Giant for the simulation per the instructions provided.
    public String toString() {
        if ((moveCount % 24)  < 6 ) {
        	return "fee";
        } else if ((moveCount % 24) < 12 ) {
        	return "fie";
        } else if ((moveCount% 24) < 18 ) {
        	return "foe";
        } else {
        	return "fum";
        }
    }
}