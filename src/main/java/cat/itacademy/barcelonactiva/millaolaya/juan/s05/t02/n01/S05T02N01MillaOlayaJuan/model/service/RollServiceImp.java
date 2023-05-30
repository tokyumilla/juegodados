package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository.RollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RollServiceImp implements RollService {

    @Autowired
    RollRepository rollRepository;

    RollConverter converter = new RollConverter();

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
