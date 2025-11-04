import java.util.ArrayList;

public class CompositionCipher extends Cipher{
    private ArrayList<Cipher> ciphers = new ArrayList<>();

    public CompositionCipher() {
        //TODO complete
    }

    public CompositionCipher( CompositionCipher other) {
        //TODO complete this method
    }

    public Cipher newCopy() {
        //TODO complete this method
        return null;
    }

    @Override
    public char encrypt(char c) {
        //TODO complete
        return c;
    }

    @Override
    public char decrypt(char c) {
        //TODO complete this method
        return  c;
    }

    public void add(Cipher theCipher) {
        //TODO complete, error checking and such i think

        this.ciphers.add(theCipher);
    }
}
