
class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        int size = array == null ? 0 : array.length - 1;
        if (index > size || index < 0) {
            System.out.println("Exception!");
        } else {
            int a = array[index];
            System.out.println(a * a);
        }
        // write your code here

    }
}