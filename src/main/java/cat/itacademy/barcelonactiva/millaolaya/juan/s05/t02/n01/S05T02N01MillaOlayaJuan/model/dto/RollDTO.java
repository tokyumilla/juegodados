package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto;

public class RollDTO {
    private Integer id;
    private Integer firstRoll;
    private Integer secondRoll;
    private PlayerDTO player;
    private boolean win;

    public RollDTO(){}

    public RollDTO(Integer id, Integer firstRoll, Integer secondRoll, PlayerDTO player) {
        this.id = id;
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.player = player;
        setWin();
    }

    public RollDTO(Integer firstRoll, Integer secondRoll, PlayerDTO player) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.player = player;
    }

    public void setWin() {
        if (firstRoll+secondRoll==7) {
            this.win=true;
        } else {
            this.win=false;
        }
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

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public boolean isWin() {
        return win;
    }

    public void rollDices() {
        this.firstRoll=
    }

    @Override
    public String toString() {
        return "RollDTO{" +
                "id=" + id +
                ", firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
                ", player=" + player +
                ", win=" + win +
                '}';
    }
}
