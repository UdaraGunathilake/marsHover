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
		Hover hover2 = new Hover(30, 3, "E");
		Hover hover3 = new Hover(3, 3, "E");

		// Deploy Hovers in Plateau
		hovers.add(hover1);
		hovers.add(hover2);
		hovers.add(hover3);
		plateau.setHovers(hovers);

		// Move Hovers
		hover1.commands("LMLMLMLMM");
		hover2.commands("MMRMMRMRRM");
		hover3.commands("MMRMMRMRRM");
		System.out.println("HOVERS SUCCESSFULLY DEPLOYED AND MOVED INSIDE PLATEAU");

		}

}
