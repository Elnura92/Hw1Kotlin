package kg.aios.hw1kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.aios.hw1kotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fromText = intent.getStringExtra(getString(R.string.et_key))
        binding.etAs.apply {
            hint = fromText
        }
        binding.btnBack.setOnClickListener {
            val intent = Intent()
            val text = binding.etAs.text.toString()
            intent.putExtra(getString(R.string.intent_key), text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}