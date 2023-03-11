package gymwala.api;

import gymwala.model.Trainer;
import gymwala.service.TrainerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainer")
public class TrainerApi {

    private final TrainerService trainerService;
    private static final Logger logger = LoggerFactory.getLogger(TrainerApi.class);

    @Autowired
    public TrainerApi(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Trainer> trainerList(){
        logger.info("TrainerApi.trainerList was accessed");
        return trainerService.getAll();
    }

    @GetMapping("/count")
    @ResponseBody
    public Map<String, String> trainerCount(){
        logger.info("TrainerApi.trainerCount was accessed");
        return Collections.singletonMap("count", "" + trainerService.getCount());
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, String> addTrainer(@RequestBody Trainer trainer){
        logger.info("TrainerApi.addTrainer was accessed with parameter=" + trainer.toString());
        trainerService.addTrainer(trainer);
        return Collections.singletonMap("status", "success");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map<String, String> deleteTrainer(@PathVariable int id){
        logger.info("TrainerApi.deleteTrainer was accessed with parameter=" + id);
        return Collections.singletonMap("status", trainerService.deleteTrainer(id));
    }

    @PutMapping("/update")
    @ResponseBody
    public Map<String, String> updateTrainer(@RequestBody Trainer trainer){
        logger.info("TrainerApi.updateTrainer was accessed with parameter=" + trainer.toString());
        return Collections.singletonMap("status", trainerService.updateTrainer(trainer));
    }


}
