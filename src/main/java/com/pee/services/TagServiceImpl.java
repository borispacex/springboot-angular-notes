package com.pee.services;

import com.pee.dto.TagDTO;
import com.pee.dto.TagRequest;
import com.pee.entities.Tag;
import com.pee.repository.TagRepository;
import com.pee.services.mapper.TagMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Collection<TagDTO> getAllTags() {
        return tagRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TagDTO> getTagById(Long id) {
        return tagRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public TagDTO saveTag(TagDTO tagDTO) {
        Tag tag = TagMapper.convertToEntity(tagDTO);
        Tag savedTag = tagRepository.save(tag);
        return convertToDTO(savedTag);
    }

    @Override
    public Collection<Tag> saveTags(Collection<TagRequest> tagRequests) {
        Collection<Tag> tags = TagMapper.convertToEntities(tagRequests, null);
        Collection<Tag> savedTags = tagRepository.saveAll(tags);
        return savedTags;
    }

    @Override
    public TagDTO updateTag(Long id, TagDTO tagDTO) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        tag.setName(tagDTO.name());
        tag.setNotes(tagDTO.notes());
        Tag updatedTag = tagRepository.save(tag);
        return convertToDTO(updatedTag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    // Convert Tag Entity to TagDTO
    private TagDTO convertToDTO(Tag tag) {
        return new TagDTO(tag.getId(), tag.getName(), tag.getNotes());
    }

}
