package KONIG.CENTRAL.CONTROLLERS;

import KONIG.CENTRAL.UNIVERSAL_METHODS.Database_Ops;
import KONIG.CENTRAL.UNIVERSAL_METHODS.Loans_MVC.LoanCont;
import KONIG.CENTRAL.UNIVERSAL_METHODS.Loans_MVC.LoanModel;
import KONIG.CENTRAL.UNIVERSAL_METHODS.UI_Methods;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class CTRL_Dashboard implements Initializable {

    Database_Ops FISCUS_Connection = new Database_Ops();
    UI_Methods FISCUS_UI_Methods = new UI_Methods();
    @FXML
    private StackPane StackP_Parent;
    @FXML
    private AnchorPane pane_cashpayments;
    @FXML
    private Pane pane_AccountsPayable;
    @FXML
    private AnchorPane pane_Dashboard;
    @FXML
    private JFXHamburger sidemenu_Hambi;
    @FXML
    private JFXDrawer sideMenu;
    /**
     * FOR ACCOUNTS PAYABLE WINDOW
     */
    @FXML
    private TextField AP_txt_InvNo;
    @FXML
    private TextField AP_txt_SupName;
    @FXML
    private TextField AP_txt_Description;
    @FXML
    private TextField AP_txt_InvAmount;
    @FXML
    private TextField AP_txt_Discount;
    @FXML
    private DatePicker AP_date_DueDate;
    @FXML
    private TableView<?> AP_TableView;
    /**
     * FOR CASH PAYMENTS PANE
     */
    @FXML
    private Pane pane_CP_Parent;
    @FXML
    private TextField CP_txt_InvNo;
    @FXML
    private TextField CP_TXT_Descp;
    @FXML
    private TextField CP_TXT_CashP;
    @FXML
    private JFXComboBox<String> CP_cbo_Sup;
    @FXML
    private TextField CP_TXT_DiscRec;
    @FXML
    private JFXRadioButton CP_rad_NewInv;
    @FXML
    private JFXRadioButton CP_rad_APInv;
    @FXML
    private JFXComboBox<String> CP_cbo_APinv;
    @FXML
    private JFXRadioButton CP_rad_NewSupplier;
    @FXML
    private TextField CP_txt_NewSupplier;
    @FXML
    private JFXRadioButton CP_rad_APSupplier;
    @FXML
    private JFXComboBox<String> CP_cbo_APSupplier;
    @FXML
    private TableView<?> CP_TableView;
    @FXML
    private Label CP_lbl_InvBalance;
    /**
     * FOR CASH ACCOUNT PANE
     */
    @FXML
    private Pane pane_Cash;
    @FXML
    private TextField CASH_txt_Source;
    @FXML
    private TextField CASH_txt_Details;
    @FXML
    private TextField CASH_txt_Amount;
    @FXML
    private TableView<?> CASH_tableview;
    /**
     * FOR ACCOUNTS RECEIVABLE PANE
     */
    @FXML
    private Pane pane_AccountsReceivable;
    @FXML
    private TextField AR_txt_InvNo;
    @FXML
    private TextField AR_txt_CustName;
    @FXML
    private TextField AR_txt_Description;
    @FXML
    private TextField AR_txt_InvAmount;
    @FXML
    private DatePicker AR_date_DueDate;
    @FXML
    private TextField AR_txt_Discount;
    @FXML
    private TableView<?> AR_TableView;
    /**
     * FOR CASH RECEIPTS PANE
     */
    @FXML
    private Pane pane_CashReceipts;
    @FXML
    private Pane pane_ParentCR;
    @FXML
    private TextField CR_txt_RecNo;
    @FXML
    private TextField CR_txt_Descp;
    @FXML
    private TextField CR_txt_CashRec;
    @FXML
    private JFXComboBox<String> CR_cbo_ARClient;
    @FXML
    private TextField CR_txt_DiscGiven;
    @FXML
    private JFXComboBox<String> CR_cbo_ARinv;
    @FXML
    private JFXRadioButton CR_rad_NewReceipt;
    @FXML
    private JFXRadioButton CR_rad_ARInv;
    @FXML
    private TextField CR_txt_NewClient;
    @FXML
    private JFXRadioButton CR_rad_NewClient;
    @FXML
    private JFXRadioButton CR_rad_ARClient;
    @FXML
    private TableView<?> CR_TableView;
    @FXML
    private Label CR_lbl_InvBalance;
    /**
     * FOR AMORTIZATION SCHEDULE GENERATOR
     */
    @FXML
    private Pane pane_AmortizationSchedule;
    @FXML
    private TextField ASG_txt_Interest;
    @FXML
    private TextField ASG_txt_LoanAmt;
    @FXML
    private TextField ASG_txt_ExtraPayments;
    @FXML
    private TextField ASG_txt_LoanPeriod;
    @FXML
    private Label ASG_lbl_SchedPayment;
    @FXML
    private Label ASG_lbl_NoOfPayments;
    @FXML
    private Label ASG_lbl_TotalEarly;
    @FXML
    private Label ASG_lbl_TotalIntrst;
    @FXML
    private TableView<?> ASG_TableView;
    @FXML
    private DatePicker ASG_date_StartDate;
    @FXML
    private JFXToggleButton tgl_SaveToDir;
    /**
     * FOR GENERAL LEDGER
     */
    @FXML
    private Pane GL_Parent;
    @FXML
    private TableView<?> GL_Tableview;
    /**
     * FOR INVENTORY MANAGER
     */
    @FXML
    private Pane pane_Inventory;
    @FXML
    private TextField INV_ItemName;
    @FXML
    private TextField INV_CurrQuantity;
    @FXML
    private TextField INV_CatalogueID;
    @FXML
    private TextField INV_StockingPrice;
    @FXML
    private TableView<?> INV_Tableview;
    @FXML
    private TextField INV_CurrentValue;
    @FXML
    private TextField INV_SellingPrice;
    @FXML
    private TextField INV_ReorderLevel;
    @FXML
    private TextField INV_DiscountLimit;
    /**
     * FOR OWNERS' EQUITY PANE
     */
    @FXML
    private Pane pane_OwnersEquity;
    @FXML
    private TextField OEQ_txtAmount;
    @FXML
    private JFXComboBox<String> OEQ_cboAcctAction;
    @FXML
    private TextField OEQ_txtNotes;
    @FXML
    private TextField OEQ_txtName;
    @FXML
    private TableView<?> OEQ_tableview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            /** CREATING DATABASE CONNECTION */
            FISCUS_Connection.Create_DB_Connection();


            /** Creating pane object to load menu fxml onto */
            Pane Pane_SideMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/KONIG/CENTRAL/GUI/Fxmls/popup_menu.fxml")));
            sideMenu.setSidePane(Pane_SideMenu);

            FileInputStream input = new FileInputStream("C:/Users/Elvin/Pictures/Screenshots/DemonDean.png");
            Image demo = new Image(input);
            ImageView deano = new ImageView(demo);
            Pane_SideMenu.getChildren().add(deano);
            deano.setFitHeight(100.0);
            deano.setFitWidth(160.0);
            deano.setX(10);
            deano.setY(10);

            /** Assigning actions for the popup side-menu buttons */
            for (Node node : Pane_SideMenu.getChildren()) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    if (node.getAccessibleText() != null) {
                        switch (node.getAccessibleText()) {
                            case "Amortization Schedule" -> pane_AmortizationSchedule.toFront();
                            case "General Ledger" -> GL_Parent.toFront();
                            case "Inventory" -> pane_Inventory.toFront();
                            case "Owners' Equity" -> pane_OwnersEquity.toFront();

                        }
                    }
                });
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        sidemenu_Hambi.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            sideMenu.toFront();

            if (sideMenu.isOpened()) {
                sideMenu.toBack();
                sideMenu.close();
            } else {
                sideMenu.open();
            }
        });

        /** FILLING THE COMBOBOXES */
        RefreshComboBoxes();

        /** Setting the Cash Payments fields for supplier and invoice as Disabled */
        CP_cbo_APinv.setDisable(true);
        CP_txt_InvNo.setDisable(true);
        CP_txt_NewSupplier.setDisable(true);
        CP_cbo_APSupplier.setDisable(true);


        /** Input validation for payments and discounts */
        FISCUS_UI_Methods.Number_Range_Validation(CP_TXT_CashP, "Billion");
        FISCUS_UI_Methods.Number_Range_Validation(CP_TXT_DiscRec, "Million");
        FISCUS_UI_Methods.Number_Range_Validation(AP_txt_Discount, "Million");
        FISCUS_UI_Methods.Number_Range_Validation(AP_txt_InvAmount, "Billion");
        FISCUS_UI_Methods.Number_Range_Validation(CASH_txt_Amount, "Billion");
        FISCUS_UI_Methods.Number_Range_Validation(AR_txt_InvAmount, "Billion");
        FISCUS_UI_Methods.Number_Range_Validation(AR_txt_Discount, "Million");
        FISCUS_UI_Methods.Number_Range_Validation(CR_txt_CashRec, "Billion");
        FISCUS_UI_Methods.Number_Range_Validation(CR_txt_DiscGiven, "Million");
        /** FOR AMORT SCHEDULE */
        FISCUS_UI_Methods.Number_Range_Validation(ASG_txt_LoanAmt, "Billion");
        FISCUS_UI_Methods.Number_Range_Validation(ASG_txt_Interest, "Percentage");
        FISCUS_UI_Methods.Number_Range_Validation(ASG_txt_LoanPeriod, "Loan_Period");
        FISCUS_UI_Methods.Number_Range_Validation(ASG_txt_ExtraPayments, "100_Million");


        /** CLEARING AMORTIZATION SCHEDULE */
        try {
            String sql7 = "TRUNCATE amortization_schedule";
            FISCUS_Connection.Database_Command.executeUpdate(sql7);
        } catch (SQLException ex) {
            System.out.println("TRUNCATE amortization_schedule ERROR: " + ex.getMessage());
        }


        /** Filling CP fields with database values */
        Instant_Update_CP_Fields();
        Instant_Update_CR_Fields();

        /** Setting cash textboxes to 0.0*/
        AP_txt_InvAmount.setText("0.0");
        AP_txt_Discount.setText("0.0");
        CP_TXT_CashP.setText("0.0");
        CP_TXT_DiscRec.setText("0.0");
        CASH_txt_Amount.setText("0.0");


        /** Filling the tableviews */
        RefreshTableviews();

        /** FILLING OEQ COMBOBOX */
        ObservableList<String> Actions = FXCollections.observableArrayList("Investment", "Withdrawal");
        OEQ_cboAcctAction.setItems(Actions);


    }

    public void RefreshComboBoxes() {
        /** Filling the comboboxes*/
        FISCUS_UI_Methods.Initialize_ComboBox("Select invoice_no from accounts_payable", FISCUS_Connection, CP_cbo_APinv, "invoice_no");
        FISCUS_UI_Methods.Initialize_ComboBox("Select supplier_name from accounts_payable", FISCUS_Connection, CP_cbo_APSupplier, "supplier_name");
        FISCUS_UI_Methods.Initialize_ComboBox("Select invoice_no from accounts_receivable", FISCUS_Connection, CR_cbo_ARinv, "invoice_no");
        FISCUS_UI_Methods.Initialize_ComboBox("Select customer_name from accounts_receivable", FISCUS_Connection, CR_cbo_ARClient, "customer_name");

        System.out.println("Comboboxes refreshed");
    }

    public void RefreshTableviews() {
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "cash_payments", CP_TableView);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "cash", CASH_tableview);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "inventory", INV_Tableview);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "accounts_receivable", AR_TableView);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "cash_receipts", CR_TableView);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "amortization_schedule", ASG_TableView);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "general_ledger", GL_Tableview);
        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "owners_equity", OEQ_tableview);


        FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "accounts_payable", AP_TableView);

    }

    public void GoToDashboard() {
        pane_Dashboard.toFront();
    }

    public void GoToAccountsPayable() {
        pane_AccountsPayable.toFront();
    }

    public void GoToCashPayments() {
        pane_CP_Parent.toFront();
    }

    public void GoToCash() {
        pane_Cash.toFront();
    }

    public void GoToAccountsReceivable() {
        pane_AccountsReceivable.toFront();
    }

    public void GoToCashReceipts() {
        pane_ParentCR.toFront();
    }


    public void create_AccountsPayable(ActionEvent actionEvent) {
        LocalDate AP_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String AP_Time = java.time.LocalTime.now().format(dtf);
        String AP_InvNO = AP_txt_InvNo.getText();
        String AP_SupName = AP_txt_SupName.getText();
        String AP_Description = AP_txt_Description.getText();
        BigDecimal AP_InvAmount;
        BigDecimal AP_Discount;
        LocalDate AP_DueDate = AP_date_DueDate.getValue();

        if (AP_InvNO.equals("") || AP_SupName.equals("") || AP_Description.equals("") || AP_txt_InvAmount.getText().equals("") || AP_txt_Discount.getText().equals("") || AP_DueDate.equals("")) {
            JFXButton btn3 = new JFXButton("Got it");
            JFXDialog Dial_MissingEntry = FISCUS_UI_Methods.Make_A_Dialog_Box(StackP_Parent, new Text("Missing Entry Alert"), new Text("There are empty fields in your entry.\nPlease fill all fields and try again."), btn3);

            btn3.setOnAction(actionEvent1 -> Dial_MissingEntry.close());

            Dial_MissingEntry.show();

        } else {
            AP_InvAmount = new BigDecimal(AP_txt_InvAmount.getText());
            AP_InvAmount = AP_InvAmount.setScale(2, RoundingMode.HALF_UP);
            AP_Discount = new BigDecimal(AP_txt_Discount.getText());
            AP_Discount = AP_Discount.setScale(2, RoundingMode.HALF_UP);


            String sql = "Insert into accounts_payable(date, time, invoice_no, supplier_name, description, invoice_amount, discount, due_date, balance_due, credit) " +
                    "values ('" + AP_Date + "', '" + AP_Time + "', '" + AP_InvNO + "', '" + AP_SupName + "', '" + AP_Description + "', '" + AP_InvAmount + "', '" + AP_Discount + "', '" + AP_DueDate + "', '" + AP_InvAmount + "', '" + AP_InvAmount + "')";

            String acct = "Accounts Payable";
            String dtls = AP_SupName + " -- " + AP_Description;
            String type = "Liability";

            String sql2 = "Insert into general_ledger(date, account_type, account_name, client_details, credit) " +
                    "values ('" + AP_Date + "', '" + type + "', '" + acct + "', '" + dtls + "', '" + AP_InvAmount + "')";

            FISCUS_Connection.Save_to_DB(sql);
            FISCUS_Connection.Save_to_DB(sql2);

            /** Creating a snackbar for Succesful entry to database */
            JFXSnackbar CreateSuccess = new JFXSnackbar(pane_AccountsPayable);
            CreateSuccess.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Great! Entry Saved Successfully!"), Duration.seconds(8)));
            CreateSuccess.setOnMouseClicked(event -> CreateSuccess.unregisterSnackbarContainer(pane_AccountsPayable));

            /** Creating a toast */
            FISCUS_UI_Methods.makeToast((Stage) pane_AccountsPayable.getScene().getWindow(), "Accounts Payable Updated Successfully", 8000, 1000, 1000);

            RefreshTableviews();
            RefreshComboBoxes();
        }
    }

    public void create_CashPayments() {

        LocalDate CP_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String CP_Time = java.time.LocalTime.now().format(dtf);
        String CP_Inv_No = "";

        JFXButton btn = new JFXButton("Got it.");
        JFXDialog DIAL_MissingEntry = FISCUS_UI_Methods.Make_A_Dialog_Box(StackP_Parent, new Text("Missing Entry!"), new Text("Please enter values for all fields"), btn);

        btn.setOnAction(actionEvent -> DIAL_MissingEntry.close());

        if (CP_rad_APInv.isSelected()) {
            CP_Inv_No = CP_cbo_APinv.getValue();
        } else if (CP_rad_NewInv.isSelected()) {
            CP_Inv_No = CP_txt_InvNo.getText();
        } else {
            DIAL_MissingEntry.show();
        }

        String CP_Sup_Name = "";

        if (CP_rad_NewSupplier.isSelected()) {
            CP_Sup_Name = CP_txt_NewSupplier.getText();
        } else if (CP_rad_APSupplier.isSelected()) {
            CP_Sup_Name = CP_cbo_APSupplier.getValue();
        }

        String CP_Details = CP_TXT_Descp.getText();
        BigDecimal CP_CashPaid;
        BigDecimal CP_Discount;
        BigDecimal CashBalance = BigDecimal.valueOf(0.0);


        if (CP_Sup_Name.equals("") || CP_Inv_No.equals("") || CP_TXT_Descp.getText().equals("") || CP_TXT_CashP.getText().equals("") || CP_TXT_DiscRec.getText().equals("")) {

            MissingEntryDialog().show();

        } else {
            CP_CashPaid = new BigDecimal(CP_TXT_CashP.getText());
            CP_Discount = new BigDecimal(CP_TXT_DiscRec.getText());

            CashBalance = FISCUS_UI_Methods.get_CashBalance(FISCUS_Connection);

            BigDecimal NewBalance = CashBalance.subtract(CP_CashPaid);

            String sql_New_CP_Entry = "Insert into cash_payments(date, time, invoice_no, supplier, details, cash_paid, discount_received)" +
                    "values ('" + CP_Date + "', '" + CP_Time + "', '" + CP_Inv_No + "', '" + CP_Sup_Name + "', '" + CP_Details + "', '" + CP_CashPaid + "', '" + CP_Discount + "' )";

            String sql_New_Cash_Entry = "insert into cash(date, time, source, details, credit, balance)" +
                    "values('" + CP_Date + "', '" + CP_Time + "', '" + CP_Sup_Name + "', '" + CP_Details + "', '" + CP_CashPaid + "', '" + NewBalance + "')";

            String acct = "Cash";
            String dtls = CP_Sup_Name + " -- " + CP_Details;
            String type = "Asset";

            String GL_Entry_For_Cash = "Insert into general_ledger(date, account_type, account_name, client_details, credit) " +
                    "values ('" + CP_Date + "', '" + type + "', '" + acct + "', '" + dtls + "', '" + CP_CashPaid + "')";


            if (CP_rad_NewInv.isSelected()) {

                FISCUS_Connection.Save_to_DB(sql_New_CP_Entry);

                FISCUS_Connection.Save_to_DB(sql_New_Cash_Entry);

                FISCUS_Connection.Save_to_DB(GL_Entry_For_Cash);

                FISCUS_UI_Methods.makeToast((Stage) pane_Cash.getScene().getWindow(), "Ledgers Successfully Updated", 5000, 500, 2500);

                RefreshTableviews();
                RefreshComboBoxes();

            } else if (CP_rad_APInv.isSelected()) {

                /** Getting the invoice amount */
                BigDecimal Latest_Inv_Balance = BigDecimal.valueOf(0.0);
                String sql_getInvBal = "select MIN(balance_due) as balance_due from accounts_payable where invoice_no = '" + CP_Inv_No + "' ";

                try {
                    ResultSet rs = FISCUS_Connection.Database_Command.executeQuery(sql_getInvBal);
                    while (rs.next()) {
                        Latest_Inv_Balance = new BigDecimal(rs.getDouble("balance_due"));
                    }
                } catch (SQLException throwables) {
                    System.out.println("sql_getInvBal ERROR: " + throwables.getMessage());
                }

                BigDecimal New_Inv_Balance = Latest_Inv_Balance.subtract(CP_CashPaid);

                if (New_Inv_Balance.compareTo(BigDecimal.valueOf(0)) < 0) {
                    OverpaymentWarningDialog().show();

                } else {


                    System.out.println("NEW BALANCE IS " + New_Inv_Balance);


                    /** Obtaining values from accounts payable in order to record a new entry */
                    String sql_getAPdata = "select * from accounts_payable where invoice_no = '" + CP_Inv_No + "'";
                    String sql_UpdateAP = "";
                    try {
                        ResultSet rs = FISCUS_Connection.Database_Command.executeQuery(sql_getAPdata);
                        while (rs.next()) {
                            String AP_InvNO = rs.getString("invoice_no");
                            String AP_SupName = rs.getString("supplier_name");
                            String AP_Description = rs.getString("description");
                            Double AP_InvAmount = rs.getDouble("invoice_amount");
                            Double AP_Discount = rs.getDouble("discount");
                            Date AP_DueDate = rs.getDate("due_date");

                            sql_UpdateAP = "Insert into accounts_payable(date, time, invoice_no, supplier_name, description, invoice_amount, discount, due_date, payment, balance_due, debit) " +
                                    "values ('" + CP_Date + "', '" + CP_Time + "', '" + AP_InvNO + "', '" + AP_SupName + "', '" + AP_Description + "', '" + AP_InvAmount + "', '" + AP_Discount + "', '" + AP_DueDate + "',  '" + CP_CashPaid + "', '" + New_Inv_Balance + "', '" + CP_CashPaid + "')";

                        }

                        FISCUS_Connection.Save_to_DB(sql_UpdateAP);
                        FISCUS_Connection.Save_to_DB(sql_New_CP_Entry);
                        FISCUS_Connection.Save_to_DB(sql_New_Cash_Entry);
                        FISCUS_Connection.Save_to_DB(GL_Entry_For_Cash);


                    } catch (SQLException throwables) {
                        System.out.println("Create Cash Payments ERROR:" + throwables.getMessage());
                        ;
                    }

                    FISCUS_UI_Methods.makeToast((Stage) pane_Cash.getScene().getWindow(), "Ledgers Successfully Updated", 5000, 500, 2500);

                    RefreshTableviews();
                    RefreshComboBoxes();

                }
            }
        }
    }


    public void Instant_Update_CP_Fields() {
        CP_cbo_APinv.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if ((!newValue)) {
                String CP_InvNo = CP_cbo_APinv.getValue();

                String sql = "select * from accounts_payable where invoice_no = '" + CP_InvNo + "'";

                String AP_Supplier = "";
                String AP_Description = "";
                String AP_InvBalance = "";
                try {
                    ResultSet rs = FISCUS_Connection.Database_Command.executeQuery(sql);
                    while (rs.next()) {
                        AP_Supplier = rs.getString("supplier_name");
                        AP_Description = rs.getString("description");
                        AP_InvBalance = rs.getString("balance_due");
                    }
                } catch (SQLException ex) {
                    System.out.println("Instant_Update_CP_Fields ERROR: " + ex.getMessage());
                }

                final String APSupplier = AP_Supplier;
                final String APDescription = AP_Description;


                CP_cbo_APSupplier.setValue(APSupplier);
                CP_TXT_Descp.setText(APDescription);
                CP_TXT_CashP.setText("");
                CP_lbl_InvBalance.setText("[ Invoice balance: " + AP_InvBalance + " ]");
            }
        });

    }

    public JFXDialog MissingEntryDialog() {
        JFXButton btn = new JFXButton("Got it.");
        JFXDialog DIAL_MissingEntry = FISCUS_UI_Methods.Make_A_Dialog_Box(StackP_Parent, new Text("Missing Entry!"), new Text("Please enter values for all fields"), btn);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DIAL_MissingEntry.close();
            }
        });

        return DIAL_MissingEntry;
    }

    public JFXDialog OverpaymentWarningDialog() {
        JFXButton btn_OP = new JFXButton("Got it.");
        JFXDialog OverPaid_Dialog = FISCUS_UI_Methods.Make_A_Dialog_Box(StackP_Parent, new Text("OVERPAYMENT WARNING!"), new Text("Please confirm respective invoice balance and retry payment."), btn_OP);
        btn_OP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                OverPaid_Dialog.close();
                CP_TXT_CashP.setText("");
            }
        });

        return OverPaid_Dialog;
    }

    public void toggle_NewInvoice(ActionEvent actionEvent) {
        if (CP_rad_NewInv.isSelected()) {
            CP_cbo_APinv.setDisable(true);
            CP_rad_APInv.setSelected(false);
            CP_txt_InvNo.setDisable(false);
            CP_rad_NewSupplier.setDisable(false);

        }
    }


    public void toggle_AP_Invoice(ActionEvent actionEvent) {
        if (CP_rad_APInv.isSelected()) {
            CP_cbo_APinv.setDisable(false);
            CP_txt_InvNo.setDisable(true);
            CP_rad_NewInv.setSelected(false);
            CP_rad_NewSupplier.setSelected(false);
            CP_rad_NewSupplier.setDisable(true);
            CP_txt_NewSupplier.setDisable(true);
        }
    }

    public void toggle_NewSupplier(ActionEvent actionEvent) {
        if (CP_rad_NewSupplier.isSelected()) {
            CP_txt_NewSupplier.setDisable(false);
            CP_cbo_APSupplier.setDisable(true);
            CP_rad_APSupplier.setSelected(false);

        }

    }

    public void toggle_AP_Supplier(ActionEvent actionEvent) {
        if (CP_rad_APSupplier.isSelected()) {
            CP_cbo_APSupplier.setDisable(false);
            CP_rad_NewSupplier.setSelected(false);
            CP_txt_NewSupplier.setDisable(true);

        }

    }


    public void create_CashEntry(ActionEvent actionEvent) {
        LocalDate CSH_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String CSH_Time = java.time.LocalTime.now().format(dtf);
        String CSH_Source = CASH_txt_Source.getText();
        String CSH_Details = CASH_txt_Details.getText();
        BigDecimal CSH_Amount;


        if (CSH_Source.equals("") || CSH_Details.equals("") || CASH_txt_Amount.getText().equals("")) {
            MissingEntryDialog().show();
        } else {
            CSH_Amount = new BigDecimal(CASH_txt_Amount.getText());
            CSH_Amount = CSH_Amount.setScale(2, RoundingMode.HALF_UP);

            BigDecimal CashBalance = FISCUS_UI_Methods.get_CashBalance(FISCUS_Connection);
            CashBalance = CashBalance.add(CSH_Amount);

            String sql_New_Cash_Entry = "insert into cash(date, time, source, details, debit, balance)" +
                    "values('" + CSH_Date + "', '" + CSH_Time + "', '" + CSH_Source + "', '" + CSH_Details + "', '" + CSH_Amount + "', '" + CashBalance + "')";

            String acct = "Cash";
            String dtls = CSH_Source + " -- " + CSH_Details;
            String type = "Asset";

            String GL_Entry_For_Cash = "Insert into general_ledger(date, account_type, account_name, client_details, debit) " +
                    "values ('" + CSH_Date + "', '" + type + "', '" + acct + "', '" + dtls + "', '" + CSH_Amount + "')";

            FISCUS_Connection.Save_to_DB(sql_New_Cash_Entry);
            FISCUS_Connection.Save_to_DB(GL_Entry_For_Cash);

            FISCUS_UI_Methods.SnackBar_Maker(pane_CashReceipts, "Great! Cash Receipts and Cash journals successfully updated.");


            FISCUS_UI_Methods.makeToast((Stage) pane_Cash.getScene().getWindow(), "Ledgers Successfully Updated", 5000, 500, 2500);

            RefreshTableviews();
            RefreshComboBoxes();
        }

    }


    public void create_AccountsReceivable(ActionEvent actionEvent) {
        LocalDate AR_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String AR_Time = java.time.LocalTime.now().format(dtf);
        String AR_InvNO = AR_txt_InvNo.getText();
        String AR_CustName = AR_txt_CustName.getText();
        String AR_Description = AR_txt_Description.getText();
        BigDecimal AR_InvAmount;
        BigDecimal AR_Discount;
        LocalDate AR_DueDate = AR_date_DueDate.getValue();

        if (AR_InvNO.equals("") || AR_CustName.equals("") || AR_Description.equals("") || AR_Description.equals("") || AR_txt_InvAmount.getText().equals("") || AR_DueDate.equals("")) {
            MissingEntryDialog().show();
        } else {
            AR_InvAmount = new BigDecimal(AR_txt_InvAmount.getText());
            AR_InvAmount = AR_InvAmount.setScale(2, RoundingMode.HALF_UP);
            AR_Discount = new BigDecimal(AR_txt_Discount.getText());
            AR_Discount = AR_Discount.setScale(2, RoundingMode.HALF_UP);

            String sql = "Insert into accounts_receivable(date, time, invoice_no, customer_name, description, invoice_amount, discount, due_date, balance_due, debit) " +
                    "values ('" + AR_Date + "', '" + AR_Time + "', '" + AR_InvNO + "', '" + AR_CustName + "', '" + AR_Description + "', '" + AR_InvAmount + "', '" + AR_Discount + "', '" + AR_DueDate + "', '" + AR_InvAmount + "', '" + AR_InvAmount + "')";

            String acct = "Accounts Receivable";
            String dtls = AR_CustName + " -- " + AR_Description;
            String type = "Asset";

            String GL_Entry = "Insert into general_ledger(date, account_type, account_name, client_details, debit) " +
                    "values ('" + AR_Date + "', '" + type + "', '" + acct + "', '" + dtls + "', '" + AR_InvAmount + "')";

            FISCUS_Connection.Save_to_DB(sql);
            FISCUS_Connection.Save_to_DB(GL_Entry);

            FISCUS_UI_Methods.makeToast((Stage) pane_Cash.getScene().getWindow(), "Ledgers Successfully Updated", 5000, 500, 2500);


            RefreshTableviews();
            RefreshComboBoxes();
        }


    }


    public void CR_toggle_NewReceipt() {
        if (CR_rad_NewClient.isSelected()) {
            CR_txt_RecNo.setDisable(true);
            CR_txt_NewClient.setDisable(true);
            CR_cbo_ARinv.setDisable(false);
            CR_cbo_ARClient.setDisable(false);
            CR_rad_NewClient.setSelected(false);
            CR_rad_ARInv.setSelected(true);
            CR_rad_ARClient.setSelected(true);
        } else {
            CR_txt_RecNo.setDisable(false);
            CR_txt_NewClient.setDisable(false);
            CR_cbo_ARinv.setDisable(true);
            CR_cbo_ARClient.setDisable(true);
            CR_rad_NewClient.setSelected(true);
            CR_rad_ARInv.setSelected(false);
            CR_rad_ARClient.setSelected(false);
        }
    }

    public void CR_toggle_NewClient(ActionEvent actionEvent) {
        CR_rad_NewReceipt.setSelected(true);
        CR_rad_ARInv.setSelected(false);
        CR_rad_ARClient.setSelected(false);
        CR_txt_RecNo.setDisable(false);
        CR_txt_NewClient.setDisable(false);
        CR_cbo_ARinv.setDisable(true);
        CR_cbo_ARClient.setDisable(true);

    }


    public void CR_toggle_AR_Invoice() {
        CR_cbo_ARinv.setDisable(false);
        CR_cbo_ARClient.setDisable(false);
        CR_txt_RecNo.setDisable(true);
        CR_txt_NewClient.setDisable(true);
        CR_rad_ARClient.setSelected(true);
        CR_rad_NewReceipt.setSelected(false);
        CR_rad_NewClient.setSelected(false);

    }


    public void CR_toggle_AR_Client() {
        CR_rad_ARInv.setSelected(true);
        CR_rad_NewReceipt.setSelected(false);
        CR_rad_NewClient.setSelected(false);
        CR_cbo_ARClient.setDisable(false);
        CR_cbo_ARinv.setDisable(false);
        CR_txt_RecNo.setDisable(true);
        CR_txt_NewClient.setDisable(true);


    }

    public void create_CashReceipts(ActionEvent actionEvent) {
        LocalDate CR_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String CR_Time = java.time.LocalTime.now().format(dtf);
        String CR_InvRec_No = "";
        String CR_Client = "";
        String CR_Details = CR_txt_Descp.getText();
        BigDecimal CR_CashRec;
        BigDecimal CR_DiscGiven;

        if (CR_rad_NewReceipt.isSelected()) {
            CR_InvRec_No = CR_txt_RecNo.getText();
        } else if (CR_rad_ARInv.isSelected()) {
            CR_InvRec_No = CR_cbo_ARinv.getValue();
        }

        if (CR_rad_NewClient.isSelected()) {
            CR_Client = CR_txt_NewClient.getText();
        } else if (CR_rad_ARClient.isSelected()) {
            CR_Client = CR_cbo_ARClient.getValue();
        }

        if (CR_InvRec_No.equals("") || CR_Client.equals("") || CR_Details.equals("") || CR_txt_CashRec.getText().equals("") || CR_txt_DiscGiven.getText().equals("")) {
            MissingEntryDialog().show();

        } else {
            CR_CashRec = new BigDecimal(CR_txt_CashRec.getText());
            CR_CashRec = CR_CashRec.setScale(2, RoundingMode.HALF_UP);
            CR_DiscGiven = new BigDecimal(CR_txt_DiscGiven.getText());
            CR_DiscGiven = CR_DiscGiven.setScale(2, RoundingMode.HALF_UP);
            BigDecimal CashBalance = FISCUS_UI_Methods.get_CashBalance(FISCUS_Connection);
            CashBalance = CashBalance.add(CR_CashRec);

            String New_CR_Entry = "Insert into cash_receipts(date, time, rec_or_inv_ID, client, details, cash_received, discount_given) " +
                    "values('" + CR_Date + "', '" + CR_Time + "', '" + CR_InvRec_No + "', '" + CR_Client + "', '" + CR_Details + "', '" + CR_CashRec + "', '" + CR_DiscGiven + "') ";

            String New_Cash_Entry = "insert into cash(date, time, source, details, debit, balance)" +
                    "values('" + CR_Date + "', '" + CR_Time + "', '" + CR_Client + "', '" + CR_Details + "', '" + CR_CashRec + "', '" + CashBalance + "')";

            String acct = "Cash";
            String dtls = CR_Client + " -- " + CR_Details;
            String type = "Asset";

            String GL_Entry = "Insert into general_ledger(date, account_type, account_name, client_details, debit) " +
                    "values ('" + CR_Date + "', '" + type + "', '" + acct + "', '" + dtls + "', '" + CR_CashRec + "')";


            if (CR_rad_NewReceipt.isSelected()) {
                FISCUS_Connection.Save_to_DB(New_CR_Entry);
                FISCUS_Connection.Save_to_DB(New_Cash_Entry);
                FISCUS_Connection.Save_to_DB(GL_Entry);

                FISCUS_UI_Methods.makeToast((Stage) pane_Cash.getScene().getWindow(), "Ledgers Successfully Updated", 5000, 500, 2500);
                Clear_CR_Fields();
                RefreshTableviews();
                RefreshComboBoxes();

            } else if (CR_rad_ARInv.isSelected()) {
                /** Getting the Invoice amount */
                BigDecimal Latest_Inv_Balance = BigDecimal.valueOf(0.0);
                Latest_Inv_Balance = Latest_Inv_Balance.setScale(2, RoundingMode.HALF_UP);

                String get_Inv_Balance = "select MIN(balance_due) as balance_due from accounts_receivable where invoice_no = '" + CR_InvRec_No + "' ";

                try {
                    ResultSet rs = FISCUS_Connection.Database_Command.executeQuery(get_Inv_Balance);
                    while (rs.next()) {
                        Latest_Inv_Balance = BigDecimal.valueOf(rs.getDouble("balance_due"));
                    }
                } catch (SQLException ex) {
                    System.out.println("get_Inv_Balance ERROR: " + ex.getMessage());
                }

                BigDecimal New_Inv_Balance = Latest_Inv_Balance.subtract(CR_CashRec);

                if (New_Inv_Balance.compareTo(BigDecimal.valueOf(0.0)) < 0) {
                    OverpaymentWarningDialog().show();

                } else {
                    /** Obtaining records from accounts receivable for a new entry */
                    String get_ARdata = "select * from accounts_receivable where invoice_no = '" + CR_InvRec_No + "' ";
                    String Update_AR = "";
                    try {
                        ResultSet rs = FISCUS_Connection.Database_Command.executeQuery(get_ARdata);
                        while (rs.next()) {
                            String AR_InvNO = rs.getString("invoice_no");
                            String AR_CustName = rs.getString("customer_name");
                            String AR_Description = rs.getString("description");
                            Double AR_InvAmount = rs.getDouble("invoice_amount");
                            Double AR_Discount = rs.getDouble("discount");
                            Date AR_DueDate = rs.getDate("due_date");

                            Update_AR = "Insert into accounts_receivable(date, time, invoice_no, customer_name, description, invoice_amount, discount, due_date, payment, balance_due, credit) " +
                                    "values ('" + CR_Date + "', '" + CR_Time + "', '" + AR_InvNO + "', '" + AR_CustName + "', '" + AR_Description + "', '" + AR_InvAmount + "', '" + AR_Discount + "', '" + AR_DueDate + "',  '" + CR_CashRec + "', '" + New_Inv_Balance + "', '" + CR_CashRec + "')";

                        }

                        FISCUS_Connection.Save_to_DB(Update_AR);
                        FISCUS_Connection.Save_to_DB(New_CR_Entry);
                        FISCUS_Connection.Save_to_DB(New_Cash_Entry);
                        FISCUS_Connection.Save_to_DB(GL_Entry);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("Instant_Update_CP_Fields SQL ERROR");
                    }


                    FISCUS_UI_Methods.makeToast((Stage) pane_Cash.getScene().getWindow(), "Ledgers Successfully Updated", 5000, 500, 2500);
                    Clear_CR_Fields();
                    RefreshTableviews();
                    RefreshComboBoxes();
                }


            }

        }
    }


    public void Instant_Update_CR_Fields() {
        CR_cbo_ARinv.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if ((!newValue)) {
                String CR_InvNo = CR_cbo_ARinv.getValue();

                String sql = "select * from accounts_receivable where invoice_no = '" + CR_InvNo + "'";

                String AR_Customer = "";
                String AR_Description = "";
                String AR_InvBalance = "";
                try {
                    ResultSet rs = FISCUS_Connection.Database_Command.executeQuery(sql);
                    while (rs.next()) {
                        AR_Customer = rs.getString("customer_name");
                        AR_Description = rs.getString("description");
                        AR_InvBalance = rs.getString("balance_due");
                    }
                } catch (SQLException ex) {
                    System.out.println("Instant Update CR Fields SQL ERROR: " + ex.getMessage());
                }

                final String ARCustomer = AR_Customer;
                final String ARDescription = AR_Description;


                CR_cbo_ARClient.setValue(ARCustomer);
                CR_txt_Descp.setText(ARDescription);
                CR_lbl_InvBalance.setVisible(true);
                CR_lbl_InvBalance.setText("[ Invoice balance: " + AR_InvBalance + " ]");
            }
        });


    }

    public void Clear_CR_Fields() {
        CR_txt_RecNo.setText("");
        CR_txt_NewClient.setText("");
        CR_cbo_ARinv.setValue("");
        CR_cbo_ARClient.setValue("");
        CR_txt_Descp.setText("");
        CR_txt_CashRec.setText("");
        CR_txt_DiscGiven.setText("");
        CR_lbl_InvBalance.setVisible(false);
        CR_rad_NewReceipt.setSelected(false);
        CR_rad_NewClient.setSelected(false);
        CR_rad_ARInv.setSelected(false);
        CR_rad_ARClient.setSelected(false);
        CR_txt_RecNo.setDisable(true);
        CR_txt_NewClient.setDisable(true);
        CR_cbo_ARinv.setDisable(true);
        CR_cbo_ARClient.setDisable(true);
    }


    public void Generate_Amortization_Schedule() {
        try {
            String sql7 = "TRUNCATE amortization_schedule";
            FISCUS_Connection.Database_Command.executeUpdate(sql7);
        } catch (SQLException ex) {
            System.out.println("TRUNCATE amortization_schedule SQL ERROR: " + ex.getMessage());
        }

        BigDecimal LoanAmount;
        BigDecimal IntRate;
        int LoanPeriod;
        int NoOfPayments;
        LocalDate ASG_Date = ASG_date_StartDate.getValue();


        if (ASG_txt_LoanAmt.getText().equals("") || ASG_txt_Interest.getText().equals("") || ASG_txt_LoanPeriod.getText().equals("") || ASG_txt_ExtraPayments.getText().equals("") || ASG_date_StartDate.getValue().equals("")) {
            MissingEntryDialog().show();

        } else {
            LoanAmount = new BigDecimal(ASG_txt_LoanAmt.getText());
            IntRate = new BigDecimal(ASG_txt_Interest.getText());
            LoanPeriod = Integer.parseInt(ASG_txt_LoanPeriod.getText());
            BigDecimal LoanBalance = LoanAmount;
            BigDecimal CumulativeInterest = BigDecimal.valueOf(0);
            int PaymentNo = 1;

            BigDecimal Perc_IntRate = IntRate.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

            BigDecimal I = (Perc_IntRate).divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
            System.out.println("Intrate is : " + I);

            BigDecimal sub1 = (I.add(BigDecimal.valueOf(1))).pow(LoanPeriod);
            BigDecimal TotMonthlyPayment = LoanAmount.multiply((I.multiply(sub1)).divide((sub1.subtract(BigDecimal.valueOf(1))), 10, RoundingMode.HALF_UP));
            TotMonthlyPayment = TotMonthlyPayment.setScale(2, RoundingMode.HALF_UP);

            System.out.println("Total Monthly Payment is : " + TotMonthlyPayment);
            ASG_lbl_SchedPayment.setText("KES " + TotMonthlyPayment);

            BigDecimal ExtraPayment = new BigDecimal(ASG_txt_ExtraPayments.getText());


            BigDecimal TotalPlusExtra = TotMonthlyPayment.add(ExtraPayment);
            System.out.println("TOTAL PAYMENT IS : " + TotalPlusExtra);

            BigDecimal InitialBalance = BigDecimal.valueOf(0);
            BigDecimal InterestPayment;
            BigDecimal PrincipalPayment;

            while (LoanBalance.compareTo(BigDecimal.valueOf(0.0)) > 0) {


                if (LoanBalance.compareTo(TotalPlusExtra) > 0) {

                    System.out.println("CALCULATIING PAYMENT NUMBER : " + PaymentNo);

                    InitialBalance = LoanBalance;


                    InterestPayment = LoanBalance.multiply((Perc_IntRate).divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP));
                    InterestPayment = InterestPayment.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("INTEREST PAYMENT IS : " + InterestPayment);

                    PrincipalPayment = TotalPlusExtra.subtract(InterestPayment);
                    System.out.println("PRINCIPAL PAYMENT IS : " + PrincipalPayment);

                    if (PaymentNo > 1) {
                        ASG_Date = ASG_Date.plusMonths(1);
                    }

                    LoanBalance = LoanBalance.subtract(PrincipalPayment);
                    CumulativeInterest = CumulativeInterest.add(InterestPayment);


                    System.out.println("ENDING LOAN BALANCE IS " + LoanBalance + " ON DATE " + ASG_Date);


                    String AS_Entry = "Insert into amortization_schedule(payment_no, payment_date, beginning_balance, scheduled_payment, extra_payment, total_payment, principal, interest, ending_balance, cumulative_interest) " +
                            "values('" + PaymentNo + "', '" + ASG_Date + "', '" + InitialBalance + "', '" + TotMonthlyPayment + "', '" + ExtraPayment + "', '" + TotalPlusExtra + "', '" + PrincipalPayment + "', '" + InterestPayment + "', '" + LoanBalance + "', '" + CumulativeInterest + "' )";

                    FISCUS_Connection.Save_to_DB(AS_Entry);

                } else {
                    InitialBalance = LoanBalance;
                    TotMonthlyPayment = LoanBalance;
                    ExtraPayment = BigDecimal.valueOf(0);
                    TotalPlusExtra = TotMonthlyPayment.add(ExtraPayment);
                    InterestPayment = LoanBalance.multiply((Perc_IntRate).divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP));
                    InterestPayment = InterestPayment.setScale(2, RoundingMode.HALF_UP);
                    PrincipalPayment = TotalPlusExtra.subtract(InterestPayment);

                    if (PaymentNo > 1) {
                        ASG_Date = ASG_Date.plusMonths(1);
                    }

                    LoanBalance = LoanBalance.subtract(TotMonthlyPayment);
                    CumulativeInterest = CumulativeInterest.add(InterestPayment);


                    System.out.println("ENDING LOAN BALANCE IS " + LoanBalance + " ON DATE " + ASG_Date);

                    String Final_AS_Entry = "Insert into amortization_schedule(payment_no, payment_date, beginning_balance, scheduled_payment, extra_payment, total_payment, principal, interest, ending_balance, cumulative_interest) " +
                            "values('" + PaymentNo + "', '" + ASG_Date + "', '" + InitialBalance + "', '" + TotMonthlyPayment + "', '" + ExtraPayment + "', '" + TotalPlusExtra + "', '" + PrincipalPayment + "', '" + InterestPayment + "', '" + LoanBalance + "', '" + CumulativeInterest + "' )";

                    FISCUS_Connection.Save_to_DB(Final_AS_Entry);

                }

                PaymentNo = PaymentNo + 1;

            }


            String sql_GetInterestTotal = "select MAX(cumulative_interest) as cumulative_interest from amortization_schedule";
            String sql_GetExtraTotal = "select SUM(extra_payment) as extra_payment from amortization_schedule";
            String sql_GetNoOfPayments = "select MAX(payment_no) as payment_no from amortization_schedule";

            Double InterestTotal = 0.0;
            Double ExtraTotal = 0.0;
            Integer NoOfPayts = 0;
            Date End_Date = null;

            try {
                ResultSet rs3 = FISCUS_Connection.Database_Command.executeQuery(sql_GetInterestTotal);
                while (rs3.next()) {
                    InterestTotal = rs3.getDouble("cumulative_interest");
                }

                ResultSet rs4 = FISCUS_Connection.Database_Command.executeQuery(sql_GetExtraTotal);
                while (rs4.next()) {
                    ExtraTotal = rs4.getDouble("extra_payment");
                }

                ResultSet rs5 = FISCUS_Connection.Database_Command.executeQuery(sql_GetNoOfPayments);
                while (rs5.next()) {
                    NoOfPayts = rs5.getInt("payment_no");
                }

                String sql_EndDate = "select payment_date as payment_date from amortization_schedule where payment_no = '" + NoOfPayts + "' ";
                ResultSet rs6 = FISCUS_Connection.Database_Command.executeQuery(sql_EndDate);
                while (rs6.next()) {
                    End_Date = rs6.getDate("payment_date");
                }

            } catch (SQLException ex) {
                System.out.println("AMORTIZATION sql error: " + ex.getMessage());
            }
            ASG_lbl_TotalIntrst.setText("KES " + InterestTotal);
            ASG_lbl_TotalEarly.setText("KES " + ExtraTotal);
            ASG_lbl_NoOfPayments.setText(NoOfPayts.toString());

            FISCUS_UI_Methods.Load_Tableview_Content(FISCUS_Connection, "amortization_schedule", ASG_TableView);


            LoanCont LN_ctrl = new LoanCont(LoanModel.NewLoan);

            if (tgl_SaveToDir.isSelected()) {
                String LIN_No = LN_ctrl.getLoanNumber();
                String LIN_Provider = LN_ctrl.getLoanProvider();
                String LIN_Details = LN_ctrl.getLoanDetails();
                BigDecimal LIN_Amount = new BigDecimal(ASG_txt_LoanAmt.getText());
                BigDecimal LIN_Rate = new BigDecimal(ASG_txt_Interest.getText());
                BigDecimal LIN_Period = new BigDecimal(ASG_txt_LoanPeriod.getText());
                BigDecimal LIN_NoofPayts = BigDecimal.valueOf(NoOfPayts);
                LocalDate LIN_StartDate = ASG_date_StartDate.getValue();
                ;
                Date LIN_EndDate = End_Date;
                BigDecimal LIN_SchedPayment = TotMonthlyPayment;
                BigDecimal LIN_TotEarly = BigDecimal.valueOf(ExtraTotal);
                BigDecimal LIN_TotIntrst = BigDecimal.valueOf(InterestTotal);

                String sql_LIN_Entry = "insert into loans_directory(loan_NO, provider, details, loan_amount, annual_rate, loan_period, number_of_payments, start_date, end_date, scheduled_payment, total_early_payments, total_interest) " +
                        "values('" + LIN_No + "', '" + LIN_Provider + "', '" + LIN_Details + "', '" + LIN_Amount + "', '" + LIN_Rate + "', '" + LIN_Period + "', '" + LIN_NoofPayts + "', '" + LIN_StartDate + "', '" + LIN_EndDate + "', '" + LIN_SchedPayment + "', '" + LIN_TotEarly + "', '" + LIN_TotIntrst + "')";
                FISCUS_Connection.Save_to_DB(sql_LIN_Entry);
            }


        }

    }


    public void Save_InventoryEntry() {
        LocalDate Invy_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String Invy_Time = java.time.LocalTime.now().format(dtf);
        String Invy_ItemName = INV_ItemName.getText();
        String Invy_CatID = INV_CatalogueID.getText();
        BigDecimal Invy_ReorderLevel;
        BigDecimal Invy_CurrQuan;
        BigDecimal Invy_StockingPrice;
        BigDecimal Invy_StockValue;
        BigDecimal Invy_SellingPrice;
        BigDecimal Invy_DiscLimit;

        if (Invy_ItemName.equals("") || Invy_CatID.equals("") || INV_ReorderLevel.getText().equals("") || INV_CurrQuantity.getText().equals("") || INV_StockingPrice.getText().equals("") || INV_StockingPrice.getText().equals("") || INV_SellingPrice.getText().equals("")) {
            MissingEntryDialog().show();

        } else {
            Invy_ReorderLevel = new BigDecimal(INV_ReorderLevel.getText());
            Invy_CurrQuan = new BigDecimal(INV_CurrQuantity.getText());
            Invy_StockingPrice = new BigDecimal(INV_StockingPrice.getText());
            Invy_SellingPrice = new BigDecimal(INV_SellingPrice.getText());
            Invy_StockValue = Invy_CurrQuan.multiply(Invy_StockingPrice);
            Invy_StockValue = Invy_StockValue.setScale(2, RoundingMode.HALF_UP);
            Invy_DiscLimit = new BigDecimal(INV_DiscountLimit.getText());

            String INV_Entry = "Insert into inventory(date, time, item_name, catalogue_ID, reorder_level, current_quantity, stocking_price, stock_value, selling_price, discount_limit) " +
                    "values('" + Invy_Date + "', '" + Invy_Time + "', '" + Invy_ItemName + "', '" + Invy_CatID + "', '" + Invy_ReorderLevel + "', '" + Invy_CurrQuan + "', '" + Invy_StockingPrice + "', '" + Invy_StockValue + "', '" + Invy_SellingPrice + "', '" + Invy_DiscLimit + "')";

            FISCUS_Connection.Save_to_DB(INV_Entry);
            RefreshTableviews();
            FISCUS_UI_Methods.makeToast((Stage) pane_Inventory.getScene().getWindow(), "Inventory Successfully Updated!", 5000, 500, 2500);
        }

    }

    public void Save_to_Loans_Directory(ActionEvent actionEvent) {
        if (tgl_SaveToDir.isSelected()) {
            FISCUS_UI_Methods.openAStage("/KONIG/CENTRAL/GUI/Fxmls/loan_dialogue.fxml", "Enter Loan Details");
        }
    }


    public void Save_OEQEntry(ActionEvent actionEvent) {
        LocalDate OE_Date = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String OE_Time = java.time.LocalTime.now().format(dtf);
        String OE_OwnerName = OEQ_txtName.getText();
        String OE_Action = OEQ_cboAcctAction.getValue();
        String OE_Notes = OEQ_txtNotes.getText();
        BigDecimal OE_Amount;

        if (OE_OwnerName.equals("") || OE_Action.equals("") || OE_Notes.equals("") || OEQ_txtAmount.getText().equals("") || OEQ_cboAcctAction.getValue().equals("")) {
            MissingEntryDialog().show();
        } else {
            OE_Amount = new BigDecimal(OEQ_txtAmount.getText());

            String SQL_OE_Entry = "Insert into owners_equity(date, time, owner_name, account_action, notes, amount) " +
                    "values('" + OE_Date + "', '" + OE_Time + "', '" + OE_OwnerName + "', '" + OE_Action + "', '" + OE_Notes + "', '" + OE_Amount + "')";

            FISCUS_Connection.Save_to_DB(SQL_OE_Entry);

            RefreshTableviews();
            FISCUS_UI_Methods.makeToast((Stage) pane_OwnersEquity.getScene().getWindow(), "Owners' Equity Journal Successfully Updated", 5000, 500, 2500);

        }


    }


}

