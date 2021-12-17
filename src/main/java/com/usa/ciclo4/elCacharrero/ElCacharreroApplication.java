package com.usa.ciclo4.elCacharrero;

import com.usa.ciclo4.elCacharrero.crudRepository.CloneCrudRepository;
import com.usa.ciclo4.elCacharrero.crudRepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElCacharreroApplication implements CommandLineRunner {
        @Autowired
        private CloneCrudRepository cloneRepository;
        
        @Autowired
        private UserCrudRepository userRepository;
        
        
	public static void main(String[] args) {
		SpringApplication.run(ElCacharreroApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        cloneRepository.deleteAll();
        
    }

}
