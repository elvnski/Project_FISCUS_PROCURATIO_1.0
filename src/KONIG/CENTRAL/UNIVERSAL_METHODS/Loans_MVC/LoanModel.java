package KONIG.CENTRAL.UNIVERSAL_METHODS.Loans_MVC;

public class LoanModel {
    public static LoanModel NewLoan = new LoanModel();
    String LoanNO;
    String LoanProvider;
    String LoanDetails;

    public String getLoanNO() {
        return LoanNO;
    }

    public void setLoanNO(String loanNO) {
        LoanNO = loanNO;
    }

    public String getLoanProvider() {
        return LoanProvider;
    }

    public void setLoanProvider(String loanProvider) {
        LoanProvider = loanProvider;
    }

    public String getLoanDetails() {
        return LoanDetails;
    }

    public void setLoanDetails(String loanDetails) {
        LoanDetails = loanDetails;
    }
}
