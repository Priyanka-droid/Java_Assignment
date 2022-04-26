public class Validations {
    public static void validateNumber(int number, int start, int end) throws NumberOutOfRangeException {

        if (number < start || number > end) throw new NumberOutOfRangeException("Number out of range exception");

    }

    public static void validateNumber(int number) throws InvalidNumberException {

        if (number < 0) throw new InvalidNumberException("Invalid number less than 0 exception");

    }

    public static void validateString(String string) throws EmptyStringException {


        if (string.isEmpty()) throw new EmptyStringException("Empty string exception");


    }

    private static boolean isValidName(String name) {
        String expression = "^[a-zA-Z\\s]+";
        return name.matches(expression);
    }

    public static void validateName(String name) throws EmptyStringException, InvalidNameSizeException, InvalidNameFormatException {


        if (name.isEmpty()) throw new EmptyStringException("Empty string exception");
        else if (name.split(" ").length > 2)
            throw new InvalidNameSizeException("Invalid name size exception");
        else if (!isValidName(name)) throw new InvalidNameFormatException("Invalid name format exception");


    }

}
