package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.Tag;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TagService {
    @Autowired
    private TagRepo tagRepo;
    public List<Tag> getAllTag()
    {
        List<Tag> tagList = new ArrayList<>();
        Streamable.of(tagRepo.findAll()).forEach(tagList::add);
        return tagList;
    }
    public Tag saveTag(Tag tag)
    {
        return tagRepo.save(tag);
    }

}
