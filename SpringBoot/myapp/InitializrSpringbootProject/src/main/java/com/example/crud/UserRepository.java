/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.crud;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
