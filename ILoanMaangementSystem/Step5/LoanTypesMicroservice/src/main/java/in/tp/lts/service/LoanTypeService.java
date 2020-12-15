package in.tp.lts.service;

import java.util.List;

import in.tp.lts.exception.LoanTypeException;
import in.tp.lts.model.LoanTypeModel;

public interface LoanTypeService {
	List<LoanTypeModel> findAll();
	LoanTypeModel findById(long loanId);
	LoanTypeModel add(LoanTypeModel model);
	void updateInterestRate(long loanId,double rateOfInterest) throws LoanTypeException;
}
