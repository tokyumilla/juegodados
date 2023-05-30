package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ArrayList<Roll> rolls;

    public Player (){}

    public Player(Integer id, String name, ArrayList<Roll> rolls) {
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

    public ArrayList<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(ArrayList<Roll> rolls) {
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
