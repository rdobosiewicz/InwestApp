package com.example.inwestanalist

import kotlin.math.round

//PL: Ta klasa umożliwa obliczenie wskaźników giełdowych informujących o atrakcyjności spółki
//ANG: This class allows the calculation of rate that provide information about the investment attractiveness of a company

class Wskazniki (var sPrzychodu:Int, var sZysków:Int, var cAkcji:Int, var lAkcji: Int){

    // Revenue per share
    var przychodNaAkcje = obliczPrzychodNaAkcje()
        get() {
            if (lAkcji>0 && sPrzychodu>0){
                return field
            }else{
                przychodNaAkcje = 0.0
                return field
            }
        }

    // Profit per share
    var zyskNaAkcje = obliczZyskNaAkcje()
        get() {
            if (sZysków>0 && lAkcji>0){
                return field
            }else{
                zyskNaAkcje = 0.0
                return field
            }
        }

    //Pries of share per profit
    var cenaAkcjiNaZysk = obliczAkcjeNaZysk()
        get() {
            if (cAkcji>0 && sZysków>0){
                return field
            }else{
                cenaAkcjiNaZysk = 0.0
                return field
            }
        }
    //PL: Wzór do obliczenia wskaźnika przychod na akcję
    //ANG: Formula for calculating of rate revenue per share
    fun obliczPrzychodNaAkcje():Double{

        przychodNaAkcje = sPrzychodu.toDouble() / lAkcji.toDouble()
        przychodNaAkcje = round(przychodNaAkcje * 1000) / 1000

        return przychodNaAkcje
    }

    //PL: Wzór do obliczenia wskaźnika zysk na akcję
    //ANG: Formula for calculating of rate profit per share
    fun obliczZyskNaAkcje():Double{

        zyskNaAkcje = sZysków.toDouble() / lAkcji.toDouble()
        zyskNaAkcje = round(zyskNaAkcje * 1000) / 1000

        return zyskNaAkcje
    }
    //PL: Wzór do obliczenia wskaźnika cena akcji na zysk
    //ANG: Formula for calculating rate pries of share per profit
    fun obliczAkcjeNaZysk():Double{

        cenaAkcjiNaZysk =cAkcji.toDouble() / (sZysków.toDouble()/lAkcji.toDouble())
        cenaAkcjiNaZysk = round(cenaAkcjiNaZysk * 1000) / 1000

        return cenaAkcjiNaZysk
    }
}