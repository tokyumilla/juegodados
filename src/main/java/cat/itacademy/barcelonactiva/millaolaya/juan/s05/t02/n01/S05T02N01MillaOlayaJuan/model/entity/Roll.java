package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity;

import jakarta.persistence.*;


@Entity
@Table (name="Rolls")
public class Roll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstRoll")
    private Integer firstRoll;
    @Column(name = "secondRoll")
    private Integer secondRoll;
    @Column(name = "win")
    private boolean win;

    @ManyToOne
    @JoinColumn(name="id_player", nullable = false)
    private Player player;

    public Roll(){}

    public Roll(Integer id, Integer firstRoll, Integer secondRoll, Player player, boolean win) {
        this.id = id;
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.player = player;
        this.win = win;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Integer firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Integer getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Integer secondRoll) {
        this.secondRoll = secondRoll;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "id=" + id +
                ", firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
                ", player=" + player +
                '}';
    }
}
