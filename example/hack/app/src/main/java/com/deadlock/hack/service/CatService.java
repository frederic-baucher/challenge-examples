package com.deadlock.hack.service;

import com.deadlock.hack.dao.CatDao;
import com.deadlock.hack.dao.CommentDao;
import com.deadlock.hack.model.Cat;
import com.deadlock.hack.model.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CatService {
    private final CatDao catDao;
    private final CommentDao commentDao;
    private final TokenService tokenService;

    public CatService(final CatDao catDao, final CommentDao commentDao, final TokenService tokenService) {
        this.catDao = catDao;
        this.commentDao = commentDao;
        this.tokenService = tokenService;
    }

    @Transactional(readOnly = true)
    public List<Cat> listCats() {
        return catDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Comment> listCatComments(final int catId) {
        assertCatExists(catId);
        return commentDao.findByCat(catId);
    }

    @Transactional(readOnly = false)
    public String addCatComment(final int catId, final String comment) {
        assertCatExists(catId);
        commentDao.insertComment(catId, comment);
        return listCats().isEmpty() ? tokenService.getToken() : null;
    }

    private void assertCatExists(final int catId) {
        if (catDao.findById(catId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cat with id: " + catId);
        }
    }
}
