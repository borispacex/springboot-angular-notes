package com.pee.dto;

import com.pee.utils.NoteStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {

    private String title;
    private String content;
    private NoteStatus status;
    private Long userId;
    private String[] tagNames;

}
