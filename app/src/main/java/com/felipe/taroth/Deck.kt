package com.felipe.taroth

import java.time.LocalDate
import java.time.LocalTime
import java.util.Random
import java.util.Calendar
import java.util.TimeZone


class Deck {

    val arcanosMaiores = arrayOf(
        "O  Louco","O Mago", "A Sacerdotisa", "A Imperatriz","O Imperador", "O Hierofante", "Os Enamorados", "O Carro",
        "A Força","O Eremita", "A Roda da Fortuna", "A Justiça", "O Pendurado", "A Morte","A Temperança",
        "O Diabo", "A Torre", "A Estrela", "A Lua", "O Sol", "O Julgamento", "O Mundo"
    )
    var maior: MutableList<String> = arcanosMaiores.toMutableList()

    private val arcanosMaioresIMG = arrayOf(
        R.drawable.m0, R.drawable.m1, R.drawable.m2, R.drawable.m3,
        R.drawable.m4, R.drawable.m5, R.drawable.m6, R.drawable.m7,
        R.drawable.m8, R.drawable.m9, R.drawable.m10, R.drawable.m11,
        R.drawable.m12, R.drawable.m13, R.drawable.m14, R.drawable.m15,
        R.drawable.m16, R.drawable.m17, R.drawable.m18, R.drawable.m19,
        R.drawable.m20,
        R.drawable.m21
    )
    var imgMaior: MutableList<Int> = arcanosMaioresIMG.toMutableList()

    private val arcanosMenores = arrayOf(
        "Ás de paus","2 de paus","3 de paus","4 de paus","5 de paus", "6 de paus", "7 de paus",
        "8 de paus", "9 de paus", "10 de paus","Pajem de paus", "Cavaleiro de paus", "Rainha de paus", "Rei de paus",

        "Ás de copas", "2 de copas", "3 de copas", "4 de copas", "5 de copas", "6 de copas", "7 de copas",
        "8 de copas", "9 de copas", "10 de copas","Pajem de copas", "Cavaleiro de copas", "Rainha de copas", "Rei de copas",

        "Ás de espadas", "2 de espadas", "3 de espadas", "4 de espadas", "5 de espadas", "6 de espadas", "7 de espadas",
        "8 de espadas", "9 de espadas", "10 de espadas","Pajem de espadas", "Cavaleiro de espadas", "Rainha de espadas", "Rei de espadas",

        "Ás de ouros", "2 de ouros", "3 de ouros", "4 de ouros", "5 de ouros", "6 de ouros", "7 de ouros",
        "8 de ouros", "9 de ouros", "10 de ouros    ","Pajem de ouros", "Cavaleiro de ouros", "Rainha de ouros", "Rei de ouros"
    )
    var menor: MutableList<String> = arcanosMenores.toMutableList()
    var paus: MutableList<String> = arcanosMenores.slice(0..13).toMutableList()
    var copas: MutableList<String> = arcanosMenores.slice(14..27).toMutableList()
    var espadas: MutableList<String> = arcanosMenores.slice(28..41).toMutableList()
    var ouros: MutableList<String> = arcanosMenores.slice(42..55).toMutableList()


