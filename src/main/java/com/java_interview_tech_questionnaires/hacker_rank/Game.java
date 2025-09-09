package com.java_interview_tech_questionnaires.hacker_rank;

import java.util.Scanner;

/**
 * @author RavikantS on Sept 08, 2025
 */
public class Game {
	public static boolean canWin(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false.
		
//		If cell i + 1 contains a zero, you can walk to cell i + 1.
//		If cell i + leap contains a zero, you can jump to cell i + leap.
//		If you're standing in cell n - 1 or the value of i + leap >= n, you can walk or jump off the end of the array and win the game.
//		In other words, you can move from index i to index i + 1, i - 1, or i + leap as long as the destination index is a cell containing a 0.
//		If the destination index is greater than n - 1, you win the game.
		int n = game.length;
		boolean isWin = false;
		for (int i = 0; i < n; ++i) {
			if (i + leap > n - 1 || i > n - 1) {
				isWin = true;
				break;
			}  else if (game[i + leap] == 0) {
				i = i + leap;
			}  else if (game[i + 1] == 1) {
				break;
			} else if (i == n - 1 || i + leap >= n) {
				i = n;
				isWin = true;
				break;
			}
		}
		return isWin;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();
			
			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			
			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();
	}
}
