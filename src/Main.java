/**
 * Program Name: Main.java
 * Purpose: Make a menu with game options that a user can input and interact with
 * Coder: Ty Burchat | 1246765
 * Date: Jan 19, 2024
 */

import java.util.*;

public class Main
{

	public static void main(String[] args)// this acts as the main menu
	{
		// Creating a Scanner and String value for menu
		String difficulty = "Nuh-uh";
		Scanner input = new Scanner(System.in);
		String choice;
		//Output Menu to user.
		while(true) {
			System.out.println("1. Guessing Game\n2. Battle Ship\n3. Exit\nType the number or the word of the game you would like to play!");
			choice = input.nextLine().toLowerCase();// Take user's input and puts it to lower case.
			
			//If checks if choice is equal to any game menu options. if is equal it call a method that runs the game. 
			//If it is not equal it will output a invalid input and reprint the menu screen
			
			//TODO: Make it so it wipes all text out of the console when switching to a new game
			//Make it so it closes the console .
			
			if(choice.equals("guessing game") ||choice.equals("1") ||choice.equals("1. guessing game") || choice.equals("1.gussinggame")) {
				System.out.print("Guessing Game Running");
				guessingGame(input, difficulty);//Starts hiLow game. the reason for input is because it
				//brings the scanner object form Main method to the HiLow method.
			}else if (choice.equals("battle ship") ||choice.equals("2") ||choice.equals("2. battle ship")) {
				System.out.println("Battle Ship Is still under devlopment. please select a diffrent option");
				battleShip(input);
			}else if(choice.equals("exit") ||choice.equals("3") ||choice.equals("3. exit")) {
				System.out.println("Exiting Program");
				break;
			}else {
				System.out.println("Invalid Input. please try again\n");//this is what outputs when the user
				//enters a input that does not match anything above
			}	
		}
		input.close();//House cleaning
	}//Main 
	
