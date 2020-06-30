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
public class EmployeeDetail implements RegisterInterface {
    @Override
    public Boolean save(Employee registration) {
    Boolean addstatus=false;
        try {
            System.out.println("inside save query");
            PreparedStatement st = ConnectionClass.getConnection().prepareStatement
                    ("insert into employee(username ,password,email,registrationdate) values(?,?,?,?)");
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

    public String checkLogin(String name, String password) {
        try
        {
            Connection  con = ConnectionClass.getConnection();
            Statement statement = con.prepareStatement("select username,password from employee");
            ResultSet resultSet = statement.executeQuery("select username,password from employee");

            while(resultSet.next())
            {
               String userName = resultSet.getString("username");
               String passwordDb = resultSet.getString("password");

                if(name.equals(userName) && password.equals(passwordDb))
                {
                    return "SUCCESS";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
