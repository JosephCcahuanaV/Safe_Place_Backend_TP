package Backendproject;


import Backendproject.entities.Authority;
import Backendproject.entities.AuthorityName;
import Backendproject.entities.UserSecurity;
import Backendproject.repositories.AuthorityRepository;
import Backendproject.repositories.UserSecurityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackendAplication {

    //Prueba1
    public static void main(String[] args) {SpringApplication.run(BackendAplication.class, args);}


    @Bean

    public CommandLineRunner mappingDemo(


            AuthorityRepository authorityRepository,
            UserSecurityRepository userSecurityRepository
    ) {
        return args -> {
            //CRUD

            authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
            authorityRepository.save(new Authority(AuthorityName.ROLE_PRINCIPAL));
            authorityRepository.save(new Authority(AuthorityName.ROLE_RENDER));
            authorityRepository.save(new Authority(AuthorityName.ROLE_CLIENT));

            authorityRepository.saveAll(
                    List.of(
                            new Authority(AuthorityName.READ),
                            new Authority(AuthorityName.WRITE)
                    )
            );



            userSecurityRepository.save(
                    new UserSecurity("ahxeluis", new BCryptPasswordEncoder().encode("ahxel100000"),true,new Date(),
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN),
                                    authorityRepository.findByName(AuthorityName.ROLE_PRINCIPAL),
                                    authorityRepository.findByName(AuthorityName.WRITE)
                            )
                    )
            );

            userSecurityRepository.save(
                    new UserSecurity("joseph123", new BCryptPasswordEncoder().encode("joseph123"),true,new Date(),
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN),
                                    authorityRepository.findByName(AuthorityName.ROLE_PRINCIPAL),
                                    authorityRepository.findByName(AuthorityName.WRITE)
                            )
                    )
            );

            userSecurityRepository.save(
                    new UserSecurity("carlos", new BCryptPasswordEncoder().encode("serna123"),true,new Date(),
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_CLIENT),
                                    authorityRepository.findByName(AuthorityName.WRITE)
                            )
                    )
            );

            userSecurityRepository.save(
                    new UserSecurity("danilo", new BCryptPasswordEncoder().encode("danilo123"),true,new Date(),
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_RENDER),
                                    authorityRepository.findByName(AuthorityName.WRITE)
                            )
                    )
            );


        };
    }


}
