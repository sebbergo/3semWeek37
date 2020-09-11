package facades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import entities.Movie;
/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getMovieCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long movieCount = (long) em.createQuery("SELECT COUNT(m) FROM Movie m").getSingleResult();
            return movieCount;
        } finally {
            em.close();
        }

    }

    public List<Movie> getMovieYear(int year) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Movie m WHERE m.year = :year");
            query.setParameter("year", year);
            List<Movie> result = query.getResultList();
            
            return result;
        } finally {
            em.close();
        }

    }

    public Movie getMovieTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("Select m FROM Movie m WHERE m.title = :title");
            query.setParameter("title", title);
            Movie result = (Movie) query.getSingleResult();
            return result;
        } finally {
            em.close();
        }

    }

    public Movie getMovieAuthor(String author) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Movie m WHERE m.author = :author");
            query.setParameter("author", author);
            Movie result = (Movie) query.getSingleResult();
            return result;
        } finally {
            em.close();
        }

    }
    
    public List<Movie> getAllMovies() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Movie m");
            List<Movie> result = query.getResultList();
            return result;
        } finally {
            em.close();
        }

    }

    public Movie getMovieByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Movie m WHERE m.id = :id");
            query.setParameter("id", id);
            Movie result = (Movie) query.getSingleResult();
            return result;
        } finally {
            em.close();
        }

    }
}
