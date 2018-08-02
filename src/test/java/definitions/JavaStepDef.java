package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import pages.Cat;
import pages.Dog;
import support.TestContext;

import java.sql.SQLOutput;
import java.util.HashMap;

public class JavaStepDef {
    @Given("^I write java step$")
    public void iWriteJavaStep() throws Throwable {
        System.out.println("some strings");
    }

    @Given("^I print \"([^\"]*)\" argument$")
    public void iPrintArgument(String var) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(var);
        System.out.println(var.toLowerCase());
        System.out.println(var.length());
        System.out.println(var == "Java");
        System.out.println(var.equalsIgnoreCase("Java"));

    }

    @Given("^I create (\\d+) variable \"([^\"]*)\" abd \"([^\"]*)\"$")
    public void iCreateVariableAbd(int numb, String myVar, String myvar) throws Throwable {
        System.out.println(myvar);
        System.out.println(myVar);
        System.out.println(myVar.toUpperCase() + myvar.toUpperCase());
        System.out.println(myvar.length() + " " + myVar.length());
        System.out.println(myvar == myVar);
        System.out.println(myVar.equalsIgnoreCase(myvar));
        if (myvar.contains(myVar)) {
            System.out.println(myVar == myvar);
        }
    }


    @Given("^I perform actions with  \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPerformActionsWithAnd(String var1, String var2) throws Throwable {

        System.out.println(var1 + " " + var2);
        System.out.println(var1.toUpperCase() + var2.toUpperCase());
        System.out.println(var1.equals(var2));
        System.out.println(var1.equalsIgnoreCase(var2));
        System.out.println(var1.contains(var2));


    }

    @Given("^I run operators with (\\d+) and (\\d+)$")
    public void iRunOperatorsWithAnd(int num1, double num2) throws Throwable {
        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);

        if (num1 < num2) {
            System.out.println("first munveer less than second!");
        } else {
            System.out.println("First number larger or equals second");

        }

    }

    @Given("^I compare \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCompareAnd(String my_string1, String my_string2) throws Throwable {
        if (my_string1.equalsIgnoreCase(my_string2)) {
            System.out.println("Atrings are equal");
        } else {
            System.out.println("strings are not equal");
        }

    }

//    @Given("^I print \"([^\"]*)\" for \"([^\"]*)\" page$")
//    public void iPrintForPage(String site, String url) throws Throwable {
//        String site;
//        switch (month) {
//            case 1:
//                monthString = "January";
//                break;
//            case 2:
//                monthString = "February";
//                break;
//            case 3:
//                monthString = "March";
//                break;
//            case 4:
//                monthString = "April";
//                break;
//            case 5:
//                monthString = "May";
//                break;
//            case 6:
//                monthString = "June";
//                break;
//            case 7:
//                monthString = "July";
//        }
//
//    }

    @Given("^I print url for \"([^\"]*)\" page$")
    public void iPrintUrlForPage(String site) {

        if (site.equalsIgnoreCase("google")) {
            System.out.println("http://www.google.com");
            TestContext.getDriver().get("");
        } else if (site.equalsIgnoreCase("sample")){
            System.out.println("http://skryabin.com/webdriver/html/sample.html");

        }else {
            System.out.println("unknown site ");

        }
    }

    @Given("^I print arrays$")
    public void iPrintArrays() throws Throwable {
        String [] groceryList ={"milk", "apple", "pear", "orange"};
        System.out.println(groceryList[2]);
        System.out.println(groceryList[3]);
//        for (int i = 0; i < groceryList.length; i++){
//            System.out.println(groceryList[i]);
//        }
        for (String element : groceryList){
            System.out.println(element);
        }
    }




    @Given("^I create classes$")
    public void iCreateClasses() throws Throwable {
       Cat cat = new Cat("Charlie");
        cat.sleep();
        cat.eat("fish");
        cat.walk();
        cat.meow();

        Dog dog = new Dog();
        dog.sleep();
        dog.eat("meat");
        dog.walk();
        dog.bark();
    }

    @Given("^I define map data$")
    public void iDefineMapData() throws Throwable {
        HashMap<String, String> formData = new HashMap();
        formData.put("username", "skryabin");
        formData.put("email", "slava@skryabin.com");


        System.out.println( formData.get("username"));
        System.out.println( formData.get("email"));
        System.out.println( formData.get("wrong"));
        System.out.println( formData);

    }
}


