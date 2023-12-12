package com.example.demoom.example.Controller;

import com.example.demoom.example.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.*;
import java.util.Vector;



@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        try{
            model.addAttribute("look",new Look().select(null));
            model.addAttribute("matiere",new Matiere().select(null));
        }catch(Exception e){

        }
        return "home";
    }

    @GetMapping("/look")
    public String look(Model model) {
        return "insertionLokk";
    }

    @PostMapping("/look")
    public String insertLook(Model model,HttpServletRequest req) {
        try{
            Look look=new Look();
            look.setNom(req.getParameter("look"));
            look.insert(null);

        }catch(Exception e){

        }
        return "redirect:/look";
    }

    @GetMapping("/matiere")
    public String matiere(Model model) {
        return "insertionMatiere";
    }

    @PostMapping("/matiere")
    public String insertMatiere(Model model,HttpServletRequest req) {
        try{
            Matiere matiere=new Matiere();
            matiere.setNom(req.getParameter("matiere"));
            matiere.insert(null);

        }catch(Exception e){

        }
        return "redirect:/matiere";
    }

    @PostMapping("/insertlookmatiere")
    public String insertLookMatiere(Model model,HttpServletRequest req) {
        try{
            Look_Matiere look_matiere=new Look_Matiere();
            look_matiere.setLook(Integer.valueOf(req.getParameter("look")));
            look_matiere.setMatiere(Integer.valueOf(req.getParameter("matiere")));
            look_matiere.insert(null);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/listeLook_Matiere")
    public String afficher(Model model,HttpServletRequest req) {
        try{
            Vector<Look> look=new Look().select(null);
            for(int i=0 ; i < look.size() ;i++){
                look.get(i).GetterMatiere();
            }

            model.addAttribute("ListeLook",look);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "affichagelook";
    }
}

