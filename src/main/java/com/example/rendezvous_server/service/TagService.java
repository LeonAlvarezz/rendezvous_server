package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;

public class TagService {
    @Autowired
    TagService tagService;
    private Tag saveTag(Tag tag)
    {
        return tagService.saveTag(tag);
    }

}
