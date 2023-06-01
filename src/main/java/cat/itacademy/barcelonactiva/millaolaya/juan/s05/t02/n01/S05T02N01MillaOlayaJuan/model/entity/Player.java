package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Table (name="Players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @CreatedDate
    @Column(name= "registerDate")
    private Instant registerDate;

    @OneToMany (mappedBy = "player")
    private List<Roll> rolls;

    public Player (){}

    public Player(Integer id, String name, List<Roll> rolls) {
        this.id = id;
        this.name = name;
        this.rolls = rolls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registerDate=" + registerDate +
                ", rolls=" + rolls +
                '}';
    }
}
