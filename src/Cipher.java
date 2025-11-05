public abstract class Cipher {

    public abstract char encrypt( char c);

    public abstract char decrypt (char c);

    public String encrypt (String s) {

        return s;
    }

    public String decrypt (String s) {

        return s;
    }

    public abstract Cipher newCopy();
}
