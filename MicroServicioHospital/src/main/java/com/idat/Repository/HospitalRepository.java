package com.idat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.Model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
