import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int count1 = 0;
        int count2 = 0;
        for (Integer el:list1) {
            if (el.equals(elem)) {
                count1++;
            }
        }
        for (Integer el:list2) {
            if (el.equals(elem)) {
                count2++;
            }
        }
        return count1 == count2;

        // implement the method
    }
}