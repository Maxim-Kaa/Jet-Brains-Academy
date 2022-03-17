
class Cat {
    String name;
    int age;
    static  int count;
    final int maxCats = 5;
    // write static and instance variables

    public Cat(String name, int age) {
        this.name = name;
        this.age = age; // implement the constructor
        count++;
        if (count > maxCats) {
            System.out.println("You have too many cats");
            // do not forget to check the number of cats
        }

    }

    public static int getNumberOfCats() {
        return count;
    }
}
