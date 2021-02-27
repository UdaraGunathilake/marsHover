package com.assignment.marshover;

/**
 * Hover POJO class
 * 
 * @author : Udara Gunathilake
 * @email : udara.dhammika@gmail.com
 * @date : Feb 26, 2021
 */
public class Hover {

	private int id;
	private int initialX;
	private int initialY;
	private String initialFacing;
	private String command;

	private int x;
	private int y;
	private String facing;

	private int upperRightX;
	private int upperRightY;

	private int lowerLeftX = 0;
	private int lowerLeftY = 0;

	private boolean succesfullyDeployed;
	private boolean successfullyMoved;

	public Hover(int x, int y, String facing) {
		super();
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.facing = facing;
		this.initialFacing = facing;
		setSuccessfullyMoved(true);
	}

	/**
	 * Move hover forward to current facing direction by one grid point
	 * 
	 * @throws Exception
	 */
	public void moveForward()  {

		switch (facing) {
		case "N":
			this.y++;
			if (!isCorrectDirection()) {
				this.y--;
				wrongPosition();
			}
			break;
		case "E":
			this.x++;
			if (!isCorrectDirection()) {
				this.x--;
				wrongPosition();
			}
			break;
		case "W":
			this.x--;
			if (!isCorrectDirection()) {
				this.x++;
				wrongPosition();
			}
			break;
		case "S":
			this.y--;
			if (!isCorrectDirection()) {
				this.y++;
				wrongPosition();
			}
			break;

		}

	}

	/**
	 * Run when hover is moving towards wrong direction out side of the limit
	 * 
	 * @throws Exception
	 */
	private void wrongPosition()  {
		// System.out.println("Stopping the hover as wrong commands");
		// System.out.print("Hover last position : ");
		// printCurrentPosition();
		setSuccessfullyMoved(false);
		// throw new Exception();
	}

	/**
	 * Turn hover left from current facing direction
	 */
	public void turnLeft() {

		switch (facing) {
		case "N":
			this.facing = "W";
			break;
		case "E":
			this.facing = "N";
			break;
		case "W":
			this.facing = "S";
			break;
		default:
			this.facing = "E";
			break;
		}
	}

	/**
	 * Turn hover right from current facing direction
	 */
	public void turnRight() {

		switch (facing) {
		case "N":
			this.facing = "E";
			break;
		case "E":
			this.facing = "S";
			break;
		case "W":
			this.facing = "N";
			break;
		default:
			this.facing = "W";
			break;
		}
	}

	/**
	 * Print current position of the hover
	 */
	public void printCurrentPosition() {

		// System.out.println(this.x + " " + this.y + " " + this.facing);
		System.out.println(
				""+this.id+" Hover - initial_position: (" + this.initialX + "," + this.initialY + "," + this.initialFacing + ")| commands : "
						+ this.command + " | success_deploy: " + isSuccesfullyDeployed() + " | success_movement: "
						+ isSuccessfullyMoved() + " | final position : (" + this.x + "," + y + "," + this.facing + ")");
	}

	/**
	 * Sequence of commands for the hover to move.
	 * 
	 * @param commandSequence
	 * @throws Exception
	 */
	public void commands(String commandSequence)  {

		char left = 'L';
		char right = 'R';
		char forward = 'M';
		this.command = commandSequence;

		if (isSuccesfullyDeployed()) {
			for (int commandNumber = 0; commandNumber < commandSequence.length(); commandNumber++) {

				char command = commandSequence.charAt(commandNumber);

				if (left == command) {
					turnLeft();
					continue;
				}
				if (right == command) {
					turnRight();
					continue;
				}
				if (forward == command) {
					moveForward();

				} else {
					System.out.println("Invalid Input command : " + command);
					setSuccessfullyMoved(false);
				}

			}
		}else {
			setSuccessfullyMoved(false);
		}
		printCurrentPosition();
	}

	/**
	 * Check the hover current position is inside the plateau
	 * 
	 * @return
	 */
	private boolean isCorrectDirection() {
		return (this.lowerLeftX <= this.x && this.x <= upperRightX)
				&& (this.lowerLeftY <= this.y && this.y <= upperRightY);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getUpperRightX() {
		return upperRightX;
	}

	public void setUpperRightX(int upperRightX) {
		this.upperRightX = upperRightX;
	}

	public int getUpperRightY() {
		return upperRightY;
	}

	public void setUpperRightY(int upperRightY) {
		this.upperRightY = upperRightY;
	}

	public int getLowerLeftX() {
		return lowerLeftX;
	}

	public void setLowerLeftX(int lowerLeftX) {
		this.lowerLeftX = lowerLeftX;
	}

	public int getLowerLeftY() {
		return lowerLeftY;
	}

	public void setLowerLeftY(int lowerLeftY) {
		this.lowerLeftY = lowerLeftY;
	}

	public boolean isSuccesfullyDeployed() {
		return succesfullyDeployed;
	}

	public void setSuccesfullyDeployed(boolean succesfullyDeployed) {
		if (!succesfullyDeployed) {
			this.x = 0;
			this.y = 0;
			this.facing = "ND";

		}
		this.succesfullyDeployed = succesfullyDeployed;
	}

	public boolean isSuccessfullyMoved() {
		return successfullyMoved;
	}

	public void setSuccessfullyMoved(boolean successfullyMoved) {
		this.successfullyMoved = successfullyMoved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
