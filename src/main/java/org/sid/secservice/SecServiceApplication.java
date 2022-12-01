package org.sid.secservice;

import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
@EnableDiscoveryClient

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return  args -> {
            accountService.addNewRole(new AppRole(null,"Admin"));
            accountService.addNewRole(new AppRole(null,"gestEvent"));
            accountService.addNewRole(new AppRole(null,"Profisseur"));
            accountService.addNewRole(new AppRole(null,"etudiant"));
            accountService.addNewRole(new AppRole(null,"vendeur"));

            accountService.addNewUser( new AppUser(null,"admin","95475558","dali@dali.com","202154254","1234",new ArrayList<>()));
            accountService.addNewUser( new AppUser(null,"adminstrative","95475558","edu@edu.com","202154254","1234",new ArrayList<>()));
            accountService.addNewUser( new AppUser(null,"prof","95475558","prof@prof.com","202154254","1234",new ArrayList<>()));
            accountService.addNewUser( new AppUser(null,"vendeure","95475558","vendeur@vendeur.com","202154254","1234",new ArrayList<>()));
            accountService.addNewUser( new AppUser(null,"etudiant","95475558","etudiant@etudiant.com","202154254","1234",new ArrayList<>()));


            accountService.addRoleToUser("admin","Admin");
            accountService.addRoleToUser("adminstrative","gestEvent");
            accountService.addRoleToUser("prof","Profisseur");
            accountService.addRoleToUser("etudiant","etudiant");
            accountService.addRoleToUser("vendeure","vendeur");


        };
    }
}
