class Question03_OverloadingExample {

    // Static method with int parameter
    static void display(int a) {
        System.out.println("Static display with int: " + a);
    }

    // Static method with String parameter
    static void display(String s) {
        System.out.println("Static display with String: " + s);
    }

    // Non-static method with int and double
    void display(int a, double b) {
        System.out.println("Non-static display with int and double: " + a + ", " + b);
    }

    // Non-static method with no parameters
    void display() {
        System.out.println("Non-static display with no parameters");
    }

    public static void main(String[] args) {

        Question03_OverloadingExample obj = new Question03_OverloadingExample();

        display(10);
        display("Capgemini");
        obj.display();
        obj.display(5, 10.5);
    }
}
