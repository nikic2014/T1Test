package com.string.test.controllers;

import com.string.test.dto.SymbolsString;
import com.string.test.util.CountLetters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private CountLetters countLetters;
    @PostMapping("/string")
    public Object cntLetters(@RequestBody SymbolsString symbolsString){
        Map<Character, Integer> response = countLetters.countLetters(symbolsString.getSymbols());

        return ResponseEntity.ok(response);
    }
}
