package S3API.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import S3API.Domain.Profile;
import S3API.repository.ProfileRepository;

@ApplicationScoped
public class ProfileService {

    @Inject
    ProfileRepository profileRepository;

    public List<Profile> allProfiles() {
        List<Profile> allProfiles = profileRepository.listAll();
        List<Profile> allSellers = new ArrayList<Profile>();

        for (Profile profile : allProfiles) {
            boolean isProfileSeller = profile.isSellerProfile();
            if (isProfileSeller == true) {
                allSellers.add(profile);
            }
        }
        return allSellers;
    }

    public Profile addProfile(Profile profile) {
        profileRepository.persist(profile);
        return profile;
    }

    public Profile getProfileById(String id) {
        Profile profile = profileRepository.findById(id);
        return profile;
    }

    public void deleteProfile(String id) {
        profileRepository.deleteById(id);
    }

    public boolean checkForId(String id) {
        Optional<Profile> profile = profileRepository.findByIdOptional(id);
        boolean isProfile = profile.isPresent();
        return isProfile;
    }
}
