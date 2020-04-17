package mongo.controller;

import com.google.gson.Gson;
import mongo.model.CurrRate;
import mongo.service.CurrRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value= "/")
public class Controller {

    @Autowired
    CurrRateService currRateService;

    @GetMapping(value= "/addall")
    public String createAll(Model model) throws IOException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(
                                        new InputStreamReader(
                                        new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20200416&json").openStream()));

        List<CurrRate> currRates = Arrays.asList(gson.fromJson(bufferedReader, CurrRate[].class));
        currRates.forEach(System.out::println);
        currRateService.addAll(currRates);
        model.addAttribute("currRateList", currRates);
        return "index";
    }

    @GetMapping (value= "/deleteall")
    public String deleteAll() {
        currRateService.deleteAll();
        return "redirect:/";
    }

}
