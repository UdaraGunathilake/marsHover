package com.assignment.marshover;

import java.util.ArrayList;

/**
 * Main class of Hover moving application
 * 
 * @author : Udara Gunathilake
 * @email : udara.dhammika@gmail.com
 * @date : Feb 26, 2021
 */
public class MainApplication {

	public static void main(String[] args) {

		int upperRightX = 5;
		int upperRightY = 5;

		ArrayList<Hover> hovers = new ArrayList<>();
		// Configure Plateau
		Plateau plateau = new Plateau(upperRightX, upperRightY);

		// Congigure Hovers
		Hover hover1 = new Hover(1, 2, "N");
		Hover hover2 = new Hover(3, 3, "E");

		try {
			// Deploy Hovers in Plateau
			hovers.add(hover1);
			hovers.add(hover2);
			plateau.setHovers(hovers);

			// Move Hovers
			hover1.commands("LMLMLMLMM");
			hover2.commands("MMRMMRMRRM");
			System.out.println("HOVERS SUCCESSFULLY DEPLOYED AND MOVED INSIDE PLATEAU");
		} catch (Exception e) {

			System.out.println("ERROR OCCURED : STOPPING THE PROCCESS");

		}

	}

}
