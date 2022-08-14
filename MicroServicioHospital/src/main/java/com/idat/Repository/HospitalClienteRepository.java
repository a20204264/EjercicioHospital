package com.idat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Model.HospitalDetalle;

@Repository
public interface HospitalClienteRepository extends JpaRepository<HospitalDetalle, Integer> {

}
