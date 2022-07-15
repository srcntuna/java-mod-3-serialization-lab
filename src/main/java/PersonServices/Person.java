package PersonServices;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    private transient String note = "this is a transient variable";


    public Person(){

    }

    public Person(String firstName, String lastName, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }



    public Person(String personCSV) {
        String[] personValues = personCSV.split(",");
        this.firstName = personValues[0];
        this.lastName = personValues[1];
        this.birthYear = Integer.parseInt(personValues[2]);
        this.birthMonth = Integer.parseInt(personValues[3]);
        this.birthDay = Integer.parseInt(personValues[4]);
        System.out.println("Initialized person object from CSV string");
        System.out.println(this);
    }

    public String toString() {
        StringBuffer personString = new StringBuffer();
        personString.append("firstName = " + firstName);
        personString.append("\n");
        personString.append("lastName = " + lastName);
        personString.append("\n");
        personString.append("Birth date = ");
        personString.append(birthMonth + "/");
        personString.append(birthDay+ "/");
        personString.append(birthYear);
        personString.append("\n");

        return personString.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String formatAsCSV() {
        StringBuffer personString = new StringBuffer();
        personString.append(firstName);
        personString.append(",");
        personString.append(lastName);
        personString.append(",");
        personString.append(birthYear);
        personString.append(",");
        personString.append(birthMonth);
        personString.append(",");
        personString.append(birthDay);

        return personString.toString();
    }
}