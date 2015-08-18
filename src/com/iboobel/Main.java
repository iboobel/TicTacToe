package com.iboobel;
import com.iboobel.games.*;
#import java.io.*;

public class Main {
	public static void main(String[] args) {
		TicTac game = new TicTac();
	
		char win = ' ';
				
		game.showField();
		
		for (; win == ' ';) {		
			
			game.makeMuveByHuman();
			win = game.checkWhoWon();
						
			game.makeMuveByPC();			
			win = game.checkWhoWon();
			
			System.out.println(win);
								
		}		
	}
}

