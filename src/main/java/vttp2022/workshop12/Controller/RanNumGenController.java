package vttp2022.workshop12.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="")
public class RanNumGenController {
    
    
    @GetMapping(path="/generate")
    public String getImages(@RequestParam(value = "number") String number, Model m) 
    {
        Set<String> images = new HashSet<>();
        //take in the requested number of numbers to generate
        try 
        {
            Integer n = Integer.parseInt(number);
            
            if (n < 0 || n > 30) {
                return "error";
            } else {

                int max = 30;
                int min = 1;
                
                while (images.size() < n)
                {
                    Integer randInteger = (int)(Math.random() * (max - min)) + min;
                    System.out.println(randInteger);
                    images.add(randInteger.toString());
                }

                System.out.println(images);
                m.addAttribute("number", n);
                m.addAttribute("images", images);
                return "imgGen";
            }
        } catch (NumberFormatException ex) {
            return "error";
        }
    }
}
