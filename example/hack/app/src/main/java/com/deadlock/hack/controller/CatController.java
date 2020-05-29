package com.deadlock.hack.controller;

import com.deadlock.hack.controller.dto.CommentDto;
import com.deadlock.hack.controller.dto.TokenDto;
import com.deadlock.hack.model.Cat;
import com.deadlock.hack.model.Comment;
import com.deadlock.hack.service.CatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    public CatController(final CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<Cat> listCats() {
        return catService.listCats();
    }

    @GetMapping("{catId}/comments")
    public List<Comment> listCatComments(@PathVariable final int catId) {
        return catService.listCatComments(catId);
    }

    @PostMapping("{catId}/comments")
    public TokenDto addCatComment(@PathVariable final int catId,
                                  @RequestBody final CommentDto commentDto) {
        return new TokenDto(catService.addCatComment(catId, commentDto.getComment()));
    }
}
