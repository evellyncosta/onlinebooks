package com.agriness.onlinebooks.enums;

public enum Available {
	DISPONIVEL(0), EMPRESTADO(1);

	private final int value;

	Available(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

}
