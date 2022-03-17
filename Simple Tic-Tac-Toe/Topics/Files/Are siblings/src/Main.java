import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        boolean b = false;
        if (f1.getParent().equals(f2.getParent())) {
            b = true;
        }
        // implement me
        return b;
    }
}