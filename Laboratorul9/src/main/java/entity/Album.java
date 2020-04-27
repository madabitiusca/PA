package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "ALBUMS", schema = "STUDENT", catalog = "")
public class Album {
    private long id;
    private String name;
    private long artistId;
    private int releaseYear;

    @Id
    @Column(name="ID")
    public long getId() {return id;}

    public void setId(long id) {this.id=id;}

    @Basic
    @Column(name = "NAME")
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Basic
    @Column(name = "ARTIST_ID")
    public long getArtistId() {return artistId;}

    public void setArtistId(long artistId) {this.artistId=artistId;}

    @Basic
    @Column(name = "RELEASE_YEAR")
    public int getReleaseYear() {return releaseYear;}

    public void setReleaseYear(int releaseYear) {this.releaseYear = releaseYear;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                artistId == album.artistId &&
                releaseYear == album.releaseYear &&
                Objects.equals(name, album.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artistId, releaseYear);
    }
}
