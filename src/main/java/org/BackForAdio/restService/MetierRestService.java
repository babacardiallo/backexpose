package org.BackForAdio.restService;

import java.util.List;

import org.BackForAdio.entiites.Metier;
import org.BackForAdio.repository.MetierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/metiers")
public class MetierRestService {

	@Autowired
	private MetierRepository metierRepository;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Metier> getMetiers(){
		
		return metierRepository.findAll();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Metier saveMetier( Metier metier) {
		
		return metierRepository.save(metier);
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public boolean deleteMetier(@PathVariable String id) {
		
		metierRepository.deleteById(id);
		
		return true;
		
	}
	
	
	

}
