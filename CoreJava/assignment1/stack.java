class StackWork {

    static int max = 10; // Maximum size of the stack
    static int[] stack = new int[max]; // Array to hold stack elements
    static private int top = -1; // Top of the stack

    // Method to push an element onto the stack
    static void push(int j) {
        if (top == max - 1) {
            System.out.println("Stack overflow. Cannot push " + j);
        } else {
            stack[++top] = j;
            System.out.println(j + " pushed onto the stack.");
        }
    }

    // Method to pop an element from the stack
    static int pop() {
        if (top == -1) {
            System.out.println("Stack underflow. No elements to pop.");
            return -1;
        } else {
            int poppedValue = stack[top--];
            System.out.println(poppedValue + " popped from the stack.");
            return poppedValue;
        }
    }

    // Method to peek the top element of the stack
    static int peek() {
        if (top == -1) {
            System.out.println("Stack is empty. No top element.");
            return -1;
        } else {
            System.out.println("Top element is " + stack[top]);
            return stack[top];
        }
    }

    // Method to display all elements in the stack
    public static void displayStack() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements are:");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method for demonstration
    public static void display() {
        System.out.println("------pushing in Stack------");
        push(20);
        push(40);
        push(60);
        push(80);
        displayStack();
        System.out.println("------popping from Stack------");
        pop();
        pop();
        System.out.println("........popping over........");
        System.out.println("-----the final stack-------");
        displayStack();
    }

    public static void main(String[] args) {
        display();
    }
}
