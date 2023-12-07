package ru.tinkoff.qa.dbtests;

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.junit.jupiter.api.*;
import ru.tinkoff.qa.hibernate.BeforeCreator;
import ru.tinkoff.qa.hibernate.HibernateSessionFactoryCreator;
import ru.tinkoff.qa.hibernate.bdmodels.Animal;
import ru.tinkoff.qa.hibernate.bdmodels.Places;
import ru.tinkoff.qa.hibernate.bdmodels.Positions;
import ru.tinkoff.qa.hibernate.bdmodels.Workman;
import ru.tinkoff.qa.hibernate.bdmodels.Zoo;
import java.util.List;

public class ZooHibernateTests {

    private static Session session;
    @BeforeAll
    static void init() {
        BeforeCreator.createData();
    }
    @BeforeEach
    public final void openSession() {
        session = HibernateSessionFactoryCreator.createSessionFactory().openSession();
        session.getTransaction().begin();
    }
    @AfterEach
    public final void closeSession() {
        session.close();
    }
    /**
     * В таблице public.animal ровно 10 записей.
     */
    @Test
    public void countRowAnimal() {
        final int countAnimal = 10;
        String query = "SELECT COUNT(*) FROM Animal";
        long count = session.createQuery(query, Long.class).getSingleResult();
        Assertions.assertEquals(count, countAnimal, "Check count animal");
    }

    /**
     * В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно.
     */
    @Test
    public void insertIndexAnimal() {
        final int id = 10;
        Animal animal = new Animal();
        animal.setId(id);
        session.persist(animal);
        Assertions.assertThrows(PersistenceException.class,
                () -> session.getTransaction().commit(), "Check double id");
    }

    /**
     * В таблицу public.workman нельзя добавить строку с name = null.
     */
    @Test
    public void insertNullToWorkman() {
        final int age = 35;
        final int id = 10;
        Positions position = session.get(Positions.class, 1);
        Workman workman = new Workman();
        workman.setAge(age);
        workman.setPosition(position);
        workman.setId(id);
        session.persist(workman);
        Assertions.assertThrows(PersistenceException.class,
                () -> session.getTransaction().commit(), "Check null name");
    }

    /**
     * Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк.
     */
    @Test
    public void insertPlacesCountRow() {
        Places place = new Places();
        final int placeNum = 200;
        final int id = 6;
        final int countPlaces = 6;
        place.setRow(1);
        place.setId(id);
        place.setPlaceNum(placeNum);
        place.setName("6");
        session.persist(place);
        session.getTransaction().commit();
        String query = "SELECT COUNT(*) FROM Places";
        long count = session.createQuery(query, Long.class).getSingleResult();
        Assertions.assertEquals(count, countPlaces, "Check count animal");
    }

    /**
     * В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'.
     */
    @Test
    public void countRowZoo() {
        final String nameCenter = "Центральный";
        final String nameNorth = "Северный";
        final String nameWest = "Западный";
        boolean center = false;
        boolean north = false;
        boolean west = false;
        String query = "SELECT z FROM Zoo z";
        List<Zoo> zoo = session.createQuery(query, Zoo.class).getResultList();
        for (Zoo z : zoo) {
            switch (z.getName()) {
                case nameCenter -> center = true;
                case nameNorth -> north = true;
                case nameWest -> west = true;
                default -> {
                    assert false;
                }
            }
        }
        final int count = 3;
        Assertions.assertTrue(center && north && west && (zoo.size() == count),
                "Check count animal");
    }
}
