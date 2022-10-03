package com.hagstrom.henrik.che.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.hagstrom.henrik.che.R
import com.hagstrom.henrik.che.databinding.ActivityPlayBinding


class Play : AppCompatActivity() {
    lateinit var binding : ActivityPlayBinding
    lateinit var but1:Array<Button>
    lateinit var but2:Array<Button>
    lateinit var but3:Array<Button>
    var scr=0
    var roll= mutableListOf<Int>(R.drawable.sl1,R.drawable.sl1,R.drawable.sl1,R.drawable.sl1,R.drawable.snake)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        but1= arrayOf(binding.im1,binding.im2,binding.im3,binding.im4,binding.im5)
        but2= arrayOf(binding.char1,binding.char2,binding.char3,binding.char4,binding.char5)
        but3= arrayOf(binding.can1,binding.can2,binding.can3,binding.can4,binding.can5)
        roll.shuffle()
        for (i in 0..4){
            but1[i].setBackgroundResource(roll[i])
            but1[i].setText(roll[i])
            but1[i].setVisibility(View.GONE)
            but2[i].setVisibility(View.GONE)
            but3[i].setOnClickListener{
                if(but3[i].text=="click"){
                    for(i in 0..4){
                        but1[i].setVisibility(View.GONE)
                        but2[i].setVisibility(View.GONE)
                    }
                    but2[i].setVisibility(View.VISIBLE)
                    but3[i].text="oncal"
                    but3[i].animate().apply {
                        translationY(30f)
                        duration=100
                    }.withEndAction {
                        but3[i].animate().apply {
                            translationY(-30f)
                            duration=100
                        }.withEndAction {
                            but1[i].animate().apply {
                                but1[i].setVisibility(View.VISIBLE)
                                translationY(1160f)
                                duration=1000
                            }.withEndAction {
                                if(but1[i].text=="res/drawable/sl1.png"){
                                    scr=scr+100
                                }
                                else{
                                    val scre="Your score : $scr"
                                    val intent= Intent(this@Play,Res::class.java)
                                    intent.putExtra("key",scre)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}