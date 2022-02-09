package com.example.inwestanalist

import kotlin.math.round

class Wskazniki (var sPrzychodu:Int, var sZysków:Int, var cAkcji:Int, var lAkcji: Int){

    //wzór do obliczenia wskaźnika przychod na akcję
    var przychodNaAkcje = 0.0
        get() {
            if (lAkcji>0 && sPrzychodu>0){
                return field
            }else{
                przychodNaAkcje = 0.0
                return field
            }
        }

    //wzór do obliczenia wskaźnika zysk na akcję
    var zyskNaAkcje = 0.0
        get() {
            if (sZysków>0 && lAkcji>0){
                return field
            }else{
                zyskNaAkcje = 0.0
                return field
            }
        }

    //wzór do obliczenia wskaźnika cena akcji na zysk
    var cenaAkcjiNaZysk = 0.0
        get() {
            if (cAkcji>0 && sZysków>0){
                return field
            }else{
                cenaAkcjiNaZysk = 0.0
                return field
            }
        }
    //obliczanie wyniku wskaźnika, zaokrąglenie wyniku
    fun wskazniki(){

        przychodNaAkcje = sPrzychodu.toDouble() / lAkcji.toDouble()
        przychodNaAkcje = round(przychodNaAkcje * 1000) / 1000


        zyskNaAkcje = sZysków.toDouble() / lAkcji.toDouble()
        zyskNaAkcje = round(zyskNaAkcje * 1000) / 1000

        cenaAkcjiNaZysk =cAkcji.toDouble() / (sZysków.toDouble()/lAkcji.toDouble())
        cenaAkcjiNaZysk = round(cenaAkcjiNaZysk * 1000) / 1000
    }

}