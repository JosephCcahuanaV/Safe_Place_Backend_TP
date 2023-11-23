package Backendproject;


import Backendproject.entities.Authority;
import Backendproject.entities.AuthorityName;
import Backendproject.entities.Local;
import Backendproject.entities.Renter;
import Backendproject.entities.UserSecurity;
import Backendproject.repositories.AuthorityRepository;
import Backendproject.repositories.LocalRepository;
import Backendproject.repositories.RenterRepository;
import Backendproject.repositories.UserSecurityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Date;

@SpringBootApplication
public class BackendAplication {
        
    public static void main(String[] args) {SpringApplication.run(BackendAplication.class, args);}

    @Bean
    public CommandLineRunner mappingDemo(
        AuthorityRepository authorityRepository,
        LocalRepository localRepository,
        UserSecurityRepository userSecurityRepository,
        RenterRepository renterRepository
    ) {
        return args -> {
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

           
                

//     private String name;
//     private String lastname;
//     private String Email;
//     private String numberphone;
//     private String Dni;
//     private String ruc;
//     private String address;
//     private String nacionality;
//     private Long bankAccount ;


//     @OneToOne
//     @JoinColumn(name = "user_Id") // viene de la tabla USER
//     private User user;


//     @OneToMany (mappedBy = "renter") // de uno a muchos con Local
//     private List<Local> locals;
            

            

            /*

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
                localRepository.save(new Local(null, "Centro de Convencions Scencia","Av. La Molina 1135 - La Molina","Somos SCENCIA CENTRO DE CONVENCIONES, establecimiento con más de 10 años de actividad en el mercado y especialista en brindar servicios de espacios y catering con los más altos estándares de calidad para nuestros clientes.", 100L,5000.00,"https://s.ineventos.com/pe/2018/04/123706/centro-de-convenciones-scencia-258190-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local(null, "Access Soluciones","AV. AREQUIPA No. 2053 - DISTRITO DE LINCE","AFORO 240 PERSONAS / SALON AMPLIO / AREA TOTAL 350 MT. 1 COCINA 2 SS.HH. 1 BARRA PARA BARMAN 1 CABINA DE DJ. MOBILIARIO (SOFAS, MESAS, SILLAS) 4 CONGELADORAS AIRE ACONDICIONADO LUCES DECORATI.", 240L,8520.00,"https://s.ineventos.com/pe/2023/09/130091/access-soluciones-336457-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local( null, "GALDOZZ Centro de Convenciones y Eventos","Av Las Convenciones s//n, Jose luis Bustamante y Rivero","Contamos con céntricas y modernas instalaciones, una capacidad de 5000 personas para realizar todo tipo de eventos o espectáculo de gran magnitud.", 650L,15000.00,"https://s.ineventos.com/pe/2019/07/126033/galdozz-centro-de-convenciones-y-287458-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local(null, "Doña Luisa","Parcela G-11 Unidad catastra 11880, Clara Luisa - Pachacamac","Eventos Doña Luisa cuenta con las siguientes instalaciones: - 3 Canchas de futbolito y 1 de futbol de grass natural - Área de cocina - 1 área amplia de grass con árboles ,un puente y más!", 700L,22000.00,"https://s.ineventos.com/pe/2022/05/128662/dona-luisa-319074-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local(null, "El Fogón del Asador","Av. República de Panamá 6574, Barranco","Nuestra propuesta es un servicios de Catering totalmente diferente para sus eventos sociales y empresariales. Estamos especializados en CARNES, PARRILLAS, PASTAS, COCINA CAMPESTRE , PISCOS y VINOS.", 45L,2750.00,"https://s.ineventos.com/pe/2018/08/124374/el-fogon-del-asador-266535-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local(null, "Fundo Don Felman","Fundo Don Felman (Camino a Huacachina) Ica Perú, Urb. Oasis 2da Etapa - Acceso Pje Mar s/n.","Jardín de eventos 2,000 m2 de grass con pileta incluida. Atención de bodas y eventos, salones con portales y piscina, playa de estacionamiento. SS.HH. modernos, terrazas y bar.", 500L,5000.00,"https://s.ineventos.com/pe/2015/07/115923/fundo-don-felman-172832-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local(null, "La Casa del Abuelo","Coop.Excoop Gallinazos Mz H, Lote 11. Altura del km 27.5 Panamericana Norte (Paradero Establo, Puente Piedra)","La Casa del Abuelo, es una hermosa casa de campo ubicada en Puente Piedra, que cuenta con un área de 3000 m2 ideal para todo tipo de eventos!", 300L,6500.00,"https://s.ineventos.com/pe/2018/06/124013/la-casa-del-abuelo-262150-i-640w.jpg", null, null, null, null));
            localRepository.save(new Local(null, "K'acharpari Eventos y Conferencias","Av. Alfonso Ugarte N° 512","Somos una empresa dedicada al rubro de servicios como Restaurante, Peña Show, Eventos Empresariales, Centro de Convenciones, Catering, Concesiones en alimentos corporativos.", 200L,7500.00,"https://s.ineventos.com/pe/2023/09/129976/kacharpari-eventos-y-conferenci-335922-i-640w.jpg", null, null, null, null));
            */
           
            userSecurityRepository.save(new UserSecurity("danilo", new BCryptPasswordEncoder().encode("danilo123"),true,new Date(),
                List.of(authorityRepository.findByName(AuthorityName.ROLE_RENDER)))
            );

            Renter renter = new Renter(null, "danilo", "chavez", "danilo@gmail.com", "976455267", "87654321", "123123123", "Surco,Lima", "Peru", 123123123L, null, null);
            renterRepository.save(renter); 

            localRepository.save(new Local(null, "Centro de Convencions Scencia","Av. La Molina 1135 - La Molina","Somos SCENCIA CENTRO DE CONVENCIONES, establecimiento con más de 10 años de actividad en el mercado y especialista en brindar servicios de espacios y catering con los más altos estándares de calidad para nuestros clientes.", 100L,5000.00,"https://s.ineventos.com/pe/2018/04/123706/centro-de-convenciones-scencia-258190-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local(null, "Access Soluciones","AV. AREQUIPA No. 2053 - DISTRITO DE LINCE","AFORO 240 PERSONAS / SALON AMPLIO / AREA TOTAL 350 MT. 1 COCINA 2 SS.HH. 1 BARRA PARA BARMAN 1 CABINA DE DJ. MOBILIARIO (SOFAS, MESAS, SILLAS) 4 CONGELADORAS AIRE ACONDICIONADO LUCES DECORATI.", 240L,8520.00,"https://s.ineventos.com/pe/2023/09/130091/access-soluciones-336457-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local( null, "GALDOZZ Centro de Convenciones y Eventos","Av Las Convenciones s//n, Jose luis Bustamante y Rivero","Contamos con céntricas y modernas instalaciones, una capacidad de 5000 personas para realizar todo tipo de eventos o espectáculo de gran magnitud.", 650L,15000.00,"https://s.ineventos.com/pe/2019/07/126033/galdozz-centro-de-convenciones-y-287458-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local(null, "Doña Luisa","Parcela G-11 Unidad catastra 11880, Clara Luisa - Pachacamac","Eventos Doña Luisa cuenta con las siguientes instalaciones: - 3 Canchas de futbolito y 1 de futbol de grass natural - Área de cocina - 1 área amplia de grass con árboles ,un puente y más!", 700L,22000.00,"https://s.ineventos.com/pe/2022/05/128662/dona-luisa-319074-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local(null, "El Fogón del Asador","Av. República de Panamá 6574, Barranco","Nuestra propuesta es un servicios de Catering totalmente diferente para sus eventos sociales y empresariales. Estamos especializados en CARNES, PARRILLAS, PASTAS, COCINA CAMPESTRE , PISCOS y VINOS.", 45L,2750.00,"https://s.ineventos.com/pe/2018/08/124374/el-fogon-del-asador-266535-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local(null, "Fundo Don Felman","Fundo Don Felman (Camino a Huacachina) Ica Perú, Urb. Oasis 2da Etapa - Acceso Pje Mar s/n.","Jardín de eventos 2,000 m2 de grass con pileta incluida. Atención de bodas y eventos, salones con portales y piscina, playa de estacionamiento. SS.HH. modernos, terrazas y bar.", 500L,5000.00,"https://s.ineventos.com/pe/2015/07/115923/fundo-don-felman-172832-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local(null, "La Casa del Abuelo","Coop.Excoop Gallinazos Mz H, Lote 11. Altura del km 27.5 Panamericana Norte (Paradero Establo, Puente Piedra)","La Casa del Abuelo, es una hermosa casa de campo ubicada en Puente Piedra, que cuenta con un área de 3000 m2 ideal para todo tipo de eventos!", 300L,6500.00,"https://s.ineventos.com/pe/2018/06/124013/la-casa-del-abuelo-262150-i-640w.jpg", renter, null, null, null));
            localRepository.save(new Local(null, "K'acharpari Eventos y Conferencias","Av. Alfonso Ugarte N° 512","Somos una empresa dedicada al rubro de servicios como Restaurante, Peña Show, Eventos Empresariales, Centro de Convenciones, Catering, Concesiones en alimentos corporativos.", 200L,7500.00,"https://s.ineventos.com/pe/2023/09/129976/kacharpari-eventos-y-conferenci-335922-i-640w.jpg", renter, null, null, null));

        };



                
    }


}
