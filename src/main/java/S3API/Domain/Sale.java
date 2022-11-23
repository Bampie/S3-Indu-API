package S3API.domain;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Sale extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID salesUuid;
    private String title;
    private String description;
    private double price;
    private Date aankoopDatum;

    @ManyToOne
    private Profile profile;

    public UUID getId() {
        return salesUuid;
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

    public Number getPrice() {
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
}
