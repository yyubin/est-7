package org.example.viewexp.service;

import org.example.viewexp.controller.FifthController;
import org.springframework.stereotype.Service;

@Service
public class SuperComplexService {

    public int sum(FifthController.Number number) {
        return number.getA() + number.getB();
    }


}
