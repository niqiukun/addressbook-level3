package seedu.address.model.password;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Password's password value in the password book.
 */
public class PasswordValue {
    public static final String MESSAGE_CONSTRAINTS = "PasswordValue can take any values, and it should not be blank";

    //public static final String VALIDATION_REGEX = "[^\\p].*";

    public final String value;

    public PasswordValue(String passwordValue) {
        requireNonNull(passwordValue);
        //checkArgument(isValidPasswordValue(passwordValue), MESSAGE_CONSTRAINTS);
        value = passwordValue;
    }

    //public static boolean isValidPasswordValue(String test) {
    //    return test.matches(VALIDATION_REGEX);
    //}

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PasswordValue // instanceof handles nulls
                && value.equals(((PasswordValue) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
