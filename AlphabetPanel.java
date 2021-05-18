import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class AlphabetPanel  extends JPanel {


	private static final int WIDTH = 650;
	private static final int HEIGHT = 50;

	public AlphabetPanel() {
		this.setFocusable(true);
	this.addKeyListener(new KeyAdapter(){//This is the keyListener for 
			//AlphabetPanel
		public void keyTyped(KeyEvent e)
		{
				char c = e.getKeyChar();
				if(c == ' '){           //if the SpaceBar is pressed, this resets the
				reset();               // colors of the letters 
				}
				else{
				c = Character.toUpperCase(c);
				if( c >='A'&& c <= 'Z'){
						if(isVowel(c) == true){
							setLetterColor(Color.GREEN,c);//sets the color to red if the
							//letter is  a vowel.
					}
					else{
						setLetterColor(Color.RED,c);// sets the color to blue if
					}
						//letter is a consonant.
				}
				}

		}
		
	});




		for(char x = 'A';x<='Z'; x++){
			System.out.println(x);
			Text t = new Text(Character.toString(x));
			super.add(t);
			t.hideUnderline();
			t.setLetterColor(Color.GRAY);
		}
		System.out.println(this.getLetterColor('*'));
		this.setLetterColor(Color.GREEN, 'C');
		System.out.println(isVowel('e'));

	}
	//when this method is called, the color of the letters is reset to gray.
	public void reset(){     
		repaint();
		for(char c ='A';c <= 'Z';c++){       
			setLetterColor(Color.GRAY,c);
		}
	}
	public Color getLetterColor(char c){
		Color color = null;
		if(c >= 'A'&& c<='Z')
			color = ((Text)super.getComponent(c- 'A')).getLetterColor();
		return color;
	}
	public void setLetterColor(Color letterColor,char c){
		c  = Character.toUpperCase(c);
		if(c >='A'&& c<='Z')
			((Text)super.getComponent(c-'A')).setLetterColor(letterColor);
	}

	public boolean hasLetterBeenSeen(char c){
		boolean b = false;
		c = Character.toUpperCase(c);
		Color letterColor = getLetterColor(c);
		if(c >='A' && c<='Z'){
			if(letterColor !=Color.GRAY){
				b = true;
			}
		}
		return b;

	}
	public boolean isVowel(char c){
		c = Character.toUpperCase(c);
		return c =='A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U';//tests whether or not 
		//the letter is a vowel.
	}


	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Hangman Alphabet Panel");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new AlphabetPanel();
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}




}

