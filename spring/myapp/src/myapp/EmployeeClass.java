package myapp;

import java.io.Serializable;

public class EmployeeClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int points = 0;
	private String name = null;

	public EmployeeClass() {
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
}