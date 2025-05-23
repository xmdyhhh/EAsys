package sdut.easys.Controller.Admin;

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
                               @RequestParam("password") String password) {
        log.info("username: {}, password: {}", username, password);
        return adminService.login(username, password);
    }
}