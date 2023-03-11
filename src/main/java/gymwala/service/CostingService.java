package gymwala.service;

import gymwala.model.Costing;
import gymwala.repo.CostingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CostingService {

    private final CostingRepo costingRepo;

    @Autowired
    public CostingService(CostingRepo costingRepo) {
        this.costingRepo = costingRepo;
    }

    public List<Costing> getAll(){
        return new ArrayList<>((Collection) costingRepo.findAll());
    }

    public void addCosting(Costing costing){
        costingRepo.save(costing);
    }

    public String deleteCosting(int id){
        if(costingRepo.existsById(id)){
            costingRepo.deleteById(id);
            return "success";
        }
        return "failed";
    }

    public String totalCost(){
        return costingRepo.totalCost().toString();
    }

    public String updateCosting(Costing costing){
        if(costingRepo.existsById(costing.getId())){
            costingRepo.updateCosting(costing.getTitle(), costing.getAmount(), costing.getDate(), costing.getId());
            return "success";
        }
        return "failed";
    }

}
