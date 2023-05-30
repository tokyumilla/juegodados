package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    PlayerConverter converter = new PlayerConverter();

    @Override
    public List<PlayerDTO> findAll() {
        List<Player> players = playerRepository.findAll();
        return converter.fromEntity(players);
    }

    @Override
    public Optional<PlayerDTO> findById(Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) return Optional.of(converter.fromEntity(player.get()));
        else return Optional.empty();
    }

    @Override
    public PlayerDTO save(PlayerDTO playerDTO) {
        playerRepository.save(converter.fromDto(playerDTO));
        return playerDTO;
    }

    @Override
    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }
}
