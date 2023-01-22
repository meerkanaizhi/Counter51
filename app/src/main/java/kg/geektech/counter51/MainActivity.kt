package kg.geektech.counter51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import kg.geektech.counter51.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View {
    lateinit var binding: ActivityMainBinding
    var counter = 0
    val presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
        presenter.attachView(this)
    }

    private fun initClicker() {
        with(binding) {
            incremenBtn.setOnClickListener {
                presenter.increment()
                presenter.showT()
                presenter.changeColor()

            }
        }

    }

    override fun changedCount(count: Int) {
        binding.resultTV.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }


    override fun changeColor() {
        binding.resultTV.setTextColor(resources.getColor(R.color.green))
    }
}