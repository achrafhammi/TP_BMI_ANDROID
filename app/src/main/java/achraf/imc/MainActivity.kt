package achraf.imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get the button
        val calculateButton = findViewById<TextView>(R.id.calculateButton)
        // set the click listener
        calculateButton.setOnClickListener {
            val weight = findViewById<EditText>(R.id.weightInput)
            val height = findViewById<EditText>(R.id.heightInput)
            val result = findViewById<TextView>(R.id.resultText)
            val resultText = findViewById<TextView>(R.id.numResult)
            val resultImage = findViewById<ImageView>(R.id.resultImage)

            if (weight.text.toString().isNotEmpty() && height.text.toString().isNotEmpty()) {
                // calculate the body mass index
                // convert height to meters

                val bmi = weight.text.toString().toDouble() / ((height.text.toString().toDouble()/100) * (height.text.toString().toDouble()/100))

                resultText.text = resultText.text.toString().plus(bmi.toString())
                if(bmi < 18.5) {
                    result.text = "Maigre"
                    resultImage.setImageResource(R.drawable.maigre)
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    result.text = "Normal"
                    resultImage.setImageResource(R.drawable.normal)
                } else if (bmi >= 25 && bmi < 29.9) {
                    result.text = "Sur Poids"
                    resultImage.setImageResource(R.drawable.surpoids)
                } else if (bmi >= 30 && bmi < 34.9) {
                    result.text = "Obese"
                    resultImage.setImageResource(R.drawable.obese)
                } else {
                    result.text = "Tres Obèse"
                    resultImage.setImageResource(R.drawable.t_obese)
                }
            } else {
                Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
            }
        }

    }
}