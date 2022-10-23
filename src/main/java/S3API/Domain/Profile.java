package S3API.Domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

//import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Profile extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID profileUuid;
    private String name;
    private String description;
    private int delivery_Time;
    private String equipment;
    private String experience;
    private Double price;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sale> sales;

    public UUID getId() {
        return profileUuid;
    }

    // constructoren:
    public Profile() {
    }

    public Profile(String name, String description, int delivery_Time, String equipment, String experience,
            double price, List<Sale> sales) {
        this.name = name;
        this.description = description;
        this.delivery_Time = delivery_Time;
        this.equipment = equipment;
        this.experience = experience;
        this.price = price;
        this.sales = sales;
    }

    // getter:
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDelivery_Time() {
        return delivery_Time;
    }

    public String getequipment() {
        return equipment;
    }

    public String getexperience() {
        return experience;
    }

    public double getPrice() {
        return price;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDelivery_Time(int delivery_Time) {
        this.delivery_Time = delivery_Time;
    }

    public void setequipment(String equipment) {
        this.equipment = equipment;
    }

    public void setexperience(String experience) {
        this.experience = experience;
    }

    public void setPrice(double prive) {
        this.price = prive;
    }
}
