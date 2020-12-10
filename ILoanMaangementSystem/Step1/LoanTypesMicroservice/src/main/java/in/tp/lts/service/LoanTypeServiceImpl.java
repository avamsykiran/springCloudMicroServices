package in.tp.lts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tp.lts.entity.LoanTypeEntity;
import in.tp.lts.exception.LoanTypeException;
import in.tp.lts.model.LoanTypeModel;
import in.tp.lts.repo.LoanTypeRepo;

@Service
public class LoanTypeServiceImpl implements LoanTypeService {

	@Autowired
	private LoanTypeRepo repo;

	private LoanTypeEntity of(LoanTypeModel source) {
		LoanTypeEntity result = null;
		if (source != null) {
			result = new LoanTypeEntity();
			result.setId(source.getId());
			result.setInterestRatePerAnum(source.getInterestRatePerAnum());
			result.setTypeTitle(source.getTypeTitle());
		}
		return result;
	}

	private LoanTypeModel of(LoanTypeEntity source) {
		LoanTypeModel result =null; 
		if (source != null) {
			result = new LoanTypeModel();
			result.setId(source.getId());
			result.setInterestRatePerAnum(source.getInterestRatePerAnum());
			result.setTypeTitle(source.getTypeTitle());
		}
		return result;
	}

	@Override
	public List<LoanTypeModel> findAll() {
		return repo.findAll().stream().map(entity -> of(entity)).collect(Collectors.toList());
	
		/*	List<LoanTypeEntity> entityList = repo.findAll();
		List<LoanTypeModel> modelList = new ArrayList<>();
		
		for(LoanTypeEntity entity:entityList) {
			modelList.add(of(entity));
		}
		
		return modelList;*/
	}

	@Override
	public LoanTypeModel findById(long loanId) {
		return of(repo.findById(loanId).orElse(null));
	}

	@Override
	public LoanTypeModel add(LoanTypeModel model) {
		return of(repo.save(of(model)));
	}

	@Override
	public void updateInterestRate(long loanId, double rateOfInterest) throws LoanTypeException {
		LoanTypeEntity entity = repo.findById(loanId).orElse(null);
		
		if(entity==null)
			throw new LoanTypeException("No Such Record");
		else {
			entity.setInterestRatePerAnum(rateOfInterest);
			repo.save(entity);
		}
	}

}
