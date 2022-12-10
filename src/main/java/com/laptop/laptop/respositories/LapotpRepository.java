package com.laptop.laptop.respositories;

import com.laptop.laptop.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapotpRepository extends JpaRepository<Laptop, Long> {
}
