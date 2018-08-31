package com.gmail.v.varvaruk89.urltest.repo;

import com.gmail.v.varvaruk89.urltest.entities.MySettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySettingsRepository extends JpaRepository<MySettings,Long> {

}
