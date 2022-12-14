package S3API.recource;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import S3API.domain.Profile;
import S3API.service.ProfileService;
import io.vertx.core.json.JsonObject;

@Path("/api/profiles")
public class ProfileResource {

    @Inject
    ProfileService profileService;

    @GET
    public List<Profile> allProfiles() {
        return profileService.allProfiles();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response addProfile(Profile profile) {
        Profile profileWihtId = profileService.addProfile(profile);
        return Response.created(URI.create("/api/profiles/" + profileWihtId.getProfileId())).build();
    }

    @Path("/edit")
    @PUT
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({ MediaType.APPLICATION_JSON })
    public void editProfile(Profile profile) {
        profileService.editProfile(profile);
    }

    @Path("/{id}")
    @GET
    public Profile getProfileById(String id) {
        return profileService.getProfileById(id);
    }

    @Path("/check/{id}")
    @GET
    public JsonObject idInUse(String id) {
        boolean foundId = profileService.checkForId(id);
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.put("isIdFound", foundId);
        return jsonResponse;
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void deleteProfile(String id) {
        profileService.deleteProfile(id);
    }

    @Path("/counting")
    @GET
    @Transactional
    public boolean asyncTest() {
        boolean q = false;
        for (int i = 1; i <= 20; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            if (i == 20) {
                q = true;
                return q;
            }
        }
        return q;
    }
}
