package sdut.easys.Service;

import sdut.easys.Entity.Admin;
import sdut.easys.Util.Result;


public interface AdminService {
    Result<Admin> login(String username, String password);

    int getAdminID(String username);

    Result<Admin> getInfo(int adminID);

    Result<String> updateInfo(Admin admin);
}