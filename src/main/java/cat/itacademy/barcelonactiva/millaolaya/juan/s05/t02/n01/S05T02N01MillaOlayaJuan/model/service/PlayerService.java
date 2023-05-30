package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDTO> findAll();
    Optional<PlayerDTO> findById(Integer id);
    PlayerDTO save (PlayerDTO playerDTO);
    void deleteById (Integer id);
}
