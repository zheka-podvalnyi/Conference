package ua.nure.podvalnyi.db.entity;

import java.sql.Date;
import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String middleName;
    private String lastName;
    private String mail;
    private Date birthday;
    private String login;
    private String password;
    private String permission;


    public User(String name, String middleName, String lastName, String mail, Date birthday, String login, String password, String permission) {

        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mail = mail;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", birthday=" + birthday +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                middleName.equals(user.middleName) &&
                lastName.equals(user.lastName) &&
                mail.equals(user.mail) &&
                birthday.equals(user.birthday) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                permission.equals(user.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, middleName, lastName, mail, birthday, login, password, permission);
    }
}
