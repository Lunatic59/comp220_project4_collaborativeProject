public abstract class Cipher {

    public abstract char encrypt( char c);

    public abstract char decrypt (char c);

    public String encrypt (String s) {
        StringBuilder theString = new StringBuilder();
        theString.append(s);

        for (int i = 0; i < theString.length(); i++)
            theString.setCharAt(i, this.encrypt(theString.charAt(i)));

        return theString.toString();
    }

    public String decrypt (String s) {
        StringBuilder theString = new StringBuilder();
        theString.append(s);

        for (int i = 0; i < theString.length(); i++)
            theString.setCharAt(i, this.decrypt(theString.charAt(i)));

        return theString.toString();
    }

    public abstract Cipher newCopy();
}
