package Funclayer.exceptions.validation.template;

import Funclayer.exceptions.exceptions.NotANameException;

public abstract class Validation {

	public static boolean hasDigit(String str) {
		return str.matches(".*[0-9].*");
	}

	public static boolean hasSpecial(String str) {
		return str.matches(".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*");
	}

	public static boolean lengthValidator(int min, int max, String str) {
		return str.length() < min || str.length() > max;
	}

	public static String nameValidator(String name) throws NotANameException {
		if (hasDigit(name))
			throw new NotANameException("Names can not have numbers. Please put in a real name!");
		if (hasSpecial(name))
			throw new NotANameException("Names can not have special characters. Please put in a real name!");
		if (lengthValidator(1, 25, name))
			throw new NotANameException("The name can only be between 2 and 25 characters");
		else
			return name;
	}
}