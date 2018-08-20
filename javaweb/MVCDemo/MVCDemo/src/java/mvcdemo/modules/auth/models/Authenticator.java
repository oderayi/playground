/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcdemo.modules.auth.models;

import mvcdemo.modules.auth.dao.UserDao;

/**
 *
 * @author soderayi
 */
public class Authenticator {
    
    public String authenticate( String username, String password ){
        
        User user = UserDao.getByUsername( username );
        
        if( user != null && user.getPassword().equals(password) ){
            return "success";
        }
        
        return "failure";
    }
}
