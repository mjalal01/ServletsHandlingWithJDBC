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
public class PersonPk {
    
    protected int personId;

    public PersonPk() {
    }

    public PersonPk(final int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId( final int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "PersonPk{" + "personId=" + personId + '}';
    }
    
    
}
