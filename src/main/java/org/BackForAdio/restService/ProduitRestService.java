package org.BackForAdio.restService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.BackForAdio.entiites.Produit;
import org.BackForAdio.repository.ProduitRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value="/produits")
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	private Produit saveProduit(Produit produit, @RequestParam(name="file")MultipartFile file) throws IOException {
		
         if(!file.isEmpty()) {
			
			produit.setPhoto(produit.getOurvrier().getUsername()+file.getOriginalFilename());
			
			produit.setDate_creation(new Date());
			
			File converfile = new File("./produitphoto/"+produit.getOurvrier().getUsername()+file.getOriginalFilename());
			
			converfile.createNewFile();
			
			FileOutputStream fout = new FileOutputStream(converfile);
			
			fout.write(file.getBytes());
			
			fout.close();
			
			return produitRepository.save(produit);
			
			
			
		}
		
         else {
        	 
        	 produit.setDate_creation(new Date());
        	 
        	 return produitRepository.save(produit);
        	 
         }
	
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable Long id) {
		
		produitRepository.deleteById(id);
		
		return true;
		
	}
	
	@RequestMapping(value="/chercherProduits", method=RequestMethod.GET)
	public Page<Produit> chercher(@RequestParam(name="mc", defaultValue="")String mc,
			                       @RequestParam(name="page", defaultValue="0")int page,
			                       @RequestParam(name="size", defaultValue="100")int size) {
		
		return produitRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@RequestMapping(value="/getPhoto/{id}", method=RequestMethod.GET, produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getimages(@PathVariable String id) throws FileNotFoundException, IOException{
		
		  Page<Produit> p = chercher(id, 0, 100);
		  
		  ArrayList<String> nom = new ArrayList<String>();
		  
		  for(int i=0; i<p.getContent().size(); i++) {
			  
			  nom.add(p.getContent().get(i).getPhoto());
		  }
		  

			File f = new File("./produitphoto/"+nom.get(0));
			
			return IOUtils.toByteArray(new FileInputStream(f));
			
	}
	
}
