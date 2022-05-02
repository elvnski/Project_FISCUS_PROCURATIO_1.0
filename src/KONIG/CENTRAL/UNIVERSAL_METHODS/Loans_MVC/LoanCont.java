package KONIG.CENTRAL.UNIVERSAL_METHODS.Loans_MVC;

public class LoanCont {
    private LoanModel LN_Model;

    public LoanCont(LoanModel LN_Mod) {
        this.LN_Model = LN_Mod;
    }

    public String getLoanNumber() {
        return LN_Model.NewLoan.getLoanNO();
    }

    public void setLoanNumber(String Loan_No) {
        LN_Model.NewLoan.setLoanNO(Loan_No);
    }

    public String getLoanProvider() {
        return LN_Model.NewLoan.getLoanProvider();
    }

    public void setLoanProvider(String Loan_Provider) {
        LN_Model.NewLoan.setLoanProvider(Loan_Provider);
    }

    public String getLoanDetails() {
        return LN_Model.NewLoan.getLoanDetails();
    }

    public void setLoanDetails(String Loan_Details) {
        LN_Model.NewLoan.setLoanDetails(Loan_Details);
    }


}
