package S3API.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import S3API.domain.Profile;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ProfileRepository implements PanacheRepositoryBase<Profile, UUID> {

}
