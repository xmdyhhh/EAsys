package sdut.easys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("sdut.easys.mapper")
@SpringBootApplication
public class EAsysApplication {
    public static void main(String[] args) {
        SpringApplication.run(EAsysApplication.class, args);
    }
}