package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Admin;
import sdut.easys.mapper.AdminMapper;
import sdut.easys.Service.AdminService;
import sdut.easys.Util.Result;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result<Admin> login(String username, String password) {
        Admin admin = adminMapper.getByUsername(username);
        if (admin == null) {
            return Result.error("用户名不存在");
        } else if (!admin.getPassword().equals(password)) {
            return Result.error("密码错误");
        } else {
            return Result.success(admin);
        }
    }

    @Override
    public int getAdminID(String username) {
        return adminMapper.getAdminID(username);
    }

    @Override
    public Result<Admin> getInfo(int adminID) {
        Admin admin = adminMapper.getInfo(adminID);
        if (admin == null) {
            return Result.error("管理员不存在");
        }
        return Result.success(admin);
    }

    @Override
    public Result<String> updateInfo(Admin admin) {
        int rows = adminMapper.updateInfo(admin);
        if (rows > 0) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }
}
