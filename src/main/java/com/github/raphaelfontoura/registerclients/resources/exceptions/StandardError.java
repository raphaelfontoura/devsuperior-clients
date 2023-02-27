package com.github.raphaelfontoura.registerclients.resources.exceptions;

import java.time.Instant;

public record StandardError(
	Instant timestamp,
    Integer status,
    String error,
    String path,
    String message
) {
}
