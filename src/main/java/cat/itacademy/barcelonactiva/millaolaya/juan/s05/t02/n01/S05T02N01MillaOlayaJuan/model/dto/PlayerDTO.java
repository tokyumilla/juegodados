package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;

import java.util.ArrayList;
import java.util.Date;

public class PlayerDTO {
    private Integer id;
    private String name;
    private Date registerDate;
    private ArrayList<RollDTO> rolls;
    private float winningRate;


    public PlayerDTO(Integer id, String name, Date registerDate, ArrayList<RollDTO> rolls) {
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

    public void attach (RollDTO roll) {
        rolls.add(roll);
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
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

}

