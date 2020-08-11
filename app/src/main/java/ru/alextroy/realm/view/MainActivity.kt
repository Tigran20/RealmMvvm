package ru.alextroy.realm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import ru.alextroy.realm.R
import ru.alextroy.realm.viewmodel.PersonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        viewModel.initDB()
        viewModel.getData(db_response)

        btn_save.setOnClickListener {
            viewModel.saveData(edit_text_name, edit_text_age, db_response)
        }
    }


}