package Tests;


import Domain.Medicament;
import Domain.MedicamentValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FarmacieTestRepository {


        @Test
        void findByIdWithExistingIdShouldReturnCorrectCake() {

            IRepository<Medicament> repo = new InMemoryRepository<>(new MedicamentValidator());
            Medicament added = new Medicament("1", "test", "test", 100, true);
            repo.upsert(added);
            Medicament found = repo.findById("1");
            assertNotNull(found, "Returned null for existing id!");
            assertEquals("1", found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
            assertEquals("test", found.getName(), String.format("Returned name=%s instead of %s", found.getName(), added.getName()));
            // ... so on
        }

        @org.junit.jupiter.api.Test
        void upsert() {
        }

        @org.junit.jupiter.api.Test
        void remove() {
        }

        @org.junit.jupiter.api.Test
        void getAll() {
        }
    }