	//This is the high low game. the Scanner Input means its asking for a
	//scanner object to be ran
	public static void guessingGame(Scanner input, String difficulty){ 
		System.out.println("Welcome to Hi Low!!!");
		int num;
		int Score = 0;
		int low;
		int high;
		
		while(true) {
			System.out.println("1. Play\n2. How to play");
			difficulty = input.nextLine().toLowerCase();
			if(difficulty.equals("1. play") || difficulty.equals("play") || difficulty.equals("1")) {
				System.out.println();
				break;
			}else if(difficulty.equals("2. how to play") || difficulty.equals("how to play") || difficulty.equals("2")) {
				System.out.println("====RULES====");
				System.out.println("1. Dont guess over 2 billion or it will crash because\nint's can only hold so much.");
				System.out.println("2. Only guess int's please do not input a double or it will crash.");
				System.out.println("3. Try your best to guess within the bounds of your diffcutly.\n It will tell you if you go out of the bounds.");
				System.out.println("4. Have fun, Yes this is required.");
				System.out.println("\n====How-To-Play====");
				System.out.println("1. Select a diffcutly easy, medium, hard, or nick's challanged");
				System.out.println("2. Once you have selected a diffculty it will tell you the what the\n   number being"
						+ "generated is between.");
				System.out.println("3. Type in a number that you think was generated.\n-if it says too high it means you guessed above the number generated. guess a lower number.\n-if it says too low it means that you guessed below the generated number. Guess higher.\n-if it says out of bounds too high or too low you guessed larger or smaller than possible numbers generated. guess within the numbers generated.\n-Once you have guessed the right number your score is how much guesses it took you to guess the number.");
				System.out.println("Press ENTER to go back to guessing game menu.");
				input.nextLine();
			}else {
				System.out.println("Invalid Input");
			}
		}
		Random randy = new Random();//Randy here is the random variable imported form the java.util libary
		while(true) {			//Sets up the game based on difficulty
		System.out.println("Please type the difficulty you want to play and press enter:\nDiffcultys:\nEasy\nNormal\nHard\nNick's Challanged\n"); //this prints all the dffcutly's in the game
		difficulty = input.nextLine().toLowerCase();//Player inputs what difficulty they want to play. 
		if (difficulty.equals("easy")) {
			num = randy.nextInt(1,11);//Randy Comes up with a number between 1 and 10
			System.out.println("Guess a number between 1 and 10?");//Outputs and lets the player know the range they need to guess in
			low = 1; //Sets lowest possible guess to 1
			high = 10; //Sets highest possible guess to 10
			break;
		}else if(difficulty.equals("normal")) {
			num = randy.nextInt(1,101);//Randy Comes up with a number between 1 and 100
			System.out.println("Guess a number between 1 and 100?");//Outputs and lets the player know the range they need to guess in
			low = 1;//Sets lowest possible guess to 1
			high = 100;//Sets highest possible guess to 100
			break;
		}else if(difficulty.equals("hard")){
			num = randy.nextInt(1,1001);//Randy Comes up with a number between 1 and 1000
			System.out.println("Guess a number between 1 and 1000?");//Outputs and lets the player know the range they need to guess in
			low = 1;//Sets lowest possible guess to 1
			high = 1000;//Sets highest possible guess to 1000
	    break; 
		}else if(difficulty.equals("nick's challanged") || difficulty.equals("nicks challanged")){//Blame Nick for this, It was not my idea.
			num = randy.nextInt(1,1_000_000_001); //Randy Comes up with a number between 1 and 1 billion
			System.out.println("Guess a number between 1 and 1,000,000,000?");//Outputs and lets the player know the range they need to guess in
			low = 1;//Sets lowest possible guess to 1
			high = 1_000_000_000;//Sets highest possible guess to 1 Billion
	    break;
	  }else {
			System.out.println("Invalid Input. please try again\n");
		}	
		}
		int guess;
		while(true) {
			guess = input.nextInt();
			if(guess >= low && guess <= high) {//this if makes sure that the guess is in range.
				//for example cant type 100 if the max number randy only can pick is 10
				Score++;//adds one to score. the lower score you have the better
				if(guess < num) {
					System.out.println("To low, guess a higher number!");
				}else if(guess > num){
					System.out.println("To high, guess a lower number!");
				}else if(guess == num) {
					input.nextLine();
					System.out.println("you win");//Lets the player know they won and prints there score
					System.out.println("It took you " + Score + " Guesses to get the right number!");
					System.out.println("Press enter key to go back to main menu");
					input.nextLine();
					break;//Breaks the while loop sending user back to main
				}
			}else if (guess < low){
			  //Lets the player know that there out of range and reminds them what 
				//the lowest number could be.
				System.out.println("Out of bounds please guess above " + low+ ".");
			}else if (guess > high){
				//Lets the player know that there out of range and reminds them what 
				//the highest number could be
				System.out.println("Out of bounds please guess below " + high+ ".");
			}
		}
		}
	
	
		public static void battleShip(Scanner input) {
			String Menu;//Sets Menu option string and outputs menu to player
			System.out.println("BATTLE SHIP");
			String ship = "$";
			String miss = "L";
			String hit = "*";
			boolean Player1lost;
			boolean Player2lost;
			String playerShips1[] = new String[5];//Sets playerships array size
			String playerShips2[] = new String[5];//Sets playerships array size
			String place = null; // varable used to place a ship
			String facing = null;
			String selector = null;
			String letter = null;
			String num = null;
			int cord;
			int shipCount = 5;
			playerShips1[0] = "carrier";//Sets playerships array value
			playerShips1[1] = "battleship";//Sets playerships array value
			playerShips1[2] = "destroyer";//Sets playerships array value
			playerShips1[3] = "submarine";//Sets playerships array value
			playerShips1[4] = "patrol boat";//Sets playerships array value
			playerShips2[0] = "carrier";//Sets playerships array value
			playerShips2[1] = "battleship";//Sets playerships array value
			playerShips2[2] = "destroyer";//Sets playerships array value
			playerShips2[3] = "submarine";//Sets playerships array value
			playerShips2[4] = "patrol boat";//Sets playerships array value
			while(true) {//Traps options in a loop so if an invalid option is made it wont continue to the game
				System.out.println("\n1. Start\n2. How To Play\nPlease put the number or the name of the action you would like to perform and press enter.");
				Menu = input.nextLine().toLowerCase();
				if(Menu.equals("start") || Menu.equals("1")) {
					break;//Breaks and starts the game
				}else if(Menu.equals("how to play") || Menu.equals("2")|| Menu.equals("2. how to play")) {
					//Outputs the rules then tells the player to press enter to continue back to battleship menu
					System.out.println("====Rules====");
					System.out.println("1. Do not peek at the other players screen during there turn.");
					System.out.println("2. Do not scroll up 10 lines during your turn because it will reveal the other players board.");
					System.out.println("3. Have fun.");
					System.out.println("====How-To-Play====");
					System.out.println("Once you start the game before it prints player 1 sides it will say 'Player1 Press ENTER to placeships'\n"
							+ "Before player1 presses enter make sure that player2 is not looking at the screen.");
					System.out.println("After player 1 places all there ships the screen will clear and it will say 'Player2 Press ENTER to placeships'\nBefore player2 presses enter make sure that player1 is not looking at the screen.");
					System.out.println("After the Ships are placed it will clear the screena and print 'player1 Press Enter to Continue'\n make sure player2 isnt looking at the screen when player 1 presses enter'.");
					System.out.println("Player1 will pick a cordinate that they think player2 put there ship on. it will fire and tell player1 if it was a 'hit' or 'miss' after that player2 turn starts follow"
							+ "\n the first 2 instructions above this but with player2");
				}else {
					System.out.println("Invalid Input. please try again\n");
				}
			}
			//this sets up both boards boardArray1 is player 1's and boardArray2 is player twos
			String boardArray1[] = new String[100];//Sets up board Array1
			String boardArray2[] = new String[100];//Sets up board Array2
			String boardAttack1[] = new String[100];//Sets up boardAttack1
			String boardAttack2[] = new String[100];//Sets up boardAttack2
			for(int i = 0; i < 100; i++) {//Sets all 100 values in array to display "-" the dash simulates empty tiles or "water"
				boardArray1[i] = "-";
				boardArray2[i] = "-";
				boardAttack1[i] = "-";
				boardAttack2[i] = "-";
			}
			
			
				System.out.println("Player1 Press ENTER to place ships");
				//This is so it waits for the player to ENTER so the nextline() stops waiting for the buffer.
				//it gives time for player1 to confirm that player 2 is not looking at the screen.
				input.nextLine();  
				
				while(true) {
					System.out.println("  1 2 3 4 5 6 7 8 9 0"); 
					for(int x = 0; x < 10; x++) {//Sets Value of arrays
						if(x == 0) { 
							letter = "A";
						} else if(x == 1) {//This needs to be redon with char's. I could convert int to char and use math.
							letter = "B";			//This is very bad.
						}else if(x == 2) {
							letter = "C";
						}else if(x == 3) {
							letter = "D";
						}else if(x == 4) {
							letter = "E";
						}else if(x == 5) {
							letter = "F";
						}else if(x == 6) {
							letter = "G";
						}else if(x == 7) {
							letter = "H";
						}else if(x == 8) {
							letter = "I";
						}else if(x == 9) {
							letter = "J";}
						System.out.print(letter +" "); //Prints the table
						System.out.print(boardArray1[x]);//a
						System.out.print(" ");
						System.out.print(boardArray1[x+10]);//b
						System.out.print(" ");
						System.out.print(boardArray1[x+20]);//c
						System.out.print(" ");
						System.out.print(boardArray1[x+30]);//d
						System.out.print(" ");
						System.out.print(boardArray1[x+40]);//e
						System.out.print(" ");
						System.out.print(boardArray1[x+50]);//f
						System.out.print(" ");
						System.out.print(boardArray1[x+60]);//g
						System.out.print(" ");
						System.out.print(boardArray1[x+70]);//h
						System.out.print(" ");
						System.out.print(boardArray1[x+80]);//i
						System.out.print(" ");
						System.out.println(boardArray1[x+90]);//j
					}
						//Player places Ship
						System.out.println("Please Select a coordinate to put your ship at for example A2");
						selector = input.nextLine().toLowerCase();
						num = selector;//sets num equil to selector
						num = num.substring(1, 2);//remove the letter form the varable
						//this value will be used below when placeing ships. it will have value added to it to make it
						//equil the array number on the board
						cord = 0;
						
						// System.out.println("Num " + num); //this is for debugging to show value of num.
						// The if and else if below is to convert num varable
						// TODO: 
						//convert Type String to type int and add it to cord
						if(num.equals("2")){
							cord += 10;
						}else if(num.equals("3")) {
							cord += 20;
						}else if(num.equals("4")) {
							cord += 30;
						}else if(num.equals("5")) {
							cord += 40;
						}else if(num.equals("6")) {
							cord += 50;
						}else if(num.equals("7")) {
							cord += 60;
						}else if(num.equals("8")) {
							cord += 70;
						}else if(num.equals("9")) {
							cord += 80;
						}else if(num.equals("0")) {
							cord += 90;
						}else {
							System.out.println("Invalid input");
						}
						
						selector = selector.substring(0, 1);//removes the number from the variable 0 is start of index and 1 is end from were it starts and removes. 0 is the first String
						//System.out.println("Selector " + selector); //converts the value to the 10's section
		
						if(selector.equals("b")) {
							cord += 1;
						}else if(selector.equals("c")) {
							cord += 2;
						}else if(selector.equals("d")) {
							cord += 3;
						}else if(selector.equals("e")) {
							cord += 4;
						}else if(selector.equals("f")) {
     				cord += 5;
						}else if(selector.equals("g")) {
							cord += 6;
						}else if(selector.equals("h")) {
							cord += 7;
						}else if(selector.equals("i")) {
							cord += 8;
						}else if(selector.equals("j")) {
							cord += 9;
						}
						/* the if statement below makes sure that the cord you pick dosen't have a ship.
						 * it does not account for overlapping ships. I will need to fix this later.
						 */
						if(boardArray1[cord].equals("-")) {
							System.out.println("");
							System.out.print("What ship would you like to place? you can pick.\n");
								for(int y = 0; y < playerShips1.length; y++) {
									System.out.println(playerShips1[y]);//Also need to add how much pins each ship takes up
							}
						}
								
						place = input.nextLine().toLowerCase(); //Selecting the Ship that will be places
						
						if(place.equals(playerShips1[0])) {
									playerShips1[0] = "        ";
									while(true) {
									System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
									facing = input.nextLine().toLowerCase();//Placing ships, and making it so you cant place a ship out of bounds
										if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //Place ship 1 upright
										//Want to try put this into a for loop check. would make it so much better. Maybe in v3 for now
										//Just want to get it running
										{//placing ship 1	
											if(cord-1 == 9 && cord >= 10||cord-1 == 19 && cord >= 20||cord-1 == 29 && cord >= 30||cord-1 == 39 && cord >= 40||cord-1 == 49 && cord >= 50||cord-1 == 59 && cord >= 60||cord-1 == 69 && cord >= 70||cord-1 == 79 && cord >= 80||cord-1 == 89 && cord >= 90) {
													boardArray1[cord+3] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+1] = ship;
													boardArray1[cord+2] = ship;
													boardArray1[cord+4] = ship;
													shipCount = shipCount -1;
													break;
											}else if(cord-2 == 9 && cord >= 10||cord-2 == 19 && cord >= 20||cord-2 == 29 && cord >= 30||cord-2 == 39 && cord >= 40||cord-2 == 49 && cord >= 50||cord-2 == 59 && cord >= 60||cord-2 == 69 && cord >= 70||cord-2 == 79 && cord >= 80||cord-2 == 89 && cord >= 90) {
												boardArray1[cord+3] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord+4] = ship;
												boardArray1[cord+1] = ship;
												boardArray1[cord+2] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord-3 == 9 && cord >= 10||cord-3 == 19 && cord >= 20||cord-3 == 29 && cord >= 30||cord-3 == 39 && cord >= 40||cord-3 == 49 && cord >= 50||cord-3 == 59 && cord >= 60||cord-3 == 69 && cord >= 70||cord-3 == 79 && cord >= 80||cord-3 == 89 && cord >= 90) {
												boardArray1[cord+2] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-1] = ship;
												boardArray1[cord-2] = ship;
												boardArray1[cord+1] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord-4 == 9 && cord >= 10||cord-4 == 19 && cord >= 20||cord-4 == 29 && cord >= 30||cord-4 == 39 && cord >= 40||cord-4 == 49 && cord >= 50||cord-4 == 59 && cord >= 60||cord-4 == 69 && cord >= 70||cord-4 == 79 && cord >= 80||cord-4 == 89 && cord >= 90) {
												boardArray1[cord-3] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-1] = ship;
												boardArray1[cord-2] = ship;
												boardArray1[cord+1] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord-5 == 9 && cord >= 10||cord-5 == 19 && cord >= 20||cord-5 == 29 && cord >= 30||cord-5 == 39 && cord >= 40||cord-5 == 49 && cord >= 50||cord-5 == 59 && cord >= 60||cord-5 == 69 && cord >= 70||cord-5 == 79 && cord >= 80||cord-5 == 89 && cord >= 90) {
												boardArray1[cord-3] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-1] = ship;
												boardArray1[cord-2] = ship;
												boardArray1[cord-4] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord+1 >= 11 && cord <= 9||cord+1 >= 21 && cord <= 19||cord+1 >= 31 && cord <= 29||cord+1 >= 41 && cord <= 39||cord+1 >= 51 && cord <= 49||cord+1 >= 61 && cord <= 69||cord+1 >= 71 && cord <= 79||cord+1 >= 81 && cord <= 89||cord+1 >= 91 && cord <= 99) {
													boardArray1[cord-1] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord-2] = ship;
													boardArray1[cord-3] = ship;	
													boardArray1[cord-4] = ship;	
													shipCount = shipCount -1;
													break;
											}else if(cord+1 >= 11 && cord <= 9||cord+1 >= 21 && cord <= 19||cord+1 >= 31 && cord <= 29||cord+1 >= 41 && cord <= 39||cord+1 >= 51 && cord <= 49||cord+1 >= 61 && cord <= 69||cord+1 >= 71 && cord <= 79||cord+1 >= 81 && cord <= 89||cord+1 >= 91 && cord <= 99) {
												boardArray1[cord-1] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-2] = ship;
												boardArray1[cord-3] = ship;	
												boardArray1[cord-4] = ship;	
												shipCount = shipCount -1;
												break;
											}else if(cord+2 >= 11 && cord <= 9||cord+2 >= 21 && cord <= 19||cord+2 >= 31 && cord <= 29||cord+2 >= 41 && cord <= 39||cord+2 >= 51 && cord <= 49||cord+2 >= 61 && cord <= 69||cord+2 >= 71 && cord <= 79||cord+2 >= 81 && cord <= 89||cord+2 >= 91 && cord <= 99) {
												boardArray1[cord-4] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-1] = ship;
												boardArray1[cord-2] = ship;	
												boardArray1[cord-3] = ship;	
												shipCount = shipCount -1;
												break;
											}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
												boardArray1[cord+1] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-1] = ship;
												boardArray1[cord+2] = ship;	
												boardArray1[cord-2] = ship;	
												shipCount = shipCount -1;
												break;// THis is very ineffetive too bad.
											}else if(cord+4 >= 11 && cord <= 9||cord+4 >= 21 && cord <= 19||cord+4 >= 31 && cord <= 29||cord+4 >= 41 && cord <= 39||cord+4 >= 51 && cord <= 49||cord+4 >= 61 && cord <= 69||cord+4 >= 71 && cord <= 79||cord+4 >= 81 && cord <= 89||cord+4 >= 91 && cord <= 99) {
												boardArray1[cord+1] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord+2] = ship;
												boardArray1[cord+3] = ship;	
												boardArray1[cord+4] = ship;	
												shipCount = shipCount -1;
												break;
											}else if(cord+5 >= 11 && cord <= 9||cord+5 >= 21 && cord <= 19||cord+5 >= 31 && cord <= 29||cord+5 >= 41 && cord <= 39||cord+5 >= 51 && cord <= 49||cord+5 >= 61 && cord <= 69||cord+5 >= 71 && cord <= 79||cord+5 >= 81 && cord <= 89||cord+5 >= 91 && cord <= 99) {
												boardArray1[cord+1] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord+2] = ship;
												boardArray1[cord+3] = ship;	
												boardArray1[cord+4] = ship;	
												shipCount = shipCount -1;
												break;
											}else{
													boardArray1[cord-1] = ship;
													boardArray1[cord-2] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+1] = ship;
													boardArray1[cord+2] = ship;
													shipCount = shipCount -1;
													break;
													
											}
										}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways"))//Place ship 2 sideways
										{
											if(cord-10 < 0) {
													boardArray1[cord+30] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+10] = ship;
													boardArray1[cord+20] = ship;
													boardArray1[cord+40] = ship;
													shipCount = shipCount -1;
													break;
													
											}else if(cord+10 >= 100 || cord+20 < 99) {
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+20] = ship;
													boardArray1[cord+10] = ship;
													boardArray1[cord+30] = ship;
													shipCount = shipCount -1;
													break;
													
											}else if(cord+20 > 99) {
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord-20] = ship;
													boardArray1[cord-30] = ship;
													boardArray1[cord-40] = ship;
													shipCount = shipCount -1;
													break;
													
											}else{
													boardArray1[cord-20] = ship;
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+20] = ship;
													boardArray1[cord+10] = ship;
													shipCount = shipCount -1;
													break;
													
											}
											}else{
													System.out.println("Invalid position");
										
											}
										break;
										}//NOTE OPTIMISED UP TO HERE
										}else if(place.equals(playerShips1[1])) {//placing ship 2
									playerShips1[1] = "       ";
									while(true) {
										System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
										facing = input.nextLine().toLowerCase();
										if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 2 upright
										{ 	
												if(cord-5 <= 9 && cord >= 10||cord-5 <= 19 && cord >= 20||cord-5 <= 29 && cord >= 30||cord-5 <= 39 && cord >= 												40||cord-5 <= 49 && cord >= 50||cord-5 <= 59 && cord >= 60||cord-5 <= 69 && cord >= 70||cord-5 <= 79 && cord 												>= 80||cord-5 <= 89 && cord >= 90) {
														boardArray1[cord] = ship;
														boardArray1[cord+1] = ship;
														boardArray1[cord+2] = ship;
														boardArray1[cord+3] = ship;
														boardArray1[cord+4] = ship;
														boardArray1[cord+5] = ship;
														shipCount = shipCount -1;
														break;
												}else if(cord+5 >= 11 && cord <= 9||cord+5 >= 21 && cord <= 19||cord+5 >= 31 && cord <= 29||cord+5 >= 41 && 													cord <= 39||cord+5 >= 51 && cord <= 49||cord+5 >= 61 && cord <= 69||cord+5 >= 71 && cord <= 79||cord+5 >= 													81 && cord <= 89||cord+5 >= 91 && cord <= 99) {
														boardArray1[cord-1] = ship;
														boardArray1[cord] = ship;
														boardArray1[cord-2] = ship;
														boardArray1[cord-3] = ship;
														boardArray1[cord-4] = ship;
														boardArray1[cord-5] = ship;
														shipCount = shipCount -1;
														break;
												}else{
													boardArray1[cord+5] = ship;
													boardArray1[cord+4] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+1] = ship;
													boardArray1[cord+2] = ship;
													boardArray1[cord+3] = ship;
													shipCount = shipCount -1;
													break;
												}
										}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
											if(cord-50 < 0) {
												boardArray1[cord] = ship;
												boardArray1[cord+10] = ship;
												boardArray1[cord+20] = ship;
												boardArray1[cord+30] = ship;
												boardArray1[cord+40] = ship;
												boardArray1[cord+50] = ship;
												shipCount = shipCount -1;
												break;
											}else if(cord+10 > 99 || cord+50 < 99) {//I dont even call this forgot why I made this
												boardArray1[cord+10] = ship;					//It should be removed later. for now
												boardArray1[cord] = ship;							//I need to make the game and do testing to confirm
												boardArray1[cord-10] = ship;					//its useless
												boardArray1[cord-20] = ship;					//I may need to add more else-if statements to actually
												boardArray1[cord-30] = ship;					//"Push back the ship" but for now this will work
												boardArray1[cord-40] = ship;
												shipCount = shipCount -1;
												break;
											}else if(cord+50 > 99) {
												boardArray1[cord-10] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord-20] = ship;
												boardArray1[cord-30] = ship;
												boardArray1[cord-40] = ship;
												boardArray1[cord-50] = ship;
												shipCount = shipCount -1;
												break;
											}else{
												boardArray1[cord-20] = ship;
												boardArray1[cord-10] = ship;
												boardArray1[cord] = ship;
												boardArray1[cord+20] = ship;
												boardArray1[cord+30] = ship;
												boardArray1[cord+40] = ship;
												shipCount = shipCount -1;
												break;
											}
										}else{
											System.out.println("Invalid position");
											
										}
										}
									}else if(place.equals(boardArray1[2])||place.equals("destroyer")) {
											playerShips1[2] = "       ";
											while(true) {
											System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
											facing = input.nextLine().toLowerCase();
											if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
											{ 	
													if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
															boardArray1[cord] = ship;
															boardArray1[cord+1] = ship;
															boardArray1[cord+2] = ship;
															shipCount = shipCount -1;
															break;
													}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
															boardArray1[cord-1] = ship;
															boardArray1[cord] = ship;
															boardArray1[cord-2] = ship;
															shipCount = shipCount -1;
															break;
													}else{
														boardArray1[cord-1] = ship;
														boardArray1[cord] = ship;
														boardArray1[cord+1] = ship;
														shipCount = shipCount -1;
														break;
													}
											}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
												if(cord-30 < 0) {
													boardArray1[cord] = ship;
													boardArray1[cord+10] = ship;
													boardArray1[cord+20] = ship;
													shipCount = shipCount -1;
													break;
												}else if(cord+10 > 99 || cord+20 < 99) {
													boardArray1[cord+10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord-10] = ship;
													shipCount = shipCount -1;
													break;
												}else if(cord+20 > 99) {
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord-20] = ship;
													shipCount = shipCount -1;
													break;
												}else{
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+10] = ship;
													shipCount = shipCount -1;
													break;
												}
											}
											}
										}else if(place.equals(playerShips1[3])){
											playerShips1[3] = "       ";
											while(true) {
											System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
											facing = input.nextLine().toLowerCase();
											if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
											{ 	
													if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
															boardArray1[cord] = ship;
															boardArray1[cord+1] = ship;
															boardArray1[cord+2] = ship;
															shipCount = shipCount -1;
															break;
													}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
															boardArray1[cord-1] = ship;
															boardArray1[cord] = ship;
															boardArray1[cord-2] = ship;
															shipCount = shipCount -1;
															break;
													}else{
														boardArray1[cord-1] = ship;
														boardArray1[cord] = ship;
														boardArray1[cord+1] = ship;
														shipCount = shipCount -1;
														break;
													}
											}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
												if(cord-30 < 0) {
													boardArray1[cord] = ship;
													boardArray1[cord+10] = ship;
													boardArray1[cord+20] = ship;
													shipCount = shipCount -1;
													break;
												}else if(cord+10 > 99 || cord+20 < 99) {
													boardArray1[cord+10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord-10] = ship;
													shipCount = shipCount -1;
													break;
												}else if(cord+20 > 99) {
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord-20] = ship;
													shipCount = shipCount -1;
													break;
												}else{
													boardArray1[cord-10] = ship;
													boardArray1[cord] = ship;
													boardArray1[cord+10] = ship;
													shipCount = shipCount -1;
													break;
												}
											}
											}
											
										}else if (place.equals(playerShips1[4])){
											playerShips1[4] = "            ";
											while(true) {
												System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
												facing = input.nextLine().toLowerCase();
												if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
												{ 	
														if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
																boardArray1[cord] = ship;
																boardArray1[cord+1] = ship;
																shipCount = shipCount -1;
																break;
														}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
																boardArray1[cord-1] = ship;
																boardArray1[cord] = ship;
																shipCount = shipCount -1;
																break;
														}else{
															boardArray1[cord] = ship;
															boardArray1[cord+1] = ship;
															shipCount = shipCount -1;
															break;
														}
												}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
													if(cord-30 < 0) {
														boardArray1[cord] = ship;
														boardArray1[cord+10] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+10 > 99 || cord+20 < 99) {
														boardArray1[cord] = ship;
														boardArray1[cord-10] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+10 > 99) {
														boardArray1[cord-10] = ship;
														boardArray1[cord] = ship;
														shipCount = shipCount -1;
														break;
													}else{
														boardArray1[cord] = ship;
														boardArray1[cord+10] = ship;
														shipCount = shipCount -1;
														break;
													}
												}
												}
											}else if(place.equals(playerShips1[3])){
												playerShips1[3] = "       ";
												while(true) {
												System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
												facing = input.nextLine().toLowerCase();
												if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
												{ 	
														if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
																boardArray1[cord] = ship;
																boardArray1[cord+1] = ship;
																boardArray1[cord+2] = ship;
																shipCount = shipCount -1;
																break;
														}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
																boardArray1[cord-1] = ship;
																boardArray1[cord] = ship;
																boardArray1[cord-2] = ship;
																shipCount = shipCount -1;
																break;
														}else{
															boardArray1[cord-1] = ship;
															boardArray1[cord] = ship;
															boardArray1[cord+1] = ship;
															shipCount = shipCount -1;
															break;
														}
												}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
													if(cord-30 < 0) {
														boardArray1[cord] = ship;
														boardArray1[cord+10] = ship;
														boardArray1[cord+20] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+10 > 99 || cord+20 < 99) {
														boardArray1[cord+10] = ship;
														boardArray1[cord] = ship;
														boardArray1[cord-10] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+20 > 99) {
														boardArray1[cord-10] = ship;
														boardArray1[cord] = ship;
														boardArray1[cord-20] = ship;
														shipCount = shipCount -1;
														break;
													}else{
														boardArray1[cord-10] = ship;
														boardArray1[cord] = ship;
														boardArray1[cord+10] = ship;
														shipCount = shipCount -1;
														break;
													}
												}
												}
											
											
										}else {
									System.out.println("Invalid placement");
								}
						
						if(shipCount == 0) {// This is tempary if its still in code when showing you remove this
							//TODO:
							//Clear all text on screen to clear ship placements
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							//Above. this is not good. if p2 scrolls up they can see all the
							//ship placements of p1.
							shipCount = 5; //Sets count back to 5 for p2 turn
							break;//Breaks the place test loop so you can place the next ship
						}
					}
				/*This code is for debugging purposes I use it as an array cheat sheet
					for(int y = 0; y < 10; y++) {//Sets Value of arrays
						System.out.print(y);//a
						System.out.print(" ");
						System.out.print(y+10);//b
						System.out.print(" ");
						System.out.print(y+20);//b
						System.out.print(" ");
						System.out.print(y+30);//b
						System.out.print(" ");
						System.out.print(y+40);//b
						System.out.print(" ");
						System.out.print(y+50);//b
						System.out.print(" ");
						System.out.print(y+60);//b
						System.out.print(" ");
						System.out.print(y+70);//b
						System.out.print(" ");
						System.out.print(y+80);//b
						System.out.print(" ");
						System.out.println(y+90);//b
					}*/ 
			
				//TODO:
				//Make player 2 placing ships
				System.out.println("Player2 Press ENTER to place ships");//Down here is basically a copy-paste of player1 but diffrent variables for palyer 2
				//This is so it waits for the player to ENTER so the nextline() stops waiting for the buffer.
				//it gives time for player1 to confirm that player 2 is not looking at the screen.
				input.nextLine();  
					while(true) {
						System.out.println("  1 2 3 4 5 6 7 8 9 0"); 
						for(int x = 0; x < 10; x++) {//Sets Value of arrays
							if(x == 0) { 
								letter = "A";
							} else if(x == 1) {//This needs to be redon with char's. I could convert int to char and use math.
								letter = "B";			//This is very bad.
							}else if(x == 2) {
								letter = "C";
							}else if(x == 3) {
								letter = "D";
							}else if(x == 4) {
								letter = "E";
							}else if(x == 5) {
								letter = "F";
							}else if(x == 6) {
								letter = "G";
							}else if(x == 7) {
								letter = "H";
							}else if(x == 8) {
								letter = "I";
							}else if(x == 9) {
								letter = "J";}
							System.out.print(letter +" "); //Prints the table
							System.out.print(boardArray2[x]);//a
							System.out.print(" ");
							System.out.print(boardArray2[x+10]);//b
							System.out.print(" ");
							System.out.print(boardArray2[x+20]);//c
							System.out.print(" ");
							System.out.print(boardArray2[x+30]);//d
							System.out.print(" ");
							System.out.print(boardArray2[x+40]);//e
							System.out.print(" ");
							System.out.print(boardArray2[x+50]);//f
							System.out.print(" ");
							System.out.print(boardArray2[x+60]);//g
							System.out.print(" ");
							System.out.print(boardArray2[x+70]);//h
							System.out.print(" ");
							System.out.print(boardArray2[x+80]);//i
							System.out.print(" ");
							System.out.println(boardArray2[x+90]);//j
						}
							//Player places Ship
							System.out.println("Please Select a coordinate to put your ship at for example A2");
							selector = input.nextLine().toLowerCase();
							num = selector;//sets num equil to selector
							num = num.substring(1, 2);//remove the letter form the varable
							//this value will be used below when placeing ships. it will have value added to it to make it
							//equil the array number on the board
							cord = 0;
							
							// System.out.println("Num " + num); //this is for debugging to show value of num.
							// The if and else if below is to convert num varable
							// TODO: 
							//convert Type String to type int and add it to cord
							if(num.equals("2")){
								cord += 10;
							}else if(num.equals("3")) {
								cord += 20;
							}else if(num.equals("4")) {
								cord += 30;
							}else if(num.equals("5")) {
								cord += 40;
							}else if(num.equals("6")) {
								cord += 50;
							}else if(num.equals("7")) {
								cord += 60;
							}else if(num.equals("8")) {
								cord += 70;
							}else if(num.equals("9")) {
								cord += 80;
							}else if(num.equals("0")) {
								cord += 90;
							}else {
								//System.out.println("Invalid input");
							}
							
							selector = selector.substring(0, 1);//removes the number from the variable 0 is start of index and 1 is end from were it starts and removes. 0 is the first String
			
							if(selector.equals("b")) {
								cord += 1;
							}else if(selector.equals("c")) {
								cord += 2;
							}else if(selector.equals("d")) {
								cord += 3;
							}else if(selector.equals("e")) {
								cord += 4;
							}else if(selector.equals("f")) {
	     				cord += 5;
							}else if(selector.equals("g")) {
								cord += 6;
							}else if(selector.equals("h")) {
								cord += 7;
							}else if(selector.equals("i")) {
								cord += 8;
							}else if(selector.equals("j")) {
								cord += 9;
							}
							
							//This check does not consider overlapping ships. 
							//I dont get overlapping ships often but still, this can cause problems.
							if(boardArray2[cord].equals("-")) {
								
								System.out.print("What ship would you like to place? you can pick.\n");
									for(int y = 0; y < playerShips2.length; y++) {
										System.out.println(playerShips2[y]);
								}
							}
									
							place = input.nextLine().toLowerCase(); //Selecting the Ship that will be places
							
							if(place.equals(playerShips2[0])) {//The whole way this selected what ship could be done more effectivly. I just dont know how ;(
										playerShips2[0] = "        ";
										while(true) {
										System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
										facing = input.nextLine().toLowerCase();//Placing ships, and making it so you cant place a ship out of bounds
											if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //Place ship 1 upright
											{//placeing ship 1	
												if(cord-1 == 9 && cord >= 10||cord-1 == 19 && cord >= 20||cord-1 == 29 && cord >= 30||cord-1 == 39 && cord >= 40||cord-1 == 49 && cord >= 50||cord-1 == 59 && cord >= 60||cord-1 == 69 && cord >= 70||cord-1 == 79 && cord >= 80||cord-1 == 89 && cord >= 90) {
													boardArray2[cord+3] = ship;
													boardArray2[cord] = ship;
													boardArray2[cord+1] = ship;
													boardArray2[cord+2] = ship;
													boardArray2[cord+4] = ship;
													shipCount = shipCount -1;
													break;
											}else if(cord-2 == 9 && cord >= 10||cord-2 == 19 && cord >= 20||cord-2 == 29 && cord >= 30||cord-2 == 39 && cord >= 40||cord-2 == 49 && cord >= 50||cord-2 == 59 && cord >= 60||cord-2 == 69 && cord >= 70||cord-2 == 79 && cord >= 80||cord-2 == 89 && cord >= 90) {
												boardArray2[cord+3] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord+4] = ship;
												boardArray2[cord+1] = ship;
												boardArray2[cord+2] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord-3 == 9 && cord >= 10||cord-3 == 19 && cord >= 20||cord-3 == 29 && cord >= 30||cord-3 == 39 && cord >= 40||cord-3 == 49 && cord >= 50||cord-3 == 59 && cord >= 60||cord-3 == 69 && cord >= 70||cord-3 == 79 && cord >= 80||cord-3 == 89 && cord >= 90) {
												boardArray2[cord+2] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord-1] = ship;
												boardArray2[cord-2] = ship;
												boardArray2[cord+1] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord-4 == 9 && cord >= 10||cord-4 == 19 && cord >= 20||cord-4 == 29 && cord >= 30||cord-4 == 39 && cord >= 40||cord-4 == 49 && cord >= 50||cord-4 == 59 && cord >= 60||cord-4 == 69 && cord >= 70||cord-4 == 79 && cord >= 80||cord-4 == 89 && cord >= 90) {
												boardArray2[cord-3] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord-1] = ship;
												boardArray2[cord-2] = ship;
												boardArray2[cord+1] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord-5 == 9 && cord >= 10||cord-5 == 19 && cord >= 20||cord-5 == 29 && cord >= 30||cord-5 == 39 && cord >= 40||cord-5 == 49 && cord >= 50||cord-5 == 59 && cord >= 60||cord-5 == 69 && cord >= 70||cord-5 == 79 && cord >= 80||cord-5 == 89 && cord >= 90) {
												boardArray2[cord-3] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord-1] = ship;
												boardArray2[cord-2] = ship;
												boardArray2[cord-4] = ship;
												shipCount = shipCount -1;
												break;	
											}else if(cord+1 >= 11 && cord <= 9||cord+1 >= 21 && cord <= 19||cord+1 >= 31 && cord <= 29||cord+1 >= 41 && cord <= 39||cord+1 >= 51 && cord <= 49||cord+1 >= 61 && cord <= 69||cord+1 >= 71 && cord <= 79||cord+1 >= 81 && cord <= 89||cord+1 >= 91 && cord <= 99) {
													boardArray2[cord-1] = ship;
													boardArray2[cord] = ship;
													boardArray2[cord-2] = ship;
													boardArray2[cord-3] = ship;	
													boardArray2[cord-4] = ship;	
													shipCount = shipCount -1;
													break;
											}else if(cord+1 >= 11 && cord <= 9||cord+1 >= 21 && cord <= 19||cord+1 >= 31 && cord <= 29||cord+1 >= 41 && cord <= 39||cord+1 >= 51 && cord <= 49||cord+1 >= 61 && cord <= 69||cord+1 >= 71 && cord <= 79||cord+1 >= 81 && cord <= 89||cord+1 >= 91 && cord <= 99) {
												boardArray2[cord-1] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord-2] = ship;
												boardArray2[cord-3] = ship;	
												boardArray2[cord-4] = ship;	
												shipCount = shipCount -1;
												break;
											}else if(cord+2 >= 11 && cord <= 9||cord+2 >= 21 && cord <= 19||cord+2 >= 31 && cord <= 29||cord+2 >= 41 && cord <= 39||cord+2 >= 51 && cord <= 49||cord+2 >= 61 && cord <= 69||cord+2 >= 71 && cord <= 79||cord+2 >= 81 && cord <= 89||cord+2 >= 91 && cord <= 99) {
												boardArray2[cord+1] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord-1] = ship;
												boardArray2[cord-2] = ship;	
												boardArray2[cord-3] = ship;	
												shipCount = shipCount -1;
												break;
											}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
												boardArray2[cord+1] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord-1] = ship;
												boardArray2[cord+2] = ship;	
												boardArray2[cord-2] = ship;	
												shipCount = shipCount -1;
												break;// THis is very ineffetive too bad.
											}else if(cord+4 >= 11 && cord <= 9||cord+4 >= 21 && cord <= 19||cord+4 >= 31 && cord <= 29||cord+4 >= 41 && cord <= 39||cord+4 >= 51 && cord <= 49||cord+4 >= 61 && cord <= 69||cord+4 >= 71 && cord <= 79||cord+4 >= 81 && cord <= 89||cord+4 >= 91 && cord <= 99) {
												boardArray2[cord+1] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord+2] = ship;
												boardArray2[cord+3] = ship;	
												boardArray2[cord+4] = ship;	
												shipCount = shipCount -1;
												break;
											}else if(cord+5 >= 11 && cord <= 9||cord+5 >= 21 && cord <= 19||cord+5 >= 31 && cord <= 29||cord+5 >= 41 && cord <= 39||cord+5 >= 51 && cord <= 49||cord+5 >= 61 && cord <= 69||cord+5 >= 71 && cord <= 79||cord+5 >= 81 && cord <= 89||cord+5 >= 91 && cord <= 99) {
												boardArray2[cord+1] = ship;
												boardArray2[cord] = ship;
												boardArray2[cord+2] = ship;
												boardArray2[cord+3] = ship;	
												boardArray2[cord+4] = ship;	
												shipCount = shipCount -1;
												break;
											}else{
													boardArray2[cord-1] = ship;
													boardArray2[cord-2] = ship;
													boardArray2[cord] = ship;
													boardArray2[cord+1] = ship;
													boardArray2[cord+2] = ship;
													shipCount = shipCount -1;
													break;
													
											}
											}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways"))//Place ship 2 sideways
											{
												if(cord-10 < 0) {
														boardArray2[cord+30] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord+10] = ship;
														boardArray2[cord+20] = ship;
														boardArray2[cord+40] = ship;
														shipCount = shipCount -1;
														break;
														
												}else if(cord+10 >= 100 || cord+20 < 99) {
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord+20] = ship;
														boardArray2[cord+10] = ship;
														boardArray2[cord+30] = ship;
														shipCount = shipCount -1;
														break;
														
												}else if(cord+20 > 99) {
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord-20] = ship;
														boardArray2[cord-30] = ship;
														boardArray2[cord-40] = ship;
														shipCount = shipCount -1;
														break;
														
												}else{
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord+20] = ship;
														boardArray2[cord+10] = ship;
														boardArray2[cord-20] = ship;
														shipCount = shipCount -1;
														break;
														
												}
												}else{
														System.out.println("Invalid position");
											
												}
											break;
											}
											}else if(place.equals(playerShips2[1])) {//placing ship 2
										playerShips2[1] = "       ";
										while(true) {
											System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
											facing = input.nextLine().toLowerCase();
											if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 2 upright
											{ 	
													if(cord-5 <= 9 && cord >= 10||cord-5 <= 19 && cord >= 20||cord-5 <= 29 && cord >= 30||cord-5 <= 39 && cord >= 												40||cord-5 <= 49 && cord >= 50||cord-5 <= 59 && cord >= 60||cord-5 <= 69 && cord >= 70||cord-5 <= 79 && cord 												>= 80||cord-5 <= 89 && cord >= 90) {
															boardArray2[cord] = ship;
															boardArray2[cord+1] = ship;
															boardArray2[cord+2] = ship;
															boardArray2[cord+3] = ship;
															boardArray2[cord+4] = ship;
															boardArray2[cord+5] = ship;
															shipCount = shipCount -1;
															break;
													}else if(cord+5 >= 11 && cord <= 9||cord+5 >= 21 && cord <= 19||cord+5 >= 31 && cord <= 29||cord+5 >= 41 && 													cord <= 39||cord+5 >= 51 && cord <= 49||cord+5 >= 61 && cord <= 69||cord+5 >= 71 && cord <= 79||cord+5 >= 													81 && cord <= 89||cord+5 >= 91 && cord <= 99) {
															boardArray2[cord-1] = ship;
															boardArray2[cord] = ship;
															boardArray2[cord-2] = ship;
															boardArray2[cord-3] = ship;
															boardArray2[cord-4] = ship;
															boardArray2[cord-5] = ship;
															shipCount = shipCount -1;
															break;
													}else{
														boardArray2[cord+5] = ship;
														boardArray2[cord+4] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord+1] = ship;
														boardArray2[cord+2] = ship;
														boardArray2[cord+3] = ship;
														shipCount = shipCount -1;
														break;
													}
											}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
												if(cord-30 < 0) {//This whole statement needs to be re-written it is very ineffective at pushing back ships.
													boardArray2[cord] = ship;
													boardArray2[cord+10] = ship;
													boardArray2[cord+20] = ship;
													boardArray2[cord+30] = ship;
													boardArray2[cord+40] = ship;
													boardArray2[cord+50] = ship;
													shipCount = shipCount -1;
													break;
												}else if(cord+10 > 99 || cord+20 < 99) {
													boardArray2[cord+10] = ship;
													boardArray2[cord] = ship;
													boardArray2[cord-10] = ship;
													boardArray2[cord-20] = ship;
													boardArray2[cord-30] = ship;
													boardArray2[cord-40] = ship;
													shipCount = shipCount -1;
													break;
												}else if(cord+50 > 99) {
													boardArray2[cord-10] = ship;
													boardArray2[cord] = ship;
													boardArray2[cord-20] = ship;
													boardArray2[cord-30] = ship;
													boardArray2[cord-40] = ship;
													boardArray2[cord-50] = ship;
													shipCount = shipCount -1;
													break;
												}else{
													boardArray2[cord-20] = ship;
													boardArray2[cord-10] = ship;
													boardArray2[cord] = ship;
													boardArray2[cord+20] = ship;
													boardArray2[cord+30] = ship;
													boardArray2[cord+40] = ship;
													shipCount = shipCount -1;
													break;
												}
											}else{
												System.out.println("Invalid position");
												
											}
											}
										}else if(place.equals(boardArray2[2])||place.equals("destroyer")) {
												playerShips2[2] = "       ";
												while(true) {
												System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
												facing = input.nextLine().toLowerCase();
												if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
												{ 	
														if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
																boardArray2[cord] = ship;
																boardArray2[cord+1] = ship;
																boardArray2[cord+2] = ship;
																shipCount = shipCount -1;
																break;
														}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
																boardArray2[cord-1] = ship;
																boardArray2[cord] = ship;
																boardArray2[cord-2] = ship;
																shipCount = shipCount -1;
																break;
														}else{
															boardArray2[cord-1] = ship;
															boardArray2[cord] = ship;
															boardArray2[cord+1] = ship;
															shipCount = shipCount -1;
															break;
														}
												}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
													if(cord-30 < 0) {
														boardArray2[cord] = ship;
														boardArray2[cord+10] = ship;
														boardArray2[cord+20] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+10 > 99 || cord+20 < 99) {
														boardArray2[cord+10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord-10] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+20 > 99) {
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord-20] = ship;
														shipCount = shipCount -1;
														break;
													}else{
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord+10] = ship;
														shipCount = shipCount -1;
														break;
													}
												}
												}
											}else if(place.equals(playerShips2[3])){
												playerShips2[3] = "       ";
												while(true) {
												System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
												facing = input.nextLine().toLowerCase();
												if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
												{ 	
														if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
																boardArray2[cord] = ship;
																boardArray2[cord+1] = ship;
																boardArray2[cord+2] = ship;
																shipCount = shipCount -1;
																break;
														}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
																boardArray2[cord-1] = ship;
																boardArray2[cord] = ship;
																boardArray2[cord-2] = ship;
																shipCount = shipCount -1;
																break;
														}else{
															boardArray2[cord-1] = ship;
															boardArray2[cord] = ship;
															boardArray2[cord+1] = ship;
															shipCount = shipCount -1;
															break;
														}
												}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
													if(cord-30 < 0) {
														boardArray2[cord] = ship;
														boardArray2[cord+10] = ship;
														boardArray2[cord+20] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+10 > 99 || cord+20 < 99) {
														boardArray2[cord+10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord-10] = ship;
														shipCount = shipCount -1;
														break;
													}else if(cord+20 > 99) {
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord-20] = ship;
														shipCount = shipCount -1;
														break;
													}else{
														boardArray2[cord-10] = ship;
														boardArray2[cord] = ship;
														boardArray2[cord+10] = ship;
														shipCount = shipCount -1;
														break;
													}
												}
												}
												
											}else if (place.equals(playerShips2[4])){
												playerShips2[4] = "            ";
												while(true) {
													System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
													facing = input.nextLine().toLowerCase();
													if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
													{ 	
															if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
																	boardArray2[cord] = ship;
																	boardArray2[cord+1] = ship;
																	shipCount = shipCount -1;
																	break;
															}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
																	boardArray2[cord-1] = ship;
																	boardArray2[cord] = ship;
																	shipCount = shipCount -1;
																	break;
															}else{
																boardArray2[cord] = ship;
																boardArray2[cord+1] = ship;
																shipCount = shipCount -1;
																break;
															}
													}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
														if(cord-30 < 0) {
															boardArray2[cord] = ship;
															boardArray2[cord+10] = ship;
															shipCount = shipCount -1;
															break;
														}else if(cord+10 > 99 || cord+20 < 99) {
															boardArray2[cord] = ship;
															boardArray2[cord-10] = ship;
															shipCount = shipCount -1;
															break;
														}else if(cord+10 > 99) {
															boardArray2[cord-10] = ship;
															boardArray2[cord] = ship;
															shipCount = shipCount -1;
															break;
														}else{
															boardArray2[cord] = ship;
															boardArray2[cord+10] = ship;
															shipCount = shipCount -1;
															break;
														}
													}
													}
												}else if(place.equals(playerShips2[3])){
													playerShips2[3] = "       ";
													while(true) {
													System.out.println("How would you like to place the ship?\n1. Upright\n2. Sideways");
													facing = input.nextLine().toLowerCase();
													if(facing.equals("1")||facing.equals("upright") || facing.equals("1. upright")) //placing ship 3 upright
													{ 	
															if(cord-2 <= 9 && cord >= 10||cord-2 <= 19 && cord >= 20||cord-2 <= 29 && cord >= 30||cord-2 <= 39 && cord 													>= 40||cord-2 <= 49 && cord >= 50||cord-2 <= 59 && cord >= 60||cord-2 <= 69 && cord >= 70||cord-2 <= 79 && 													cord >= 80||cord-2 <= 89 && cord >= 90) {
																	boardArray2[cord] = ship;
																	boardArray2[cord+1] = ship;
																	boardArray2[cord+2] = ship;
																	shipCount = shipCount -1;
																	break;
															}else if(cord+3 >= 11 && cord <= 9||cord+3 >= 21 && cord <= 19||cord+3 >= 31 && cord <= 29||cord+3 >= 41 && 													cord <= 39||cord+3 >= 51 && cord <= 49||cord+3 >= 61 && cord <= 69||cord+3 >= 71 && cord <= 79||cord+3 >= 													81 && cord <= 89||cord+3 >= 91 && cord <= 99) {
																	boardArray2[cord-1] = ship;
																	boardArray2[cord] = ship;
																	boardArray2[cord-2] = ship;
																	shipCount = shipCount -1;
																	break;
															}else{
																boardArray2[cord-1] = ship;
																boardArray2[cord] = ship;
																boardArray2[cord+1] = ship;
																shipCount = shipCount -1;
																break;
															}
													}else if(facing.equals("2")||facing.equals("sideways") || facing.equals("2. sideways")){
														if(cord-30 < 0) {
															boardArray2[cord] = ship;
															boardArray2[cord+10] = ship;
															boardArray2[cord+20] = ship;
															shipCount = shipCount -1;
															break;
														}else if(cord+10 > 99 || cord+20 < 99) {
															boardArray2[cord+10] = ship;
															boardArray2[cord] = ship;
															boardArray2[cord-10] = ship;
															shipCount = shipCount -1;
															break;
														}else if(cord+20 > 99) {
															boardArray2[cord-10] = ship;
															boardArray2[cord] = ship;
															boardArray2[cord-20] = ship;
															shipCount = shipCount -1;
															break;
														}else{
															boardArray2[cord-10] = ship;
															boardArray2[cord] = ship;
															boardArray2[cord+10] = ship;
															shipCount = shipCount -1;
															break;
														}
													}
													}
											}else {
												System.out.println("Invalid position");
											} 
							
							if(shipCount == 0) {// This is tempary if its still in code when showing you remove this
								//TODO:
								//Clear all text on screen to clear ship placements
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								//If the player scrolls up enough the system.out.print above statement is basically useless. 
								//this need to be fixed.
								//need to find out how to clear all text
								break;
							}
				}//SETUP has been finished. this is going to take awhile.
					while(true) {
					System.out.println("Player1 Press ENTER to start your turn");//Freezes program until player1 presses enter
					input.nextLine();//Kinda loosing track on all the inputs. hoping there isnt a int above or else this could fall apart
					//I mostly used strings so it should be fine
					/*TODO:
					  1) Print player1's Attack and ship boards
						2) Ask Player1 for cord to fire at
						3) Check charater at that cord.
						4) make an if-else statement seeing if it hit
						5) if it hit change ship string to hit string and print out to player
						1 that they hit and update there hit board. if it was a miss change player1 
						hit board to show a miss
						6)check to see if there are any other ship string's on player2's board
						if there is continue the game. if not announce that player 1 hit.
						7) clear the screen and tell player 2 to press enter to do there turn.
						8) Loop back though steps but swap player 1 and 2 positions.
						9) continue until one player has no ship char's
					*/
					
					// 1) Print player1's Attack and ship boards
					System.out.println("===Attack_BOARD===");
					System.out.println("  1 2 3 4 5 6 7 8 9 0"); 
					for(int x = 0; x < 10; x++) {//Sets Value of arrays
						if(x == 0) { 
							letter = "A";
						} else if(x == 1) {//This needs to be redon with char's. I could convert int to char and use math.
							letter = "B";			//This is very bad.
						}else if(x == 2) {
							letter = "C";
						}else if(x == 3) {
							letter = "D";
						}else if(x == 4) {
							letter = "E";
						}else if(x == 5) {
							letter = "F";
						}else if(x == 6) {
							letter = "G";
						}else if(x == 7) {
							letter = "H";
						}else if(x == 8) {
							letter = "I";
						}else if(x == 9) {
							letter = "J";}
						System.out.print(letter +" "); //Prints the table
						System.out.print(boardAttack1[x]);//a
						System.out.print(" ");
						System.out.print(boardAttack1[x+10]);//b
						System.out.print(" ");
						System.out.print(boardAttack1[x+20]);//c
						System.out.print(" ");
						System.out.print(boardAttack1[x+30]);//d
						System.out.print(" ");
						System.out.print(boardAttack1[x+40]);//e
						System.out.print(" ");
						System.out.print(boardAttack1[x+50]);//f
						System.out.print(" ");
						System.out.print(boardAttack1[x+60]);//g
						System.out.print(" ");
						System.out.print(boardAttack1[x+70]);//h
						System.out.print(" ");
						System.out.print(boardAttack1[x+80]);//i
						System.out.print(" ");
						System.out.println(boardAttack1[x+90]);//j
					}
					
					System.out.println("=====SHIP_BOARD=====");
					System.out.println("  1 2 3 4 5 6 7 8 9 0"); 
					for(int x = 0; x < 10; x++) {//Sets Value of arrays
						if(x == 0) { 
							letter = "A";
						} else if(x == 1) {//This needs to be redon with char's. I could convert int to char and use math.
							letter = "B";			//This is very bad.
						}else if(x == 2) {
							letter = "C";
						}else if(x == 3) {
							letter = "D";
						}else if(x == 4) {
							letter = "E";
						}else if(x == 5) {
							letter = "F";
						}else if(x == 6) {
							letter = "G";
						}else if(x == 7) {
							letter = "H";
						}else if(x == 8) {
							letter = "I";
						}else if(x == 9) {
							letter = "J";}
						System.out.print(letter +" "); //Prints the table
						System.out.print(boardArray1[x]);//a
						System.out.print(" ");
						System.out.print(boardArray1[x+10]);//b
						System.out.print(" ");
						System.out.print(boardArray1[x+20]);//c
						System.out.print(" ");
						System.out.print(boardArray1[x+30]);//d
						System.out.print(" ");
						System.out.print(boardArray1[x+40]);//e
						System.out.print(" ");
						System.out.print(boardArray1[x+50]);//f
						System.out.print(" ");
						System.out.print(boardArray1[x+60]);//g
						System.out.print(" ");
						System.out.print(boardArray1[x+70]);//h
						System.out.print(" ");
						System.out.print(boardArray1[x+80]);//i
						System.out.print(" ");
						System.out.println(boardArray1[x+90]);//j
					}
					while(true) {
					//2) Ask Player1 for cord to fire at
					System.out.println("Please Select a coordinate to fire at for example A2");
					selector = input.nextLine().toLowerCase();
					num = selector;//sets num equil to selector
					num = num.substring(1, 2);//remove the letter form the varable
					//this value will be used below when placeing ships. it will have value added to it to make it
					//equil the array number on the board
					cord = 0;
					
					// System.out.println("Num " + num); //this is for debugging to show value of num.
					// The if and else if below is to convert num varable
					// TODO: 
					//convert Type String to type int and add it to cord
					if(num.equals("2")){
						cord += 10;
					}else if(num.equals("3")) {
						cord += 20;
					}else if(num.equals("4")) {
						cord += 30;
					}else if(num.equals("5")) {
						cord += 40;
					}else if(num.equals("6")) {
						cord += 50;
					}else if(num.equals("7")) {
						cord += 60;
					}else if(num.equals("8")) {
						cord += 70;
					}else if(num.equals("9")) {
						cord += 80;
					}else if(num.equals("0")) {
						cord += 90;
					}else {
						System.out.println("Invalid input");
					}
					
					selector = selector.substring(0, 1);//removes the number from the variable 0 is start of index and 1 is end from were it starts and removes. 0 is the first String
	
					if(selector.equals("b")) {
						cord += 1;
					}else if(selector.equals("c")) {
						cord += 2;
					}else if(selector.equals("d")) {
						cord += 3;
					}else if(selector.equals("e")) {
						cord += 4;
					}else if(selector.equals("f")) {
   				cord += 5;
					}else if(selector.equals("g")) {
						cord += 6;
					}else if(selector.equals("h")) {
						cord += 7;
					}else if(selector.equals("i")) {
						cord += 8;
					}else if(selector.equals("j")) {
						cord += 9;
					}
					
					if(boardArray2[cord].equals("-")) {
						System.out.println("You Fired and it was a miss");
						boardAttack1[cord] = miss;
						System.out.println("Press Enter and hand laptop to player 2");
						input.nextLine();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}else if(boardArray2[cord].equals(ship)) {
						System.out.println("You Fired and it was a hit");
						boardAttack1[cord] = hit;
						boardArray2[cord] = hit;
						System.out.println("Press Enter and hand laptop to player 2");
						input.nextLine();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}else {
						System.out.println("You already fired here\nFire Again");
					}
					}
					
					System.out.println("Player2 Press ENTER to start your turn");//Freezes program until player1 presses enter
					input.nextLine();//Kinda loosing track on all the inputs. hoping there isnt a int above or else this could fall apart
					//I mostly used strings so it should be fine
					/*TODO:
					  1) Print player1's Attack and ship boards
						2) Ask Player1 for cord to fire at
						3) Check charater at that cord.
						4) make an if-else statement seeing if it hit
						5) if it hit change ship string to hit string and print out to player
						1 that they hit and update there hit board. if it was a miss change player1 
						hit board to show a miss
						6)check to see if there are any other ship string's on player2's board
						if there is continue the game. if not announce that player 1 hit.
						7) clear the screen and tell player 2 to press enter to do there turn.
						8) Loop back though steps but swap player 1 and 2 positions.
						9) continue until one player has no ship char's
					*/
					
					// 1) Print player1's Attack and ship boards
					System.out.println("===Attack_BOARD===");
					System.out.println("  1 2 3 4 5 6 7 8 9 0"); 
					for(int x = 0; x < 10; x++) {//Sets Value of arrays
						if(x == 0) { 
							letter = "A";
						} else if(x == 1) {//This needs to be redon with char's. I could convert int to char and use math.
							letter = "B";			//This is very bad.
						}else if(x == 2) {
							letter = "C";
						}else if(x == 3) {
							letter = "D";
						}else if(x == 4) {
							letter = "E";
						}else if(x == 5) {
							letter = "F";
						}else if(x == 6) {
							letter = "G";
						}else if(x == 7) {
							letter = "H";
						}else if(x == 8) {
							letter = "I";
						}else if(x == 9) {
							letter = "J";}
						System.out.print(letter +" "); //Prints the table
						System.out.print(boardAttack2[x]);//a
						System.out.print(" ");
						System.out.print(boardAttack2[x+10]);//b
						System.out.print(" ");
						System.out.print(boardAttack2[x+20]);//c
						System.out.print(" ");
						System.out.print(boardAttack2[x+30]);//d
						System.out.print(" ");
						System.out.print(boardAttack2[x+40]);//e
						System.out.print(" ");
						System.out.print(boardAttack2[x+50]);//f
						System.out.print(" ");
						System.out.print(boardAttack2[x+60]);//g
						System.out.print(" ");
						System.out.print(boardAttack2[x+70]);//h
						System.out.print(" ");
						System.out.print(boardAttack2[x+80]);//i
						System.out.print(" ");
						System.out.println(boardAttack2[x+90]);//j
					}
					
					System.out.println("=====SHIP_BOARD=====");
					System.out.println("  1 2 3 4 5 6 7 8 9 0"); 
					for(int x = 0; x < 10; x++) {//Sets Value of arrays
						if(x == 0) { 
							letter = "A";
						} else if(x == 1) {//This needs to be redon with char's. I could convert int to char and use math.
							letter = "B";			//This is very bad.
						}else if(x == 2) {
							letter = "C";
						}else if(x == 3) {
							letter = "D";
						}else if(x == 4) {
							letter = "E";
						}else if(x == 5) {
							letter = "F";
						}else if(x == 6) {
							letter = "G";
						}else if(x == 7) {
							letter = "H";
						}else if(x == 8) {
							letter = "I";
						}else if(x == 9) {
							letter = "J";}
						System.out.print(letter +" "); //Prints the table
						System.out.print(boardArray2[x]);//a
						System.out.print(" ");
						System.out.print(boardArray2[x+10]);//b
						System.out.print(" ");
						System.out.print(boardArray2[x+20]);//c
						System.out.print(" ");
						System.out.print(boardArray2[x+30]);//d
						System.out.print(" ");
						System.out.print(boardArray2[x+40]);//e
						System.out.print(" ");
						System.out.print(boardArray2[x+50]);//f
						System.out.print(" ");
						System.out.print(boardArray2[x+60]);//g
						System.out.print(" ");
						System.out.print(boardArray2[x+70]);//h
						System.out.print(" ");
						System.out.print(boardArray2[x+80]);//i
						System.out.print(" ");
						System.out.println(boardArray2[x+90]);//j
					}
					while(true) {
					//2) Ask Player1 for cord to fire at
					System.out.println("Please Select a coordinate to fire at for example A2");
					selector = input.nextLine().toLowerCase();
					num = selector;//sets num equil to selector
					num = num.substring(1, 2);//remove the letter form the varable
					//this value will be used below when placeing ships. it will have value added to it to make it
					//equil the array number on the board
					cord = 0;
					
					// System.out.println("Num " + num); //this is for debugging to show value of num.
					// The if and else if below is to convert num varable
					// TODO: 
					//convert Type String to type int and add it to cord
					if(num.equals("2")){
						cord += 10;
					}else if(num.equals("3")) {
						cord += 20;
					}else if(num.equals("4")) {
						cord += 30;
					}else if(num.equals("5")) {
						cord += 40;
					}else if(num.equals("6")) {
						cord += 50;
					}else if(num.equals("7")) {
						cord += 60;
					}else if(num.equals("8")) {
						cord += 70;
					}else if(num.equals("9")) {
						cord += 80;
					}else if(num.equals("0")) {
						cord += 90;
					}else {
						System.out.println("Invalid input");
					}
					
					selector = selector.substring(0, 1);//removes the number from the variable 0 is start of index and 1 is end from were it starts and removes. 0 is the first String
	
					if(selector.equals("b")) {
						cord += 1;
					}else if(selector.equals("c")) {
						cord += 2;
					}else if(selector.equals("d")) {
						cord += 3;
					}else if(selector.equals("e")) {
						cord += 4;
					}else if(selector.equals("f")) {
   				cord += 5;
					}else if(selector.equals("g")) {
						cord += 6;
					}else if(selector.equals("h")) {
						cord += 7;
					}else if(selector.equals("i")) {
						cord += 8;
					}else if(selector.equals("j")) {
						cord += 9;
					}
					
					if(boardArray1[cord].equals("-")) {
						System.out.println("You Fired and it was a miss");
						boardAttack2[cord] = miss;
						System.out.println("Press Enter and hand laptop to player 1");
						input.nextLine();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}else if(boardArray1[cord].equals(ship)) {
						System.out.println("You Fired and it was a Hit");
						boardAttack2[cord] = hit;
						boardArray1[cord] = hit;
						System.out.println("Press Enter and hand laptop to player 1");
						input.nextLine();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}else {
						System.out.println("You already fired here\nFire Again");
					}
					}
					Player1lost = true;
					for (int x = 0; x < boardArray1.length; x++) {
						if(boardArray1[x].equals(ship)){
							Player1lost = false;
						}
					}
					
					if(Player1lost == true) {
						System.out.println("Player 2 Wins");
						System.out.println("Press ENTER to go back to main menu");
						input.nextLine();
						break;
					}
					
					Player2lost = true;
					for (int x = 0; x < boardArray2.length; x++) {
						if(boardArray2[x].equals(ship)){
							Player2lost = false;
						}
					}
					
					if(Player2lost == true) {
						System.out.println("Player 1 Wins");
						System.out.println("Press ENTER to go back to main menu");
						input.nextLine();
						break;
					}
					}
			}
}//end class
