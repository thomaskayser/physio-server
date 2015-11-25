package ch.tkayser.physio.patient;

import javax.persistence.Entity;

/**
 * Created by Tom on 24.11.15.
 */
@Entity
public class Patient {

    private long id;
    private String lastName;
    private String firstName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
