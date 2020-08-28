package id.kotaktech.codemockupinterview

import android.util.Log

class Presenter {
    val listOfNumber = listOf<Int>(0,1,2,3,4,5,6,7,8,9)
    private lateinit var player1: Player
    private lateinit var player2: Player
    private lateinit var view: MainView


    fun setView(view: MainView){
        this.view = view
    }

    fun setPlayer(Player: Player){
        player1 = Player(String())
    }

    fun setPlayer2(player: Player){
        player2 = Player(String())
    }

    fun randomNumber(): Int{
        return listOfNumber.random()
    }

    fun checkResult(pilihanPlayer1: Int, pilihanPlayer2: Int){
        val number: Int = randomNumber()
        player2.pilihanPlayer = pilihanPlayer2
        player1.pilihanPlayer = pilihanPlayer1
        Log.d("CheckResult", "${player1.pilihanPlayer} ${player2.pilihanPlayer}")

        view.roundMatch("Masukkan angka anda")
    }

}