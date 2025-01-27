package com.pee.services.mapper;

import com.pee.dto.TagDTO;
import com.pee.dto.TagRequest;
import com.pee.entities.Note;
import com.pee.entities.Tag;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class TagMapper {

    // Convert Tag Entity to TagDTO
    private static TagDTO convertToDTO(Tag tag) {
        return new TagDTO(tag.getId(), tag.getName(), tag.getNotes());
    }

    public static Collection<TagDTO> convertToDTOs(Collection<Tag> tags) {
        Collection<TagDTO> tagDTOs = tags.stream()
                .map(tag -> convertToDTO(tag))
                .collect(Collectors.toList());
        return tagDTOs;
    }

    // Convert TagDTO to Tag Entity
    public static Tag convertToEntity(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.name());
        tag.setNotes(tagDTO.notes());
        return tag;
    }

    // Convert TagDTO to Tag Entity
    public static Tag convertToEntity(TagRequest tagRequest, Collection<Note> notes) {
        Tag tag = new Tag();
        tag.setName(tagRequest.getName());
        tag.setNotes(notes);
        return tag;
    }

    public static Collection<Tag> convertToEntities(Collection<TagRequest> tagRequests, Collection<Note> notes) {
        Collection<Tag> tags = tagRequests.stream()
                .map(tagRequest -> convertToEntity(tagRequest, notes))
                .collect(Collectors.toList());
        return tags;
    }

    public static Collection<TagRequest> convertToEntities(String[] tagIds) {
        Collection<TagRequest> tagRequests = Arrays.stream(tagIds)
                .map(TagRequest::new)
                .collect(Collectors.toList());
        return tagRequests;
    }

}
