// CS210 Assignment #3 "Circles"
// Michael Ward

import java.awt.*;

//This code produces an Ehrenstein Illusion from methods, nested loops, and parameters.
public class Illusion {
    public static void main(String[] args) {
        drawFigures();
    }

//This method calls the drawCircle and drawCircle2 methods.
    public static void drawFigures() {
    	DrawingPanel panel = new DrawingPanel(500 , 400);
    	panel.setBackground(Color.CYAN);
    	Graphics g = panel.getGraphics();
    	
    	//Calls drawCircle method (using parameters)
    	drawCircle(g, 0, 0, 90, 3);
    	drawCircle(g, 120, 10, 90, 3);
    	drawCircle(g, 250, 50, 80, 5);
    	
    	//Calls drawCircle2 method (using parameters)
    	drawCircle2(g, 350, 20, 40, 5, 3);
    	drawCircle2(g, 10, 120, 100, 10, 2);
    	drawCircle2(g, 240, 160, 50, 5, 4);
    	
    }
    
//This method draws the first 3 circles (not within boxes). Parameters and loops were created to create the circles.
    public static void drawCircle(Graphics g, int x,  int y, int SIZE, int insideCircle) {
    	//g.setBackground(Color.BLACK);
    	g.setColor(Color.YELLOW);
    	g.fillOval(x, y, SIZE, SIZE);
    	g.setColor(Color.BLACK);
    	g.drawOval(x, y, SIZE, SIZE);
    	g.drawLine(0 + x, (SIZE / 2) + y, (SIZE / 2) + x, 0 + y);
    	g.drawLine((SIZE / 2) + x, 0 + y, (SIZE) + x, (SIZE / 2) + y); 
    	g.drawLine( 0 + x, (SIZE / 2) + y, (SIZE / 2) + x, (SIZE) + y); 
    	g.drawLine( (SIZE / 2) + x, (SIZE) + y, (SIZE) + x, (SIZE / 2) + y); 
    	for (int i = 0; i < insideCircle; i ++ ){
    		g.drawOval(  ((SIZE/2)/insideCircle * i) +x ,((SIZE/2)/insideCircle * i) + y, SIZE - (i * (SIZE / insideCircle)), SIZE - (i * (SIZE / insideCircle)) );
    	}
    }
    
    
// This method draws the circles within the grey box. This method uses parameters and nested loops. 
    public static void drawCircle2 (Graphics g, int x,  int y, int SIZE, int insideCircle, int RowCol) {
    	g.setColor(Color.YELLOW);
    	g.fillOval(x, y, SIZE, SIZE);
    	g.setColor(Color.BLACK);
    	g.drawOval(x, y, SIZE, SIZE);
    	
    	g.setColor(Color.LIGHT_GRAY);
    	g.fillRect(x , y, SIZE * RowCol, SIZE * RowCol);
    	g.setColor(Color.RED);
    	g.drawRect(x , y, SIZE * RowCol, SIZE * RowCol);

    	
    	for (int k = 0; k <= RowCol -1; k++){
        	for (int j = 0; j <= RowCol -1; j++){ 
            	for (int i = 0; i < insideCircle; i ++ ){
                	g.setColor(Color.YELLOW);
                	g.fillOval(  ((SIZE/2)/insideCircle * i) +x + (SIZE * j) ,((SIZE/2)/insideCircle * i) + y  + (SIZE * k), SIZE - (i * (SIZE / insideCircle)), SIZE - (i * (SIZE / insideCircle)) );
                	g.setColor(Color.BLACK);
            		g.drawOval(  ((SIZE/2)/insideCircle * i) +x + (SIZE * j) ,((SIZE/2)/insideCircle * i) + y  + (SIZE * k), SIZE - (i * (SIZE / insideCircle)), SIZE - (i * (SIZE / insideCircle)) );
            	}
            	g.setColor(Color.BLACK);
        		g.drawLine(0 + x + (SIZE * j), (SIZE / 2) + y  + (SIZE * k), (SIZE / 2) + x  + (SIZE * j), 0 + y  + (SIZE * k));
            	g.drawLine((SIZE / 2) + x  + (SIZE * j), 0 + y  + (SIZE * k), (SIZE) + x  + (SIZE * j), (SIZE / 2) + y + (SIZE * k)); 
            	g.drawLine( 0 + x  + (SIZE * j), (SIZE / 2) + y  + (SIZE * k), (SIZE / 2) + x  + (SIZE * j), (SIZE) + y  + (SIZE * k)); 
            	g.drawLine( (SIZE / 2) + x  + (SIZE * j), (SIZE) + y + (SIZE * k), (SIZE) + x + (SIZE * j), (SIZE / 2) + y  + (SIZE * k)); 
        	}
    	}
    }
}