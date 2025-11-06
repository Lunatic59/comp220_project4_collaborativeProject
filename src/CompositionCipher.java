/**
 * The {@code CompositionCipher} class encrypts or decrypts strings or characters using a Composition Cipher
 *
 * This class also includes a copy constructor to create a deep copy of the current object
 *
 * @author Hayden Califf & Ben Obman
 * @version 1.0
 * @since 2025-11-05
 */
import java.util.ArrayList;

public class CompositionCipher extends Cipher{
    /**
     * An arraylist of type Cipher to hold the characters for encryption and decryption
     */
    private ArrayList<Cipher> ciphers = new ArrayList<>();

    /**
     * Constructor for the CompositionCipher class
     */
    public CompositionCipher() {
        //TODO discuss with ben. couldn't see anything wrong with this.
    }

    /**
     *Creates a deep copy of the specified {@code CompositionCipher}
     *
     * @param other the CompositionCipher to copy
     */
    public CompositionCipher( CompositionCipher other) {
        for (Cipher template : other.ciphers) {
            this.ciphers.add(template.newCopy());
        }
    }

    /**
     *
     * @return a copy of the CompositionCipher
     */
    @Override
    public Cipher newCopy() {
        return (new CompositionCipher(this));
    }

    /**
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
    @Override
    public char encrypt(char c) {
        for (int i = 0; i < ciphers.size(); i++) {
           c = this.ciphers.get(i).encrypt(c);
        }

        return c;
    }

    /**
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
    @Override
    public char decrypt(char c) {
        for (int i = (ciphers.size() - 1); i >= 0; i--) {
           c = this.ciphers.get(i).decrypt(c);
        }

        return  c;
    }

    /**
     *Adds a cipher to the composition
     *
     * @param theCipher the Cipher to be added to the composition
     */
    public void add(Cipher theCipher) {
        //TODO complete, error checking and such i think

        this.ciphers.add(theCipher.newCopy());
    }
}
