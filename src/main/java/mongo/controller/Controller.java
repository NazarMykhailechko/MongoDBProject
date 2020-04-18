package mongo.controller;

import com.google.gson.Gson;
import mongo.model.CurrRate;
import mongo.service.CurrRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value= "/")
public class Controller {

    @Autowired
    CurrRateService currRateService;

    @RequestMapping(value= "/addall")
    public String createAll(Model model) throws IOException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(
                                        new InputStreamReader(
                                        new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20200415&json").openStream()));

        List<CurrRate> currRates = Arrays.asList(gson.fromJson(bufferedReader, CurrRate[].class));
        currRates.forEach(System.out::println);
        currRateService.addAll(currRates);
        //model.addAttribute("currRateList", currRates);
        return "redirect:/";
    }

    @RequestMapping (value= "/deleteall")
    public String deleteAll() {
        currRateService.deleteAll();
        return "redirect:/";
    }

    @RequestMapping (value= "/")
    public String home(Model model) {
        model.addAttribute("currRateList", currRateService.showAll());
        return "index";
    }

}
