package App;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Utils {
    static Company initData() {
        Person firstPerson = new Person("Jan", "Testowy");
        Person secondPerson = new Person("Kazimierz", "Przykładowy");
        Person thirdPerson = new Person("Maria", "Demo");

        Company company = new Company("Super Firma");

        Person.initializeIdCounter(company.getEmployees().size());

        Employee firstEmployee = new Employee(firstPerson, Departament.SALES);
        Employee secondEmployee = new Employee(secondPerson, Departament.ADMINISTRATION);
        Employee thirdEmployee = new Employee(thirdPerson, Departament.FINANCE);

        List<Employee> employees = company.getEmployees();
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);

        return company;
    }

    static void printBanner(String text) {
        String border = "+" + "-".repeat(text.length() + 2) + "+";
        System.out.println(border);
        System.out.println("| " + text + " |");
        System.out.println(border);
    }

    static void printAnswer(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    static int inputInt(String message) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            return input.nextInt();
        } catch (InputMismatchException e) {
            printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            return inputInt(message);
        }
    }

    static String inputString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }


    static void updateEmployee(Employee employee) {

        String newName = inputString("Podaj nowe imię: ");

        String newSurname = inputString("Podaj nowe nazwisko: ");

        employee.setName(newName);

        employee.setSurname(newSurname);

        printAnswer("Dane pracownika zostały zaktualizowane.");

    }

    public static Optional<Employee> findEmployee(Company company, int id) {

    return company.getEmployees().stream()

            .filter(employee -> employee.getId() == id)

            .findFirst();

}

    public static boolean removeEmployee(Company company, int id) {

        Optional<Employee> employeeOpt = findEmployee(company, id);

        if (employeeOpt.isPresent()) {

            Employee employee = employeeOpt.get();

            company.getEmployees().remove(employee);

            return true;

        }

        return false;

    }



}
