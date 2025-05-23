package sdut.easys.Controller.Admin;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdut.easys.Entity.Admin;
import sdut.easys.Service.AdminService;
import sdut.easys.Util.Result;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<Admin> login(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session) {
        log.info("username: {}, password: {}", username, password);
        Result<Admin> result = adminService.login(username, password);
        if (result.getData() != null) {
            // 将管理员信息存入会话
            session.setAttribute("admin", result.getData());
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除会话属性
        session.removeAttribute("admin");
        session.removeAttribute("student");
        session.removeAttribute("teacher");
        // 重定向到登录页面
        return "redirect:/login.html";
    }
    @GetMapping("/getAdminName")
    public String getAdminName(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        log.info("admin: {}", admin);
        if (admin != null) {
            return admin.getUsername();
        }
        return null;
    }
}