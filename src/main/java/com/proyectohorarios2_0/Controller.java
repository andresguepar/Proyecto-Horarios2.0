package com.proyectohorarios2_0;

import com.Model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label asig;

    @FXML
    private Button btClose;

    @FXML
    private Button btDelete;

    @FXML
    private Button btEdit;

    @FXML
    private Button btSave;

    @FXML
    private Label fecha;

    @FXML
    private Label hora;

    @FXML
    private Label name;

    @FXML
    private Label salon;

    @FXML
    private Label sede;

    @FXML
    private Label semestre;

    @FXML
    private TableView<Persona> table;

    @FXML
    private TableColumn<Persona,String> tbSemestre;
    @FXML
    private TableColumn<Persona, String> tbAsig;

    @FXML
    private TableColumn<Persona, LocalDate> tbFecha;

    @FXML
    private TableColumn<Persona, String> tbHora;

    @FXML
    private TableColumn<Persona, String> tbProfesor;

    @FXML
    private TableColumn<Persona, String> tbSalon;

    @FXML
    private TableColumn<Persona, String> tbSede;

    @FXML
    private TextField txtAsig;

    @FXML
    private DatePicker txtFecha;

    @FXML
    private ChoiceBox<String> txtHora;

    @FXML
    private TextField txtName;

    @FXML
    private ChoiceBox<String> txtSalon;

    @FXML
    private ChoiceBox<String> txtSede;

    @FXML
    private ChoiceBox<String> txtSemestre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtHora.getItems().addAll("7:00 AM","8:00 AM","9:00 AM","10:00 AM","11:00 AM","12:00 PM");
        txtSemestre.getItems().addAll("1","2","3","4","5","6","7","8");
        txtSede.getItems().addAll("Principal","Nogal","Anova","Alcazar");
        txtSalon.getItems().addAll("101","102","103","104");

        showPersona();
    }

    public Connection getConenction(){
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios", "root", "");
            return con;
        }catch (Exception exception){
            System.out.println("Error" + exception.getMessage());
            return null;
        }
    }

    public ObservableList<Persona> getPersonaList() {
        ObservableList<Persona> personList = FXCollections.observableArrayList();
        Connection conn = getConenction();
        String query = "SELECT * FROM persona";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Persona persona;
            while (rs.next()){
                persona = new Persona(rs.getString("nombre"), rs.getString("semestre"), rs.getString("asignatura"), rs.getString("sede"), rs.getString("salon"), rs.getString("hora"), rs.getDate("fecha").toLocalDate());
                personList.add(persona);
            }

        }catch (Exception exception){
            exception.printStackTrace();

        }
        return personList;
    }

    public void showPersona(){
        ObservableList<Persona> list = getPersonaList();
        tbProfesor.setCellValueFactory(new PropertyValueFactory<>("profesor"));
        tbSemestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
        tbAsig.setCellValueFactory(new PropertyValueFactory<>("asignatura"));
        tbSede.setCellValueFactory(new PropertyValueFactory<>("sede"));
        tbSalon.setCellValueFactory(new PropertyValueFactory<>("salon"));
        tbHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tbFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        table.setItems(list);

    }
    @FXML
    private void save (ActionEvent event){

    }
    @FXML
    private void edit (ActionEvent event){

    }
    @FXML
    private void delete (ActionEvent event){

    }
    @FXML
    private void close (ActionEvent event){

    }
}