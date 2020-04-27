package repo;

import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    private EntityManagerFactory entityManagerFactory;

    public AlbumRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Album album) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Album> findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query =entityManager.createQuery("select id from Album id where id.id= :id");
        List albums = query.setParameter("id", id).getResultList();
        entityManager.close();
        return albums.isEmpty() ? null : albums;
    }
    public Album findByName(String albumName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select album from Album album where album.name like: name");
        List albums = query.setParameter("name",albumName).getResultList();
        entityManager.close();
        return albums.isEmpty() ? null : (Album) albums.get(0);
    }

    public List<Album> findByArtist (long artistId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Album where a.artistId= :artistId");

        List<Album> albums = query.setParameter("artistId",artistId).getResultList();
        entityManager.close();
        return albums.isEmpty() ? null : albums;
    }

}
