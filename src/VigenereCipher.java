/**
 * The {@code VigenereCipher} class encrypts or decrypts a string of characters using a vigenere cipher
 *
 * This class also includes a copy constructor to make a deep copy of the current object
 *
 * @author unkown, mostly complete class that was altered
 * @Author Hayden Califf & Ben Obman
 * @version 1.0
 * @since 2025-5-05
 */

import java.util.ArrayList;

public class VigenereCipher extends Cipher{
	
	private ArrayList<CaesarCipher> subCiphers;

    /**
     * The nextIndexForEncrypt and nextIndexForDecrypt variables
     * keep track of which CaesarCipher to use for the
     * next encrypt or decrypt operation, respectively
     */
	private int nextIndexForEncrypt;
	private int nextIndexForDecrypt;

    /**
     * Shifts the characters by a specified amount and then adds them to
     * the subCiphers ArrayList
     * @param shiftAmounts the amount to shift the characters by
     */
	public VigenereCipher(Iterable<Integer> shiftAmounts){
		nextIndexForEncrypt = 0;
		nextIndexForDecrypt = 0;
		
		subCiphers = new ArrayList<>();
		for(Integer amt : shiftAmounts){
			subCiphers.add(new CaesarCipher(amt));
		}
	}

    /**
     *Creates a new VigenereCipher as a copy of the specified one
     *
     * @param other the VigenereCipher to copy
     */
	public VigenereCipher(VigenereCipher other){
		this.nextIndexForDecrypt = other.nextIndexForDecrypt;
        this.nextIndexForEncrypt = other.nextIndexForEncrypt;
        this.subCiphers = new ArrayList<>(other.subCiphers);
	}

    /**
     * Encrypts the current character in subCiphers
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
	@Override
	public char encrypt(char c) {
		char res = subCiphers.get(nextIndexForEncrypt).encrypt(c);
		nextIndexForEncrypt = (nextIndexForEncrypt + 1) % subCiphers.size();
        c = res;
		return c;
	}

    /**
     * Decrypts the characters in subCiphers
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
	@Override
	public char decrypt(char c) {
		char res = subCiphers.get(nextIndexForDecrypt).decrypt(c);
		nextIndexForDecrypt = (nextIndexForDecrypt + 1) % subCiphers.size();
		return res;
	}

    /**
     * Returns a new object, a deep copy of the current object
     *
     * @return a deep copy of the current object
     */
	@Override
	public Cipher newCopy() {
		return new VigenereCipher(this);
	}

}
