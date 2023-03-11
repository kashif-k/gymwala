package gymwala.service;

import gymwala.model.Trainer;
import gymwala.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepo trainerRepo;

    @Autowired
    public TrainerService(TrainerRepo trainerRepo) {
        this.trainerRepo = trainerRepo;
    }

    public List<Trainer> getAll(){
        return new ArrayList<>((Collection) trainerRepo.findAll());
    }

    public Trainer getTrainer(long phone){
        return trainerRepo.findByPhone(phone).orElse(null);
    }

    public void addTrainer(Trainer trainer){
        trainerRepo.save(trainer);
    }

    public String deleteTrainer(int id){
        if(trainerRepo.existsById(id)){
            trainerRepo.deleteById(id);
            return "success";
        }
        return "failed";
    }

    public String updateTrainer(Trainer trainer){
        if(trainerRepo.existsById(trainer.getId())){
            trainerRepo.updateTrainer(trainer.getName(), trainer.getAddress(), trainer.getPhoto(), trainer.getPhone(), trainer.getAadhaar(), trainer.getId());
            return "success";
        }
        return "failed";
    }

    public long getCount(){
        return trainerRepo.count();
    }
}
