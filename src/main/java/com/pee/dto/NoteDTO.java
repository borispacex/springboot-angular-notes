package com.pee.dto;

import com.pee.entities.Tag;
import com.pee.entities.User;
import com.pee.utils.NoteStatus;

import java.util.Collection;

public record NoteDTO(Long id, String title, String content, NoteStatus status, User user, Collection<Tag> tags) {}