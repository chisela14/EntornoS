package com.jacaranda;

import java.util.Objects;

public class Calculator {
	private float x;
	private float y;
	
	public Calculator(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public float add() {
		return x + y;
	}
	
	public float subtract() {
		return x - y;
	}
	
	public float multiply() {
		return x * y;
	}
	
	public float divide() throws CalculatorException {
		if(x==0 || y==0) {
			throw new CalculatorException();
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
		return Float.floatToIntBits(x) == Float.floatToIntBits(other.x)
				&& Float.floatToIntBits(y) == Float.floatToIntBits(other.y);
	}

	@Override
	public String toString() {
		return "Calculator [x=" + x + ", y=" + y + "]";
	}
	
}
