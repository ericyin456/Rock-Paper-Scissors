import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		System.out.println("Welcome to Rock Paper Scisscors game. Good Luck!");
		
		int AIGuesser, win = 0, lose = 0, draw = 0, rounds = 0;
		String userGuess = "";
		String[] rock_paper_scissors = {"rock", "paper", "scissors"};
		Random  rand = new Random();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Type in your choice of (rock, paper, scissors)");
			userGuess = sc.nextLine();
			if("quit".equals(userGuess)) {
				break;
			}
			
			while( !userGuess.equals(rock_paper_scissors[0]) && !userGuess.equals(rock_paper_scissors[1]) && !userGuess.equals(rock_paper_scissors[2])) {
				System.out.println("You type something incorrect, double check your spelling.");
				System.out.println("'rock', 'paper', 'scissors'");
				userGuess = sc.nextLine();
			}

			AIGuesser = abs(rand.nextInt() % 3);

			String winner = whoWins(userGuess, rock_paper_scissors[AIGuesser]);
			System.out.println("AI guessed:" + rock_paper_scissors[AIGuesser]);
			if("user".equals(winner)) {
				win++;
				System.out.println("You win!");
			}
			else if("AI".equals(winner)){
				lose++;
				System.out.println("You lose!");
			}
			else if (winner.equals("draw")) {
				draw++;
				System.out.println("It's a draw, WHY COULDN'T YOU WIN??");
			}
			rounds++;
		}

		
		System.out.println("Here is your stats for the game");
		System.out.println("Total Rounds:"+rounds);
		System.out.println("Wins:" + win);
		System.out.println("Loses:" + lose);
		System.out.println("Draws:" + draw);
		
	}
	

	private static int abs(int i) {
		if(i < 0)
			return i*-1;
		else
			return i;
	}


	static String whoWins(String userGuess, String AIGuess) {
		if(userGuess.equalsIgnoreCase("rock") && AIGuess.equalsIgnoreCase("scissors")) {
			return "user";
		}
		else if (userGuess.equalsIgnoreCase("paper") && AIGuess.equalsIgnoreCase("rock")) {
			return "user";
		}
		else if (userGuess.equalsIgnoreCase("scissors") && AIGuess.equalsIgnoreCase("paper") ) {
			return "user";
		}
		else if(userGuess.equalsIgnoreCase(AIGuess)) {
			return "draw";
		}
		else
			return "AI";
	}

}
