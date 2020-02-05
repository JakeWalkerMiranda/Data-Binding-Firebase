package br.com.jwm.livros.binding

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

// A API de Data Binding permite a criação de binding adapters,
// que são classes simples para conversão de tipos de dados.

object EditTextBinding {

    /* O método setTextFromInt(EditText,Int) convertá um Int para o texto que será
     exibido no EditText. Note um detalhe importante aqui: é feita uma verificação
     para saber se o valor atribuído ao EditText é diferente do valor atual. Isso é
     essencial, pois se isso não for feito, será gerado um “loop infinito” e o
     componente ficaria travado ao tentar digitar algo.*/


    @JvmStatic
    @BindingAdapter("android:text")
    fun setTextFromInt(editText: EditText, value: Int) {
        if (getTextAsInt(editText) != value) {
            editText.setText(value.toString())
        }
    }

    /* O método getTextAsInt(EditText) está anotado com @InverseBindingAdapter e é
     o responsável por converter o que é digitado no EditText para um Int.*/

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:text")
    fun getTextAsInt(editText: EditText): Int {
        return try {
            Integer.parseInt(editText.text.toString())
        } catch (e: Exception) {
            0
        }
    }
}