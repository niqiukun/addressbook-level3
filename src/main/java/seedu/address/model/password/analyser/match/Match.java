package seedu.address.model.password.analyser.match;

/**
 * Represents a match found by an {@code Analyser} which contains the portion of the password
 * where in the password the match was found (token), how many characters it is (length)
 * Additionally it should be able to return a string with details about the match to display to a user with relevant
 * information pertaining to the type of {@code Match}.
 */
public interface Match {
    String MESSAGE_INIT = "------------\n";

    /**
     * Returns the portion of the password in which a {@code Match} was found.
     *
     * @return the {@code String} value of the {@code Match}.
     */
    String getToken();

    /**
     * Returns the start index of portion in the {@code PasswordValue}.
     *
     * @return the the start index
     */
    int getStartIndex();

    /**
     * Returns the end index of portion in the {@code PasswordValue}.
     *
     * @return the end index
     */
    int getEndIndex();

    /**
     * Stringifies the details of the {@code Match} to be output in a report
     *
     * @return all specific details about this {@code Match} in printable String format.
     */
    String toString();

}
