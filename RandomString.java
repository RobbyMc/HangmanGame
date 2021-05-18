import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class RandomString {
	private ArrayList<String> phrases;
	private Random random;
	public RandomString(String filename) {
		try{
			random = new Random();
			phrases = new ArrayList<String>();
			Scanner scan = new Scanner(filename);

			while(scan.hasNext()){
				String line = scan.nextLine();
				phrases.add(line);
				//System.out.println(phrases.size());
			}
			
		}catch(Exception e){
			e.printStackTrace(); 
		}
	}
	public  String next(){  // Gets the next phrase. takes it as a string
		int r = random.nextInt(phrases.size());
		return phrases.get(r);
	}

	public static void main(String[] args) {
         RandomString rs = new RandomString("test software");//Main method that calls the RandomString constructor
         System.out.println(rs.next());
         
	}

}
