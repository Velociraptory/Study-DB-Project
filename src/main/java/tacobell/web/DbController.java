package tacobell.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
@RestController
@RequestMapping("/dbconnection")
//checking for connection to h2 database
public class DbController {

    @GetMapping
    public boolean get() throws Exception{
        log.info("Detecting db connection");
        boolean marker = false;
        try(Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "")){
            if(conn != null){
                marker = true;
            }
        }
        return marker;
    }
    }

