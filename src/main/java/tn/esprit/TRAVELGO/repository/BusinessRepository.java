package tn.esprit.TRAVELGO.repository;

import tn.esprit.TRAVELGO.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
