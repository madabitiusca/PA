package com.example.demo;


    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Query;
    import java.util.ArrayList;
    import java.util.List;

@RestController
@RequestMapping("/players")
public class Controller {

    private final List<Player> players = new ArrayList<>();
    private EntityManagerFactory entityManagerFactory;


    public  Controller() {
        players.add(new Player());
    }
    //GET
    @GetMapping
    public List<Player> getPlayers() {
        return players;
    }
    @GetMapping("/count")
    public int countPlayers() {
        return players.size();
    }
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }


    //POST
    @PostMapping
    public int createPlayer(@RequestParam String name) {
        int id = 1+players.size();
        players.add(new Player(id, name));
        return id;
    }
    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String>
    createPlayer(@RequestBody Player player) {
        players.add(player);
        return new ResponseEntity<>(
                "Player created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(
            @PathVariable int id, @RequestParam String name) {
        Player player = (Player) findById(id);
        if (player==null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND);

        }
        player.setName(name);
        return new ResponseEntity<>(
                "Player updated successfully", HttpStatus.OK);

    }


    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        Player player = (Player) findById(id);
        if (player==null) {
            return new ResponseEntity<>(
                    "Player not found",HttpStatus.GONE
            );

        }
        players.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }

    public List<Player> findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select player from Players player where player.Id = :Id");

        List<Player> players = query.setParameter("Id", id).getResultList();
        entityManager.close();

        return players.isEmpty() ? null : players;
    }



}
