package S3API.service;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import S3API.Domain.Profile;
import S3API.repository.ProfileRepository;

@ApplicationScoped
public class ProfileService {

    @Inject
    ProfileRepository profileRepository;

    public List<Profile> allProfiles() {
        return profileRepository.listAll();
    }

    public Profile addProfile(Profile profile) {
        profileRepository.persist(profile);
        return profile;
    }

    public Profile getProfileById(UUID id) {
        Profile profile = profileRepository.findById(id);
        return profile;
    }

    public void deleteProfile(UUID id) {
        profileRepository.deleteById(id);
    }
}
