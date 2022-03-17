import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String line2 = line.trim();
        if (line2.length() > 0) {
            String[] words = line2.split("\\s+");
            System.out.println(words.length);
        } else {
            System.out.println(0);
        }
        // start coding here
        reader.close();
    }
}