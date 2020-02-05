package br.com.jwm.livros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.jwm.livros.model.Book
import br.com.jwm.livros.model.MediaType
import br.com.jwm.livros.model.Publisher
import kotlinx.android.synthetic.main.activity_book_list.*

class BooksListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Referencia a Lista de livros
        setContentView(R.layout.activity_book_list)

        //Testando para ver se está tudo funcionando

        //Criando a lista de livros que será passada ao adapter.

        val books = listOf(
            Book().apply {
                id = "1"
                title = "Dominando o Android com Kotlin"
                author = "Nelson Glauber"
                coverUrl = "https://s3.novatec.com.br/capas-ampliadas/capa-ampliada-9788575224632.jpg"
                pages = 954
                year = 2018
                publisher = Publisher("1", "Novatec")
                available = true
                mediaType = MediaType.PAPER
                rating = 5.0f
            }
        )


        //Configuração do LayoutManager
        rvBooks.layoutManager = LinearLayoutManager(this)

        //Recebe a lista e utiliza o adapter para gerar a tela de detalhes
        rvBooks.adapter = BookAdapter(books) { book ->
            BookDetailsActivity.start(this, book)
        }

    }
}
