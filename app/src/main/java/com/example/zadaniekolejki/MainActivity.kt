package com.example.zadaniekolejki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Kolejka
        val queue: Queue<Int> = LinkedList<Int>()
        val btnDodajDoKolejki = findViewById<Button>(R.id.btnDodaj)
        val btnUsunZKolejki = findViewById<Button>(R.id.btnUsun)
        var txtPierwszyWKolejce = findViewById<TextView>(R.id.txtPierwszy)
        var txtIloscWKolejce = findViewById<TextView>(R.id.textView2)
        val txtOstatni = findViewById<TextView>(R.id.txtOstatni)
        var pierwszy = 0
        var ostatni = 0
        var numerKolejki = 1
        var dlugosc = Toast.LENGTH_SHORT

        btnDodajDoKolejki.setOnClickListener() {
            queue.add(numerKolejki)
            numerKolejki += 1
            txtIloscWKolejce.text = txtIloscWKolejce.toString() + numerKolejki
            if (!queue.isEmpty()) {
                val first = queue.element()
                val last = queue.last()
                txtIloscWKolejce.text = first.toString()
                txtOstatni.text = last.toString()
            }
            btnUsunZKolejki.setOnClickListener() {
                if (!queue.isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        "Usunieto numer: " + queue.element() + " z kolejki!",
                        dlugosc
                    ).show()
                    queue.remove()
                    txtIloscWKolejce.text = txtIloscWKolejce.toString() + numerKolejki
                } else {
                    Toast.makeText(applicationContext, "Brak liczb w kolejce", dlugosc).show()
                }
            }
            //Stos
            
        }
    }
}