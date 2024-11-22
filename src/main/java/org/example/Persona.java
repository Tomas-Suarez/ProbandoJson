package org.example;

public class Persona {
    private int id;
    private String user;
    private String password;
    private String name;
    private int age;
    private String details;

    public Persona(int id, String user, String password, String name, int age, String details) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.name = name;
        this.age = age;
        this.details = details;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "JsonArchive{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", details='" + details + '\'' +
                ", id=" + id +
                ", user='" + user + '\'' +
                '}';
    }
}
