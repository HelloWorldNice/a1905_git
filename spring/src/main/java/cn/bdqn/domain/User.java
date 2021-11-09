package cn.bdqn.domain;

public class User {

    private Integer id;

    private String name;

    public void setId(Integer id) {
        System.out.println("----setId---");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("----setName---");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
