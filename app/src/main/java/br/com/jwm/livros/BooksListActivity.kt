package br.com.jwm.livros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.jwm.livros.model.Book
import br.com.jwm.livros.model.MediaType
import br.com.jwm.livros.model.Publisher

class BooksListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Testando para ver se está tudo funcionando
        BookDetailsActivity.start(this, Book(
            id = "1",
            title = "Dominando o Android com Kotlin",
            author = "Nelson Glauber",
            coverUrl = "https://s3.novatec.com.br/capas-ampliadas/capa-ampliada-9788575224632.jpg",
            pages = 954,
            year = 2018,
            publisher = Publisher("1", "Novatec"),
            available = true,
            mediaType = MediaType.PAPER,
            rating = 5.0f
        ))

    }
}
