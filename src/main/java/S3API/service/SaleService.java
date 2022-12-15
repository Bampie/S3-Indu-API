package S3API.service;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import S3API.domain.Sale;

@ApplicationScoped
public class SaleService {

    @Inject
    S3API.repository.SaleRepository saleRepository;

    public void addSale(Sale sale) {
        saleRepository.persist(sale);

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
