package S3API.service;

import java.util.ArrayList;
import java.util.List;

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
            boolean isProfileSeller = profile.getSellerProfile();
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
        Profile profile = profileRepository.find("auth0Id", id).firstResult();
        return profile;
    }

    public void deleteProfile(String id) {
        profileRepository.find("auth0Id", id).firstResult().delete();
    }

    public boolean checkForId(String id) {
        boolean isProfile = true;
        Profile profile = profileRepository.find("auth0Id", id).firstResult();
        if (profile == null) {
            isProfile = false;
        }
        return isProfile;
    }

    public void editProfile(Profile newProfile) {
        String profileId = newProfile.getAuth0Id();
        Profile updatingProfile = profileRepository.find("auth0Id", profileId).firstResult();
        updatingProfile.setName(newProfile.getName());
        updatingProfile.setDescription(newProfile.getDescription());
        updatingProfile.setDelivery_Time(newProfile.getDelivery_Time());
        updatingProfile.setPrice(newProfile.getPrice());
        updatingProfile.setSellerProfile(newProfile.getSellerProfile());
        updatingProfile.setequipment(newProfile.getEquipment());
        updatingProfile.setexperience(newProfile.getExperience());

        profileRepository.persist(updatingProfile);
    }
}
