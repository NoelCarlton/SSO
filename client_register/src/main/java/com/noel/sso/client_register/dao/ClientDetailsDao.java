package com.noel.sso.client_register.dao;

import com.noel.sso.client_register.model.ClientDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/11
 * Version 1.0
 **/
@Repository
public interface ClientDetailsDao extends JpaRepository<ClientDetailsModel, String> {
}
