package com.example.uaspbo2;
/**
 * Sebastian Giovanni Bastari 1972006
 */
import com.example.uaspbo2.DAO.feMemberDAO;
import com.example.uaspbo2.DAO.fePointDAO;
import com.example.uaspbo2.DAO.feTransactionDAO;
import com.example.uaspbo2.model.FeMemberEntity;
import com.example.uaspbo2.model.FePointEntity;
import com.example.uaspbo2.model.FeTransactionEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.Member;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainController implements Initializable {
    @FXML
    private TextArea addressField;

    @FXML
    private DatePicker birthdateField;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSaveTransaction;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField citizenIdField;

    @FXML
    private TableColumn<FeMemberEntity, String> colBirthday;

    @FXML
    private TableColumn<FeMemberEntity, String> colCitizenId;

    @FXML
    private TableColumn<FePointEntity, String> colId;

    @FXML
    private TableColumn<FeMemberEntity, String> colNameCitizen;

    @FXML
    private TableColumn<FeTransactionEntity, String> colNominal;

    @FXML
    private TableColumn<FeMemberEntity, String> colPhone;

    @FXML
    private TableColumn<FePointEntity, String> colPoint;

    @FXML
    private TableColumn<FeTransactionEntity, String> colTransactionDate;

    @FXML
    private TextField emailField;



    @FXML
    private TextField namaCitizenField;

    @FXML
    private TextField nominalField;

    @FXML
    private TextField phoneFIeld;
    @FXML
    private Label selectedJumlahMember;

    @FXML
    private Label selectedJumlahPoint;

    @FXML
    private Label jumlahMember;

    @FXML
    private TableView<FeMemberEntity> tableCitizen;

    @FXML
    private TableView<FePointEntity> tablePoint;

    @FXML
    private TableView<FeTransactionEntity> tableTransaction;

    @FXML
    private DatePicker transactionDateField;

    @FXML
    private TextField usernameField;

    private feMemberDAO memberDAO ;
    private feTransactionDAO transactionDAO ;
    private fePointDAO pointDAO ;
    ObservableList<FeMemberEntity> members;
    private ObservableList<FePointEntity> points;
    ObservableList<FeTransactionEntity> transactions;


    @FXML
    void resetAction(ActionEvent event) {
        citizenIdField.clear();
        usernameField.clear();
        namaCitizenField.clear();
        addressField.clear();
        phoneFIeld.clear();
        emailField.clear();
        birthdateField.setValue(null);
    }

    @FXML
    void saveMemberAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                FeMemberEntity member =new FeMemberEntity();
                member.setCitizenId(citizenIdField.getText());
                member.setName(namaCitizenField.getText());
                member.setAddress(addressField.getText());
                member.setPhone(phoneFIeld.getText());
                member.setEmail(emailField.getText());
                member.setUsername(usernameField.getText());
                member.setBirthdate(Date.valueOf(birthdateField.getValue()));
                feMemberDAO memberDAO = new feMemberDAO();
                memberDAO.addData(member);
                members.clear();
                members.addAll(memberDAO.showData());
                tableCitizen.refresh();
                citizenIdField.clear();
                usernameField.clear();
                namaCitizenField.clear();
                addressField.clear();
                phoneFIeld.clear();
                emailField.clear();
                birthdateField.setValue(null);
                return null;
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(task);
        service.shutdown();

    }

    @FXML
    void saveTransAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                FeTransactionEntity transaction =new FeTransactionEntity();
                transaction.setNominal(Long.parseLong(nominalField.getText()));
                transaction.setTransDate(Date.valueOf(transactionDateField.getValue()));
                feTransactionDAO transactionDAO = new feTransactionDAO();
                transactionDAO.addData(transaction);
                transactions.clear();
                transactions.addAll(transactionDAO.showData());
                nominalField.clear();
                transactionDateField.setValue(null);
                return null;
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(task);
        service.shutdown();

    }

    @FXML
    void updateAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                FeMemberEntity selected;
                selected = tableCitizen.getSelectionModel().getSelectedItem();
                selected.setBirthdate(Date.valueOf(birthdateField.getValue()));
                selected.setCitizenId(citizenIdField.getText());
                selected.setName(namaCitizenField.getText());
                selected.setAddress(addressField.getText());
                selected.setPhone(phoneFIeld.getText());
                selected.setEmail(emailField.getText());
                selected.setUsername(usernameField.getText());
                feMemberDAO memberDAO = new feMemberDAO();
                int result = memberDAO.updateData(selected);
                if (result != 0){
                    System.out.println("Update Berhasil");
                }
                members.clear();
                members.addAll(memberDAO.showData());
                tableCitizen.refresh();
                return null;
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(task);
        service.shutdown();

    }
    @FXML
    void selectedItem(MouseEvent event) {
        citizenIdField.setText(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getCitizenId()));
        namaCitizenField.setText(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getName()));
        addressField.setText(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getAddress()));
        phoneFIeld.setText(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getPhone()));
        emailField.setText(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getEmail()));
        usernameField.setText(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getUsername()));
        birthdateField.setValue(LocalDate.parse(String.valueOf(tableCitizen.getSelectionModel().getSelectedItem().getBirthdate())));
        btnUpdate.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        feMemberDAO memberDAO = new feMemberDAO();
        fePointDAO pointDAO = new fePointDAO();
        feTransactionDAO transactionDAO = new feTransactionDAO();
        members =(ObservableList<FeMemberEntity>)memberDAO.showData();
        points = (ObservableList<FePointEntity>)pointDAO.showData();
        transactions = (ObservableList<FeTransactionEntity>) transactionDAO.showData();
        tableCitizen.setItems(members);
        tablePoint.setItems(points);
        tableTransaction.setItems(transactions);
        colCitizenId.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getCitizenId())));
        colNameCitizen.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getName())));
        colPhone.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPhone())));
        colBirthday.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getBirthdate())));
        colTransactionDate.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getTransDate())));
        colNominal.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNominal())));
        colId.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        colPoint.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getValue())));
        jumlahMember.setText(String.valueOf(members.size()));
    }

}