package com.deadlock.hack.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class TokenService {
    private static final String TOKEN_FOLDER = "tokens";

    public String getToken() {
        final File[] tokensContent = new File(TOKEN_FOLDER).listFiles();
        if (tokensContent == null || tokensContent.length == 0) {
            throw new IllegalStateException("Token not found");
        }
        try {
            return FileUtils.readFileToString(tokensContent[0], StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
