package id.kotaktech.codemockupinterview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var player: Player
    lateinit var computer: Player
    lateinit var presenter: Presenter
    val listNumber = listOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    var round: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tebak.setOnClickListener {
            player = Player(edt_Player_Name.text.toString())
            computer = Player("Computer")
            presenter.setPlayer(player)
            presenter.setPlayer2(player)
            round = 1

            btn_tebak.visibility = View.GONE
            edt_Player_Name.visibility = View.GONE
            tv_choice.visibility = View.VISIBLE
            btn_input.visibility = View.VISIBLE
        }

        btn_input.setOnClickListener {
            if (round < 3) {
                if (tv_choice.toString().toInt() !in listNumber) {
                    tv_winner.text = ""
                } else {
                    presenter.checkResult(tv_choice.text.toString().toInt(), listNumber.random())
                }
            }
        }

    }

    override fun winner(playername: String) {
        btn_tebak.visibility = View.VISIBLE
        edt_Player_Name.visibility = View.VISIBLE
        tv_choice.visibility = View.GONE
        btn_input.visibility = View.GONE

    }

    override fun roundMatch(roundMatch: String) {
        tv_winner.text = "Ronde ${round + 1} : $roundMatch"
    }
}