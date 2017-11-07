package com.epam.rmusabirov.tasks;

import java.util.*;

public class Task17 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(90, "Дмитрий", "Светличный", 80000),
                new Employee(60, "Алексей", "Мельников", 60000),
                new Employee(81, "Семен", "Паршин", 70000)
        );

        Comparator<Person> personComparator = Comparator.comparing(Person::getFirstName);

        Comparator<PhysicalObject> physicalObjectComparator = Comparator.comparingDouble(o -> (o.getWeight()));

    sortByName(personComparator,employees);
        System.out.println(employees);

    sortByWeight(physicalObjectComparator,employees);
        System.out.println(employees);

    List<Object> richGuys = new ArrayList<>();

    selectEmployeesWithSalaryGreaterThen1000(employees, richGuys);
        System.out.println(richGuys);

    List<PhysicalObject> lightObjects = new ArrayList<>();

    selectObjectsWithWeightLessThen50(employees, lightObjects);
        System.out.println(lightObjects);
}

    /**
     * Sorts employees using passed comparator
     * @param comparator for Persons by Name
     * @param employees list
     */
    private static void sortByName(Comparator<Person> comparator, List<Employee> employees) {
        employees.sort(comparator);
    }

    /**
     * Sorts employees using passed comparator
     * @param comparator for PhysicalObjects by weight
     * @param employees list
     */
    private static void sortByWeight(Comparator<PhysicalObject> comparator, List<Employee> employees) {
        employees.sort(comparator);
    }

    /**
     * Searches employees with salary more then 65000 and adds them into richGuys
     * @param employees list of Employee
     * @param richGuys result list
     */
    private static void selectEmployeesWithSalaryGreaterThen1000(List<Employee> employees, List<Object> richGuys) {
        for (Employee emp : employees) {
            if (emp.getSalary() > 65000) {
                richGuys.add(emp);
            }
        }
    }

    /**
     * Searches employees with weight less then 65 and adds them into lightObjects
     * @param employees list of Employee
     * @param lightObjects result list
     */
    private static void selectObjectsWithWeightLessThen50(List<Employee> employees, List<PhysicalObject> lightObjects) {
        for (Employee emp : employees) {
            if (emp.getWeight() < 65) {
                lightObjects.add(emp);
            }
        }
    }

}

abstract class PhysicalObject {

    private final double weight;

    PhysicalObject(double weight) {
        this.weight = weight;
    }

    /**
     * @return Вес.
     */
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }
}

class Person extends PhysicalObject {

    private final String firstName;
    private final String lastName;

    Person(double weight, String firstName, String lastName) {
        super(weight);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return Имя.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Фамилия.
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return super.toString() + " " + firstName + " " + lastName;
    }
}

class Employee extends Person {

    private int salary;

    public Employee(double weight, String firstName, String lastName, int salary) {
        super(weight, firstName, lastName);
        this.salary = salary;
    }

    /**
     * @return Зарплата.
     */
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " " + salary;
    }
}

