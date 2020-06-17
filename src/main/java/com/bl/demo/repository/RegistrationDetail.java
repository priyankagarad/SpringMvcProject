/***********************************************************************************************************
 * @Purpose:- RegistrationDetail is DAO class,used to perform Database operation
 * @Author:- priyanka
 * @Date:- 13/6/2020
 ************************************************************************************************************/
package com.bl.demo.repository;
import com.bl.demo.connection.ConnectionClass;
import com.bl.demo.model.Employee;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.time.LocalDateTime;

@Repository
public class RegistrationDetail implements RegisterInterface {
    @Override
    public Boolean save(Employee registration) {
    Boolean addstatus=false;
        try {
            System.out.println("inside save query");
            PreparedStatement st = ConnectionClass.getConnection().prepareStatement
                    ("insert into registrationmodel(username ,password,email,registrationdate) values(?,?,?,?)");
            st.setString(1, registration.getUsername());
            st.setString(2, registration.getPassword());
            st.setString(3, registration.getEmail());
            st.setString(4, String.valueOf(LocalDateTime.now()));
            int row = st.executeUpdate();
        if(row!=0){
            addstatus=true;
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    return addstatus;
    }
}
