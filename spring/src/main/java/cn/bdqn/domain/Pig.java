package cn.bdqn.domain;

public class Pig {
    private String username;
    public Pig(String username) {
        this.username = username;
    }

    public Pig() {
    }

    @Override
    public String toString() {
        return "Pig{" +
                "username='" + username + '\'' +
                '}';
    }
}
