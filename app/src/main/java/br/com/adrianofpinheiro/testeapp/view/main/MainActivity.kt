package br.com.adrianofpinheiro.testeapp.view.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.adrianofpinheiro.testeapp.R
import br.com.adrianofpinheiro.testeapp.model.Filme

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.loading.*

class MainActivity : AppCompatActivity() {

    private var adapter: MainListAdapter? = null

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel::class.java)

        mainViewModel.filmes.observe(this, filmesObserver)
        mainViewModel.isLoading.observe(this, loadingObserver)

        mainViewModel.buscarTodos()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Adriano Ferreira Pinheiro", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private var filmesObserver = Observer<List<Filme>> {
        preencheALista(it!!)
    }

    private var loadingObserver = Observer<Boolean> {
        if (it == true) {
            containerLoading.visibility = View.VISIBLE
        } else {
            containerLoading.visibility = View.GONE
        }
    }

    private fun preencheALista(filmes: List<Filme>){
        adapter = MainListAdapter(this, filmes, {}, {})

        rvFilmes.adapter = adapter
        rvFilmes.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
