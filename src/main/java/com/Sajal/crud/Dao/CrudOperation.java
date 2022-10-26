package com.Sajal.crud.Dao;

import com.Sajal.crud.model.parameters;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CrudOperation extends JpaRepository<parameters,String> {

}
