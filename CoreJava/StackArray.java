import java.util.*;

class StackArray{
    private int []stackArray;
    private int top;

    public StackArray(){
        this.stackArray=new int[10];
        top=-1;
    }

    public StackArray(int len){
        this.stackArray=new int[len];
        top=-1;
    }

    //return size of stack
    public int size(){
        return top+1;
    }

    //check if stack is full
    public boolean isFull(){
        return top==stackArray.length-1;
    }

    //check if stack is empty
    public boolean isEmpty(){
        return top==-1;
    }

    //push into stack
    public void push(int value){
        if(isFull()){
            System.out.println("Stack is full");
            throw new RuntimeException();
        }
        top++;
        stackArray[top]=value;
    }

    //pop from stack
    public int pop(){
        int x;
        if(isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        x=stackArray[top];
        top--;
        return x;
    }

    //peek into stack
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public void display()
    {
	   if(isEmpty())
	   {
		   System.out.println("Stack is empty");
		   throw new EmptyStackException();
	   }
	   System.out.println("Array is: ");
	   for(int i=top;i>=0;i--)
		   System.out.println(stackArray[i]+" ");
	   System.out.println();
    }
}