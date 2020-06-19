package Funclayer.exceptions.validation.template;

import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.NotANameException;
import Funclayer.exceptions.exceptions.NotAStatusException;

import java.sql.SQLException;

public abstract class Validation {

	protected static boolean isDouble(Object number) {
		if(number instanceof Double)
			return true;

		return false;
	}

	protected static boolean hasDigit(String str) {
		return str.matches(".*[0-9].*");
	}


	protected static boolean hasSpecial(String str) {
		return str.matches(".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*");
	}

	protected static boolean lengthValidator(int min, int max, String str) {
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

	protected static int idValidator(int id) throws  IDException {
		if (!hasDigit( String.valueOf( id ) ))
			throw new IDException( "ID should be a number" );

		if (id < 1 || id > 99999999)
			throw new IDException( "ID should be between 1 - 99999999" );

		return id;
	}


}