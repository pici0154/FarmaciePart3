package UI;

import Domain.CardClient;
import Domain.Medicament;
import Domain.Tranzactie;
import Service.CardClientService;
import Service.MedicamentService;
import Service.TranzactieService;
import java.util.Iterator;
import java.util.Scanner;


public class Console_Natural {

    private MedicamentService MedicamentService;
    private CardClientService CardClientService ;
    private TranzactieService TranzactieService;

    private Scanner scanner;

    public Console_Natural(MedicamentService MedicamentService, CardClientService b, TranzactieService TranzactieService) {
        this.MedicamentService = MedicamentService;
        this.CardClientService = CardClientService;
        this.TranzactieService = TranzactieService;
        this.scanner = new Scanner(System.in);
    }

    private void AddRemoveUpdateMedicament() {

        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new producer: ");
            String producator = scanner.nextLine();
            System.out.print("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter new recept: ");
            boolean reteta = Boolean.parseBoolean(scanner.nextLine());
            MedicamentService.update(id, name, producator, price, reteta);

        } catch (RuntimeException rex) {
            System.out.println("Errors:\n"+ rex.getMessage());

        }
    }
}