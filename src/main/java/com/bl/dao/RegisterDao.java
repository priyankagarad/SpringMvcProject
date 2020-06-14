package com.bl.dao;
import com.bl.connection.ConnectionClass;
import com.bl.daointerface.RegisterDaoInterface;
import com.bl.model.RegistrationModel;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;

@Repository
public class RegisterDao implements RegisterDaoInterface {

    @Override
    public Boolean save(RegistrationModel registration) {
    Boolean addstatus=false;
        try {
            PreparedStatement st = ConnectionClass.getConnection().prepareStatement
                    ("insert into registrationmodel(username ,password,email,registrationdate) values(?,?,?,?)");
            st.setString(1, registration.getUsername());
            st.setString(2, registration.getEmail());
            st.setString(3, registration.getPassword());
            st.setString(4, registration.getRegistrationdate());
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
