package br.com.jwm.livros.model
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import br.com.jwm.livros.BR
import org.parceler.Parcel

/*Classe modelo do objeto Book (Livro). Livro possui publicação e tipo, que são
outros dois objetos. */

/*A classe Book herda de BaseObservable, que é classe base para os objetos
que atualizarão a UI automaticamente. Todas as propriedades foram marcadas com a
anotação @Bindable e os métodos set estão chamando notifyPropertyChanged(int)
(herdado da classe BaseObervable) passando como parâmetro o id da propriedade que
foi modificada. Esses IDs são gerados automaticamente na classe BR (assim como
acontece com a classe R) em tempo de compilação baseado no nome do atributo.*/

@Parcel
class Book: BaseObservable(){

    @Bindable
    var id: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @Bindable
    var title: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var author: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.author)
        }

    @Bindable
    var coverUrl: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.coverUrl)
        }

    @Bindable
    var pages: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.pages)
        }

    @Bindable
    var year: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.year)
        }

    @Bindable
    var publisher: Publisher? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.publisher)
        }

    @Bindable
    var available: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.available)
        }

    @Bindable
    var mediaType: MediaType = MediaType.PAPER
        set(value) {
            field = value
            notifyPropertyChanged(BR.mediaType)
        }

    @Bindable
    var rating: Float = 0.0f
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }
}
