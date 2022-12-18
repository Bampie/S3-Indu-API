package S3API.service;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import S3API.domain.Profile;
import S3API.domain.Sale;
import io.quarkus.logging.Log;

@ApplicationScoped
public class SaleService {

    @Inject
    S3API.repository.SaleRepository saleRepository;

    public void addSale(Sale sale) {
        Sale newSale = new Sale();
        newSale.setAankoopDatum(sale.getAankoopDatum());
        newSale.setCostumerNote(sale.getCostumerNote());
        newSale.setDescription(sale.getDescription());
        newSale.setPrice(sale.getPrice());
        newSale.setProfile(sale.getProfile());
        newSale.setTitle(sale.getTitle());
        Log.info(newSale.getProfile().getProfileId());

        saleRepository.persist(newSale);
    }

    public List<Sale> getAllSalesByProfileId(UUID id) {
        return saleRepository.find("profile_profileuuid", id).list();
    }

    public Sale getSaleById(UUID id) {
        return saleRepository.findById(id);
    }

    public void deleteSale(UUID id) {
        saleRepository.deleteById(id);
    }
}
