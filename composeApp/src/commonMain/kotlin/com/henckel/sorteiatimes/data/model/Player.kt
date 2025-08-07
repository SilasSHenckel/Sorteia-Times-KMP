package com.henckel.sorteiatimes.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Player : RealmObject {
    @PrimaryKey
    val id          : Int? = null
    var name        : String? = null
    var position    : Int? = null
    var rate        : Int? = null
}