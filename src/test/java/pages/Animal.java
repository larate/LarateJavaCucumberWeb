package pages;

public abstract class Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Animal() {
        name = "nameless";
    }

    public void walk() {
        System.out.println(getClass() + " walking!");

    }

    public void sleep() {
        System.out.println(getClass() + " sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass() + " eating " + what);
    }
}
