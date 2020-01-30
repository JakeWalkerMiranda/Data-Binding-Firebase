package br.com.jwm.livros

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.jwm.livros.databinding.ActivityBookDetailsBinding
import br.com.jwm.livros.model.Book
import org.parceler.Parcels

class BookDetailsActivity : AppCompatActivity() {

    //Referenciamento do arquivo de layout e a realização do Binding pela classe gerada
    //ActivityBookDetailsBinding, sua inicialização é "preguiçosa" devido ao lazy.

    private val binding: ActivityBookDetailsBinding by lazy {
        DataBindingUtil.setContentView<ActivityBookDetailsBinding>(
            this, R.layout.activity_book_details
        )
    }

    //O objeto é desembrulhado(unwrap). A instância do book que será passada via
    //Intent é obtida e atribuída ao objeto binding.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val book = Parcels.unwrap<Book>(intent.getParcelableExtra(EXTRABOOK))
        if (book != null) {
            binding.book = book
        }
    }

    //Método padrão de intent, com o detalhe do embrulho(wrap) do objeto book.

    companion object {
        private const val EXTRABOOK = "book"

        fun start(context: Context, book: Book) {
            context.startActivity(
                Intent(context, BookDetailsActivity::class.java).apply{
                    putExtra(EXTRABOOK, Parcels.wrap(book))
                }
            )
        }
    }
}
