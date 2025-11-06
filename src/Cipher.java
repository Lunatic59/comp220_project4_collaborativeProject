/**
 * The {@code Cipher} class defines the abstract structure for character based encryption and decryption
 *
 * Subclasses of {@code Cipher} need to implement methods of encrypting and decrypting individual characters,
 * and provide a way to return a new instance of the cipher
 *
 * This class also provides concrete methods for encrypting and decrypting strings by processing each
 * character sequentially
 *
 * @author Hayden Califf & Ben Obman
 * @version 1.0
 * @since 2025-5-05
 */
public abstract class Cipher {

    /**
     * Encrypts a single character using the cipher's method
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
    public abstract char encrypt( char c);

    /**
     * Decrypts a single character using the cipher's method
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
    public abstract char decrypt (char c);

    /**
     * Encrypts a string by applying the cipher's {@link #encrypt(char)} method to each character
     *
     * @param s the string to encrypt
     * @return a new string containing the encrypted characters
     */
    public String encrypt (String s) {
        StringBuilder theString = new StringBuilder();
        theString.append(s);

        for (int i = 0; i < theString.length(); i++)
            theString.setCharAt(i, this.encrypt(theString.charAt(i)));

        return theString.toString();
    }

    /**
     * Decrypts a string by applying the cipher's {@link #decrypt(char)} method to each character
     *
     * @param s the string to decrypt
     * @return a new string containing the decrypted characters
     */
    public String decrypt (String s) {
        StringBuilder theString = new StringBuilder();
        theString.append(s);

        for (int i = 0; i < theString.length(); i++)
            theString.setCharAt(i, this.decrypt(theString.charAt(i)));

        return theString.toString();
    }

    /**
     * Creates and returns a new instance (copy) of this cipher
     * <p>
     * This method is used to create a new, uninitialized cipher object
     * of the same type as the current one
     * </p>
     *
     * @return a new instance of the cipher
     */
    public abstract Cipher newCopy();
}
