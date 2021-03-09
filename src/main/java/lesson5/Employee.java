package lesson5;

import org.jetbrains.annotations.NotNull;

public class Employee {

    private String firstname;
    private String secname;
    private String surname;
    protected String Fullname;
    protected String position;
    protected String email;
    protected String cellNumber;
    protected double salary;
    private int age;
    private static int empCount;
    private String str;

    public Employee(String firstname, String secname, String surname, int age, String position, String email, String cellNumber, double salary) {
        this.Fullname = getFullName(firstname, secname, surname);
        this.age = age;
        this.position = position;
        this.email = email;
        this.cellNumber = cellNumber;
        this.salary = salary;

        System.out.printf("Офисный раб добавлен. Имя: %s(%sл), всего рабов: %d%n", Fullname, age, ++empCount);
    }
    public Employee(String firstname, String secname, String surname, int age) {
        this.Fullname = getFullName(firstname, secname, surname);
        this.age = age;
        setPosition();
        setCellNumber();
        setEmail();
        setSalary();
    }



    private String getFullName(String firstname, String secname, String surname){
        return doCapitalize(firstname) + " " + doCapitalize(secname) + " " + doCapitalize(surname);
    }

    private @NotNull String doCapitalize(String str){
        //this.str = str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }

    public static int getEmpCount() {
        return empCount;
    }

    void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Имя раба: " + Fullname + ", место на галере: " + position + ", возраст: " + age + ", email: " + email + ", телефон: " + cellNumber;
    }

    public void incAge() {
        age++;
    }

    public void setAge(int age) {
        if (age >= 18 && age < 65) {
            this.age = age;
        } else {
            System.err.println("Недопустимый возраст");
        }
    }

    public String getPosition() {
        return position;
    }
    public String getCellNumber() {
        return cellNumber;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setPosition() {
        this.position = "Просто какой-то раб";
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmail() {
        this.email = "noreply@gooooooogle.zx";
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    public void setCellNumber() {
        this.cellNumber = "+7-000-000-00-00";
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
    private void setSalary() {
        this.salary = 0;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Раб " + Fullname + " сбежал");
        empCount--;
    }
}
