package br.com.jwm.livros.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/* A API de Data Binding permite a criação de binding adapters,
que são classes simples para conversão de tipos de dados. */

/* Para atribuir uma imagem a uma ImageView deve-se utilizar a propriedade
android:src, mas essa propriedade recebe um Drawable ou um Bitmap e o objeto
book possui apenas a URL da imagem. Por essa razão foi definida a propriedade
app:imageUrl da ImageView, que na verdade não existe. Quem fará esse tratamento
será um binding adapter que carregará a imagem baseado na URL e preencherá a
ImageView. */

object ImageBinding {

    //Nota-se que o valor do BindingAdapter é uma referencia ao arquivo de layout.

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String){

        //Se a url não for vazia o Glide faz o carregamento da url para uma imagem.

        if (url.isNotEmpty()) {
            Glide.with(imageView)
                .load(url)
                .into(imageView)
        }
    }
}