package com.henckel.sorteiatimes.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Player : RealmObject {
    @PrimaryKey
    var id          : Int? = null
    var name        : String? = null
    var position    : Int? = null
    var rate        : Int? = null

    companion object{
        fun getPositions() : List<String> {
            return listOf("Sem Posicao", "Goleiro", "Zagueiro", "Lateral-Direito", "Lateral-Esquerdo", "Volante",  "Meia", "Atacante")
        }
    }
}
