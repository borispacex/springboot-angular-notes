package com.pee.services;

import com.pee.dto.TagDTO;
import com.pee.dto.TagRequest;
import com.pee.entities.Tag;

import java.util.Collection;
import java.util.Optional;

public interface TagService {

    Collection<TagDTO> getAllTags();
    Optional<TagDTO> getTagById(Long id);
    TagDTO saveTag(TagDTO tagDTO);
    Collection<Tag> saveTags(Collection<TagRequest> tagRequests);
    TagDTO updateTag(Long id, TagDTO tagDTO);
    void deleteTag(Long id);


}
