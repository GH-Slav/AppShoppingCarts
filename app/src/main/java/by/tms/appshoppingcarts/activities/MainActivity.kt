package by.tms.appshoppingcarts.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.tms.appshoppingcarts.R
import by.tms.appshoppingcarts.collections.ProductList
import by.tms.appshoppingcarts.model.Product
import kotlinx.android.synthetic.main.activity_main.*

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
            if (nameProduct.text.isNotEmpty() && namePrice.text.isNotEmpty())
            {nameProduct.text.clear(); namePrice.text.clear()}
        }

        clearCart.setOnClickListener {
            if (ProductList.instance.list.isNotEmpty()) {
                ProductList.instance.list.clear()
            }
        }

        cart.setOnClickListener {
            val intent = Intent(this, ActivityCart::class.java)
            startActivity(intent)
        }
    }
}
