package gymwala.api;

import gymwala.model.Admin;
import gymwala.repo.AdminRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminApi {

    public final AdminRepo adminRepo;

    @Autowired
    public AdminApi(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @PostMapping("/valid")
    @ResponseBody
    public Map<String, String> valid(@RequestBody Admin admin){
        String result = adminRepo.existsByUsernameAndPassword(admin.getUsername(), admin.getPassword()) ? "success" : "failed";
        LoggerFactory.getLogger(AdminApi.class).info("AdminApi.valid was accessed with parameter=" + admin.getUsername() +", result="+result);
        return Collections.singletonMap("status", result);
    }
}
