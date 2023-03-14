package com.bus.service;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.beans.MovieDetails;

@Repository
public interface MovieRepo extends JpaRepository<MovieDetails, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM movies_details m where m.movie_name=?1",nativeQuery = true)
	void deleteBymovieName(String removeMovie);
}
