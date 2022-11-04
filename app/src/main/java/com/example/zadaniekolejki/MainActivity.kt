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
        val kolejka: Queue<Int> = LinkedList<Int>()
        val butt_dodaj_do_kolejki = findViewById<Button>(R.id.btnDodaj)
        val butt_usun_z_kolejki = findViewById<Button>(R.id.btnUsun)
        val butt_pierw_i_ost_w_kolejce = findViewById<Button>(R.id.btnPokaz)
        val txt_ile_w_kolejce = findViewById<TextView>(R.id.textView2)
        val txt_pierwszy_w_kolejce = findViewById<TextView>(R.id.txtPierwszy)
        val txt_ostatni_w_kolejce = findViewById<TextView>(R.id.txtOstatni)
        val length = Toast.LENGTH_SHORT
        var numer = 1
        var ilosc_kolejka = 0


        butt_dodaj_do_kolejki.setOnClickListener {
            Toast.makeText(applicationContext, "Dodano do kolejki numer: " + numer, length).show()
            kolejka.add(numer)
            numer += 1
            ilosc_kolejka += 1
            txt_ile_w_kolejce.text = "Ilosc liczb w kolejce: " + ilosc_kolejka.toString()
        }

        butt_usun_z_kolejki.setOnClickListener {
            if (!kolejka.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Usunieto numer: " + kolejka.element() + " z kolejki!",
                    length
                ).show()
                kolejka.remove()
                ilosc_kolejka -= 1
                txt_ile_w_kolejce.text = "Ilosc elementow w kolejce: " + ilosc_kolejka.toString()

            } else {
                Toast.makeText(applicationContext, "Brak liczb w kolejce", length).show()
            }
        }
        butt_pierw_i_ost_w_kolejce.setOnClickListener {
            if (!kolejka.isEmpty()) {
                val pierw = kolejka.element()
                val ost = kolejka.last()
                txt_pierwszy_w_kolejce.text = "Pierwszy Element w kolejce: " + pierw.toString()
                txt_ostatni_w_kolejce.text = "Ostatni Element w kolejce: " + ost.toString()
            } else {
                Toast.makeText(applicationContext, "Brak osob w kolejce", length).show()
                txt_pierwszy_w_kolejce.text = "brak liczb w kolejce"
                txt_ostatni_w_kolejce.text = "brak liczb w kolejce"
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
                    Toast.makeText(applicationContext, "Dodano do stosu liczbe: " + liczba, length).show()
                    stos.add(liczba)
                    ilosc_ele_w_stosie += 1
                    txt_ile_w_stosie.text = "Ilosc Elementow w stosie: " + ilosc_ele_w_stosie.toString()

                }
                else
                {
                    Toast.makeText(applicationContext, "Wpisz do pola nad przyciskiem, jaka liczbe chcesz dodac", length).show()
                }

            }

            butt_usun_ze_stosu.setOnClickListener {
                if (!stos.isEmpty())
                {
                    val liczba = stos.last()
                    Toast.makeText(applicationContext, "usunieto do stosu liczbe: " + liczba, length).show()
                    stos.removeLast()
                    ilosc_ele_w_stosie -= 1
                    txt_ile_w_stosie.text = "Ilosc Elementow w stosie: " + ilosc_ele_w_stosie.toString()
                }
                else
                {
                    Toast.makeText(applicationContext, "Stos jest pusty", length).show()
                }
            }
        }
    }

