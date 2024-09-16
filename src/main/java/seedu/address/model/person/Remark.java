package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {
    public final String value;

    /**
     * Constructs a new {@code Remark} instance with the specified remark.
     *
     * <p>This constructor ensures that the provided {@code remark} is not {@code null}.
     * If {@code remark} is {@code null}, a {@link NullPointerException} is thrown.
     *
     * @param remark the remark text to be encapsulated in this instance
     * @throws NullPointerException if {@code remark} is {@code null}
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
