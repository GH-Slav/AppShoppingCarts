package by.tms.appshoppingcarts.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.tms.appshoppingcarts.R
import by.tms.appshoppingcarts.collections.ProductList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_cart.*


class ActivityCart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_cart)

        fillCart()

        val total = intent.getDoubleExtra(TOTAL, 0.0)

        totalProduct.append(total.toString() + "BYN")

        Picasso.get().load("https://programmatique-marketing.fr/wp-content/uploads/2016/09/chiffre-ecommerce-france-FEVAD-2eme-trimestre-2016-1024x1024.png").placeholder(R.drawable.ic_launcher_background).into(cartImage)
    }


    fun fillCart() {
        val list = ProductList.instance.list

        for (i in 0 until list.size) {
            nameProductList.append(list.get(i).name + "\n")
            namePriceList.append(list.get(i).price.toString() + "BYN" + "\n")
        }
    }


}