package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.RollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private RollRepository rollRepository;

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

    @Override
    public List<RollDTO> findAll() {
        List<Roll> rolls = rollRepository.findAll();
        return converter.fromEntity(rolls);
    }

    @Override
    public Optional<RollDTO> findById(Integer id) {
        Optional<Roll> roll = rollRepository.findById(id);
        if (roll.isPresent()) return Optional.of(converter.fromEntity(roll.get()));
        else return Optional.empty();
    }

    @Override
    public RollDTO save(RollDTO rollDTO) {
        rollRepository.save(converter.fromDto(rollDTO));
        return rollDTO;
    }

    @Override
    public void deleteById(Integer id) {
        rollRepository.deleteById(id);
    }
}
