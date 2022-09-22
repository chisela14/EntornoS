package com.jacaranda;

import java.util.Objects;

public class Calculator {
	private double x;
	private double y;
	
	public Calculator(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double add() {
		return x + y;
	}
	
	public double subtract() {
		return x - y;
	}
	
	public double multiply() {
		return x * y;
	}
	
	public double divide() throws CalculatorException {
		if(x==0 || y==0) {
			throw new CalculatorException("No se puede dividir entre 0");
		}else {
			return x / y;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

	@Override
	public String toString() {
		return "Calculator [x=" + x + ", y=" + y + "]";
	}
	
}
