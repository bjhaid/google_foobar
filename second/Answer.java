// Prison Labor Dodgers
// ====================
//
// Commander Lambda is all about efficiency, including using her bunny prisoners for manual labor. But no one's been properly monitoring the labor shifts for a while, and they've gotten quite mixed up. You've been given the task of fixing them, but after you wrote up new shifts, you realized that some prisoners had been transferred to a different block and aren't available for their assigned shifts. And manually sorting through each shift list to compare against prisoner block lists will take forever - remember, Commander Lambda loves efficiency!
//
// Given two almost identical lists of prisoner IDs x and y where one of the lists contains an additional ID, write a function answer(x, y) that compares the lists and returns the additional ID.
//
// For example, given the lists x = [13, 5, 6, 2, 5] and y = [5, 2, 5, 13], the function answer(x, y) would return 6 because the list x contains the integer 6 and the list y doesn't. Given the lists x = [14, 27, 1, 4, 2, 50, 3, 1] and y = [2, 4, -4, 3, 1, 1, 14, 27, 50], the function answer(x, y) would return -4 because the list y contains the integer -4 and the list x doesn't.
//
// In each test case, the lists x and y will always contain n non-unique integers where n is at least 1 but never more than 99, and one of the lists will contain an additional unique integer which should be returned by the function.  The same n non-unique integers will be present on both lists, but they might appear in a different order, like in the examples above. Commander Lambda likes to keep her numbers short, so every prisoner ID will be between -1000 and 1000.
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
//     (int list) x = [13, 5, 6, 2, 5]
//     (int list) y = [5, 2, 5, 13]
// Output:
//     (int) 6
//
// Inputs:
//     (int list) x = [14, 27, 1, 4, 2, 50, 3, 1]
//     (int list) y = [2, 4, -4, 3, 1, 1, 14, 27, 50]
// Output:
//     (int) -4
//
// Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

public class Answer {
    public static int answer(int[] x, int[] y) {
        java.util.Set<Integer> set_x = new java.util.HashSet<Integer>();
        java.util.Set<Integer> set_y = new java.util.HashSet<Integer>();
        java.util.Set<Integer> result;

        for (int i = 0; i < x.length; i++) set_x.add((Integer)x[i]);
        for (int i = 0; i < y.length; i++) set_y.add((Integer)y[i]);

        if (set_x.containsAll(set_y)) {
            set_x.removeAll(set_y);
            result = set_x;
        } else {
            set_y.removeAll(set_x);
            result = set_y;
        }

        int ans = 0;
        for (Integer i : result) {
            ans = i;
            break;
        }
        return ans;
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
        int[] x = {14, 27, 1, 4, 2, 50, 3, 1};
        int[] y = {2, 4, -4, 3, 1, 1, 14, 27, 50};
        System.out.println(answer(x, y));
        // p(answer(data2, 0));
        // p(answer(data2, 6));
    }
}
