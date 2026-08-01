import java.util.*;

class Test23 {

    final int i = 0;
    static int j;
    public static void main(String[] args) {
        Map.Entry<Integer, String> m1; //eta sikhte hobe!!!

        IO.println(new Test23().i);
        final int i;
        i=100;
        IO.println(i);
        IO.println(Test23.j);
        j=999;
        IO.println(Test23.j+" "+j);

        int []x[]={{},{},{}};
        IO.println(x.getClass());
        IO.println(Arrays.toString(x));

        int y[]=new int[-0];

        int []z = new int[2];
        IO.println(z.getClass()+" "+z[0]+" "+z[1]+" length is: "+z.length);
        z[0]=10; z[1]=90;
        for(int m:z)
            IO.println(m);
        for(int a=0; a<z.length; a++){
            IO.println((double)z[a]);
        }

        final int w[];
        w=new int[]{1,2,3,4,5};
        IO.println(Arrays.toString(w));

        Number n[] = new Integer[10];
        n = new Float[10];
        n = new Double[10];
        n = new Long[10];
        n = new Byte[10];
        n = new Short[10];

        IO.println(n.getClass());
    }
}