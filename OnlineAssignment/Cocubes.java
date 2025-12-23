package OnlineAssignment;

public class Cocubes {

    public int countBmi(int w, double h) {
        double bmi = (double) w / (h * h);

        if (bmi < 18) {
            return 0;
        } else if (bmi >= 18 && bmi <= 25) {
            return 1;
        } else if (bmi > 25 && bmi <= 35) {
            return 2;
        } else if (bmi > 35 && bmi <= 40) {
            return 3;
        } else {
            return 4;
        }
    }

    public String minNumName(String str) {
        String[] arr = str.split(" ");
        int n = arr.length;
        int nameNum = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < n; i++) {
            String name = arr[i];

            int sum = 0;
            for (int j = 0; j < name.length(); j++) {
                int digit = (name.charAt(j) - 'a');
                sum = sum + (digit + 1);
            }

            if (nameNum > sum) {
                nameNum = sum;
                ans = name;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}