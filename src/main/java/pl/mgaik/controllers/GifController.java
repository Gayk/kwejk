package pl.mgaik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mgaik.repositories.GifRepository;

/**
 * Created by monik on 04.11.2017.
 */
@Controller
public class GifController {
    @Autowired
    GifRepository gifRepository;

    @GetMapping("/")
    String search(@RequestParam(value = "q", required = false) String q, ModelMap modelMap) {
        if (q != null) {
            modelMap.addAttribute( "gifs", gifRepository.findByName( q ) );
        } else {
            modelMap.addAttribute( "gifs", gifRepository.findAll() );
        }
        return "home";
    }

    @GetMapping("/category/{id}")
    String mems(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute( "gifs", gifRepository.getGifsByCategoryId(
                id ) );
        return "home";

    }

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap) {
        modelMap.addAttribute( "gifs", gifRepository.getFavorites() );
        return "favorites";
    }

}
