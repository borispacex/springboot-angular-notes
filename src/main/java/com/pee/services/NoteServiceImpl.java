package com.pee.services;

import com.pee.dto.NoteDTO;
import com.pee.entities.Note;
import com.pee.repository.NoteRepository;

import java.util.Collection;
import java.util.Optional; 
import java.util.stream.Collectors;

public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
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
    public NoteDTO saveNote(NoteDTO noteDTO) {
        Note note = convertToEntity(noteDTO);
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

    // Convert NoteDTO to Note Entity
    private Note convertToEntity(NoteDTO noteDTO) {
        Note note = new Note();
        note.setTitle(noteDTO.title());
        note.setContent(noteDTO.content());
        note.setStatus(noteDTO.status());
        note.setUser(noteDTO.user());
        note.setTags(noteDTO.tags());
        return note;
    }

}
