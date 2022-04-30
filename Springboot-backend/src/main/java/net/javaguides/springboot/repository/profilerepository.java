package net.javaguides.springboot.repository;


import org.springframework.context.annotation.Profile;
//import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.profile;
@Repository
public interface profilerepository extends JpaRepository<profile, Long>{

	Profile save(Profile profile);

	//Profile save(Profile profile);
	

}
