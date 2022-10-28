package S3API.recource;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import S3API.Domain.Profile;
import S3API.service.ProfileService;

@Path("/api/profiles")
public class ProfileResource {

    @Inject
    ProfileService profileService;

    @GET
    public List<Profile> allProfiles() {
        return profileService.allProfiles();
    }

    @POST
    public Response addProfile(Profile profile) {
        Profile profileWihtId = profileService.addProfile(profile);
        return Response.created(URI.create("/api/profiles/" + profileWihtId.getId())).build();
    }

    @Path("/{id}")
    @GET
    public Profile GetProfileById(String id) {
        Profile profile = profileService.getProfileById(id);
        return profile;
    }

    @Path("/check/{id}")
    @GET
    public boolean idInUse(String id) {
        boolean foundId = profileService.checkForId(id);
        return foundId;
    }
}
