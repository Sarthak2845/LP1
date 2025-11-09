import java.util.Scanner;

class Demo {
    static {
        System.loadLibrary("Demo");
    }

    private native int add(int a, int b);

    private native int sub(int a, int b);

    private native int mul(int a, int b);

    private native int div(int a, int b);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, ch;

        System.out.println("\nEnter value of a : ");
        a = sc.nextInt();
        System.out.println("\nEnter value of b : ");
        b = sc.nextInt();
        Demo d = new Demo();
        do {
            System.out.println("\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.println("\nENTER YOUR CHOICE : ");
            ch = sc.nextInt();
            int result;
            switch (ch) {
                case 1:
                    result = d.add(a, b);
                    System.out.println("\nAddition is : " + result);
                    break;
                case 2:
                    result = d.sub(a, b);
                    System.out.println("\nSubtraction is : " + result);
                    break;
                case 3:
                    result = d.mul(a, b);
                    System.out.println("\nMultiplication is : " + result);
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("\nDivision by zero is not allowed.");
                        break;
                    } else {
                        result = d.div(a, b);
                        System.out.println("\nDivision is : " + result);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is wrong.");
            }
        } while (ch != 5);
        sc.close();
    }
}
