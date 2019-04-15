package com.example.Meikkipussi.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MeikkiRepository extends CrudRepository<Meikki,Long> {
	
	List<Meikki> findByValmistaja(@Param("valmistaja") String valmistaja);

}
