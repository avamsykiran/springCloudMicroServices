package in.tp.lms.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tp.lms.exception.LoanException;
import in.tp.lms.model.LoanModel;
import in.tp.lms.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService service;
	
	private Logger logger;
	
	public LoanController() {
		logger = Logger.getLogger(LoanController.class.getName());
	}
	
	@GetMapping
	public ResponseEntity<List<LoanModel>> findAll(){
		logger.info("findAll got hit");
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoanModel> findById(@PathVariable("id") long id){
		
		logger.info("findById got hit");
		
		ResponseEntity<LoanModel> result;
		
		LoanModel model = service.findById(id);
		
		if(model==null)
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			result = new ResponseEntity<>(model,HttpStatus.OK);
		
		return result;
	}
	
	@PostMapping
	public ResponseEntity<LoanModel> add(@RequestBody LoanModel model){
		logger.info("add got hit");
		return new ResponseEntity<>(service.add(model),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<LoanModel> save(@RequestBody LoanModel model) throws LoanException{
		logger.info("save got hit");
		return new ResponseEntity<>(service.updateStatus(model.getLoanId(), model.getStatus()),HttpStatus.OK);
	}
}
