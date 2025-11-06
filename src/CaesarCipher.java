/**
 * The {@code CaesarCipher} class encrypts strings or characters using a Caesar Cipher
 *
 * This class also includes a copy constructor to create a deep copy of the current object
 *
 * @author unknown, gave mostly complete class
 * @author Hayden Califf & Ben Obman
 * @version 1.0
 * @since 2025-5-05
 */
public class CaesarCipher extends Cipher{
    /**
     * The number of letters in the English Alphabet
     */
    private final static int NUM_LETTERS = 26;
    /**
     * The amount to shift the character by during encryption and decryption
     */
	private final int shiftAmount;
	
	/**
	 * @param amt - the distance to shift letters when encrypting
	 */
	public CaesarCipher(int amt){
		this.shiftAmount = amt;
	}
	
	public CaesarCipher(CaesarCipher other) {
        this.shiftAmount = other.shiftAmount;
    }

    /**
     * Encrypts a character using a Caesar Cipher
     * @param c the character to encrypt
     * @return the encrypted character
     */
	@Override
	public char encrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');		
			// c - base is the index in the alphabet: 'a' becomes 0, 'b' becomes 1, etc.
			return (char)(base + ((c - base + shiftAmount) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}

    /**
     *Decrypts a character using a Caesar Cipher
     * @param c the character to decrypt
     * @return the decrypted character
     */
	@Override
	public char decrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');			
			return (char)(base + ((c - base - shiftAmount + NUM_LETTERS) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}

    /**
     *Creates a deep copy of the current object
     * @return the deep copy of the current object
     */
	// Returns a new object, a deep copy of the current object
	@Override
	public Cipher newCopy() {
		return new CaesarCipher(this);
	}

}
