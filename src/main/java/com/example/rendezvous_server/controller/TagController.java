package com.example.rendezvous_server.controller;

import com.example.rendezvous_server.model.Tag;
import com.example.rendezvous_server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("tag/get")
    public List<Tag> getAllTag() {
        return tagService.getAllTag();
    }

    @PostMapping("tag/save")
    public ResponseEntity<Tag> saveTag(@RequestBody Tag tag)
    {
        tagService.saveTag(tag);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

}
