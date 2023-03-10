package com.kamelia.ugeoverflow.post

import com.kamelia.ugeoverflow.tag.Tag
import com.kamelia.ugeoverflow.tag.TagDTO
import com.kamelia.ugeoverflow.tag.toDTO
import java.time.Instant
import java.util.UUID

data class PostLightDTO(
    val id: UUID,
    val title: String,
    val tags: Set<TagDTO>,
    val creationDate: Instant,
)

fun Post.toLightDTO() = PostLightDTO(
    id,
    title,
    tags.mapTo(mutableSetOf(), Tag::toDTO),
    creationDate,
)
