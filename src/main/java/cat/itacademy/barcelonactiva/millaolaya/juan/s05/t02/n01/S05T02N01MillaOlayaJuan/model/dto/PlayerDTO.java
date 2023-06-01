package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto;

import java.time.Instant;
import java.util.ArrayList;

public class PlayerDTO {
    private Integer id;
    private String name;
    private Instant registerDate;

    private ArrayList<RollDTO> rolls;
    private float winningRate;

    public PlayerDTO(String name, ArrayList<RollDTO> rolls) {
        this.name = name;
        this.rolls = rolls;
    }

    public PlayerDTO(Integer id, String name, Instant registerDate, ArrayList<RollDTO> rolls) {
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
        this.rolls = rolls;
        this.winningRate = setWinningRate();
    }

    public float setWinningRate() {
        if (rolls.isEmpty()) {
            return 0;
        } else {
            int i = 0;
            for (RollDTO r : rolls) {
                if (r.isWin()) i++;
            }
            return (i * 100) / rolls.size();
        }
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

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    public ArrayList<RollDTO> getRolls() {
        return rolls;
    }

    public void setRolls(ArrayList<RollDTO> rolls) {
        this.rolls = rolls;
    }

    public float getWinningRate() {
        return winningRate;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", winningRate=" + winningRate +
                '}';
    }
}

