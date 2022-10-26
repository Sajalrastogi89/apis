package com.Sajal.crud.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Sajal.crud.Dao.CrudOperation;
import com.Sajal.crud.model.parameters;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class control
{

    @Autowired
    CrudOperation operate;
    parameters para;

    @PostMapping(path = "/insert")

    public String Insert(@Valid parameters param){
       String Email= param.getEmail().toLowerCase();
       param.setEmail(Email);
       boolean result= (operate.findById(Email).isEmpty());
       System.out.println(result);
        if(result){
            operate.save(param);
            return "inserted";
        }

        return "Already present";
    }
//@GetMapping(path = "/read")
//    public List<parameters> realAll(){
//
//return operate.findAll();
//
//    }
 @GetMapping(path = "read/{Email}/{password}")
public String readById(@PathVariable("Email") String email,@PathVariable("password") String Password){


     Optional<parameters> a=operate.findById(email);
para=a.get();
if (para.getPassword().equals(Password))
     return "Found";

return "not found";
}
//@DeleteMapping("/delete/{roll}")
//    public String delete(@PathVariable("roll") int roll){
//        operate.deleteById(roll);
//        return "Deleted";
//}
//
//    @PutMapping(path = "/update")
//    public String Update(parameters param){
//        operate.save(param);
//        return "Updated";
//    }

}
