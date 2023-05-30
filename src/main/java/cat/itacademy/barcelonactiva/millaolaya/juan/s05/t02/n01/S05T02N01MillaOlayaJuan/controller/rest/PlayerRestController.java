package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.controller.rest;


import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http:localhost:8080")
@RestController
@RequestMapping
public class PlayerRestController {

    @Autowired
    private PlayerService playerService;


    @PostMapping("/players")
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
        if (playerService.checkName(playerDTO.getName())) {
            try {
                PlayerDTO _player = playerService.savePlayer(new PlayerDTO(playerDTO.getName()));
                return new ResponseEntity<>(_player, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("id") int id, @RequestBody String playerName) {
        Optional<PlayerDTO> playerData = playerService.findPlayerById(id);

        if (playerService.checkName(playerName)) {
            if (playerData.isPresent()) {
                PlayerDTO _player = playerData.get();
                _player.setName(playerName);
                return new ResponseEntity<>(playerService.savePlayer(_player), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/player/{id}/games/")
    public ResponseEntity<PlayerDTO> addRoll(@PathVariable("id") int id, @RequestBody PlayerDTO playerDTO) {
        Optional<PlayerDTO> playerData = playerService.findPlayerById(id);

        if (playerData.isPresent()) {
            PlayerDTO _player = playerData.get();
            playerService.rollDices(_player);
            return new ResponseEntity<>(playerService.savePlayer(_player), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/player/{id}/games/")
    public ResponseEntity<HttpStatus> deleteRolls(@PathVariable("id") int id) {
        try {
            playerService.deleteRolls(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/players/")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {

    }


}
