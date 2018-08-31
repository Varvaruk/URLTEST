package com.gmail.v.varvaruk89.urltest.repo;

import com.gmail.v.varvaruk89.urltest.entities.MyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MyResponseRepository extends JpaRepository<MyResponse,Long> {

    Set<MyResponse> findFirstByContainsWordTrue();
}
