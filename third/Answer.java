// Elevator Maintenance
// ====================
//
// You've been assigned the onerous task of elevator maintenance - ugh! It wouldn't be so bad, except that all the elevator documentation has been lying in a disorganized pile at the bottom of a filing cabinet for years, and you don't even know what elevator version numbers you'll be working on.
//
// Elevator versions are represented by a series of numbers, divided up into major, minor and revision integers. New versions of an elevator increase the major number, e.g. 1, 2, 3, and so on. When new features are added to an elevator without being a complete new version, a second number named "minor" can be used to represent those new additions, e.g. 1.0, 1.1, 1.2, etc. Small fixes or maintenance work can be represented by a third number named "revision", e.g. 1.1.1, 1.1.2, 1.2.0, and so on. The number zero can be used as a major for pre-release versions of elevators, e.g. 0.1, 0.5, 0.9.2, etc (Commander Lambda is careful to always beta test her new technology, with her loyal henchmen as subjects!).
//
// Given a list of elevator versions represented as strings, write a function answer(l) that returns the same list sorted in ascending order by major, minor, and revision number so that you can identify the current elevator version. The versions in list l will always contain major numbers, but minor and revision numbers are optional. If the version contains a revision number, then it will also have a minor number.
//
// For example, given the list l as ["1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"], the function answer(l) would return the list ["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"]. If two or more versions are equivalent but one version contains more numbers than the others, then these versions must be sorted ascending based on how many numbers they have, e.g ["1", "1.0", "1.0.0"]. The number of elements in the list l will be at least 1 and will not exceed 100.
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
//     (string list) l = ["1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"]
//     Output:
//         (string list) ["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"]
//
//         Inputs:
//             (string list) l = ["1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"]
//             Output:
//                 (string list) ["0.1", "1.1.1", "1.2", "1.2.1", "1.11", "2", "2.0", "2.0.0"]
//
//                 Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
//
public class Answer {
    public static String[] answer(String[] l) {
        class VersionComparator<T> implements java.util.Comparator<T> {
            public int compare(T version1, T version2) {
                int res = 0;
                String[] version1_parts = ((String)version1).split("\\.");
                String[] version2_parts = ((String)version2).split("\\.");
                int number_of_versions = 0;
                if (version1_parts.length < version2_parts.length) {
                    number_of_versions = version1_parts.length;
                } else number_of_versions = version2_parts.length;

                int i = 0;
                while (i < number_of_versions) {
                    String str1 = version1_parts[i];
                    int val1 = Integer.parseInt(str1);
                    String str2 = version2_parts[i];
                    int val2 = Integer.parseInt(str2);
                    res = val1 - val2;
                    if (res != 0) break;
                    i++;
                }
                if (res == 0) {
                    if (version1_parts.length < version2_parts.length) {
                        res = -1;
                    } else res = 1;
                }

                return res;
            }
        }

        java.util.ArrayList<String> arrayList = new java.util.ArrayList<String>(java.util.Arrays.asList(l));
        java.util.Collections.sort(arrayList, new VersionComparator<String>()) ;

        return arrayList.toArray(new String[l.length]);
    }

    static void p(String [] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else System.out.print(arr[i] + ", ");
        }
        System.out.print("]\n");
    }


    public static void main(String [] argv) {
        String[] arr = {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"};
        p(answer(arr));
        String[] arr1 = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
        p(answer(arr1));
        String[] arr2 = {"2.0", "0.2.0", "0.2", "1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
        p(answer(arr2));
        String[] arr3 = {"1", "1.0", "1.0.0"};
        p(answer(arr3));
    }
}
