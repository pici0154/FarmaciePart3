import Domain.CardClientValidator;
import Domain.MedicamentValidator;
import Domain.TranzactieValidator;
import Repository.CardClientRepository;
import Repository.MedicamentRepository;
import Repository.TranzactieRepository;
import Service.CardClientService;
import Service.MedicamentService;
import Service.TranzactieService;
import UI.Console;

    public class Main {

        public static void main(String[] args) {
            MedicamentValidator MedicamentValidator = new MedicamentValidator();
            MedicamentRepository MedicamentRepository = new MedicamentRepository(MedicamentValidator);
            MedicamentService MedicamentService = new MedicamentService(MedicamentRepository);


            CardClientValidator CardClVal = new CardClientValidator();
            CardClientRepository CardClRepo = new CardClientRepository(CardClVal);
            CardClientService cardClServ = new CardClientService(CardClRepo);

            TranzactieValidator TranzactieValidator = new TranzactieValidator();
            TranzactieRepository TranzactieRepository = new TranzactieRepository(TranzactieValidator);
            TranzactieService TranzactieService = new TranzactieService(TranzactieRepository, MedicamentRepository);


            Console console = new Console(MedicamentService, cardClServ, TranzactieService);
            console.run();
        }
    }


