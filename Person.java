import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Person extends JPanel {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	private static final int NUM_SHAPES = 8;
	
	private int numLeft = NUM_SHAPES;
	public Person(){
		this.addMouseListener(new MouseAdapter() {
       	 public void mouseClicked(MouseEvent e) {
           	// add code so if not all shown, the next body part
				// is shown, otherwise the person is reset
       		 // if not all body parts shown
       		 showNext();
       		 //otherwise, reset person.
}
       });
	}
	
	
	
	public void reset(){        //resets the number of shapes if the mouse is clicked.
		numLeft = NUM_SHAPES;
		repaint();
	}
	public int getNumLeft(){
		return numLeft;
	}
	public void showNext(){
		numLeft -= 1;
		repaint();
	}
	//The following method paints each shape to the screen.
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		if(numLeft < 8 && numLeft>= 0){
			Circle head = new Circle(300,150,50,Color.BLUE);
			head.draw(page);
		}
		if(numLeft < 7 && numLeft >= 0){
			page.draw3DRect(100, 50, 200, 50, true);
		}
		if(numLeft < 6 && numLeft >= 0){
			page.draw3DRect(100,100,50,300,true);
		}
		if(numLeft < 5 && numLeft >= 0){
			Rectangle body = new Rectangle(270,200, 50, 100, Color.RED, Color.ORANGE);
			body.draw(page);
		}
		if(numLeft < 4 && numLeft >=0){
			Rectangle leftarm = new Rectangle(200,200, 100, 10,Color.RED,
					Color.GRAY);
			leftarm.draw(page);
		}
		if (numLeft < 3 && numLeft >=0){
			Rectangle rightarm = new Rectangle(300,200,100,10,Color.RED,Color.ORANGE);
			rightarm.draw(page);
		}
		if(numLeft < 2 && numLeft >= 0){
			Rectangle leftLeg = new Rectangle(270,300,10,90,Color.RED);
			leftLeg.draw(page);
		}
		if(numLeft  == 0 && numLeft >= 0){
			Rectangle rightLeg = new Rectangle(310,300,10,90,Color.RED);
			rightLeg.draw(page);
			page.setFont(new Font("Times New Roman",Font.BOLD,12));
			page.setColor(Color.BLACK);
			page.drawString("You lose! Click to play again.",10,25);
		}
		if(numLeft < 0){   
			reset();
		}
		
		
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Hangman Person");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JPanel panel = new Person();
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	
	
}