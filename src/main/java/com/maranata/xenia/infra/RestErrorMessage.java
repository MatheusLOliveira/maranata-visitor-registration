package com.maranata.xenia.infra;

import java.time.Instant;

public record RestErrorMessage(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) {}
