package ru.bakigoal.model;

/**
 * Created by ilmir on 15.03.16.
 */
public class Player {

    private final long id;
    private String name;
    private int age;
    private String amplua;

    public Player(long id) {
        this.id = id;
    }

    public Player(long id, String name, int age, String amplua) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.amplua = amplua;
    }

    public long getId() {
        return id;
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

    public String getAmplua() {
        return amplua;
    }

    public void setAmplua(String amplua) {
        this.amplua = amplua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
