package org.example;

public class Employee implements java.lang.Comparable<Employee> {
    private Integer id;
    private String name;

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}