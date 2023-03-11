package com.kamelia.ugeoverflow.core

import com.kamelia.ugeoverflow.comment.Comment
import com.kamelia.ugeoverflow.user.User
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotBlank

@MappedSuperclass
abstract class AbstractCommentablePost(
    @ManyToOne
    var author: User,
    content: String,
    comments: Set<Comment>,
) : AbstractIdEntity() {

    @NotBlank
    var content: String = content
        set(value) {
            require(value.isNotBlank()) { "Answer content cannot be blank" }
            field = value
        }

    @OneToMany
    @JoinColumn(name = "parentId")
    private var _comments: MutableSet<Comment> = comments.toMutableSet()

    var comments: Set<Comment>
        get() = _comments
        set(value) {
            _comments = value.toMutableSet()
        }

    fun addComment(comment: Comment) {
        _comments.add(comment)
    }

    fun removeComment(comment: Comment) {
        _comments.remove(comment)
    }

}
