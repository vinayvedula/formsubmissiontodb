package com.example.submissionformtodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @Autowired
    CustomerRepo repo;

    @RequestMapping("/")
    public String details(){
        System.out.println("details");
        return "edureka";
    }

    @RequestMapping("details")
    public String details(Customers customers)
    {
        repo.save(customers);
        return "edureka";
    }

    @RequestMapping("getdetails")
    public String getdetails()
    {
        return "viewcustomers";
    }

    @PostMapping("getdetails")
    public ModelAndView viewdetails(@RequestParam(value = "cid") int cid){
        System.out.println("viewdetails");
        ModelAndView mv = new ModelAndView("retrieve");
        Customers customers = repo.findById(cid).orElse(null);
        System.out.println("customers :: " +customers);
        mv.addObject(customers);
        return mv;
    }

}
