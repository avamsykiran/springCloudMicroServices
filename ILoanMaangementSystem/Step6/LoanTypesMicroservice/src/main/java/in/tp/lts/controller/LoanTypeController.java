package in.tp.lts.controller;

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

import in.tp.lts.exception.LoanTypeException;
import in.tp.lts.model.LoanTypeModel;
import in.tp.lts.service.LoanTypeService;

@RestController
@RequestMapping("/loanTypes")
public class LoanTypeController {

	@Autowired
	private LoanTypeService service;
	
	private Logger logger;
	
	public LoanTypeController() {
		logger = Logger.getLogger(LoanTypeController.class.getName());
	}
	
	@GetMapping
	public ResponseEntity<List<LoanTypeModel>> findAll(){
		logger.info("findAll method got hit");
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoanTypeModel> findById(@PathVariable("id") long id){
		
		logger.info("findById method got hit");
		ResponseEntity<LoanTypeModel> result;
		LoanTypeModel model = service.findById(id);
		if(model==null)
			result =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			result =  new ResponseEntity<>(model,HttpStatus.OK);
		return result;
	}
	
	@PostMapping
	public ResponseEntity<LoanTypeModel> add(@RequestBody LoanTypeModel model){
		logger.info("add method got hit");
		model = service.add(model);
		return new ResponseEntity<>(model,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<LoanTypeModel> update(@RequestBody LoanTypeModel model) throws LoanTypeException{
		logger.info("update method got hit");
		service.updateInterestRate(model.getId(), model.getInterestRatePerAnum());
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
}
