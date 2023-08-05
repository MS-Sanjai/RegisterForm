package com.example.Registration_form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Register_Repository extends JpaRepository<Register_Model, Integer> {

    Register_Model findByUsername(String username);
    
    // You can add more custom query methods here if needed
    // For example:
    // Register_Model findByMail(String mail);
    // Register_Model findByMobile(String mobile);
    // ...

}
