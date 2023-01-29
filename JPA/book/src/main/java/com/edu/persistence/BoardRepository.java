package com.edu.persistence;

import org.springframework.data.repository.CrudRepository;

import com.edu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
