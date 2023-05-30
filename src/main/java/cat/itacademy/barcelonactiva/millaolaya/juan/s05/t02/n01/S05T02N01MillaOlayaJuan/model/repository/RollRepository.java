package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository;


import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Roll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RollRepository extends JpaRepository<Roll, Integer> {

}
