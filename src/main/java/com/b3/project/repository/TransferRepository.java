package com.b3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3.project.model.TransferEntity;
@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

}
