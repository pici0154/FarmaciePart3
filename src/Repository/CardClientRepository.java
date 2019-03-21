package Repository;

import Domain.CardClient;
import Domain.CardClientValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardClientRepository {
    private Map<String, CardClient> storage = new HashMap<>();
    private CardClientValidator validator;

    /**
     * ...
     * @param CardClientValidator
     */
    public CardClientRepository(CardClientValidator validator) {
        this.validator = validator;
    }

    public CardClient getById(String id) {
        return storage.get(id);
    }
    /**
     *
     * @param CardClient
     */
    public void insert(CardClient CardClient) {
        if (storage.containsKey(CardClient.getIdCard())) {
            throw new RuntimeException(String.format("There already is a cake with id=%s", CardClient.getIdCard()));
        }
        // check if the CNP Is unique
        if (storage.containsKey(CardClient.getCNP())) {
            throw new RuntimeException(String.format("There already is a cake with id=%s", CardClient.getCNP()));
        }

        validator.validate(CardClient);
        storage.put(CardClient.getIdCard(), CardClient);
    }

    /**
     *
     * @param CardClient
     */
    public void update(CardClient CardClient) {
        if (!storage.containsKey(CardClient.getIdCard())) {
            throw new RuntimeException(String.format("There is no CardClient with id=%s", CardClient.getIdCard()));
        }

        validator.validate(CardClient);
        storage.put(CardClient.getIdCard(), CardClient);
    }

    /**
     *
     * @param id
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException(String.format("There is no CardClient with id=%s", id));
        }

        storage.remove(id);
    }

    /**
     *
     * @return
     */
    public List<CardClient> getAll() {
        return new ArrayList<>(storage.values());
    }
}
