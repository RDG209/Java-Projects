package myProjects;
import java.util.*;

public class TicTacToe {
	
	static ArrayList<Integer> playerPosList = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
		
		char[] players = {'X', 'O'};
		
		
		
		Scanner scnr = new Scanner(System.in);
		
		Random rand = new Random();
		int coinFlip = rand.nextInt(1);
		
		System.out.println("Flippling a coin for who begins, player 1 is X and cpu is O");
		System.out.println("X is up first!");
		
		while (true) {
			
			System.out.print("Enter where you'd like to place a piece (1-9) : ");
			int pos = scnr.nextInt();
			
			
			while(playerPosList.contains(pos) || cpuPosList.contains(pos)) {
				System.out.println("Position Taken! Enter a correct Position!");
				pos = scnr.nextInt();
			}
			
			placePiece(gameBoard, pos, "player");
			String result = checkWin();
			if (result.length() > 0) {
				System.out.println(result);
				printGameBoard(gameBoard);
				break;
			}
			
			int cpuPos = rand.nextInt(9)+1;
			
			while(playerPosList.contains(cpuPos) || cpuPosList.contains(cpuPos)) {
				System.out.println("Position Taken! Ai trying again!");
				cpuPos = rand.nextInt(9)+1;
			}
			
			placePiece(gameBoard, cpuPos, "cpu");
			
			printGameBoard(gameBoard);
			
			result = checkWin();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
		
		}
		
		
	}
	
	public static String checkWin() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winCons = new ArrayList<List>();
		
		winCons.add(topRow);
		winCons.add(midRow);
		winCons.add(botRow);
		winCons.add(leftCol);
		winCons.add(midCol);
		winCons.add(rightCol);
		winCons.add(cross1);
		winCons.add(cross2);
		
		for (List l : winCons) {
			if (playerPosList.containsAll(l)) {
				return ("You WON!!!");
			} else if (cpuPosList.containsAll(l)) {
				return ("CPU WIN! Unlucky :(");
			} else if (playerPosList.size() + cpuPosList.size() == 9) {
				return ("Draw, board full");
			}
		}
		
		return"";
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPosList.add(pos);
		} else if(user.equals("cpu")) {
			symbol = '0';
			cpuPosList.add(pos);
		}
		
		
		
		switch(pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
			
		case 2:
			gameBoard[0][2] = symbol;
			break;
			
		case 3:
			gameBoard[0][4] = symbol;
			break;
			
		case 4:
			gameBoard[2][0] = symbol;
			break;
			
		case 5:
			gameBoard[2][2] = symbol;
			break;
			
		case 6:
			gameBoard[2][4] = symbol;
			break;
			
		case 7:
			gameBoard[4][0] = symbol;
			break;
			
		case 8:
			gameBoard[4][2] = symbol;
			break;
			
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		
		}
		
		
	}


}
