package com.loginValidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginValidation.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class ControllerClass {

	@GetMapping("/form")
	public String formPage(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "form";
	}

	// Handler for processing form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "form";
		}
		return "success";
	}
}
