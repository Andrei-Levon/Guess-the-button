package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController
public class Controller {

    @GetMapping("/")
    public ModelAndView Home(@ModelAttribute("randomizer") Randomizer rd, Model model) {
        ModelAndView mAv = new ModelAndView("home", "randomizer", model);
        rd.random();
        model.addAttribute("buton1", rd.answers[0]);
        model.addAttribute("buton2", rd.answers[1]);
        model.addAttribute("buton3", rd.answers[2]);
        return mAv;
    }

    @PostMapping("/answer")
    public ModelAndView answer(@Valid @ModelAttribute("answer") Answer answer, Model model) {
        ModelAndView mAv = new ModelAndView("answer", "answer", model);
        if (answer.getValue()) {
            model.addAttribute("value", "Câștigător!");
        } else {
            model.addAttribute("value", "Necâștigător :(");
        }
        return mAv;
    }

}
