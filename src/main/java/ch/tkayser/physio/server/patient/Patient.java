package ch.tkayser.physio.server.patient;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tom on 24.11.15.
 */
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "PATEINT_SEQ")
    private long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
