public class JK implements Student{
    public String name;
    public String school;

    @Override
    public void studying(){
        System.out.println(this.getName() + " is studying.");
    }

    @Override
    public void resting(){
        System.out.println(this.getName() + " is resting.");
    }

    @Override
    public String getName(){
        return this.name;
    }

    public JK(String name, String school) {
        this.name = name;
        this.school = school;
    }

    public JK() {
    }
}
