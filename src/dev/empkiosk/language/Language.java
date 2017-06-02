package dev.empkiosk.language;

public enum Language {
	KOREAN, ENGLISH;

	@Override
	public String toString() {
		return this.name();
	}
}
