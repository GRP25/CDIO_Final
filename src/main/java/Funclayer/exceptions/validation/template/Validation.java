package Funclayer.exceptions.validation.template;

import Funclayer.exceptions.exceptions.NotANameException;
import Funclayer.exceptions.exceptions.NotAStatusException;

import java.sql.SQLException;

public abstract class Validation {

	private static boolean hasDigit(String str) {
		return str.matches(".*[0-9].*");
	}

	private static boolean hasSpecial(String str) {
		return str.matches(".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*");
	}

	private static boolean lengthValidator(int min, int max, String str) {
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

	public static boolean isDateValidator(String date) {
		return date.matches("^(3[01]|[12][0-9]|0[1-9])(1[0-2]|0[1-9])[0-9]{2}$");
	}

	public static void statusValidator(int status) throws NotAStatusException {
		if (status != 0 && status != 1) {
			throw new NotAStatusException("Not a Valid status");
		}
	}


}