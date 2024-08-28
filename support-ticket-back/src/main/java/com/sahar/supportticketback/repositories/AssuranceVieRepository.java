package com.sahar.supportticketback.repositories;

import com.sahar.supportticketback.entities.AssuranceAutomobile;
import com.sahar.supportticketback.entities.AssuranceVie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceVieRepository extends JpaRepository<AssuranceVie,Long> {



}
