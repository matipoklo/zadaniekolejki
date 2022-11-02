package com.example.zadaniekolejki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            val stos = LinkedList<Int>()
            val butt_dodaj_do_stosu = findViewById<Button>(R.id.btnDodaj3)
            val butt_usun_ze_stosu = findViewById<Button>(R.id.btnUsun2)
            val edittext_dodaj_do_stosu = findViewById<EditText>(R.id.editText_dodaj_do_stosu)
            val txt_ile_w_stosie = findViewById<TextView>(R.id.textView7)
            var ilosc_ele_w_stosie = 0

            butt_dodaj_do_stosu.setOnClickListener {
                if(edittext_dodaj_do_stosu.text.toString() != "") {
                    val liczba = edittext_dodaj_do_stosu.text.toString().toInt()
                    Toast.makeText(applicationContext, "Dodano do stosu liczbe: " + liczba, dlugosc).show()
                    stos.add(liczba)
                    ilosc_ele_w_stosie += 1
                    txt_ile_w_stosie.text = ilosc_ele_w_stosie.toString()
                }
                else
                {
                    Toast.makeText(applicationContext, "Wpisz do pola nad przyciskiem, jaka liczbe chcesz dodac", dlugosc).show()
                }

            }

            butt_usun_ze_stosu.setOnClickListener {
                if (!stos.isEmpty())
                {
                    val liczba = stos.last()
                    Toast.makeText(applicationContext, "usunieto do stosu liczbe: " + liczba, dlugosc).show()
                    stos.removeLast()
                    ilosc_ele_w_stosie -= 1
                    txt_ile_w_stosie.text = ilosc_ele_w_stosie.toString()
                }
                else
                {
                    Toast.makeText(applicationContext, "Stos jest pusty", dlugosc).show()
                }
            }
        }
    }
}