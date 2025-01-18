package App;

public class Person {
    private static int idCounter = 0;
    private final int id;
    private String name;
    private String surname;
    private Address address;

    public Person(String name, String surname) {
        this.id = idCounter++;
        this.name = name;
        this.surname = surname;
    }

    public static void initializeIdCounter(int startingValue) {
        idCounter = startingValue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String city, String street) {
        this.address = new Address(city, street);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + " " + surname;
    }
}
