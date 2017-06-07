package tictactoe;

import java.util.Scanner;

public class TicTacToe {
	
		//global variable so it can be seen everywhere
		static int counter = 0;
		
		//everything can see that there is a 3 by 3 table
		static char[][]table = new char[3][3];
		
		public static void main(String[] args){

			Scanner scan = new Scanner(System.in);
			int row, column;
			boolean var;

			//initialize all values
			int games = 0;
			int p1win = 0;
			int p2win = 0;
			boolean NewGame = true;
			String player;
			boolean decision;
			char EndGame;
			boolean winner;
			int move;

			System.out.print("What is the name of player 1(O)? ");
			String Player1 = scan.next();
			System.out.print("What is the name of player 2(X)? ");
			String Player2 = scan.next();

				do{
					move = 0;
					games = games+1;
					do{
						winner = false;
						displayTable();
						if(counter%2==0){
							System.out.print("Player " + Player1 + ": ");}
						if(counter%2==1){
							System.out.print("Player " + Player2 + ": ");}

						row = scan.nextInt();
						column = scan.nextInt();
						var = move(row,column);

						if(checkWinner()==true){
							if(counter%2==0){
								p1win = p1win + 1;
								displayTable();
								System.out.println(Player1 + " won the game!");
								winner = true;}

							else{
								p2win = p2win + 1;
								displayTable();
								System.out.println(Player2 + " won the game!");
								winner = true;}
						}

						if(var==true){
							counter++;
							move++;}
						if(move==9){
							displayTable();
							System.out.println("Tie Game!");}

					}while(winner == false && move<9);
						System.out.print("Would you like to play another game (y/n)? ");
						EndGame = scan.next().charAt(0);
						if(EndGame == 'y' || EndGame =='Y'){
							decision = true;
							clearTable();}
						else{
							decision = false;}
				}while(decision==true);

					//display results
					System.out.println("\n" + "Statistics");
					System.out.println(Player1 + "\t" + p1win + "/" + games);
					System.out.println(Player2 + "\t" + p2win + "/" + games);
					System.out.println("Auf Wiedersehen!");

	}//end main


		//create 3x3 table
		//no return, thus void
		public static void displayTable(){

			//figure out how table will display
			System.out.println("   0  1  2");//print column numbers
			for(int i=0; i<3; i++){
				System.out.print(i + " "); //print row numbers
				for(int j=0; j<3; j++){
					System.out.print("[" + table[i][j] + "]");
				}//end second for loop
					System.out.println();//go down a line after each inner loop
			}//end first for loop

		}//end displayTable

		public static boolean move(int row, int column){
			boolean ryan = true;

			if((table[row][column]=='X')||(table[row][column]=='O')){
				System.out.println("This is an invalid move");
				return false;}
			else{
				if(counter%2==0){
					table[row][column]='O';}
				else{
					table[row][column]='X';}
			}
			return true;
		}//end move()

		public static void clearTable(){
			for(int i=0; i<3; i++){//initialize array
				for(int j=0; j<3; j++){
					table[i][j] = ' ';//assigns blank space to array items
				}//end inner for loop
			}//end outer for loop
		}//end clearTable

		public static boolean checkRow(int row){

			if((table[row][0] & table[row][1] & table[row][2]) == 'X'){
				return true;}
			if((table[row][0] & table[row][1] & table[row][2]) == 'O'){
				return true;}
			return false;
		}//end checkRow()

		public static boolean checkColumn(int column){

			if((table[0][column] & table[1][column] & table[2][column]) == 'X'){
				return true;}
			if((table[0][column] & table[1][column] & table[2][column]) == 'O'){
				return true;}
			return false;
		}//end checkColumn()

		public static boolean checkDiagonal(){

			if((table[0][0] & table[1][1] & table[2][2])=='X'){
				return true;}
			if((table[0][0] & table[1][1] & table[2][2])=='O'){
				return true;}
			if((table[2][0] & table[1][1] & table[0][2])=='X'){
				return true;}
			if((table[2][0] & table[1][1] & table[0][2])=='O'){
				return true;}
			return false;
		}//end checkDiagonal()

		public static boolean checkWinner(){

			for(int i=0;i<3;i++){
				if(checkColumn(i)==true ||checkRow(i)==true){
					return true;
				}
			}
			if(checkDiagonal()==true){
				return true;
			}
			return false;
		}//end checkWinner()
	}//end class
