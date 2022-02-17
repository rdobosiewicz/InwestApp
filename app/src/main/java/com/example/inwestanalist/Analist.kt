package com.example.inwestanalist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.inwestanalist.dataBase.WskaznikiDataBase
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_analist.*

class Analist : AppCompatActivity() {

    var sumaPrzychodu = 0
    var sumaZyskow = 0
    var cenaAkcji = 0
    var liczbaAkcji = 0
    var nazwaS =" "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analist)

        var firebaseDatabase = FirebaseDatabase.getInstance("https://investapp-a565e-default-rtdb.firebaseio.com/")


        //PL: Gui pierwszy wiersz layoutu / Wykorzystanie rozszerzenia extensions w build.gradle
        //ANG: First row of layout / Use add-on extensions in build.gradle
        //val przychod = findViewById<EditText>(R.id.przychodSpolki)
        //val textViewPrzychod = findViewById<TextView>(R.id.przychodSpolkiTextView)

        //PL: Gui drugi wiersz layoutu
        //ANG: Second row of layout
        val editTextZysk = findViewById<EditText>(R.id.zyskNettoSpolki)
        val textViewZysk = findViewById<TextView>(R.id.zyskSpolkiTextView)

        //PL: Gui trzeci wiersz layoutu
        //ANG: Third row of layout
        val editTextCenaAkcji = findViewById<EditText>(R.id.cenaAkcji)
        val textViewCenaAkcji = findViewById<TextView>(R.id.cenaAkcjiTextView)

        //Pl: Gui czwarty wiersz layoutu
        //ANG: Fourth row of layout
        val editTextLiczbaAkcji = findViewById<EditText>(R.id.liczbaAkcji)
        val textViewLiczbaAkcji = findViewById<TextView>(R.id.liczbaAkcjiTextView)


        val oblicz = findViewById<Button>(R.id.obliczWskazniki)
        val textViewWynikObliczenia = findViewById<TextView>(R.id.wynikObliczenia)




        //PL: Zapis przychodu do zmiennej
        //ANG: Entry value of revenue to variable
        pSpolki.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    var sumaPrzychoduTemp = s.toString()
                    przychodSpolkiTextView.text = " "
                    if (sumaPrzychoduTemp.isEmpty()) {
                        przychodSpolkiTextView.text = "Wpisz kwotę"
                    }
                    sumaPrzychodu = sumaPrzychoduTemp.toInt()

                } catch (nfe: NumberFormatException){
                    val text ="Popraw wartość"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    sumaPrzychodu = 0
                        }

                }

            override fun afterTextChanged(s: Editable?) {}

            })

        //PL: Zapis zysku do zmiennej
        //ANG: Entry value of accounting profit to variable
        editTextZysk.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                try {
                    var sumaZyskowTemp = s.toString()
                    textViewZysk.text = " "
                    if (sumaZyskowTemp.isEmpty()) {
                        textViewZysk.text = "Wpisz kwotę"
                    }
                    sumaZyskow = sumaZyskowTemp.toInt()

                } catch (nfe: NumberFormatException){
                    val text ="Popraw wartość"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    sumaZyskow = 0
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //PL: Zapis liczby akcji do zmiennej
        //ANG: Writing the number of shares into a variable
        editTextLiczbaAkcji.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                try {
                    var liczbaAkcjiTemp = s.toString()
                    textViewLiczbaAkcji.text = " "
                    if (liczbaAkcjiTemp.isEmpty()) {
                        textViewLiczbaAkcji.text = "Wpisz kwotę"
                    }
                    liczbaAkcji = liczbaAkcjiTemp.toInt()

                } catch (nfe: NumberFormatException){
                    val text ="Popraw wartość"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    liczbaAkcji = 0
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //PL: Zapis ceny akcji do zmiennej
        //ANG: Entry price of share to variable
        editTextCenaAkcji.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                try {
                    var cenaAkcjiTemp = s.toString()
                    textViewCenaAkcji.text = " "
                    if (cenaAkcjiTemp.isEmpty()) {
                        textViewCenaAkcji.text = "Wpisz kwotę"
                    }
                    cenaAkcji = cenaAkcjiTemp.toInt()

                } catch (nfe: NumberFormatException){
                    val text ="Popraw wartość"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    cenaAkcji = 0
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        nazwaSpolki.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                try {
                    nazwaS = s.toString()
                    nazwaSpolkiTextView.text = " "
                    if (nazwaS.isEmpty()) {
                        nazwaSpolkiTextView.text = "Wpisz kwotę"
                    }

                } catch (nfe: NumberFormatException){
                    val text ="Popraw wartość"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    nazwaS = "Brak"
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        oblicz.setOnClickListener {

            val wskazniki = Wskazniki(sumaPrzychodu,sumaZyskow,cenaAkcji,liczbaAkcji)


            textViewWynikObliczenia.text = """Nazwa spółki: $nazwaS
                    |Przychód na akcję:  ${wskazniki.przychodNaAkcje} 
                    |Zysk na akcję: ${wskazniki.zyskNaAkcje}
                    |Cena akcji: ${wskazniki.cAkcji}
                    |Cena/Zysk: ${wskazniki.cenaAkcjiNaZysk}""".trimMargin()

            var dataBaseWsk = WskaznikiDataBase(nazwaS,wskazniki.przychodNaAkcje, wskazniki.zyskNaAkcje, wskazniki.cenaAkcjiNaZysk, liczbaAkcji)
            var databaseReference = firebaseDatabase.getReference()
            databaseReference.child("Wskazniki").push().setValue(dataBaseWsk)


        }
        }






    }