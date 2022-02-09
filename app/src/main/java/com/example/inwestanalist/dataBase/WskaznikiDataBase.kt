package com.example.inwestanalist.dataBase

data class WskaznikiDataBase(
                        var nazwa: String = "",
                        var przychodNaA:Double = 0.0,
                        var zyskNaA:Double = 0.0,
                        var canaAnaZysk:Double = 0.0,
                        var liczbaAkcji:Int = 1){

    constructor():this("",-1.0,-1.0, -1.0,-1)
}

