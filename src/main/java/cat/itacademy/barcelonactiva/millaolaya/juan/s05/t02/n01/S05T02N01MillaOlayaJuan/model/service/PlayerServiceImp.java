package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.RollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImp implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private RollRepository rollRepository;

    PlayerConverter playerConverter = new PlayerConverter();
    RollConverter rollConverter = new RollConverter();

    @Override
    public List<PlayerDTO> findAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return playerConverter.fromEntity(players);
    }

    @Override
    public Optional<PlayerDTO> findPlayerById(Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) return Optional.of(playerConverter.fromEntity(player.get()));
        else return Optional.empty();
    }

    @Override
    public void deletePlayerById(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<RollDTO> findAllRolls() {
        List<Roll> rolls = rollRepository.findAll();
        return rollConverter.fromEntity(rolls);
    }

    @Override
    public Optional<RollDTO> findRollById(Integer id) {
        Optional<Roll> roll = rollRepository.findById(id);
        if (roll.isPresent()) return Optional.of(rollConverter.fromEntity(roll.get()));
        else return Optional.empty();
    }

    @Override
    public void deleteRolls(Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()&& player.get().getRolls()!=null) {
            ArrayList<Roll> rolls = player.get().getRolls();
            rollRepository.deleteAll(rolls);
        }
    }
    //probar si no deja datos incoherentes

    public void rollDices (PlayerDTO playerDTO) {
        int firstroll = (int)Math.floor(Math.random()*6+1);
        int secondroll =(int)Math.floor(Math.random()*6+1);
        RollDTO roll = new RollDTO(firstroll,secondroll,playerDTO);
        playerDTO.getRolls().add(roll);
    }




    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        playerRepository.save(playerConverter.fromDto(playerDTO));
        return playerDTO;
    }


    @Override
    public RollDTO saveRoll (RollDTO rollDTO) {
        rollRepository.save(rollConverter.fromDto(rollDTO));
        return rollDTO;
    }
}

