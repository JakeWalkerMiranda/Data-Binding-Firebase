package br.com.jwm.livros.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import br.com.jwm.livros.R
import br.com.jwm.livros.model.MediaType

// A API de Data Binding permite a criação de binding adapters,
// que são classes simples para conversão de tipos de dados.

object TextBinding {

    //Função que transforma MediaType em texto.

    @JvmStatic
    @BindingAdapter("android:text")
    fun setMediaTypeText(textView: TextView, mediaType: MediaType?) {

        //Se o mediaType for nulo o texto deve ser nulo
        if (mediaType == null) {
            textView.text =  null
            return
        }

        //O binding é feito utilizando um when(super switch) que referencia o texto
        //do arquivo string de acordo com o tipo do MediaType.
        val context = textView.context
        textView.text = when (mediaType) {
            MediaType.EBOOK -> context.getString(R.string.text_book_media_ebook)
            MediaType.PAPER -> context.getString(R.string.text_book_media_paper)
        }
    }

}