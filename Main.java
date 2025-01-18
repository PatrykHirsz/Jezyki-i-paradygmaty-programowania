package App;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Company company = Utils.initData();
        Utils.printBanner("Panel administracyjny firmy " + company.getName());

        boolean done = false;
        while (!done) {

            System.out.println("Dostępne operacje:");
            System.out.println("1 - Wyświetl pracowników");
            System.out.println("2 - Dodaj pracownika");
            System.out.println("3 - Zwolnij pracownika");
            System.out.println("4 - Aktualizuj dane pracownika");
            System.out.println("5 - Pokaż szczegóły pracownika");
            System.out.println("0 - Zakończ program");
            System.out.println();

            int choice = Utils.inputInt("Wybierz operację: ");

            switch (choice) {
                case 1 -> company.getEmployees().forEach(employee -> 
                        System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + " " + employee.getSurname()));
                case 2 -> {
                    String name = Utils.inputString("Podaj imię: ");
                    String surname = Utils.inputString("Podaj nazwisko: ");
                    Employee newEmployee = company.addEmployee(name, surname);
                    Utils.printAnswer("Dodano pomyślnie pracownika: %s %s z ID: %d".formatted(name, surname, newEmployee.getId()));
                }
                case 3 -> {
                    int deleteId = Utils.inputInt("Podaj ID pracownika do usunięcia: ");
                    boolean removed = Utils.removeEmployee(company, deleteId);
                    if (removed) {
                        Utils.printAnswer("Pracownik o ID %d został usunięty.".formatted(deleteId));
                    } else {
                        Utils.printAnswer("Nie znaleziono pracownika o ID %d.".formatted(deleteId));
                    }
                }
                case 4 -> {
                    int updateId = Utils.inputInt("Podaj ID pracownika do aktualizacji: ");
                    Optional<Employee> employeeOpt = Utils.findEmployee(company, updateId);
                    if (employeeOpt.isPresent()) {
                        Employee employee = employeeOpt.get();
                        Utils.updateEmployee(employee);
                    } else {
                        Utils.printAnswer("Nie znaleziono pracownika o ID %d.".formatted(updateId));
                    }
                }
                case 5 -> {
                    int detailId = Utils.inputInt("Podaj ID pracownika: ");
                    Optional<Employee> detailEmployee = Utils.findEmployee(company, detailId);
                    if (detailEmployee.isPresent()) {
                        Utils.printAnswer(detailEmployee.get().toString());
                    } else {
                        Utils.printAnswer("Nie znaleziono pracownika o ID %d.".formatted(detailId));
                    }
                }
                case 0 -> {
                    Utils.printAnswer("Do zobaczenia");
                    done = true;
                }
                default -> Utils.printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            }
        }
    }
}
