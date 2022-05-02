package KONIG.CENTRAL.CONTROLLERS;

import KONIG.CENTRAL.UNIVERSAL_METHODS.Loans_MVC.LoanCont;
import KONIG.CENTRAL.UNIVERSAL_METHODS.Loans_MVC.LoanModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Loan_Inventory {

    LoanCont LN_ctrl = new LoanCont(LoanModel.NewLoan);
    @FXML
    private TextField LIN_Provider;
    @FXML
    private TextField LIN_LoanNo;
    @FXML
    private TextField LIN_Details;

    @FXML
    public void Save_Loan(ActionEvent event) {
        LN_ctrl.setLoanNumber(LIN_LoanNo.getText());
        LN_ctrl.setLoanProvider(LIN_Provider.getText());
        LN_ctrl.setLoanDetails(LIN_Details.getText());

        Stage stg = (Stage) LIN_Provider.getScene().getWindow();
        stg.close();
    }


    public void Cancel_Entry(ActionEvent actionEvent) {
        Stage stg = (Stage) LIN_Provider.getScene().getWindow();
        stg.close();
    }
}