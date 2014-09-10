package com.iboobel.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TicTac {	
	private static final int FIELD_LENGTH = 3;
	private static final char TIC = 'X';
	private static final char TAC = 'O';
	private static final char EMPTY_CELL = ' ';
	
	private String won = "";		
	
	private char[][] field = new char[FIELD_LENGTH][FIELD_LENGTH];	
	
	public TicTac(){
		for (int i=0; i < FIELD_LENGTH; i++){
			eraseLine(i);			
		}
	}
	
	public void showField(){
		
		try {
			Runtime.getRuntime().exec("cls");
		} catch ( final Exception e ) {
			
			
		} 
		
		
		
		System.out.println(field[0][0]+" | "+field[0][1]+" | "+field[0][2]);		
		System.out.println("---------");
		System.out.println(field[1][0]+" | "+field[1][1]+" | "+field[1][2]);
		System.out.println("---------");
		System.out.println(field[2][0]+" | "+field[2][1]+" | "+field[2][2]);
		
		System.out.println("---------------------------------------------");
	}
	
	public int setElement(int x, int y, int ticTac){		
		// ticTac = 1 - X; 0 - O;
		int flag = 0; 
		
		if (field[y][x] == EMPTY_CELL) {			
			if (ticTac == 1) {
				field[y][x] = TIC;
			} else {
				field[y][x] = TAC;
			}
			flag = 1;
		} else {
			System.out.println("There is some obj !"+y+" >>> "+x);			
		}					
		
		return flag;
	}
		
	public void eraseLine(int lineNumber) {

		for (int i=0; i < FIELD_LENGTH; i++){
			field[i][lineNumber] = EMPTY_CELL;			
		}
	}
	
	private int checkEnterData(String enterText) {
		int n = 0; 		
		try {
			n = Integer.parseInt(enterText);
		} catch (NumberFormatException e) {
			System.out.println("Не цифра");
		}			
		
		if (n > FIELD_LENGTH || n <= 0) {
			n = 0;
			System.out.println("Not in range");
		}		
		return n;			
	}
	
	public void makeMuveByHuman(){	
		BufferedReader reader;		
		int x ;
		int y ;
		int flag = 0;
		
		for (;flag == 0; ) {
			
			x = 0;
			y = 0;
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			for(;x == 0;) {
				System.out.println("Enter number of col:");
				try {
					x = checkEnterData(reader.readLine());
					
				} catch (IOException ioe) {
							
				}
			}
			
			for(;y == 0;) {
				System.out.println("Enter number of row:");
				try {
					y = checkEnterData(reader.readLine());
					
				} catch (IOException ioe) {
							
				}
			}
			 
			flag = setElement(x-1,y-1,1);			
		}
		showField();			
	
	}
	
	public void makeMuveByPC(){
		Random rand = new Random();		
		
		int flag = 0;
		
		for (;flag == 0;) {
			flag = setElement(rand.nextInt(3),rand.nextInt(3),0);
		}
									
		showField();		
	}
	
	private char checkFields(char who) {
		// check horisontal 
		for (int i = 0; i < FIELD_LENGTH; i++) {
			if (field[0][i] == who && field[1][i] == who && field[2][i] == who) {
				System.out.println("Win in row "+i+" - "+who);
				return who;
			}
		}
		
		// check vert
		for (int i = 0; i < FIELD_LENGTH; i++) {
			if (field[i][0] == who && field[i][1] == who && field[i][2] == who) {
				System.out.println("Win in col "+i+" - "+who);
				return who;
			}
		}
		
		// diagonal 
		if ( (field[0][0] == who && field[1][1] == who && field[2][2] == who) || (field[2][0] == who && field[1][1] == who && field[0][2] == who)) {
			System.out.println("Win in diagonal - "+who);
			return who;						
		}	
		
		who = ' ';
		return who;
	}
	
	public char checkWhoWon() {	
		char win = ' ';
		// check horisontal
		win = checkFields(TIC);
		if (win != ' ') {
			 System.exit(1);
			return win;
		}
		
		checkFields(TAC);
		if (win != ' ') {
			 System.exit(1);
			return win; 
		}
				
		return win;
	}
	
	
}

