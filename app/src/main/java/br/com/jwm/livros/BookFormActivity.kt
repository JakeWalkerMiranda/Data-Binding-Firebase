package br.com.jwm.livros

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.jwm.livros.databinding.ActivityBookFormBinding
import br.com.jwm.livros.model.Book
import br.com.jwm.livros.model.MediaType
import br.com.jwm.livros.model.Publisher
import org.parceler.Parcels

class BookFormActivity : AppCompatActivity() {

    /*Referenciamento do arquivo de layout e a realização do Binding pela classe
    gerada ActivityBookFormBinding, sua inicialização é "preguiçosa" devido ao
    lazy.*/

    private val binding: ActivityBookFormBinding by lazy {
        DataBindingUtil.setContentView<ActivityBookFormBinding>(
            this, R.layout.activity_book_form
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* O objeto é desembrulhado(unwrap). O objeto (Book) será passado via
        Intent (if) ou pela instancia (else), se possuir. */

        binding.content.book = if (savedInstanceState == null) {
            Parcels.unwrap<Book>(intent.getParcelableExtra(EXTRA_BOOK)) ?: Book()
        } else {
            Parcels.unwrap<Book>(savedInstanceState.getParcelable(EXTRA_BOOK))
        }

        //Manualmente é feito um binding com a lista de publicações

        binding.content.publishers = listOf(
            Publisher("1", "Novatec"),
            Publisher("2", "Outra")
        )

        /* Note que está sendo utilizado binding.content, pois no arquivo de
        layout res/layout/activity_book_form.xml está sendo feito um <include>
        com o id content para o arquivo res/layout/book_form_content.xml.*/

        binding.content.view = this
    }

    //Guardando o estado do objeto instanciado

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_BOOK, Parcels.wrap(binding.content.book))
    }

    /* Metodo do arquivo de layout (RadioGroup) para fazer o binding de acordo
    com a opção do RadioButtom */

    fun onMediaTypeChanged(buttonView: CompoundButton, isChecked: Boolean){
       if (isChecked) {
           if (buttonView == binding.content.rbMediaEbook) {
               binding.content.book?.mediaType = MediaType.EBOOK
           } else if (buttonView == binding.content.rbMediaPaper) {
               binding.content.book?.mediaType = MediaType.PAPER
           }
       }
    }

    /* Metodo do arquivo de layout (Button) para recuperar os dados passados e
    exibir atravez de um Toast */

    fun clickSaveBook(view: View){
        val book = binding.content.book
        if (book != null) {
            val s = "${book.title}\n" +
                    "${book.author}\n" +
                    "${book.publisher?.name}\n" +
                    "${book.pages}\n" +
                    "${book.year}\n" +
                    "${book.available}\n" +
                    "${book.rating}\n" +
                    "${book.mediaType}"
            Toast.makeText(this,s, Toast.LENGTH_SHORT).show()
        }
    }

    //Método padrão de intent, com o detalhe do embrulho(wrap) do objeto book.

    companion object {
        private const val EXTRA_BOOK = "book"

        fun start(context: Context, book: Book){
            context.startActivity(
                Intent(context, BookFormActivity::class.java).apply{
                    putExtra(EXTRA_BOOK, Parcels.wrap(book))
                }
            )
        }
    }
}
