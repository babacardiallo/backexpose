package org.BackForAdio.restService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.BackForAdio.entiites.Ourvrier;
import org.BackForAdio.repository.OuvrierRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/ouvriers")
public class OuvrierRestService {
	
	@Autowired
	private OuvrierRepository ouvrierRepository;
	
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Ourvrier> getOurvriers(){
		
		return ouvrierRepository.findAll();
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Ourvrier saveOuvrier(Ourvrier ourvrier) {
		
		return ouvrierRepository.save(ourvrier);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public boolean deleteOuvrier(@PathVariable String id) {
		
		ouvrierRepository.deleteById(id);
		
		return true;
		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public Ourvrier updateOuvrier(@PathVariable String id, Ourvrier ourvrier) {
		
		ourvrier.setUsername(id);
		
		ourvrier.setDate_creation(new Date());

		return ouvrierRepository.save(ourvrier);
		
	}
	
	@RequestMapping(value="/check/{id}", method=RequestMethod.GET)
	public Ourvrier findOuvrier(@PathVariable String id) {
		
		return ouvrierRepository.getOne(id);
		
	}
	
	@RequestMapping(value="/chercherOuvriers", method=RequestMethod.GET)
	public Page<Ourvrier> chercher(@RequestParam(name="mc", defaultValue="")String mc,
			                       @RequestParam(name="page", defaultValue="0")int page,
			                       @RequestParam(name="size", defaultValue="10")int size) {
		
		return ouvrierRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}

	@RequestMapping(value="/profil/{id}", method=RequestMethod.PUT, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public String changerphoto(@PathVariable String id,  @RequestParam(name="file")MultipartFile file) throws IOException {
		
		Ourvrier ourvrier = ouvrierRepository.getOne(id);
		
		if(!file.isEmpty()) {
			
			ourvrier.setPhoto(id);
			
			ouvrierRepository.save(ourvrier);
			
			File converfile = new File("./userphoto/"+id);
			
			converfile.createNewFile();
			
			FileOutputStream fout = new FileOutputStream(converfile);
			
			fout.write(file.getBytes());
			
			fout.close();
			
			return "upload effectuee";
				
			
		}
		
		else {
			
			return "aucun fichier choisi";
		}
		
	
	}
	@RequestMapping(value="/getphoto/{id}", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImage(@PathVariable String id) throws FileNotFoundException, IOException {
		
		File f = new File("./userphoto/"+id);
		
		return IOUtils.toByteArray(new FileInputStream(f));
		
	
		
	}
}
