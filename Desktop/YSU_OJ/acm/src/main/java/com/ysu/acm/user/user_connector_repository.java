package com.ysu.acm.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface user_connector_repository extends JpaRepository<user,Integer> {
    @Query(value = "select t from user t where t.usr_name=:name")
    user find_by_usrname(@Param("name") String name);
    
}
