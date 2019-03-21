package Service;
import Domain.CardClient;
import Repository.CardClientRepository;
import java.util.List;

public class CardClientService {

        private CardClientRepository repository;

        public CardClientService(CardClientRepository repository) {
            this.repository = repository;
        }

        public void insert (String id, String name, String firstname, String CNP, String dateOfBirth, String dateOfRegistration ) {
            CardClient CardClient = new CardClient(id, name, firstname, CNP, dateOfBirth, dateOfRegistration);
            repository.insert(CardClient);
        }

        public void update(String id, String name, String firstname, String CNP, String dateOfBirth, String dateOfRegistration) {
            CardClient CardClient = new CardClient (id, name, firstname, CNP, dateOfBirth, dateOfRegistration);
            repository.update(CardClient);
        }

        public void remove(String id) {
            repository.remove(id);
        }

        public List<CardClient> getAll() {

            return repository.getAll();
        }
    }





