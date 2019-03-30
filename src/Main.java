import Domain.*;
import Repository.InMemoryRepository;
import  Repository.IRepository;
import Service.CardClientService;
import Service.MedicamentService;
import Service.TranzactieService;
import UI.Console;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


    public class Main extends Application {

        @Override
        public  void start(Stage primaryStage) throws Exception{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/mainWindow.fxml"));
           // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/NewWindow.fxml"));
            Parent root = fxmlLoader.load();

            IValidator<Medicament> medicamentValidator = new MedicamentValidator();
            IValidator<CardClient> cardClientValidator = new CardClientValidator();
            IValidator<Tranzactie> transactionValidator = new TranzactieValidator();

            IRepository<Medicament> medicamentRepository = new InMemoryRepository(medicamentValidator);
            IRepository<CardClient> cardClientRepository = new InMemoryRepository(cardClientValidator);
            IRepository<Tranzactie> transactionRepository = new InMemoryRepository(transactionValidator);

            MedicamentService medicamentService = new MedicamentService(medicamentRepository);
            CardClientService cardClientService = new CardClientService(cardClientRepository);
            TranzactieService transactionService = new TranzactieService(transactionRepository, medicamentRepository);

          //  Console console = new Console(medicamentService, cardClientService, transactionService);
            // console.run();

            MainController mainController = fxmlLoader.getController();
            mainController.setServices(medicamentService,cardClientService,transactionService);

            primaryStage.setTitle("Medicamente");
            primaryStage.setScene(new Scene(root, 450, 500));
            primaryStage.show();
        }

        public static void main (String [] args){
            launch(args);
        }
    }


