package com.gmail.v.varvaruk89.urltest.repo;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface MyHostRepository extends JpaRepository<MyHost,Long> {

    Set<MyHost> findByActiveIsTrue ();
}
