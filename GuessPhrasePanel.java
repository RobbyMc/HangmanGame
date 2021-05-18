import java.awt.Dimension; //These are all the import statements for all the methods.
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuessPhrasePanel extends JPanel {

	private String phrase;

	private void initializeLetters(String phrase) {     
		this.phrase = phrase.toUpperCase();
		this.removeAll(); // throw away existing letters in phrase
		this.updateUI();  // reset entire UI
		for(int i = 0; i<=phrase.length()-1;i++){
			Text t = new Text(Character.toString(phrase.charAt(i)));
			if(t.isWhiteSpace() == true){
				t.hideUnderline();
				t.hideText();	
			}
			else{
				t.showUnderline();
				t.hideText();
			}
			this.add(t);
		}
		this.revalidate();
	}

	public GuessPhrasePanel(String phrase) {   // this method calls the initalizeLetters method implemented
		initializeLetters(phrase);                    // earlier in the code.
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();

				if (hasLetter(c) == true){
					revealLetter(c);
				}
			}
		});
	}








	public void setPhrase(String phrase){
		initializeLetters(phrase);
	}


	public boolean hasLetter(char c){
		c = Character.toUpperCase(c);
		boolean b = false;
		for(int i = 0; i<=phrase.length()-1;i++){
			if(c == phrase.charAt(i)){
				b = true;
			}
		}
		return b;



	}
	public void revealLetter(char c){
		c = Character.toUpperCase(c);
		for(int i = 0; i<=phrase.length()-1;i++){
			if(c == phrase.charAt(i)){
				((Text)super.getComponent(i)).showText();
			}
		}

	}
	public void revealFullPhrase(){ //reveals the full phrase 
		for(int i = 0; i<phrase.length();i++){
			((Text)super.getComponent(i)).showText();
		}
	}
	//this method tests whether or not the phrase has been revealed. If
	//the phrase is not revealed, then
	public boolean isFullPhraseRevealed(){
		int x = 0;
		boolean b = false;
		for(int i = 0; i<=phrase.length();i++){
			if(((Text)super.getComponent(i)).isVisible() == true){
				x++;
			}
			else if(phrase.charAt(i) ==' '){
				x++;
			}
		}
		return true;
	}


	public void paintComponent(Graphics page){
		super.paintComponent(page);
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Guess Phrase Panel");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new GuessPhrasePanel("Jeopardy!");
		panel.setPreferredSize(new Dimension(500,500));

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}

