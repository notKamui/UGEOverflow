package com.kamelia.ugeoverflow.votes

import com.kamelia.ugeoverflow.core.AbstractIdEntity
import com.kamelia.ugeoverflow.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "vote")
class Vote(
    @ManyToOne
    @JoinColumn(name = "voter")
    val voter: User,
    @Column(name = "is_upvote")
    var isUpvote: Boolean,
) : AbstractIdEntity()
