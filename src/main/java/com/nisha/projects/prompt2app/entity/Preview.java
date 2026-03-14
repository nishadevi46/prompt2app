package com.nisha.projects.prompt2app.entity;

import com.nisha.projects.prompt2app.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {
    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;
    Instant startedAt;
    Instant terminatedAt;
    Instant createdAt;
    PreviewStatus status;
}
