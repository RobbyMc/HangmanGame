import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class HangmanGame extends JFrame {

	private Person person;
	private AlphabetPanel ap;
	private GuessPhrasePanel gpp;
	private String phrase;
	private RandomString rs;

	public HangmanGame()  {
		super("Hangman Game");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setup the panels
		person = new Person();
		person.setPreferredSize(new Dimension(650, 500));
		ap = new AlphabetPanel();
		ap.setPreferredSize(new Dimension(650, 50));

		rs = new RandomString("Test software");
		gpp = new GuessPhrasePanel(rs.next());
		super.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		super.getContentPane().add(ap); //adds the panels to the JFrame.
		super.getContentPane().add(person);
		super.getContentPane().add(gpp);
		super.pack();
		super.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				c =Character.toUpperCase(c);
				if(gpp.hasLetter(c)){
					gpp.revealLetter(c);
					ap.setLetterColor(Color.GREEN, c);
				}
                 //alphabetPanel
					else{
						person.showNext();
						ap.setLetterColor(Color.RED, c);
					}

				

				if(c == KeyEvent.VK_SPACE){
					gpp.setPhrase(rs.next());

				}
				if(c== KeyEvent.VK_ENTER){
					gpp.revealFullPhrase();
				}
			}
		});
	}





	public static void main(String[] args) {
		new HangmanGame();

	}

}
















