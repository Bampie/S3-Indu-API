package S3API.domain;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Sale extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String title;
    private String description;
    private double price;
    private Date aankoopDatum;
    private String costumerNote;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Profile profile;

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Sale() {
    }

    public Sale(String title, String description, double price, Date aankoopDatum, String costumerNote,
            Profile profile) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.aankoopDatum = aankoopDatum;
        this.costumerNote = costumerNote;
        this.profile = profile;
    }

    public void setCostumerNote(String costumerNote) {
        this.costumerNote = costumerNote;
    }

    public String getCostumerNote() {
        return costumerNote;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAankoopDatum() {
        return aankoopDatum;
    }

    public void setAankoopDatum(Date aankoopDatum2) {
        aankoopDatum = aankoopDatum2;
    }

    public Profile getProfile() {
        return profile;
    }
}
