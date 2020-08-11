package ru.alextroy.realm.viewmodel

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import ru.alextroy.realm.repository.PersonRepository

class PersonViewModel : ViewModel() {

    private var personRepository: PersonRepository = PersonRepository()

    fun getData(db_response: TextView) {
        personRepository.readData(db_response)
    }

    fun saveData(editTextName: EditText, editTextAge: EditText, dbResponse: TextView) {
        personRepository.saveData(editTextName, editTextAge, dbResponse)
    }

    fun initDB() {
        personRepository.initDB()
    }

}