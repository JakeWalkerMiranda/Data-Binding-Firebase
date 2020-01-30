package br.com.jwm.livros.model
import org.parceler.Parcel

//Classe modelo do objeto Publisher (Publicação). Sobreescreve o método toString.

@Parcel
data class Publisher(
    var id: String = "",
    var name: String = ""
) {
    override fun toString(): String = "$id - $name"
}
