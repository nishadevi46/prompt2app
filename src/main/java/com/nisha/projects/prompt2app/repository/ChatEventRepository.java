package com.nisha.projects.prompt2app.repository;

import com.nisha.projects.prompt2app.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent, Long> {
}
