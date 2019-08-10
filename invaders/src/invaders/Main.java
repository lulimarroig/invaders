package invaders;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to invaders detector :)");
		
		System.out.println("Processing input");
		if(args == null || args.length == 0) {
			System.out.println("Ooops you need to provide an input");
			System.out.println("Goodbye");
			return;
		}else if(args.length > 2){
			System.out.println("Ooops wrong parameters. Expected input:");
			System.out.println("File name");
			System.out.println("[Optional] Detection accuracy");
			System.out.println("Goodbye");
			return;
		}
		
		char[][] input;
		try {
			input = Parser.readInput(args[0]);

			System.out.println("Detecting invaders");
			int invadersFound = 0;
			if(args.length == 2)
				invadersFound = DetectInvaders.detect(input, Parser.readInvaders(), Integer.parseInt(args[1]));
			else
				invadersFound = DetectInvaders.detect(input, Parser.readInvaders());
			
			if(invadersFound > 0)
				System.out.println("We have found " + invadersFound + " invader in your input");
			else 
				System.out.println("We didn't find invaders :)");

			System.out.println("Goodbye");
		} catch (Exception e) {
			System.out.println("Ooops an error happened: " + e.getMessage());
			System.out.println("Goodbye");
			return;
		}
	}
}
