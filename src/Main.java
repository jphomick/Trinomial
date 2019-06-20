import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the depth of the Trinomial Triangle:");
        int depth = read.nextInt();
        int girth = (depth * 2) - 1;
        String tabs = "\t";
        if (depth > 8) {
            tabs = "\t\t";
        }
        String singleTab = "\t";
        ArrayList<Integer> currLine = new ArrayList<>();
        ArrayList<Integer> prevLine = new ArrayList<>();
        for (int i = 0; i < girth; i++) {
            if (i == ((girth + 1) / 2) - 1) {
                currLine.add(1);
                prevLine.add(1);
                System.out.print(currLine.get(i) + tabs);
            } else {
                currLine.add(0);
                prevLine.add(0);
                System.out.print(" " + tabs);
            }
        }
        System.out.println();
        for (int j = 0; j < depth - 1; j++) {
            for (int k = 0; k < girth; k++) {
                int left, middle, right;
                if (k > 0) {
                    left = prevLine.get(k - 1);
                } else {
                    left = 0;
                }
                middle = prevLine.get(k);
                if (k == girth - 1) {
                    right = 0;
                } else {
                    right = prevLine.get(k + 1);
                }
                currLine.set(k, left + middle + right);
                if (currLine.get(k) == 0) {
                    System.out.print(" " + tabs);
                } else {
                    if (currLine.get(k) >= 1000) {
                        System.out.print(currLine.get(k) + singleTab);
                    } else {
                        System.out.print(currLine.get(k) + tabs);
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < girth; i++) {
                prevLine.set(i, currLine.get(i));
            }
        }
    }
}
