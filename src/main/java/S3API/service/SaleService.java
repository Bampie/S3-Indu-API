package S3API.service;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import S3API.Domain.Sale;

@ApplicationScoped
public class SaleService {

    @Inject
    S3API.repository.SaleRepository saleRepository;

    public Sale addSale(Sale sale) {
        saleRepository.persist(sale);
        return sale;
    }

    public List<Sale> GetAllSalesByProfileId(UUID id) {
        List<Sale> saleList = saleRepository.find("profile_profileuuid", id).list();
        return saleList;
    }

    public Sale getSaleById(UUID id) {
        Sale sale = saleRepository.findById(id);
        return sale;
    }

    public void deleteSale(UUID id) {
        saleRepository.deleteById(id);
    }
}