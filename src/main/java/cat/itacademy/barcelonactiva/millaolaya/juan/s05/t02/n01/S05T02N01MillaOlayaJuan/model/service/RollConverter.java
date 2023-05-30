package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;

public class RollConverter extends AbstractConverter<Roll, RollDTO> {

    private PlayerConverter converter = new PlayerConverter();
    @Override
    public Roll fromDto(RollDTO dto) {
        Roll roll = new Roll();
        if (dto.getId()!=null) {
            roll.setId((dto.getId()));
        }
        roll.setFirstRoll(dto.getFirstRoll());
        roll.setSecondRoll(dto.getSecondRoll());
        roll.setPlayer(converter.fromDto(dto.getPlayer()));
        return roll;
    }

    @Override
    public RollDTO fromEntity(Roll entity) {
        PlayerDTO playerDTO = converter.fromEntity(entity.getPlayer());
        RollDTO rollDTO = new RollDTO(entity.getId(), entity.getFirstRoll(), entity.getSecondRoll(), playerDTO);
        return null;
    }
}
