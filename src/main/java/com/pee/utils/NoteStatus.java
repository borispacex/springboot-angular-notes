package com.pee.utils;

public enum NoteStatus {
    DELETED(0),
    CREATED(1),
    ARCHIVED(2);

    private final int value;

    NoteStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
