package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;


import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;

import java.util.List;
import java.util.Optional;

public interface RollService {
    List<RollDTO> findAll();
    Optional<RollDTO> findById(Integer id);
    RollDTO save (RollDTO playerDTO);
    void deleteById (Integer id);

}
