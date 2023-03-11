package gymwala.service;

import gymwala.model.Equipment;
import gymwala.repo.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    public List<Equipment> getAll(){
        var equipments = new ArrayList<Equipment>();
        equipmentRepo.findAll().forEach(equipments::add);
        return equipments;
    }

    public void addEquipment(Equipment equipment){
        equipmentRepo.save(equipment);
    }

    public String deleteEquipment(int id){
        if(equipmentRepo.existsById(id)){
            equipmentRepo.deleteById(id);
            return "success";
        }
        return "failed";
    }

    public String updateEquipment(Equipment equipment){
        if(equipmentRepo.existsById(equipment.getId())){
            equipmentRepo.updateEquipment(equipment.getName(), equipment.getQuantity(), equipment.getId());
            return "success";
        }
        return "failed";
    }
}
