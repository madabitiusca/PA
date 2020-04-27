package entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ARTISTS", schema = "STUDENT",catalog = "")
public class Artist {

    private long id;
    private String name;
    private String country;

    @Id
    @Column(name = "ID")
    public long getId(){return id;}

    public void setId(long id) {this.id=id;}

    @Basic
    @Column(name = "NAME")
    public String getName() {return name;}

    public void setName(String name) {this.name=name;}

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {return country;}

    public void setCountry(String country) {this.country=country;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id &&
                Objects.equals(name, artist.name) &&
                Objects.equals(country, artist.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }


}
