package facades;

import utils.EMF_Creator;
import entities.Movie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;
    private static final Movie m1 = new Movie("Star Wars", 1977, "George Lucas");
    private static final Movie m2 = new Movie("Harry Potter", 2001, "J.K. Rowling");

    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = MovieFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.persist(m1);
            em.persist(m2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(2, facade.getMovieCount());
    }

    @Test
    public void testYearMethod() {
        assertEquals(m2.getId(), facade.getMovieYear(2001).get(0).getId());
    }
    
    @Test
    public void testTitleMethod() {
        assertEquals(m1.getId(), facade.getMovieTitle("Star Wars").getId());
    }
    
    @Test
    public void testAuthorMethod() {
        assertEquals(m1.getId(), facade.getMovieAuthor("George Lucas").getId());
    }
    
    @Test
    public void testAllMethod() {
        assertEquals(2, facade.getAllMovies().size());
    }
    
    //Disabled because the id keeps changing in the db, because it goes
    //up everytime i create the table
    @Test
    @Disabled
    public void testIdMethod() {
        assertEquals(m1.getId(), facade.getMovieByID(1).getId());
    }
}
