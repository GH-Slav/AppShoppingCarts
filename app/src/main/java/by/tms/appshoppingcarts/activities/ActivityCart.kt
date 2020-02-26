package by.tms.appshoppingcarts.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.tms.appshoppingcarts.R
import by.tms.appshoppingcarts.collections.ProductList
import kotlinx.android.synthetic.main.layout_cart.*


class ActivityCart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_cart)

        fillCart()
    }


    fun fillCart() {
        val list = ProductList.instance.list

        for (i in 0 until list.size) {
            nameProductList.append(list.get(i).name + "\n")
            namePriceList.append(list.get(i).price.toString() + "BYN" + "\n")
        }
    }


}