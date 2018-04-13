/**
* NAME:   Michael Robert Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
*  This code was written to describe a creature "MRW" (Michael Robert Ward) for the Critter simulation based on student own instructions for best possible outcome.
*/

import java.awt.Color;

public class MRW extends Critter{
	//initializes the variables for counting moves for the simulation.
	int moveCount;
	
	public MRW () {
		this.moveCount = 0;
	}

	// this method provides the action of the MRW with the use of if statements.
    public Action getMove(CritterInfo info) {
    	moveCount++;
    	if (info.getFront() == Neighbor.OTHER) {  // this if statement checks if there is a critter in front of the MRW and then infects if there is.
            return Action.INFECT;
        } else if (info.getLeft() == Neighbor.OTHER ) { // this statement checks if there is a critter to the left of the MRW, if there is, then it turns the critter to the left.
            return Action.LEFT;    
        } else if (info.getRight() == Neighbor.OTHER ) { // this statement checks if there is a critter to the right of the MRW, if there is, then it turns the critter to the right.
            return Action.RIGHT;     
            
        // this statement checks if there is an empty space, if there is NOT wall to the left and NOT wall to the critter's back. 
        //If those are all true, then the MRW will move forward. This is written so the MRW will eventually be next the wall.
        } else if (info.getFront() == Neighbor.EMPTY && info.getLeft() != Neighbor.WALL && info.getBack() != Neighbor.WALL && info.getRight() != Neighbor.WALL) { 
            return Action.HOP;
            
        } else if (info.getFront() == Neighbor.WALL ) { // this statement checks if there is a wall in front of the MRW, if there is, then the MRW will turn right.
            return Action.RIGHT;
        } else if (info.getFront() == Neighbor.SAME ){ 	// this statement checks if there is a MRW in front of the MRW, if there is, then the MRW will turn right again.
        											 	// this allows the MRW to then face outwards and not all the same direction for a better defense.
        	return Action.RIGHT;
        } else if (info.getRight() == Neighbor.EMPTY && info.getLeft() == Neighbor.SAME){ // this statement checks if there is nothing to the right of the MRW and
		 												//  if there is anything to the left of the MRW. If these conditions are met, then the MRW will turn to the left.
        												// this allows the MRW to then face outwards and not all the same direction for a better defense.
        	return Action.RIGHT;
        } else { 
        	return Action.INFECT;
        } 
    }

    // this method provides the color of the MRW per the fact that green is my favorite color.
    public Color getColor() {
		return Color.GREEN;
    }
    
    // this method provides the string of the MRW for the simulation using if statements. When the simulation starts, the critter will "WHOO AHHH" and then go snort oink oink repeatly.
    // every 100 turns, the MRW will again let loose a war cry (WHOO AHHH) and carry on the oink oink snort pattern.
    public String toString() {
    	if (moveCount % 100 == 0){
    		return "WHOO AHHH";  // MRW battle cry.
    	} else if ((moveCount % 3) == 1){
    		return "snort";
        } else {
        	return "oink";
        } 
    }
}
