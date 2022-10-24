package S3API.recource;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import S3API.Domain.Sale;
import S3API.service.SaleService;

@Path("/api/sale")
public class SaleResource {

    @Inject
    SaleService saleService;

    @Path("/profileId/{id}")
    @GET
    public List<Sale> allSalesByProfileId(UUID id) {
        return saleService.GetAllSalesByProfileId(id);
    }

    @POST
    public void addSale(Sale sale) {
        saleService.addSale(sale);
    }

    @Path("/findById/{id}")
    @GET
    public Sale getSaleById(UUID id) {
        Sale sale = saleService.getSaleById(id);
        return sale;
    }
}
