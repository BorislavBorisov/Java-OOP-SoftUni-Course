public abstract class PersonImpl implements Person{
    private String name;

    protected PersonImpl(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
