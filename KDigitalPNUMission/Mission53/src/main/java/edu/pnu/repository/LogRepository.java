package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Logs;

public interface LogRepository extends JpaRepository<Logs, Long> {

}
