/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dto;

/**
 *
 * @author Incognito
 */
public class Person {
    
    //Columns in the table
    protected int personId;
    protected String first_name;
    protected String birth_name;
    protected String birth;
    protected String gender;
    protected String email;
    protected String phone;

    public Person() {
    }

    
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getBirth_name() {
        return birth_name;
    }

    public void setBirth_name(String birth_name) {
        this.birth_name = birth_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
        @Override
    public String toString() {
        return "Person{" + "personId=" + personId + 
                ", first_name=" + first_name + ", birth_name="
                + birth_name + ", birth=" + birth + ", gender=" 
                + gender + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
