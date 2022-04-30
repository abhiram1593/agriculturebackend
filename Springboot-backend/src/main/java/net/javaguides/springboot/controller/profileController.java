package net.javaguides.springboot.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.Profiles;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.profile;
import net.javaguides.springboot.repository.profilerepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(allowedHeaders="*",origins="*")
public class profileController {
	@Autowired
	private profilerepository profilerepository;
	
	@GetMapping("/profile") 
	public List<profile> getAllProfile(){
		return profilerepository.findAll();
	}

	@PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile profile) {
    	return profilerepository.save(profile);
    	
    }
	/*@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/profile/{loanid}")
	public ResponseEntity<profile> getLoanId(@PathVariable Long id) {
		profile profile=profilerepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("check the id:"+id));
	return ResponseEntity.ok(profile);
	}*/
	
	@PutMapping("/profile/{loanid}")
	public ResponseEntity<profile> updateprofile(@PathVariable Long id, @RequestBody profile profiledetails){
	
			profile profile=profilerepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("check the id:"+id));
			profile.setName(profiledetails.getName());
			profile.setPh_number(profile.getPh_number());
			profile.setEmail_id(profile.getEmail_id());
			profile.setAddress(profile.getAddress());
			profile.setMonthlyemi(profile.getMonthlyemi());
			
			
			profile updatedprofile =profilerepository .save(profile);
			return ResponseEntity.ok(updatedprofile);
			
	}
	@DeleteMapping("/profile/delete/{loanid}")
	public ResponseEntity<Map<String, Boolean>> deleteprofile(@PathVariable Long loanid){
		profile profile=profilerepository.findById(loanid)
				.orElseThrow(() -> new ResourceNotFoundException("check the id:"+loanid));
		profilerepository.delete(profile);
		Map<String, Boolean>response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
