package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDTO> findAllPlayers();
    Optional<PlayerDTO> findPlayerById(Integer id);
    PlayerDTO save (PlayerDTO playerDTO);
    void deletePlayerById (Integer id);

    List<RollDTO> findAllRolls();
    Optional<RollDTO> findRollById(Integer id);
    RollDTO save (RollDTO playerDTO);
    void deleteRolls (Integer id);

}
