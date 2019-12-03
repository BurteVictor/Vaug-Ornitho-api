package com.adaming.vaugrenier;

import com.adaming.vaugrenier.service.observation.ObservationServiceImpl;
import com.adaming.vaugrenier.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaugrenierApplication implements CommandLineRunner {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    ObservationServiceImpl observationService;

    public static void main(String[] args) {
        SpringApplication.run(VaugrenierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String genre="Alcedo";
        String species="atthis";
        String vulgarName="Kingfisher";
        String description="the Eurasian kingfisher, " +
                "and river kingfisher, is a small kingfisher with seven subspecies recognized within its wide distribution " +
                "across Eurasia and North Africa. It is resident in much of its range, but migrates from areas where rivers " +
                "freeze in winter.";
        String imageUrl="martin_pecheur.jpg";
        observationService.createObservation(genre, species, vulgarName, description, imageUrl);

        genre="Ardea";
        species="cinerea";
        vulgarName="Grey heron";
        description="A bird of wetland areas, it can be seen around lakes, rivers, ponds, marshes and on the sea coast. " +
                "It feeds mostly on aquatic creatures which it catches after standing stationary beside or in the water or " +
                "stalking its prey through the shallows.";
        imageUrl="vaugrenier_heron.jpg";
        observationService.createObservation(genre, species, vulgarName, description, imageUrl);
    }
}
