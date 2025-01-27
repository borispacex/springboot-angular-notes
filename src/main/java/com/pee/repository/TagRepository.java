package com.pee.repository;

import com.pee.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT a FROM Tag a WHERE a.name IN (?1)")
    public Collection<Tag> listAllByNames(String[] tagNames);

}
