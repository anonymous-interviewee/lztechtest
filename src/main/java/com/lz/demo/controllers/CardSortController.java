package com.lz.demo.controllers;

import com.lz.demo.models.CardDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class CardSortController {

    @PostMapping(value = "upload", consumes = "multipart/form-data")
    public ModelAndView handleRequest(@RequestParam MultipartFile file) throws IOException {

        final String input = new String(file.getBytes());
        List<CardDetails> results = parseCardCSV(input);

        results.sort(Comparator.reverseOrder());

        final ModelAndView response = new ModelAndView();
        response.setViewName("cardsortresponse");
        response.addObject("results", results);

        return response;
    }

    private static List<CardDetails> parseCardCSV(String in) {
        final List<CardDetails> ret = new ArrayList<>();

        final String [] inputs = in.split("\n");
        for (String input : inputs) {
            final String[] split = input.split(",");
            final CardDetails details = new CardDetails(split[0], split[1], split[2]);
            ret.add(details);
        }
        return ret;
    }

}
