// Minion Labor Shifts
// ===================
//
// Commander Lambda's minions are upset! They're given the worst jobs on the whole space station, and some of them are starting to complain that even those worst jobs are being allocated unfairly. If you can fix this problem, it'll prove your chops to Commander Lambda so you can get promoted!
//
// Minions' tasks are assigned by putting their ID numbers into a list, one time for each day they'll work that task. As shifts are planned well in advance, the lists for each task will contain up to 99 integers. When a minion is scheduled for the same task too many times, they'll complain about it until they're taken off the task completely. Some tasks are worse than others, so the number of scheduled assignments before a minion will refuse to do a task varies depending on the task.  You figure you can speed things up by automating the removal of the minions who have been assigned a task too many times before they even get a chance to start complaining.
//
// Write a function called answer(data, n) that takes in a list of less than 100 integers and a number n, and returns that same list but with all of the numbers that occur more than n times removed entirely. The returned list should retain the same ordering as the original list - you don't want to mix up those carefully-planned shift rotations! For instance, if data was [5, 10, 15, 10, 7] and n was 1, answer(data, n) would return the list [5, 15, 7] because 10 occurs twice, and thus was removed from the list entirely.
//
// Languages
// =========
//
// To provide a Python solution, edit solution.py
// To provide a Java solution, edit solution.java
//
// Test cases
// ==========
//
// Inputs:
//     (int list) data = [1, 2, 3]
//     (int) n = 0
// Output:
//     (int list) []
//
// Inputs:
//     (int list) data = [1, 2, 2, 3, 3, 3, 4, 5, 5]
//     (int) n = 1
// Output:
//     (int list) [1, 4]
//
// Inputs:
//     (int list) data = [1, 2, 3]
//     (int) n = 6
// Output:
//     (int list) [1, 2, 3]
//
// Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
class Answer {
    public static int[] answer(int[] data, int n) {
        java.util.Map<Integer, Integer> map = new java.util.LinkedHashMap<Integer, Integer>();
        java.util.Set<Integer> deleted = new java.util.HashSet<Integer>();
        int j = 0;
        Integer size;

        for (int i = 0; i < data.length; i++) {
            size = map.get((Integer)data[i]);
            if (size == null) size = 0;
            size = size + 1;
            if (size > n) {
                map.remove((Integer)data[i]);
                deleted.add((Integer)data[i]);
                if (j > 0) j = j-n;
            } else if (!deleted.contains((Integer)data[i])) {
                j++;
                map.put(data[i], size);
            }
        }

        int[] arr = new int[j];
        for (int i = 0, k = 0; i < data.length; i++) {
            if (map.containsKey((Integer)data[i])) {
                arr[k] = data[i];
                k++;
            }
        }
        return arr;
    }

    static void p(int [] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else System.out.print(arr[i] + ", ");
        }
        System.out.print("]\n");
    }


    public static void main(String [] argv) {
        // int[] arr = {5, 10, 15, 10, 7};
        // int[] arr1 = {1,1,1,1,1};
        // int[] arr2 = {};
        int[] data = {1, 4, 2, 2, 3, 3, 3, 4, 5, 5};
        // int[] data2 = {1, 2, 3};
        // p(answer(arr, 1));
        // p(answer(arr1, 1));
        p(answer(data, 2));
        // p(answer(data2, 0));
        // p(answer(data2, 6));
    }
}
