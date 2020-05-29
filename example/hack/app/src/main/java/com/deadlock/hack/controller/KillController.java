package com.deadlock.hack.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KillController {

    @DeleteMapping("/program")
    public void kill() {
        System.exit(1);
    }
}
