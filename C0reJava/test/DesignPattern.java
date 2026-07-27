class FactoryDesignPattern {
    private FactoryDesignPattern(){}
    public static FactoryDesignPattern getInstance(){
        return new FactoryDesignPattern();
    }
    public void work(){
        IO.println("Do the work using FactoryDesignPattern!!!");
    }
}

class SingletonDesignPattern {
    public final static SingletonDesignPattern pattern=new SingletonDesignPattern();
    private SingletonDesignPattern(){}
    public static SingletonDesignPattern getInstance(){
        return pattern;
    }
    public void work(){
        IO.println("Do the work using SingletonDesignPattern!!!");
    }
}

class Testing{
    public static void main(String[] args) {
        FactoryDesignPattern f = FactoryDesignPattern.getInstance();
        f.work();
        SingletonDesignPattern s = SingletonDesignPattern.getInstance();
        s.work();
    }
}