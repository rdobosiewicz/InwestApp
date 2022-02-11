package com.example.inwestanalist

import kotlin.math.round

class Wskazniki (var sPrzychodu:Int, var sZysków:Int, var cAkcji:Int, var lAkcji: Int){

    //wzór do obliczenia wskaźnika przychod na akcję
    var przychodNaAkcje = obliczPrzychodNaAkcje()
        get() {
            if (lAkcji>0 && sPrzychodu>0){
                return field
            }else{
                przychodNaAkcje = 0.0
                return field
            }
        }

    //wzór do obliczenia wskaźnika zysk na akcję
    var zyskNaAkcje = obliczZyskNaAkcje()
        get() {
            if (sZysków>0 && lAkcji>0){
                return field
            }else{
                zyskNaAkcje = 0.0
                return field
            }
        }

    //wzór do obliczenia wskaźnika cena akcji na zysk
    var cenaAkcjiNaZysk = obliczAkcjeNaZysk()
        get() {
            if (cAkcji>0 && sZysków>0){
                return field
            }else{
                cenaAkcjiNaZysk = 0.0
                return field
            }
        }
    //obliczanie wyniku wskaźnika, zaokrąglenie wyniku
    fun obliczPrzychodNaAkcje():Double{

        przychodNaAkcje = sPrzychodu.toDouble() / lAkcji.toDouble()
        przychodNaAkcje = round(przychodNaAkcje * 1000) / 1000

        return przychodNaAkcje
    }

    fun obliczZyskNaAkcje():Double{

        zyskNaAkcje = sZysków.toDouble() / lAkcji.toDouble()
        zyskNaAkcje = round(zyskNaAkcje * 1000) / 1000

        return zyskNaAkcje
    }

    fun obliczAkcjeNaZysk():Double{

        cenaAkcjiNaZysk =cAkcji.toDouble() / (sZysków.toDouble()/lAkcji.toDouble())
        cenaAkcjiNaZysk = round(cenaAkcjiNaZysk * 1000) / 1000

        return cenaAkcjiNaZysk
    }
}