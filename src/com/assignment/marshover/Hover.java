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

	private boolean succesfullyDeployed;
	private boolean successfullyMoved;

	private static final int LOWER_LEFT_X = 0;
	private static final int LOWER_LEFT_Y = 0;
	private static final String NORTH = "N";
	private static final String EAST = "E";
	private static final String WEST = "W";
	private static final String SOUTH = "S";
	private static final String NOT_DEPLOYED = "ND";

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
	public void moveForward() {

		switch (facing) {
		case NORTH:
			this.y++;
			if (!isCorrectDirection()) {
				this.y--;
				setSuccessfullyMoved(false);
			}
			break;
		case EAST:
			this.x++;
			if (!isCorrectDirection()) {
				this.x--;
				setSuccessfullyMoved(false);
			}
			break;
		case WEST:
			this.x--;
			if (!isCorrectDirection()) {
				this.x++;
				setSuccessfullyMoved(false);
			}
			break;
		default:
			this.y--;
			if (!isCorrectDirection()) {
				this.y++;
				setSuccessfullyMoved(false);
			}
			break;

		}

	}

	/**
	 * Turn hover left from current facing direction
	 */
	public void turnLeft() {

		switch (facing) {
		case NORTH:
			this.facing = WEST;
			break;
		case EAST:
			this.facing = NORTH;
			break;
		case WEST:
			this.facing = SOUTH;
			break;
		default:
			this.facing = EAST;
			break;
		}
	}

	/**
	 * Turn hover right from current facing direction
	 */
	public void turnRight() {

		switch (facing) {
		case NORTH:
			this.facing = EAST;
			break;
		case EAST:
			this.facing = SOUTH;
			break;
		case WEST:
			this.facing = NORTH;
			break;
		default:
			this.facing = WEST;
			break;
		}
	}

	/**
	 * Print current position of the hover
	 */
	public void printCurrentPosition() {

		System.out.println("" + this.id + " Hover - (" + this.initialX + "," + this.initialY + "," + this.initialFacing
				+ "), " + this.command + " | success_deploy: " + isSuccesfullyDeployed() + " | success_movement: "
				+ isSuccessfullyMoved() + " | final position : (" + this.x + "," + y + "," + this.facing + ")");
	}

	/**
	 * Sequence of commands for the hover to move.
	 * 
	 * @param commandSequence
	 * @throws Exception
	 */
	public void commands(String commandSequence) {

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
		} else {
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
		return (LOWER_LEFT_X <= this.x && this.x <= upperRightX) && (LOWER_LEFT_Y <= this.y && this.y <= upperRightY);

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
		return LOWER_LEFT_X;
	}

	public int getLowerLeftY() {
		return LOWER_LEFT_Y;
	}

	public boolean isSuccesfullyDeployed() {
		return succesfullyDeployed;
	}

	public void setSuccesfullyDeployed(boolean succesfullyDeployed) {
		if (!succesfullyDeployed) {
			this.x = 0;
			this.y = 0;
			this.facing = NOT_DEPLOYED;

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
