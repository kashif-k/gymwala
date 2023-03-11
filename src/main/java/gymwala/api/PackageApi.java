package gymwala.api;

import gymwala.model.Package;
import gymwala.repo.PackageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageApi {
    private final PackageRepo packageRepo;
    private static final Logger logger = LoggerFactory.getLogger(PackageApi.class);

    @Autowired
    public PackageApi(PackageRepo packageRepo) {
        this.packageRepo = packageRepo;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Package> getPackages(){
        logger.info("PackageApi.getPackages was accessed");
        List<Package> packages = new ArrayList<>();
        packageRepo.findAll().forEach(packages::add);
        return packages;
    }


}
