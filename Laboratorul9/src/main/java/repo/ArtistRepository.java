package repo;

import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ArtistRepository {
    private EntityManagerFactory entityManagerFactory;

    public ArtistRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create (Artist artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Artist> findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query =entityManager.createQuery("select id from Artist id where id.id= :id");
        List<Artist> artists = query.setParameter("id", id).getResultList();
        entityManager.close();
        return artists.isEmpty() ? null : artists;
    }

    public Artist findByName(String artistName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select artist from Artist artist where artist.name like: name");
        List artists = query.setParameter("name",artistName).getResultList();
        entityManager.close();
        return artists.isEmpty() ? null : (Artist) artists.get(0);
    }
}
