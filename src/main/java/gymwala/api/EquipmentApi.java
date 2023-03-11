package gymwala.api;

import gymwala.model.Equipment;
import gymwala.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipment")
public class EquipmentApi {

    private final EquipmentService equipmentService;
    private static final Logger logger = LoggerFactory.getLogger(EquipmentApi.class);

    @Autowired
    public EquipmentApi(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Equipment> equipmentList(){
        logger.info("EquipmentApi.equipmentList was accessed");
        return equipmentService.getAll();
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, String> addEquipment(@RequestBody Equipment equipment){
        logger.info("EquipmentApi.addEquipment was accessed with parameter=" + equipment.toString());
        equipmentService.addEquipment(equipment);
        return Collections.singletonMap("status", "success");
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteEquipment(@PathVariable int id){
        logger.info("EquipmentApi.deleteEquipment was accessed with parameter=" + id);
        return Collections.singletonMap("status",equipmentService.deleteEquipment(id));
    }

    @PutMapping("/update")
    @ResponseBody
    public Map<String, String> updateEquipment(@RequestBody Equipment equipment){
        logger.info("EquipmentApi.updateEquipment was accessed with parameter=" + equipment.toString());
        return Collections.singletonMap("status", equipmentService.updateEquipment(equipment));
    }

}
