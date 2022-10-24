package S3API.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import S3API.Domain.Sale;

@ApplicationScoped
public class SaleRepository implements PanacheRepositoryBase<Sale, UUID> {

}
