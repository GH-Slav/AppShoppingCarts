package by.tms.appshoppingcarts.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.tms.appshoppingcarts.R
import by.tms.appshoppingcarts.collections.ProductList
import by.tms.appshoppingcarts.model.Product
import kotlinx.android.synthetic.main.activity_main.*

const val TOTAL = "TOTAL"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addToCart.setOnClickListener {
            if (nameProduct.text.isNotEmpty() && namePrice.text.isNotEmpty()) {
                ProductList.instance.list.add(
                    Product(
                        nameProduct.text.toString(),
                        namePrice.text.toString().toDouble()
                    )
                )
            }
            Toast.makeText(this, R.string.added, Toast.LENGTH_SHORT).show()
            nameProduct.text.clear()
            namePrice.text.clear()
        }

        clearCart.setOnClickListener {
            ProductList.instance.list.clear()
        }

        cart.setOnClickListener {
            val intent = Intent(this, ActivityCart::class.java)
            intent.putExtra(TOTAL, totalSum())
            startActivity(intent)
        }
    }

    fun totalSum(): Double {
        var sumListPrice = 0.0
        ProductList.instance.list.forEach {
            sumListPrice += it.price
        }
        return sumListPrice
    }
}
