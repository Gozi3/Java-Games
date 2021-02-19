package MonteCarloDice;

import java.util.*;

public class MonteCarloDice {
	public static void main(String[] args) {
		Random rand = new Random();
		int n = 100000000;// number of simulations
		int turns[] = { 0, 0, 0 };// stores how many turns for the occurence to happen
		int average[] = { 1, 1, 1 };
		int dss = 0;
		int ds = 0;
		int d = 0;
		boolean checkDice = false;
		boolean checkSnz = false;
		boolean checkSnpCht = false;
		int dice, sneeze, snapchat;
		for (int i = 0; i < n; i++) {
			dice = rand.nextInt(6) + 1;
			sneeze = rand.nextInt(1000) + 1;
			snapchat = rand.nextInt(1000) + 1;
			if (dice == 6) {
				checkDice = true;
			}
			if (sneeze == rand.nextInt(1000) + 1) {
				checkSnz = true;
			}
			if (snapchat == rand.nextInt(1000) + 1) {
				checkSnpCht = true;
			}
			if (checkDice) {
				if (checkSnz && checkSnpCht) {
					dss += turns[0];
					turns[0] = 0;
					average[0]++;
					checkSnz = false;
					checkSnpCht = false;
				}
				if (checkSnpCht) {
					ds += turns[1];
					turns[1] = 0;
					average[1]++;
				}
				d += turns[2];
				turns[2] = 0;
				average[2]++;
				checkDice = false;
			}
			turns[0]++;
			turns[1]++;
			turns[2]++;
		}
		System.out.println((double) dss / average[0] + " for a dice to roll 6, sneeze and snapchat.");
		System.out.println((double) ds / average[1] + " for a dice to roll 6 and snapchat.");
		System.out.println((double) d / average[2] + " for a dice to roll 6.");
	}
}
