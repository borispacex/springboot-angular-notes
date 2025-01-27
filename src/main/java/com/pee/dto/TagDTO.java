package com.pee.dto;

import com.pee.entities.Note;

import java.util.Collection;

public record TagDTO(Long id, String name, Collection<Note> notes) {
}
