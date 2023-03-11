package gymwala.api;

import gymwala.model.Costing;
import gymwala.service.CostingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/costing")
public class CostingApi {

    private final CostingService costingService;
    private static final Logger logger = LoggerFactory.getLogger(CostingApi.class);

    @Autowired
    public CostingApi(CostingService costingService) {
        this.costingService = costingService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Costing> costingList(){
        logger.info("CostingApi.costingList was accessed");
        return costingService.getAll();
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, String> addCosting(@RequestBody Costing costing){
        logger.info("CostingApi.addCosting was accessed with parameter=" + costing.toString());
        costingService.addCosting(costing);
        return Collections.singletonMap("status", "success");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map<String, String> deleteCosting(@PathVariable int id){
        logger.info("CostingApi.deleteCosting was accessed with parameter=" + id);
        return Collections.singletonMap("status", costingService.deleteCosting(id));
    }

    @PutMapping("/update")
    public Map<String, String> updateCosting(@RequestBody Costing costing){
        logger.info("CostingApi.updateCosting was accessed with parameter=" + costing.toString());
        return Collections.singletonMap("status", costingService.updateCosting(costing));
    }

    @GetMapping("/total")
    @ResponseBody
    public Map<String, String> totalCost(){
        logger.info("CostingApi.totalCost was accessed");
        return Collections.singletonMap("count", costingService.totalCost());
    }

}
