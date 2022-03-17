public class Main {

    public static void main(String[] args) {
        Secret[] cons = Secret.values();
        int count = 0;
        for (Secret con:Secret.values()) {
            if (String.valueOf(con).startsWith("STAR")) {
                count++;
            }
        }
        System.out.println(count); // write your program here
    }
}

/*sample enum for inspiration
   enum Secret {
    STAR, CRASH, START, // ...
}*/
