package filters.validation;



public class RegisterValidation {

	
	private static String NAMEPATTERN = "^[a-zA-Z]*$";
	private static String EMAILATTERN = "^[a-zA-Z0-9+_.-]+@[a-zA-Z.-]+$";

	private static boolean isNameValid(String name) {
	
		if (name == null || name.length() < 3 || name.length() > 15)
			return false;


		return name.matches(NAMEPATTERN);
	}

	/*
	 * It will return boolean value y checking whether entered data is valid or not
	 **/
	public static boolean isDataValid(String name, String last_name, String email, String password) {
		
		return isNameValid(name) && isNameValid(last_name) && isEmailValid(email) && isPasswordValid(password);

	}

	public static boolean isPasswordValid(String password) {
		
		if (password == null || password.length() > 12 || password.length() < 8)
			return false;

		return true;
	}

	public static boolean isEmailValid(String email) {
		
		if (email == null || email.length() > 20 || email.length() < 5)
			return false;

		return email.matches(EMAILATTERN);
	}


}
