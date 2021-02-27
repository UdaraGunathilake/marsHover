package com.assignment.marshover;

import java.util.List;

/**
 * Plateau POJO
 * 
 * @author : Udara Gunathilake
 * @email : udara.dhammika@gmail.com
 * @date : Feb 27, 2021
 */
public class Plateau {

	private int upperRightX;
	private int upperRightY;

	private int lowerLeftX = 0;
	private int lowerLeftY = 0;

	private List<Hover> hovers;

	private int hoverCount = 0;

	public Plateau(int upperRightX, int upperRightY) {
		super();
		this.upperRightX = upperRightX;
		this.upperRightY = upperRightY;
	}

	public List<Hover> getHovers() {
		return hovers;
	}

	/**
	 * Deploy Hovers inside the Plateau
	 * 
	 * @param hovers
	 * @throws Exception
	 */
	public void setHovers(List<Hover> hovers) {

		for (Hover hover : hovers) {

			int x = hover.getX();
			int y = hover.getY();

			if (!isHoverPositionInsidePlateau(x, y)) {
				/*
				 * System.out .println("Hover position : (" + x + "," + y +
				 * ")out side the Plateau . Stopping the proccess");
				 */
				setHover(hover, false);
			} else {
				setHover(hover, true);
			}

		}

		this.hovers = hovers;
	}

	private void setHover(Hover hover, boolean deploySuccess) {
		hoverCount++;
		hover.setId(hoverCount);
		hover.setUpperRightX(upperRightX);
		hover.setUpperRightY(upperRightY);
		hover.setSuccesfullyDeployed(deploySuccess);

	}

	/**
	 * Check whether the hover inside the Plateau
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isHoverPositionInsidePlateau(int x, int y) {
		return (this.lowerLeftX <= x && x <= this.upperRightX) && (this.lowerLeftY <= y && y <= this.upperRightY);

	}

}
