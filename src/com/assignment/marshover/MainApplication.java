package com.assignment.marshover;
/**
 * Main class of Hover moving application
 * 
 * @author : Udara Gunathilake
 * @email  : udara.dhammika@gmail.com
 * @date   : Feb 26, 2021
 */
public class MainApplication {

	public static void main(String[] args) {

		Hover hover1 = new Hover(1, 2, "N",5,5);
		
		try {
			hover1.commands("LMLMLMLMMMMMMMMM");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED : INVALID INPUT STREAM");
		}

	}

}
