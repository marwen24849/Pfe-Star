package coding.dojo.Pfe.repository;

import coding.dojo.Pfe.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


}
