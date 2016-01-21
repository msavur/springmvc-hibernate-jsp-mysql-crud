package com.mahmut.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mahmut.model.Ogrenci;
import com.mahmut.service.OgrenciService;

@Controller
public class OgrenciController {

	@Autowired
	private OgrenciService ogrenciService;

	@RequestMapping(value = "/listOgrenci", method = RequestMethod.GET)
	public ModelAndView listOgrenci(Model model, Ogrenci ogrenci) {

		model.addAttribute("listOgrenci", ogrenciService.listOgrenci());

		return new ModelAndView("ogrenci");
	}

	@RequestMapping(value = "/ekleOgrenci", method = RequestMethod.POST)
	public ModelAndView ekleOgrenci(@ModelAttribute("ogrenci") Ogrenci ogrenci, @Valid Ogrenci validOgrenci,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("ogrenci");
		} else {

			ogrenciService.ekleOgrenci(ogrenci);
		}

		return new ModelAndView("redirect:/listOgrenci");
	}

	@RequestMapping(value = "/silOgrenci/{id}", method = RequestMethod.GET)
	public ModelAndView silOgrenci(@PathVariable("id") long id) {

		ogrenciService.silOgrenci(id);

		return new ModelAndView("redirect:/listOgrenci");
	}

	@RequestMapping(value = "/duzenleOgrenci/{id}", method = RequestMethod.GET)
	public ModelAndView duzenleOgrenci(@PathVariable("id") long id, Model model) {

		model.addAttribute("ogrenci", new Ogrenci());
		model.addAttribute("ogrenci", ogrenciService.getById(id));

		return new ModelAndView("duzenle");
	}

	@RequestMapping(value = "/guncelleOgrenci/{id}", method = RequestMethod.POST)
	public ModelAndView guncelleOgrenci(@PathVariable("id") long id, Ogrenci ogrenci, @Valid Ogrenci ogrenci2,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("duzenle");
		} else {
			ogrenciService.guncelleOgrenci(ogrenci);
		}

		return new ModelAndView("redirect:/listOgrenci");
	}

}
