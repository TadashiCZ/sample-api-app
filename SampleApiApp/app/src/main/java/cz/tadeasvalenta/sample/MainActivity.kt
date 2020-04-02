package cz.tadeasvalenta.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cz.tadeasvalenta.sample.domain.IApi

class MainActivity : AppCompatActivity() {

    lateinit var iApi: IApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
