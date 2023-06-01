package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PlayerConverter extends AbstractConverter<Player, PlayerDTO> {
    private final RollConverter converter;

    public PlayerConverter(RollConverter converter) {
        this.converter = converter;
    }

    @Override
    public Player fromDto(PlayerDTO dto) {
        Player player = new Player();
        if (dto.getId() != null) {
            player.setId(dto.getId());
        }
        player.setName(dto.getName());
        if (!dto.getRolls().isEmpty()) {
            player.setRolls(converter.fromDto(dto.getRolls()));
        }
        return player;
    }

    @Override
    public PlayerDTO fromEntity(Player entity) {
        ArrayList<RollDTO> rolls = new ArrayList<>();
        if (entity.getRolls()!=null) {
            rolls = (ArrayList<RollDTO>) converter.fromEntity(entity.getRolls());
        }
        return new PlayerDTO(entity.getId(), entity.getName(), entity.getRegisterDate(), rolls);
    }
}
