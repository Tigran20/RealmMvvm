package ru.alextroy.realm.repository

import android.widget.EditText
import android.widget.TextView
import io.realm.Realm
import ru.alextroy.realm.model.Student

class PersonRepository {

    private lateinit var realm: Realm

    fun saveData(editTextName: EditText, editTextAge: EditText, dbResponse: TextView) {
        realm.executeTransactionAsync({
            val student = it.createObject(Student::class.java)
            student.name = editTextName.text.toString()
            student.age = editTextAge.text.toString().toInt()
        }, {
            readData(dbResponse)
        }, {
        })
    }

    fun readData(dbResponse: TextView) {
        val students = realm.where(Student::class.java).findAll()
        var response = ""
        students.forEach {
            response = response + "Name: ${it.name}, Age: ${it.age}" + "\n"
        }
        dbResponse.text = response
    }

    fun initDB() {
        realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.commitTransaction()
    }
}