    private val arcanosMenoresIMG = arrayOf(
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

    var imgMenor: MutableList<Int> = arcanosMenoresIMG.toMutableList()
    var imgPaus: MutableList<Int> = arcanosMenoresIMG.slice(0..13).toMutableList()
    var imgCopas: MutableList<Int> = arcanosMenoresIMG.slice(14..27).toMutableList()
    var imgEspadas: MutableList<Int> = arcanosMenoresIMG.slice(28..41).toMutableList()
    var imgOuros: MutableList<Int> = arcanosMenoresIMG.slice(42..55).toMutableList()


    var baralho: MutableList<String> = (arcanosMaiores + arcanosMenores).toMutableList()
    var baralhoIMG: MutableList<Int> = (arcanosMaioresIMG + arcanosMenoresIMG).toMutableList()




    fun jogar() :  Triple<String, Int, Int> {
        var i = (LocalDate.now().toEpochDay() + LocalTime.now().toNanoOfDay()) % baralho.size
        var index = i.toInt()
        var carta = baralho[index]
        var idCarta = baralhoIMG[index]
        baralho.remove(carta)
        baralhoIMG.remove(idCarta)

        var baralhoRef: MutableList<String> = (arcanosMaiores + arcanosMenores).toMutableList()
        val indice = baralhoRef.indexOf(carta)


        return  Triple( carta, idCarta, indice)
    }
    fun jogarMaior() : Triple<String, Int, Int> {
        val i = Random().nextInt(maior.size)
        //var index = i.toInt()
        val carta = maior[i]
        val idCarta = imgMaior[i]
        maior.remove(carta)
        imgMaior.remove(idCarta)

        var baralhoRef: MutableList<String> = (arcanosMaiores + arcanosMenores).toMutableList()
        val indice = baralhoRef.indexOf(carta)

        return Triple( carta, idCarta, indice)
    }
    fun jogarMenor() : Triple<String, Int, Int> {
        val i = Random().nextInt(menor.size)
        //var index =  i.toInt()
        val carta = menor[i]
        val idCarta = imgMenor[i]
        menor.remove(carta)
        imgMenor.remove(idCarta)

        var baralhoRef: MutableList<String> = (arcanosMaiores + arcanosMenores).toMutableList()
        val indice = baralhoRef.indexOf(carta)
        return Triple(carta, idCarta, indice )
    }

    data class Jogada (
        var txt1: String, var carta1: Int, var carta1Index: Int,
        var txt2: String, var carta2: Int, var carta2Index: Int,
        var txt3: String, var carta3: Int, var carta3Index: Int,
        var txt4: String, var carta4: Int, var carta4Index: Int,
        var txt5: String, var carta5: Int, var carta5Index: Int,
        var txt6: String, var carta6: Int, var carta6Index: Int,
        var txt7: String, var carta7: Int, var carta7Index: Int,
        var txt8: String, var carta8: Int, var carta8Index: Int,
        var txt9: String, var carta9: Int, var carta9Index: Int,
        var txt10: String, var carta10: Int, var carta10Index: Int,


        )//Fim data Jogada
    fun jogada(): Jogada {
        val c1 = jogar()
        var c2 = jogar()
        var c3 = jogar()
        var c4 = jogar()
        var c5 = jogar()
        var c6 = jogar()
        var c7 = jogar()
        var c8 = jogar()
        var c9 = jogar()
        var c10 = jogar()

        return Jogada(
            txt1 = c1.first, carta1 = c1.second,    carta1Index = c1.third,
            txt2 = c2.first, carta2 = c2.second,    carta2Index = c2.third,
            txt3 = c3.first, carta3 = c3.second,     carta3Index = c3.third,
            txt4 = c4.first, carta4 = c4.second,     carta4Index = c4.third,
            txt5 = c5.first, carta5 = c5.second,     carta5Index = c5.third,
            txt6 = c6.first, carta6 = c6.second,     carta6Index = c6.third,
            txt7 = c7.first, carta7 = c7.second,     carta7Index = c7.third,
            txt8 = c8.first, carta8 = c8.second,     carta8Index = c8.third,
            txt9 = c9.first, carta9 = c9.second,     carta9Index = c9.third,
            txt10 = c10.first, carta10 = c10.second,     carta10Index = c10.third
        )

    }


    //Caminho.função.expecifica.método.Europeu
    data class Caminho (
        val txtCarta1: String, val carta1: Int, val carta1index: Int,
        val txtCarta2: String, val carta2: Int, val carta2index: Int,
        val txtCarta3: String, val carta3: Int, val carta3index: Int,
        val txtCarta4: String, val carta4: Int, val carta4index: Int,
        val txtCarta5: String, val carta5: Int, val carta5index: Int,
        val txtCarta6: String, val carta6: Int, val carta6index: Int,
        val txtCarta7: String, val carta7: Int, val carta7index: Int,
        val txtCarta8: String, val carta8: Int, val carta8index: Int,
        val txtCarta9: String, val carta9: Int, val carta9index: Int


    )//Fim data class Caminho
    fun jogarCaminho(): Caminho {
        maior.clear()
        maior.addAll(arcanosMaiores)

        imgMaior.clear()
        imgMaior.addAll(arcanosMaioresIMG)

        menor.clear()
        menor.addAll(arcanosMenores)

        imgMenor.clear()
        imgMenor.addAll(arcanosMenoresIMG)


        var c1 = jogarMenor()
        var c2 = jogarMenor()
        var c3 = jogarMaior()
        var c4 = jogarMaior()
        var c5 = jogarMenor()
        var c6 = jogarMaior()
        var c7 = jogarMenor()
        var c8 = jogarMaior()
        var c9 = jogarMenor()

        return Caminho(
            txtCarta1 = c1.first, carta1 = c1.second, carta1index = c1.third,
            txtCarta2 = c2.first, carta2 = c2.second, carta2index = c2.third,
            txtCarta3 = c3.first, carta3 = c3.second, carta3index = c3.third,
            txtCarta4 = c4.first, carta4 = c4.second, carta4index = c4.third,
            txtCarta5 = c5.first, carta5 = c5.second, carta5index = c5.third,
            txtCarta6 = c6.first,  carta6 = c6.second, carta6index = c6.third,
            txtCarta7 = c7.first, carta7 = c7.second, carta7index = c7.third,
            txtCarta8 = c8.first, carta8 = c8.second, carta8index = c8.third,
            txtCarta9 = c9.first , carta9 = c9.second, carta9index = c9.third,
        )
    }

    data class Tabuleiro (
        var txt0: String, var carta0: Int, var carta0Index: Int,
        var txt1: String, var carta1: Int, var carta1Index: Int,
        var txt2: String, var carta2: Int, var carta2Index: Int,
        var txt3: String, var carta3: Int, var carta3Index: Int,
        var txt4: String, var carta4: Int, var carta4Index: Int,
        var txt5: String, var carta5: Int, var carta5Index: Int,
        var txt6: String, var carta6: Int, var carta6Index: Int,
        var txt7: String, var carta7: Int, var carta7Index: Int,
        var txt8: String, var carta8: Int, var carta8Index: Int,
        var txt9: String, var carta9: Int, var carta9Index: Int,
        var txt10: String, var carta10: Int, var carta10Index: Int,
        var txt11: String, var carta11: Int, var carta11Index: Int,
        var txt12: String, var carta12: Int, var carta12Index: Int,
        var txt13: String, var carta13: Int, var carta13Index: Int,
        var txt14: String, var carta14: Int, var carta14Index: Int,
        var txt15: String, var carta15: Int, var carta15Index: Int,
        var txt16: String, var carta16: Int, var carta16Index: Int,
        var txt17: String, var carta17: Int, var carta17Index: Int,
        var txt18: String, var carta18: Int, var carta18Index: Int,
        var txt19: String, var carta19: Int, var carta19Index: Int,
        var txt20: String, var carta20: Int, var carta20Index: Int,
        var txt21: String, var carta21: Int, var carta21Index: Int,


        )//Fim data Jogada
    fun tabuleiro(): Tabuleiro {
        var c0 = jogarMaior()
        var c1 = jogarMaior()
        var c2 = jogarMaior()
        var c3 = jogarMaior()
        var c4 = jogarMaior()
        var c5 = jogarMaior()
        var c6 = jogarMaior()
        var c7 = jogarMaior()
        var c8 = jogarMaior()
        var c9 = jogarMaior()
        var c10 = jogarMaior()
        var c11 = jogarMaior()
        var c12 = jogarMaior()
        var c13 = jogarMaior()
        var c14 = jogarMaior()
        var c15 = jogarMaior()
        var c16 = jogarMaior()
        var c17 = jogarMaior()
        var c18 = jogarMaior()
        var c19 = jogarMaior()
        var c20 = jogarMaior()
        var c21 = jogarMaior()

        return Tabuleiro(
            txt0 = c0.first, carta0 = c0.second,    carta0Index = c0.third,
            txt1 = c1.first, carta1 = c1.second,    carta1Index = c1.third,
            txt2 = c2.first, carta2 = c2.second,    carta2Index = c2.third,
            txt3 = c3.first, carta3 = c3.second,     carta3Index = c3.third,
            txt4 = c4.first, carta4 = c4.second,     carta4Index = c4.third,
            txt5 = c5.first, carta5 = c5.second,     carta5Index = c5.third,
            txt6 = c6.first, carta6 = c6.second,     carta6Index = c6.third,
            txt7 = c7.first, carta7 = c7.second,     carta7Index = c7.third,
            txt8 = c8.first, carta8 = c8.second,     carta8Index = c8.third,
            txt9 = c9.first, carta9 = c9.second,     carta9Index = c9.third,
            txt10 = c10.first, carta10 = c10.second,     carta10Index = c10.third,
            txt11 = c11.first, carta11 = c11.second,    carta11Index = c11.third,
            txt12 = c12.first, carta12 = c12.second,    carta12Index = c12.third,
            txt13 = c13.first, carta13 = c13.second,     carta13Index = c13.third,
            txt14 = c14.first, carta14 = c14.second,     carta14Index = c14.third,
            txt15 = c15.first, carta15 = c15.second,     carta15Index = c15.third,
            txt16 = c16.first, carta16 = c16.second,     carta16Index = c16.third,
            txt17 = c17.first, carta17 = c17.second,     carta17Index = c17.third,
            txt18 = c18.first, carta18 = c18.second,     carta18Index = c18.third,
            txt19 = c19.first, carta19 = c19.second,     carta19Index = c19.third,
            txt20 = c20.first, carta20 = c20.second,     carta20Index = c20.third,
            txt21 = c21.first, carta21 = c21.second,     carta21Index = c21.third

        )

    }




    data class Jogar3(
        val txtCarta1: String, val carta1: Int, val carta1index: Int,
        val txtCarta2: String, val carta2: Int, val carta2index: Int,
        val txtCarta3: String, val carta3: Int, val carta3index: Int
    )//Fim data class jogar3
    fun jogar3() : Jogar3 {
        var c1 = jogar()
        var c2 = jogar()
        var c3 = jogar()

        return Jogar3(
            txtCarta1 = c1.first, carta1 = c1.second, carta1index = c1.third,
            txtCarta2 = c2.first, carta2 = c2.second, carta2index = c2.third,
            txtCarta3 = c3.first, carta3 = c3.second, carta3index = c3.third

        )
    }//Fim fun jogar3

    data class Afrodite (
        val txtCarta1: String, val carta1: Int, val carta1index: Int,
        val txtCarta2: String, val carta2: Int, val carta2index: Int,
        val txtCarta3: String, val carta3: Int, val carta3index: Int,
        val txtCarta4: String, val carta4: Int, val carta4index: Int,
        val txtCarta5: String, val carta5: Int, val carta5index: Int,
        val txtCarta6: String, val carta6: Int, val carta6index: Int,
        val txtCarta7: String, val carta7: Int, val carta7index: Int,

        )//Fim data class Afrodite
    fun jogarAfrodite(): Afrodite {
        var c1 = jogar()
        var c2 = jogar()
        var c3 = jogar()
        var c4 = jogar()
        var c5 = jogar()
        var c6 = jogar()
        var c7 = jogar()

        return Afrodite(
            txtCarta1 = c1.first, carta1 = c1.second, carta1index = c1.third,
            txtCarta2 = c2.first, carta2 = c2.second, carta2index = c2.third,
            txtCarta3 = c3.first, carta3 = c3.second, carta3index = c3.third,
            txtCarta4 = c4.first, carta4 = c4.second, carta4index = c4.third,
            txtCarta5 = c5.first, carta5 = c5.second, carta5index = c5.third,
            txtCarta6 = c6.first, carta6 = c6.second, carta6index = c6.third,
            txtCarta7 = c7.first, carta7 = c7.second, carta7index = c7.third
        )
    }

    data class Sonho (
        var txtMotivo: String,      var cartaMotivo: Int,   var cartaMotivoindex: Int,
        var txtVida: String,        var cartaVida: Int,     var cartaVidaindex: Int,
        var txtExterior: String,    var cartaExterior: Int, var cartaExteriorindex: Int,
        var txtMensagem: String,    var cartaMensagem: Int, var cartaMensagemindex: Int,
        var txtEmocao: String,      var cartaEmocao: Int,   var cartaEmocaoindex: Int,
        var txtConselho: String,    var cartaConselho: Int, var cartaConselhoindex: Int,
    )//Fim data class Sonho
    fun jogarSonho(): Sonho {
        val c1 = jogar()
        var c2 = jogar()
        var c3 = jogar()
        var c4 = jogar()
        var c5 = jogar()
        var c6 = jogar()

        return Sonho(
            txtMotivo = c1.first,   cartaMotivo = c1.second,    cartaMotivoindex = c1.third,
            txtVida = c2.first,     cartaVida = c2.second,      cartaVidaindex = c2.third,
            txtExterior = c3.first, cartaExterior = c3.second,  cartaExteriorindex = c3.third,
            txtMensagem = c4.first, cartaMensagem = c4.second,  cartaMensagemindex = c4.third,
            txtEmocao = c5.first,   cartaEmocao = c5.second,    cartaEmocaoindex = c5.third,
            txtConselho = c6.first, cartaConselho = c6.second,  cartaConselhoindex = c6.third
        )
    }

    data class Peladan (
        var txt1: String, var carta1: Int, var carta1Index: Int,
        var txt2: String, var carta2: Int, var carta2Index: Int,
        var txt3: String, var carta3: Int, var carta3Index: Int,
        var txt4: String, var carta4: Int, var carta4Index: Int,
        var txt5: String, var carta5: Int, var carta5Index: Int
    )//Fim data class Peladan
    fun jogarPeladan(): Peladan {
        val c1 = jogar()
        var c2 = jogar()
        var c3 = jogar()
        var c4 = jogar()
        var c5 = jogar()

        return Peladan(
            txt1 = c1.first, carta1 = c1.second,    carta1Index = c1.third,
            txt2 = c2.first, carta2 = c2.second,    carta2Index = c2.third,
            txt3 = c3.first, carta3 = c3.second,     carta3Index = c3.third,
            txt4 = c4.first, carta4 = c4.second,     carta4Index = c4.third,
            txt5 = c5.first, carta5 = c5.second,     carta5Index = c5.third

        )
    }
    fun zero(): Int{
        val fundo = R.drawable.fundocarta2
        return fundo
    }

    data class Data(
        var dia: Int,
        var mes: Int,
        var ano: Int,
        var dsemana: Int,
        var epochDay: Long)
    fun getData() : Data {
        var calendar = Calendar.getInstance().apply {
            timeZone = TimeZone.getDefault()
        }
        var dataAtual = LocalDate.now()

        // Converte a data para um objeto `Calendar`
        calendar.set(Calendar.YEAR, dataAtual.year)
        calendar.set(Calendar.MONTH, dataAtual.monthValue - 1) // O índice do mês em `Calendar` começa em 0
        calendar.set(Calendar.DAY_OF_MONTH, dataAtual.dayOfMonth)


        val dia = calendar.get(Calendar.DAY_OF_MONTH)
        val mes = calendar.get(Calendar.MONTH) + 1 // O mês começa em 0, então adicione 1
        val ano = calendar.get(Calendar.YEAR)
        val dsemana = calendar.get(Calendar.DAY_OF_WEEK) // 1-dom/2-seg...7-sab.
        val timestamp = calendar.timeInMillis
        val epochDay = timestamp / (1000 * 60 * 60 * 24)

        // Cria um objeto Data para armazenar e retornar os dados extraídos
        return Data(dia, mes, ano, dsemana, epochDay)

    }
    fun gerarCarta(): Int  {
        var data = getData()

        var dSemana = data.dsemana //1-dom/2-seg...7-sab.
        var dia = data.dia
        /*var mes = data.mes
        var ano = data.ano*/

        var dSemanaAstro = 0
        if (dSemana == 1) {dSemanaAstro = 6
        } else if (dSemana == 2) { dSemanaAstro = 9
        } else if (dSemana == 3) { dSemanaAstro = 5
        } else if (dSemana == 4) { dSemanaAstro = 8
        } else if (dSemana == 5) { dSemanaAstro = 4
        } else if (dSemana == 6) { dSemanaAstro = 7
        } else if (dSemana == 7) { dSemanaAstro = 3
        }

        var numero = (data.epochDay / dSemanaAstro) + (dia / dSemanaAstro)
        //var numero = (data.epochDay * ano) - mes  + dSemanaAstro
        var resto = numero % 78

        /*  var baralhoRef: MutableList<String> = (arcanosMaiores + arcanosMenores).toMutableList()
          val res = resto.toInt()
          val indice = baralhoRef.indexOf(res)*/

        return resto.toInt()
    }

    var tags = listOf<String>(
        "#alquimia",
        "#autoconhecimento",
        "#baralhotarot",
        "#cartasdetarot",
        "#cartasdetarotbr",
        "#cabala",
        "#cartadodia",
        "#conselhodotarot",
        "#despertar",
        "#escolhaumacarta",
        "#espiritualidade",
        "#esoterismo",
        "#futurotarot",
        "#guiaespiritual",
        "#historiadetarot",
        "#instatarot",
        "#intuicao",

        "#jogodetarot",
        "#jornadaespiritual",
        "#kaballah",
        "#leituradetarot",
        "#magia",
        "#mensagem",
        "#mensagemdotarot",
        "#mensagemdodia",
        "#misticismo",
        "#oraculotarot",
        "#previsoestarot",
        "#simbolismotarot",
        "#tarot",
        "#tarotbr",
        "#tarotbrasil",
        "#tarotfacil",
        "#tarotgratis",
        "#tarotinterativo",
        "#tarotlove",
        "#tarotonline",
        "#tarotonlinebr",
        "#tarotparaafinanceiro",
        "#tarotparaoamor",
        "#tarotparacarreira",
        "#tarotpararelacionamentos",
        "#tarotportugues",
        "#tarotprofissional",
        "#tarotreading",
        "#tarotsemmisterio",
        "#tarotsimples",
        "#tarotsimbologista",
        "#tarotterapeutico",
        "#transformacaopessoal",
        "#viverdetarot",
        "#tarotcards",
        "#tarotcardsbr"
    )





}//Fim Class