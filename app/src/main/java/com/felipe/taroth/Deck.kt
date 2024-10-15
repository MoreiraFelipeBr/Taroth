package com.felipe.taroth

import java.time.LocalDate
import java.time.LocalTime


class Deck {

    val cartas = arrayOf(
        "O Louco","O Mago", "A Sacerdotisa", "A Imperatriz","O Imperador", "O Hierofante", "Os Enamorados", "O Carro",
        "A Força","O Eremita", "A Roda da Fortuna", "A Justiça", "O Pendurado", "A Morte","A Temperança",
        "O Diabo", "A Torre", "A Estrela", "A Lua", "O Sol", "O Julgamento", "O Mundo",
        "Ás de paus","2 de paus","3 de paus","4 de paus","5 de paus", "6 de paus", "7 de paus",
        "8 de paus", "9 de paus", "10 de paus","Pajem de paus", "Cavaleiro de paus", "Rainha de paus", "Rei de paus",
        "Ás de copas", "2 de copas", "3 de copas", "4 de copas", "5 de copas", "6 de copas", "7 de copas",
        "8 de copas", "9 de copas", "10 de copas","Pajem de copas", "Cavaleiro de copas", "Rainha de copas", "Rei de copas",
        "Ás de espadas", "2 de espadas", "3 de espadas", "4 de espadas", "5 de espadas", "6 de espadas", "7 de espadas",
        "8 de espadas", "9 de espadas", "10 de espadas","Pajem de espadas", "Cavaleiro de espadas", "Rainha de espadas", "Rei de espadas",
        "Ás de ouros", "2 de ouros", "3 de ouros", "4 de ouros", "5 de ouros", "6 de ouros", "7 de ouros",
        "8 de ouros", "9 de ouros", "10 de ouros    ","Pajem de ouros", "Cavaleiro de ouros", "Rainha de ouros", "Rei de ouros"
    )
    private val cartasIMG = arrayOf(
        R.drawable.m0, R.drawable.m1, R.drawable.m2, R.drawable.m3,
        R.drawable.m4, R.drawable.m5, R.drawable.m6, R.drawable.m7,
        R.drawable.m8, R.drawable.m9, R.drawable.m10, R.drawable.m11,
        R.drawable.m12, R.drawable.m13, R.drawable.m14, R.drawable.m15,
        R.drawable.m16, R.drawable.m17, R.drawable.m18, R.drawable.m19,
        R.drawable.m20, R.drawable.m21,
        R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
        R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10,
        R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.c1,
        R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6,
        R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.c11,
        R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.e1, R.drawable.e2,
        R.drawable.e3, R.drawable.e4, R.drawable.e5, R.drawable.e6, R.drawable.e7,
        R.drawable.e8, R.drawable.e9, R.drawable.e10, R.drawable.e11, R.drawable.e12,
        R.drawable.e13, R.drawable.e14, R.drawable.o1, R.drawable.o2, R.drawable.o3,
        R.drawable.o4, R.drawable.o5, R.drawable.o6, R.drawable.o7, R.drawable.o8,
        R.drawable.o9, R.drawable.o10, R.drawable.o11, R.drawable.o12, R.drawable.o13,
        R.drawable.o14
    )

    var baralho: MutableList<String> = (cartas).toMutableList()

    var baralhoIMG: MutableList<Int> = (cartasIMG).toMutableList()

    fun jogar() :  Triple<String, Int, Int> {
        var i = (LocalDate.now().toEpochDay() + LocalTime.now().toNanoOfDay()) % baralho.size
        var index = i.toInt()
        var carta = baralho[index]
        var idCarta = baralhoIMG[index]
        baralho.remove(carta)
        baralhoIMG.remove(idCarta)

        var baralhoRef: MutableList<String> = (cartas).toMutableList()
        val indice = baralhoRef.indexOf(carta)


        return  Triple( carta, idCarta, indice)
    }


}//Fim Class