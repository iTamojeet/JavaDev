import java.lang.reflect.Field;

class User {
    private final String role;

    User() {
        this.role = "developer";
    }

    public String getRole() {
        return this.role;
    }
    // public void setRole(String role){
    // this.role=role;
    // }
}

class JavaNew {
    public static void main(String[] args) {
        User u = new User();
        IO.println(u.getRole());
        // u.setRole("admin");
        IO.println(u.getRole());
        try {
            Field f = User.class.getDeclaredField("role");
            f.setAccessible(true);
            f.set(u, "HR");
            IO.println("getter after " + u.getRole());
            IO.println("field after " + new User().getRole());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            System.out.println(e);
        }
    }
}

class A {
    A(int i) {
        this.i = i;
    }

    final int i;
    int j;

    void ff() {
        final int g;
    }
}