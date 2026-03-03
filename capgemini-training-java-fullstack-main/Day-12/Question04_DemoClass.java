class Question04_DemoClass {

    // Static Initialization Block 1
    static {
        System.out.println("Static Initialization Block 1 executed");
    }

    // Static Initialization Block 2
    static {
        System.out.println("Static Initialization Block 2 executed");
    }

    // Instance Initialization Block
    {
        System.out.println("Instance Initialization Block executed");
    }

    // Constructor
    Question04_DemoClass() {
        System.out.println("Constructor executed");
    }

    static void staticMethodOne() {
        System.out.println("Static Method One called");
    }

    static void staticMethodTwo() {
        System.out.println("Static Method Two called");
    }

    void displayMessage() {
        System.out.println("Non-static method called");
    }

    public static void main(String[] args) {

        Question04_DemoClass.staticMethodOne();
        Question04_DemoClass.staticMethodTwo();

        Question04_DemoClass obj = new Question04_DemoClass();
        obj.displayMessage();
    }
}
