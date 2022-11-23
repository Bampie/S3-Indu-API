package S3API.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Profile extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID profileId;
    private String auth0Id;
    private String name;
    private String description;

    @Column(name = "deliveryTime", nullable = true)
    private int deliveryTime;
    private String equipment;
    private String experience;
    private Double price;
    private boolean sellerProfile;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sale> sales;

    public UUID getId() {
        return profileId;
    }

    // constructoren:
    public Profile() {
    }

    public Profile(String auth0Id, int deliveryTime, Double price, boolean sellerProfile) {
        this.auth0Id = auth0Id;
        this.deliveryTime = deliveryTime;
        this.price = price;
        this.sellerProfile = sellerProfile;
    }

    public Profile(UUID profileId, String name, String description, int deliveryTime, String equipment,
            String experience,
            Double price, boolean sellerProfile, List<Sale> sales) {
        this.profileId = profileId;
        this.name = name;
        this.description = description;
        this.deliveryTime = deliveryTime;
        this.equipment = equipment;
        this.experience = experience;
        this.price = price;
        this.sellerProfile = sellerProfile;
        this.sales = sales;
    }

    // getter:
    public UUID getProfileId() {
        return profileId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public boolean getSellerProfile() {
        return sellerProfile;
    }

    public double getPrice() {
        return price;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getExperience() {
        return experience;
    }

    public List<Sale> getSales() {
        return sales;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeliveryTime(int delivery_Time) {
        this.deliveryTime = delivery_Time;
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

    public void setSellerProfile(boolean sellerProfile) {
        this.sellerProfile = sellerProfile;
    }
}
