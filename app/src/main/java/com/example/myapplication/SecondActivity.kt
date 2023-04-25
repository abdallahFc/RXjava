package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySecondBinding
import io.reactivex.rxjava3.disposables.Disposable

class SecondActivity : AppCompatActivity() {
    val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    private lateinit var disposable: Disposable

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        disposable =DataHolder.listen(Person::class.java).subscribe {
            binding.textView.text = it.name
        }
        binding.button3.setOnClickListener {
            Intent(this,MainActivity2::class.java).also {
                startActivity(it)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        DataHolder.destroy()
        disposable.dispose()

    }
}