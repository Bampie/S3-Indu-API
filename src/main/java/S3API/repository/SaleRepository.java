package S3API.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import S3API.domain.Sale;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class SaleRepository implements PanacheRepositoryBase<Sale, UUID> {

}
