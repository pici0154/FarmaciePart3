package Domain;

public class MedicamentValidator {

    public void validate(Medicament medicament) {

         String errors = "";
         double price = medicament.getPrice();
        if (price < 0) {
            errors += "The price should be greater then 0";
        }

        if (!errors.equals("")) {
            throw new RuntimeException(errors);
        }
    }

}
