package com.example.comisaria.repositories;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.comisaria.models.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long>{
    ArrayList<Form> findAll();
}
