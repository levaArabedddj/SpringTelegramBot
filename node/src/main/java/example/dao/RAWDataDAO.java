package example.dao;

import example.entity.RawData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RAWDataDAO extends JpaRepository<RawData,Long> {

}
