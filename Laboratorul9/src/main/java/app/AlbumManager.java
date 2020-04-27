package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.Scanner;

public class AlbumManager {
    static final EntityManagerFactory em = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    static final AlbumRepository albumRepository = new AlbumRepository(em);
    static final ArtistRepository artistRepository = new ArtistRepository(em);

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("INPUT: ");
            String string = scanner.nextLine();
            if(string.equals("exit")) break;
        }

    }

    private void createAlbum(String albumName) {
        Album album = new Album();
        album.setName(albumName);
        albumRepository.create(album);
    }

    private void createArtist(String artistName) {
        Artist artist = artistRepository.findByName(artistName);

    }

    public static void main (String args[]) {new AlbumManager().run();}
}
