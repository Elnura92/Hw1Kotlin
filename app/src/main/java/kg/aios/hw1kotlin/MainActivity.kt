package kg.aios.hw1kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.aios.hw1kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
   private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val text = it.data?.getStringExtra(getString(R.string.intent_key))
                Log.e(getString(R.string.log_tag), getString(R.string.log_message) + text)
                binding.tvInfo.text = text
            }
        }

        binding.btnSubmit.setOnClickListener{
            if (binding.etAm.text.isEmpty()){
                Toast.makeText(this, getString(R.string.toast_msg), Toast.LENGTH_SHORT).show()
            }else {
                launcher?.launch(Intent(this, SecondActivity:: class.java).also {
                    val etText = binding.etAm.text.toString()
                    it.putExtra(getString(R.string.et_key), etText)
                })

            }
        }
    }
}