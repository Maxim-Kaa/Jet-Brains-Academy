
class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        int x = p1.age;
        String y = p1.name;
        p1.age = p2.age;
        p1.name = p2.name;
        p2.name = y;
        p2.age = x;

    }
}