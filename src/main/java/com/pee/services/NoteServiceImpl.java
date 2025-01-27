package com.pee.services;

import com.pee.dto.NoteDTO;
import com.pee.dto.NoteRequest;
import com.pee.entities.Note;
import com.pee.entities.Tag;
import com.pee.entities.User;
import com.pee.repository.NoteRepository;
import com.pee.repository.UserRepository;
import com.pee.services.mapper.NoteMapper;
import com.pee.services.mapper.TagMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final TagServiceImpl tagServiceImpl;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository, TagServiceImpl tagServiceImpl) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.tagServiceImpl = tagServiceImpl;
    }

    @Override
    public Collection<NoteDTO> getAllNotes() {
        return noteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NoteDTO> getNoteById(Long id) {
        return noteRepository.findById(id).map(this::convertToDTO);    }

    @Override
    public NoteDTO saveNote(NoteRequest noteRequest) {
        Optional<User> userFind = userRepository.findById(noteRequest.getUserId());
        Collection<Tag> tagsFind = tagServiceImpl.saveTags(TagMapper.convertToEntities(noteRequest.getTagNames()));

        Note note = NoteMapper.convertToEntity(noteRequest, userFind.get(), tagsFind);
        Note savedNote = noteRepository.save(note);
        return convertToDTO(savedNote);
    }

    @Override
    public NoteDTO updateNote(Long id, NoteDTO noteDTO) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(noteDTO.title());
        note.setContent(noteDTO.content());
        note.setStatus(noteDTO.status());
        note.setUser(noteDTO.user());
        note.setTags(noteDTO.tags());
        Note updatedNote = noteRepository.save(note);
        return convertToDTO(updatedNote);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    // Convert Note Entity to NoteDTO
    private NoteDTO convertToDTO(Note note) {
        return new NoteDTO(note.getId(), note.getTitle(), note.getContent(), note.getStatus(), note.getUser(), note.getTags());
    }

}
