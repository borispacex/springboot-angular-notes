package com.pee.services.mapper;

import com.pee.dto.NoteDTO;
import com.pee.dto.NoteRequest;
import com.pee.entities.Note;
import com.pee.entities.Tag;
import com.pee.entities.User;

import java.util.Collection;

public class NoteMapper {

    // Convert NoteDTO to Note Entity
    public static Note convertToEntity(NoteDTO noteDTO) {
        Note note = new Note();
        note.setTitle(noteDTO.title());
        note.setContent(noteDTO.content());
        note.setStatus(noteDTO.status());
        note.setUser(noteDTO.user());
        note.setTags(noteDTO.tags());
        return note;
    }

    // Convert NoteDTO to Note Entity
    public static Note convertToEntity(NoteRequest noteRequest, User user, Collection<Tag> tags) {
        Note note = new Note();
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());
        note.setStatus(noteRequest.getStatus());
        note.setUser(user);
        note.setTags(tags);
        return note;
    }

}
