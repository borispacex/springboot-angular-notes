package com.pee.services;

import com.pee.dto.NoteDTO;
import com.pee.dto.NoteRequest;

import java.util.Collection;
import java.util.Optional;

public interface NoteService {

    Collection<NoteDTO> getAllNotes();
    Optional<NoteDTO> getNoteById(Long id);
    NoteDTO saveNote(NoteRequest noteRequest);
    NoteDTO updateNote(Long id, NoteDTO noteDTO);
    void deleteNote(Long id);

}
