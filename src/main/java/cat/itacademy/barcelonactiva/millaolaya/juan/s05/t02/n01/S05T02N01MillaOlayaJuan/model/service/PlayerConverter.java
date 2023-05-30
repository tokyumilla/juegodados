package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;

import java.util.ArrayList;

public class PlayerConverter extends AbstractConverter<Player, PlayerDTO> {
    RollConverter converter = new RollConverter();
    @Override
    public Player fromDto(PlayerDTO dto) {
        Player player = new Player();
        if (dto.getId()!=null) {
            player.setId(dto.getId());
        }
        player.setName(dto.getName());
        player.setRegisterDate(dto.getRegisterDate());
        player.setRolls((ArrayList<Roll>) converter.fromDto(dto.getRolls()));
        return player;
    }

    @Override
    public PlayerDTO fromEntity(Player entity) {
        ArrayList<RollDTO> rolls = (ArrayList<RollDTO>) converter.fromEntity(entity.getRolls());
        return new PlayerDTO(entity.getId(), entity.getName(), entity.getRegisterDate(), rolls);
    }
}
