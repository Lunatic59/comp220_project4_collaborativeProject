import java.util.ArrayList;

public class CompositionCipher extends Cipher{
    private ArrayList<Cipher> ciphers = new ArrayList<>();

    public CompositionCipher() {
        //TODO discuss with ben. couldn't see anything wrong with this.
    }

    //should be complete
    public CompositionCipher( CompositionCipher other) {
        for (int i = 0; i < other.ciphers.size(); i++) {
            this.ciphers.add(other.ciphers.get(i).newCopy());
        }
    }

    // I think this is good
    @Override
    public Cipher newCopy() {
        return (new CompositionCipher(this));
    }

    //should be done
    @Override
    public char encrypt(char c) {
        for (int i = 0; i < ciphers.size(); i++) {
           c = this.ciphers.get(i).encrypt(c);
        }

        return c;
    }

    @Override
    public char decrypt(char c) {
        for (int i = (ciphers.size() - 1); i >= 0; i--) {
           c = this.ciphers.get(i).decrypt(c);
        }

        return  c;
    }

    public void add(Cipher theCipher) {
        //TODO complete, error checking and such i think

        this.ciphers.add(theCipher.newCopy());
    }
}
