package UI;

import Domain.CardClient;
import Domain.Medicament;
import Domain.Tranzactie;
import Service.MedicamentService;
import Service.CardClientService;
import Service.TranzactieService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;


public class MainController {

        public TableView tblMedicament;
        public TableColumn colIdMedicament;
        public TableColumn colNumeMedicament;
        public TableColumn colProducatorMedicament;
        public TableColumn colPretMedicament;
        public TableColumn colRetetaMedicament;
        public TextField txtMedicamentID;
        public TextField txtMedicamentNume;
        public TextField txtMedicamentProducator;
        public TextField txtMedicamentPret;
        public TextField txtMedicamentReteta;
        public Button btnAddMedicament;

        private MedicamentService medicamentService;
        private CardClientService cardClientService;
        private TranzactieService tranzactieService;

        private ObservableList<Medicament> medicamente = FXCollections.observableArrayList();
        private ObservableList<Tranzactie> tranzactii = FXCollections.observableArrayList();
        private ObservableList<CardClient> cardClient = FXCollections.observableArrayList();

        public void setServices(MedicamentService medicamentService, CardClientService CardClientService, TranzactieService tranzactieService) {
            this.medicamentService = medicamentService;
            this.cardClientService = cardClientService;
            this.tranzactieService = tranzactieService;
        }

        public MedicamentService getMedicamentService(){
            return this.medicamentService;
        }
        @FXML
        private void initialize() {

           Platform.runLater(() -> {
                medicamente.addAll(medicamentService.getAll());
                tblMedicament.setItems(medicamente);

            });
        }

        public void btnAddMedicamentClick(ActionEvent actionEvent) {
            try {
                String id = txtMedicamentID.getText();
                String nume = txtMedicamentNume.getText();
                String producator = txtMedicamentProducator.getText();
                double pret = Double.parseDouble(txtMedicamentPret.getText());
                boolean reteta = Boolean.parseBoolean(txtMedicamentReteta.getText());

               medicamentService.insert(id,nume,producator,pret,reteta);

                medicamente.clear();
                medicamente.addAll(medicamentService.getAll());
            } catch ( RuntimeException rex ){
                Common.showValidationError(rex.getMessage());
            }
        }
        public void btnDeleteMedicamentClick(ActionEvent actionEvent){
            try{
                String id = txtMedicamentID.getText();
            medicamentService.remove(id);
            medicamente.clear();
            medicamente.addAll(medicamentService.getAll());
            }catch ( RuntimeException rex ){
                Common.showValidationError(rex.getMessage());
            }

        }

        public void btnUpdateMedicamentClick(ActionEvent actionEvent){
            try{
                String id = txtMedicamentID.getText();
                String nume = txtMedicamentNume.getText();
                String producator = txtMedicamentProducator.getText();
                double pret = Double.parseDouble(txtMedicamentPret.getText());
                boolean reteta = Boolean.parseBoolean(txtMedicamentReteta.getText());


                medicamentService.update(id,nume,producator,pret,reteta);

                medicamente.clear();
                medicamente.addAll(medicamentService.getAll());
            } catch ( RuntimeException rex ){
                Common.showValidationError(rex.getMessage());
            }
        }


        public void btnAddTranzactieClick(ActionEvent actionEvent){
            try {
               // String id_tranzactie = txtTranzactieID.getText();
               // String id_medicament = txtTranzactietIDMedicament.getText();
               // String id_card_client = txtIDCardClientTranzactieMedicament.getText();
              //  String nr_bucati = txtNr_bucati.getText();
               // String date = txtDate.getText();
               // String hour = txtHour.getText();

               // tranzactieService.insert(id_tranzactie,id_medicament,id_card_client,nr_bucati,date,hour);

                tranzactii.clear();
                tranzactii.addAll(tranzactieService.getAll());
            } catch ( RuntimeException rex ){
                System.out.println("Error Add tranzactie!");
                Common.showValidationError(rex.getMessage());
            }
        }
}




