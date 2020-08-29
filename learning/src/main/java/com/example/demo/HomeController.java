package com.example.demo;

import java.io.IOException;
import java.util.List;

//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@RequestMapping("/stock")
	@ResponseBody
	public List<stock> getStock(StockDetails stock) throws IOException{
			
			return stock.HistStock();
	}
}
