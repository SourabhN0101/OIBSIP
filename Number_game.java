import java.util.*;
class Game_1 {
	int computerInput;
	int userInput;
	int number_of_guess=0;
	Game_1(){
		Random random=new Random();
		this.computerInput=random.nextInt(100) + 1;
		}
	public boolean takeUserInput() {
		if(number_of_guess<15) {
			System.out.println("Guess the number:");
			this.userInput=Number_game.takeIntegerInput(100);
			number_of_guess++;
			return false;
			
		}
		else {
			System.out.println("Number of attempts finished...\n");
			return true;
		}
	}
	public boolean correctGuess() {
		if(computerInput==userInput) {
			System.out.println("Congratulations, you have guess the number " + computerInput + " in " + number_of_guess +" guesses ");
			switch(number_of_guess) {
			case 1:
				System.out.println("Your score is 100");
				break;
			case 2:
				System.out.println("Your score is 90");
				break;
			case 3:
				System.out.println("Your score is 80");
				break;
			case 4:
				System.out.println("Your score is 70");
				break;
			case 5:
				System.out.println("Your score is 60");
				break;
			case 6:
				System.out.println("Your score is 50");
				break;
			case 7:
				System.out.println("Your score is 40");
				break;	
			case 8:
				System.out.println("Your score is 30");
				break;
			case 9:
				System.out.println("Your score is 20");
				break;
			case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if(number_of_guess<10 && userInput > computerInput ) {
			if(userInput -computerInput>10) {
				System.out.println("Its too high");
			}
			else {
				System.out.println("Its little high");
			}
		}
		else if(number_of_guess<10 && userInput < computerInput ) {
			if(computerInput -userInput>10) {
				System.out.println("Its too low");
			}
			else {
				System.out.println("Its little low");
			}
		}
		return false;
		
	}
}
public class Number_game {
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag= false;
		
		while (!flag) {
			try {
				Scanner s=new Scanner(System.in);
				
				input=s.nextInt();
				flag =true;
				
				if(flag && input>limit || input<1) {
					System.out.println("choose the number between 1 to " + limit);
					flag = false;
					
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value");
				flag= false;
			}
		};
		return input;
	}
	

	public static void main(String[] args) {
		System.out.println("1.Start the game \n2.Exit");
		System.out.println("Enter your Option:");
		int choice=takeIntegerInput(2);
		int next_Round=1;
		int no_of_Round=0;
		
		if(choice==1) {
			while(next_Round==1) {
				Game_1 game=new Game_1();
				boolean is_Matched=false;
				boolean is_LimitCross=false;
				System.out.println("\nRound "+ ++no_of_Round + " starts..");
				
				while (!is_Matched && !is_LimitCross) {
					is_LimitCross =game.takeUserInput();
					is_Matched= game.correctGuess();
				}
				System.out.println("1.Next Round\n2.Exit");
				System.out.println("Enter your Option:");
				next_Round=takeIntegerInput(2);
				
				if (next_Round!=1) {
					System.exit(0);
					
				}
				
				
			}
		}else
			System.exit(0);

	}

}
