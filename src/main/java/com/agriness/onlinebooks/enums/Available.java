package com.agriness.onlinebooks.enums;

public enum Available {
	EMPRESTADO(0), DISPONIVEL(1);

	private final int value;

	Available(final int newValue) {
		value = newValue;
	} 

	public int getValue() {
		return value;
	}

}
