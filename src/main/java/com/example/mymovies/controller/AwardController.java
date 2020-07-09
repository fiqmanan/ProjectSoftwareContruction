package com.example.mymovies.controller;

import com.example.mymovies.model.*;
import com.example.mymovies.model.DirectorAward;
import com.example.mymovies.model.ActorAward;
import com.example.mymovies.service.ActorAwardService;
import com.example.mymovies.service.ActorService;
import com.example.mymovies.service.DirectorAwardService;
import com.example.mymovies.service.DirectorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * Refactor Code (Large Class) from previous code
 * With this method also we can prevent code change (Inappropriate intimacy) 
 * Here we split the code for Award (Extract Award Attribute from the actor controller and Director Controller) 
 * @author FIQMANAN
 */

@Controller
public class AwardController {
    
    @Autowired
    private ActorService actorService;
    
    @Autowired
    private DirectorService directorService;
    
    @Autowired
    private ActorAwardService actorAwardService;
    
    @Autowired
    private DirectorAwardService awardService;
    
    @RequestMapping("/addActorAward/{aid}")
    public String addActorAward(@PathVariable("aid") Integer aid, Model model) {
        Optional<Actor> actor = actorService.getActor(aid);
        ActorAward award = new ActorAward();
        actor.ifPresent(a -> award.setActor(a));
        actor.ifPresent(a -> a.getAwards().add(award));
        actor.ifPresent(a -> model.addAttribute("movies", a.getMovies()));
        model.addAttribute("award", award);
        return "add_actor_award";
    }

    @RequestMapping("/saveActorAward")
    public String saveActorAward(@ModelAttribute("award") ActorAward award) {
        actorAwardService.addActorAward(award);
        return "redirect:/";
    }
    
    @RequestMapping("/addDirectorAward/{did}")
    public String addDirectorAward(@PathVariable("did") Integer did, Model model) {
        Optional<Director> director = directorService.getDirector(did);
        DirectorAward award = new DirectorAward();
        director.ifPresent(d -> award.setDirector(d));
        director.ifPresent(d -> d.getAwards().add(award));
        director.ifPresent(d -> model.addAttribute("movies", d.getMovies()));
        model.addAttribute("award", award);
        return "add_director_award";
    }

    @RequestMapping("/saveDirectorAward")
    public String saveDirectorAward(@ModelAttribute("award") DirectorAward award) {
        awardService.addDirectorAward(award);
        return "redirect:/";
    }
}
