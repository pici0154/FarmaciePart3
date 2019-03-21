package Repository;

import Domain.Tranzactie;
import Domain.TranzactieValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class TranzactieRepository {
        private Map<String, Tranzactie> storage = new HashMap<>();
        private TranzactieValidator validator;

        /**
         * ...
         * @param TranzactieValidator
         */
        public TranzactieRepository(TranzactieValidator TranzactieValidator) {
            this.validator = TranzactieValidator;
        }

        public Tranzactie getById(String id) {
            return storage.get(id);
        }

        /**
         *
         * @param Tranzactie
         */
        public void insert(Tranzactie Tranzactie) {
            if (storage.containsKey(Tranzactie.getId_tranzactie())) {
                throw new RuntimeException(String.format("There already is a tranzactie with id=%s", Tranzactie.getId_tranzactie()));
            }

            validator.validate(Tranzactie);
            storage.put(Tranzactie.getId_tranzactie(), Tranzactie);
        }

        /**
         *
         * @param Tranzactie
         */
        public void update(Tranzactie Tranzactie) {
            if (!storage.containsKey(Tranzactie.getId_tranzactie())) {
                throw new RuntimeException(String.format("There is no tranzactie with id=%s", Tranzactie.getId_tranzactie()));
            }

            validator.validate(Tranzactie);
            storage.put(Tranzactie.getId_tranzactie(), Tranzactie);
        }

        /**
         *
         * @param id
         */
        public void remove(String id) {
            if (!storage.containsKey(id)) {
                throw new RuntimeException(String.format("There is no tranzactie with id=%s", id));
            }
            storage.remove(id);
        }

        /**
         *
         * @return
         */
        public List<Tranzactie> getAll() {
            return new ArrayList<>(storage.values());
        }
    }


