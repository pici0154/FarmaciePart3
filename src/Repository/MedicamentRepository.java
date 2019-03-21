package Repository;

import Domain.Medicament;
import Domain.MedicamentValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentRepository {
    private Map<String, Medicament> storage = new HashMap<>();
    private MedicamentValidator validator;

    /**
     * ...
     * @param MedicamentValidator
     */
    public MedicamentRepository(MedicamentValidator MedicamentValidator) {
        this.validator = MedicamentValidator;
    }

    public Medicament getById(String id) {
        return storage.get(id);
    }


    /**
     *
     * @param Medicament
     */
    public void insert(Medicament Medicament) {
        if (storage.containsKey(Medicament.getId())) {
            throw new RuntimeException(String.format("There already is a medicament with id=%s", Medicament.getId()));
        }

        validator.validate(Medicament);
        storage.put(Medicament.getId(), Medicament);
    }

    /**
     *
     * @param Medicament
     */
    public void update(Medicament Medicament) {
        if (!storage.containsKey(Medicament.getId())) {
            throw new RuntimeException(String.format("There is no medicament with id=%s", Medicament.getId()));
        }

        validator.validate(Medicament);
        storage.put(Medicament.getId(), Medicament);
    }

    /**
     *
     * @param id
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException(String.format("There is no medicament with id=%s", id));
        }

        storage.remove(id);
    }

    /**
     *
     * @return
     */
    public List<Medicament> getAll() {
        return new ArrayList<>(storage.values());
    }
}
