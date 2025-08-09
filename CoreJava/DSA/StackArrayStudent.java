import java.util.*;

class StackArray{
    private Student []stackOfStudents;
    private int top;

    public StackArray(){
        this.stackOfStudents=new Student[10];
        top=-1;
    }

    public StackArray(int len){
        this.stackOfStudents=new Student[len];
        top=-1;
    }

    //return size of stack
    public int size(){
        return top+1;
    }

    //check if stack is full
    public boolean isFull(){
        return top==stackOfStudents.length-1;
    }

    //check if stack is empty
    public boolean isEmpty(){
        return top==-1;
    }

    //push into stack
    public void push(Student s){
        if(isFull()){
            System.out.println("Stack is full");
            throw new RuntimeException();
        }
        top++;
        stackOfStudents[top]=s;
    }

    //pop from stack
    public Student pop(){
        Student x;
        if(isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        x=stackOfStudents[top];
        top--;
        return x;
    }

    //peek into stack
    public Student peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stackOfStudents[top];
    }

    public void display()
    {
	   if(isEmpty())
	   {
		   System.out.println("Stack is empty");
		   throw new EmptyStackException();
	   }
	   System.out.println("Students are: ");
	   for(int i=top;i>=0;i--)
		   System.out.println(stackOfStudents[i]+" ");
	   System.out.println();
    }

    public Student searchByEmail(String email) {
    if (isEmpty()) {
        System.out.println("Stack is empty");
        return null;
    }
    for (int i = 0; i <= top; i++) {
        if (stackOfStudents[i].getEmail().equals(email))
            return stackOfStudents[i];
    }
    return null; // not found
}

}