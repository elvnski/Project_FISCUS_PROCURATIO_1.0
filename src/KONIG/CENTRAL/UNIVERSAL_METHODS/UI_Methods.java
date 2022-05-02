package KONIG.CENTRAL.UNIVERSAL_METHODS;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UI_Methods {

    public static void makeToast(Stage ownerStage, String ToastMessage, int ToastTime, int FadeInTime, int FadeOutTime) {


        Stage toastStage = new Stage();
        toastStage.initOwner(ownerStage);
        toastStage.setResizable(false);
        toastStage.initStyle(StageStyle.TRANSPARENT);

        Text text = new Text(ToastMessage);
        text.setFont(Font.font("Futura", 15));
        text.setFill(Color.WHITE);

        StackPane root = new StackPane(text);
        root.setStyle("-fx-background-radius: 10; -fx-background-color: linear-gradient(to right, rgba(27, 0, 82, 1), rgba(130, 0, 0, 1)); -fx-padding: 10 60 10 60;");
        root.setPrefHeight(30);
        root.setOpacity(0);
        root.setLayoutY(638);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        toastStage.setScene(scene);
        toastStage.show();

        Timeline fadeInTimeline = new Timeline();
        KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(FadeInTime), new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 1));
        fadeInTimeline.getKeyFrames().add(fadeInKey1);
        fadeInTimeline.setOnFinished((ae) ->
        {
            new Thread(() -> {
                try {
                    Thread.sleep(ToastTime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Timeline fadeOutTimeline = new Timeline();
                KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(FadeOutTime), new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 0));
                fadeOutTimeline.getKeyFrames().add(fadeOutKey1);
                fadeOutTimeline.setOnFinished((aeb) -> toastStage.close());
                fadeOutTimeline.play();
            }).start();
        });
        fadeInTimeline.play();
    }

    public JFXDialog Make_A_Dialog_Box(StackPane stackpane, Text DialogHeading, Text DialogBody, JFXButton actionButtion) {
        /**Creating a layout for the dialog*/

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(DialogHeading);
        dialogLayout.setBody(DialogBody);

        JFXDialog NewDialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.LEFT);

        dialogLayout.setActions(actionButtion);


        return NewDialog;
    }

    public void Initialize_ComboBox(String sql, Database_Ops database_ops, JFXComboBox<String> jfxComboBox, String ColumnName) {
        try {
            ResultSet rset1 = database_ops.Database_Command.executeQuery(sql);
            List<String> Suppliers = new ArrayList<>();
            List<String> cboValues = new ArrayList<>();

            while (rset1.next()) {
                Suppliers.add(rset1.getString(ColumnName));
            }

            Set<String> valscbo = new HashSet<>(Suppliers);
            cboValues.addAll(valscbo);

            for (int i = 0; i < cboValues.size(); i++) {
                jfxComboBox.getItems().addAll(cboValues.get(i));
            }

        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Number_Range_Validation(TextField NumberTextField, String Range) {
        NumberTextField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if ((!newValue)) { //when focus is lost
                switch (Range) {
                    case "Million":
                        if (!NumberTextField.getText().matches("([0-9]|[1-9][0-9]{1,5}|1000000)(\\.[0-9]{1,2})?|1000000(\\.0{1,2}){0,1}|(\\.[0-9]{1,2}){0,1}")) {
                            NumberTextField.setText("");
                        }
                        break;
                    case "Billion":
                        if (!NumberTextField.getText().matches("([0-9]|[1-9][0-9]{1,8}|1000000000)(\\.[0-9]{1,2})?|1000000(\\.0{1,2}){0,1}|(\\.[0-9]{1,2}){0,1}")) {
                            NumberTextField.setText("");
                        }
                        break;
                    case "Percentage":
                        if (!NumberTextField.getText().matches("([0-9]|[1-9][0-9]|100)(\\.[0-9]{1,2}){0,1}|100(\\.0{1,2})?|(\\.[0-9]{1,2}){0,1}")) {
                            NumberTextField.setText("");
                        }
                        break;
                    case "Loan_Period":
                        if (!NumberTextField.getText().matches("([1-9]|[1-9][0-9]|[1-6][0-9]{2}|7[01][0-9]|720)(\\.[0-9]{1,2})?|720(\\.0{1,2}){0,1}|(\\.[0-9]{1,2}){0,1}")) {
                            NumberTextField.setText("");
                        }
                        break;
                    case "100_Million":
                        if (!NumberTextField.getText().matches("([1-9]|[1-9][0-7]{1,5}|100000000)(\\.[0-9]{1,2})?|100000000(\\.0{1,2}){0,1}|(\\.[0-9]{1,2}){0,1}")) {
                            NumberTextField.setText("");
                        }
                        break;


                }
                // regex for numbers 1.00 to 1000000.99 and .00 to .99

            }
        });
    }

    public void Load_Tableview_Content(Database_Ops database_ops, String SQL_Table_Name, TableView tableView) {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        tableView.getItems().clear();
        tableView.getColumns().clear();

        try {
            //Selecting all records in employee_data
            String SQL = "Select * from " + SQL_Table_Name;
            ResultSet rs = database_ops.Database_Command.executeQuery(SQL);

            //TABLE COLUMNS ADDED DYNAMICALLY
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;

                String[] Column_Names = new String[]{""};

                switch (SQL_Table_Name) {
                    case "accounts_payable":
                        Column_Names = new String[]{"Date", "Time", "AP S/No.", "Invoice No.", "Supplier Name", "Description", "Invoice Amount", "Discount", "Due date", "Payment", "Balance Due", "Debit", "Credit"};
                        break;
                    case "cash_payments":
                        Column_Names = new String[]{"Date", "Time", "CP ID", "Invoice No.", "Supplier Name", "Details", "Cash Paid", "Discount Received"};
                        break;
                    case "cash":
                        Column_Names = new String[]{"Date", "Time", "Cash ID", "Source", "Details", "Debit", "Credit", "Balance"};
                        break;
                    case "accounts_receivable":
                        Column_Names = new String[]{"Date", "Time", "AR S/No.", "Invoice No.", "Customer Name", "Description", "Invoice Amount", "Discount", "Due date", "Payment", "Balance Due", "Debit", "Credit"};
                        break;
                    case "cash_receipts":
                        Column_Names = new String[]{"Date", "Time", "CR ID", "Receipt/Invoice No.", "Client Name", "Details", "Cash Received", "Discount Given"};
                        break;
                    case "amortization_schedule":
                        Column_Names = new String[]{"Payment\nNo.", "Payment\nDate", "Beginning Balance", "Scheduled Payment", "Extra Payment", "Total Payment", "Principal", "Interest", "Ending Balance", "Cumulative Interest"};
                        break;
                    case "general_ledger":
                        Column_Names = new String[]{"Gen. Ledger\nNo.", "Date", "Account Type", "Account Name", "Client Details", "Debit", "Credit"};
                        break;
                    case "inventory":
                        Column_Names = new String[]{"Invoice\nID", "Date", "Time", "Item Name", "Catalogue ID", "Reorder Level", "Selling Price", "Current Quantity", "Stocking Price", "Stock Value", "Discount Limit"};
                        break;
                    case "owners_equity":
                        Column_Names = new String[]{"Date", "Time", "OE ID", "Owner Name", "Account Action", "Notes", "Amount"};
                        break;
                }


                TableColumn col = new TableColumn(Column_Names[i]);
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                tableView.getColumns().addAll(col);


            }
            //********************************
            //* Data added to ObservableList *
            //********************************/
            while (rs.next()) {
                //Iterate row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            //FINALLY ADDED TO TableView
            tableView.setItems(data);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on building data");
        }
        tableView.setVisible(true);

    }


    public void SnackBar_Maker(Pane Target_Pane, String Message) {
        JFXSnackbar CreateSuccess = new JFXSnackbar(Target_Pane);
        CreateSuccess.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout(Message), Duration.seconds(8)));
        CreateSuccess.setOnMouseClicked(event -> {
            CreateSuccess.unregisterSnackbarContainer(Target_Pane);
        });
    }

    public void SnackBar_Maker(AnchorPane Target_Pane, String Message) {
        JFXSnackbar CreateSuccess = new JFXSnackbar(Target_Pane);
        CreateSuccess.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout(Message), Duration.seconds(8)));
        CreateSuccess.setOnMouseClicked(event -> {
            CreateSuccess.unregisterSnackbarContainer(Target_Pane);
        });
    }

    public BigDecimal get_CashBalance(Database_Ops database_ops) {
        BigDecimal CashBalance = BigDecimal.valueOf(0.0);
        try {
            String get_MaxCashID = "Select MAX(cash_ID) as cash_ID from cash";
            int cashid = 0;
            ResultSet rs8 = database_ops.Database_Command.executeQuery(get_MaxCashID);
            while (rs8.next()) {
                cashid = rs8.getInt("cash_ID");
            }

            String get_CashBalance = "Select balance as balance from cash where cash_ID = '" + cashid + "'";
            ResultSet rs9 = database_ops.Database_Command.executeQuery(get_CashBalance);
            while (rs9.next()) {
                CashBalance = new BigDecimal(rs9.getDouble("balance"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return CashBalance;
    }

    public void openAStage(String FXML_File_Location, String Stage_Title) {
        try {
            FXMLLoader newstage = new FXMLLoader(getClass().getResource(FXML_File_Location));
            Parent root = newstage.load();
            Stage NewWindow = new Stage();
            NewWindow.setScene(new Scene(root));
            NewWindow.initStyle(StageStyle.DECORATED);
            NewWindow.initModality(Modality.APPLICATION_MODAL);
            NewWindow.setResizable(false);
            NewWindow.setTitle(Stage_Title);
            NewWindow.setAlwaysOnTop(true);
            NewWindow.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class datarecords extends RecursiveTreeObject<datarecords> {
        StringProperty colNME;
        ObservableList<String> list;

        public datarecords(String colNME) {
            this.colNME = new SimpleStringProperty(colNME);
        }
    }


}

























