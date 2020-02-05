package br.com.jwm.livros

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.jwm.livros.databinding.ItemBookBinding
import br.com.jwm.livros.model.Book

class BookAdapter(val books: List<Book>,
                  private val onClick: (Book) -> Unit)
    : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.run {
            val currentBook = books[position]
            book = currentBook

            /* A propriedade root de um binding retorna a View raiz do arquivo de
            layout, que nesse exemplo (res/layout/item_book.xml) é um ConstraintLayout.*/

            root.setOnClickListener {
                onClick(currentBook)
            }

            /* Um ponto importantíssimo é a chamada ao método executePendingBindings(),
            pois quando o objeto que está fazendo o binding em um arquivo de layout
            é atribuído, essa atualização só é realizada após alguns milissegundos.
            E numa tela de listagem, se o usuário fizer um scroll muito rápido, essa
            alteração pode ficar atrasada e ficar perceptível para o usuário. Esse
            método executa o binding imediatamente.*/

            executePendingBindings()
        }
    }

    override fun getItemCount(): Int = books.size


    /*Como é possível observar na classe ViewHolder, foi utilizada a classe
    DataBindingUtils para obter o objeto binding passando como parâmetro uma
    View em vez de um arquivo de layout.*/

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DataBindingUtil.bind<ItemBookBinding>(view)
    }

    /* Uma abordagem similar é utilizada com Fragments, onde o
    onCreateView(LayoutInflater,ViewGroup,Bundle) ficaria da seguinte forma:

    class MyFragment: Fragment() {
        var binding: FragmentMyBinding? = null
        override fun onCreateView(inflater: LayoutInflater,
                                  container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_my, container, false)
            return binding.root
        }
    }

    */
}