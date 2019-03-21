package Service;
import Domain.Medicament;
import Repository.MedicamentRepository;
import java.util.List;

public class MedicamentService {
        private MedicamentRepository repository;

        public MedicamentService(MedicamentRepository repository) {
            this.repository = repository;
        }

        public void insert(String id, String name, String producator, double price, boolean reteta) {
            Medicament Medicament = new Medicament(id, name, producator, price,reteta);
            repository.insert(Medicament);
        }

        public void update(String id, String name, String producator, double price, boolean reteta) {
            Medicament Medicament = new Medicament(id, name, producator, price,reteta);
            repository.update(Medicament);
        }

        public void remove(String id) {
            repository.remove(id);
        }

        public List<Medicament> getAll() {
            return repository.getAll();
        }
    }


