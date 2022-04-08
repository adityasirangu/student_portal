package com.student.repository.solr;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.student.model.SolrStudent;


@Repository
public interface SolrRepository extends SolrCrudRepository<SolrStudent, String>{
	
	SolrStudent findByStudentId(String studentId);
	SolrStudent getByStudentId(String studentId);

}
