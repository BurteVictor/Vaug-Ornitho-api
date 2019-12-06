package com.adaming.vaugrenier;

import com.adaming.vaugrenier.entity.Dates;
import com.adaming.vaugrenier.entity.Role;
import com.adaming.vaugrenier.entity.RoleNameEnum;
import com.adaming.vaugrenier.repository.DatesRepository;
import com.adaming.vaugrenier.repository.RoleRepository;
import com.adaming.vaugrenier.service.observation.ObservationServiceImpl;
import com.adaming.vaugrenier.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VaugrenierApplication implements CommandLineRunner {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    ObservationServiceImpl observationService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    DatesRepository datesRepository;

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
        String day="24";
        String month="January";
        String year="2015";
        Dates date1=new Dates(day,month,year);
        datesRepository.save(date1);
        day="02";
        month="March";
        year="2017";
        Dates date2=new Dates(day,month,year);
        datesRepository.save(date2);
        List<Dates> dates=new ArrayList<>();
        dates.add(date1);
        dates.add(date2);
        String imageUrl="martin_pecheur.jpg";
        observationService.createObservation(genre, species, vulgarName, imageUrl, description,dates);

        genre="Ardea";
        species="cinerea";
        vulgarName="Grey heron";
        description="A bird of wetland areas, it can be seen around lakes, rivers, ponds, marshes and on the sea coast. " +
                "It feeds mostly on aquatic creatures which it catches after standing stationary beside or in the water or " +
                "stalking its prey through the shallows.";

        imageUrl="vaugrenier_heron.jpg";
        observationService.createObservation(genre, species, vulgarName, imageUrl, description,dates);

        Role simpleUser=new Role(RoleNameEnum.USER,"simple user");
        roleRepository.save(simpleUser);
        Role expert=new Role(RoleNameEnum.EXPERT,"expert in ornithology field");
        roleRepository.save(expert);

        List<Role> rolesExpert=new ArrayList<>();
        List<Role> userRole=new ArrayList<>();
        rolesExpert.add(simpleUser);
        rolesExpert.add(expert);
        userRole.add(simpleUser);

        String pseudo="Tryphon";
        String email="vb@gmail.com";
        String password="yoyo";
        userService.register(pseudo,password,email,rolesExpert);

        String pseudo1="Krispy";
        String email1="krispy@gmail.com";
        String password1="mypassword";
        userService.register(pseudo1,password1,email1,userRole);

    }
}
