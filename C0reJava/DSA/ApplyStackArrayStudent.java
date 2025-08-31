import java.util.Scanner;

class ApplyStackArrayStudent {
    public static void main(String args[]) {
        int choice;
        Student x;
        Scanner sc = new Scanner(System.in);
        StackArray st = new StackArray(8);

        while (true) {
            System.out.println("1. Push a new student.");
            System.out.println("2. Pop a student.");
            System.out.println("3. Display the top student.");
            System.out.println("4. Display all students.");
            System.out.println("5. Display the size of the stack.");
            System.out.println("6. Search student by his/her email.");
            System.out.println("7. Quit.\n");
            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 7)
                break;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    Student s = new Student(id, name, email);
                    st.push(s);
                    break;

                case 2:
                    x = st.pop();
                    System.out.println("Popped student is: " + x);
                    break;

                case 3:
                    System.out.println("Student at the top is: " + st.peek());
                    break;

                case 4:
                    st.display();
                    break;

                case 5:
                    System.out.println("Size of the stack is: " + st.size());
                    break;

                case 6: // search by email
                    System.out.print("Enter email to search: ");
                    String searchEmail = sc.nextLine();
                    Student found = st.searchByEmail(searchEmail);
                    if (found != null) {
                        System.out.println("Student found: " + found);
                    } else {
                        System.out.println("No student found with that email.");
                    }
                    break;

                default:
                    System.out.println("WRONG CHOICE!!!!");
            }
            System.out.println();
        }
        sc.close();
    }
}
