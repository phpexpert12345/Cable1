package cable.social.app.razorpaymentgateway;

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener

import cable.social.app.R
import kotlinx.android.synthetic.main.activity_rozorpay.*
import org.json.JSONObject

class RozorPayActivity : AppCompatActivity(), PaymentResultListener {
    override fun onPaymentError(code: Int, response: String?) {
        Toast.makeText(this, code, Toast.LENGTH_LONG).show()
        Toast.makeText(this, response, Toast.LENGTH_LONG).show()
        val intent = Intent()
        setResult(Activity.RESULT_CANCELED, intent)
        finish()
    }

    override fun onPaymentSuccess(razorpayPaymentID: String?) {
        val returnIntent = Intent()
        returnIntent.putExtra("result", razorpayPaymentID)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
//        Toast.makeText(this, "Successs..  " + razorpayPaymentID, Toast.LENGTH_LONG).show()
    }

    var totalAmounttoPay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rozorpay)


        intent.getIntExtra("totalAmounttoPay", 0).let {
            totalAmounttoPay = (it)
            txtTotalAmountToPay.text = "INR " + totalAmounttoPay

        }
        Toast.makeText(this, totalAmounttoPay.toString(), Toast.LENGTH_LONG).show()


        /*
         To ensure faster loading of the Checkout form,
          call this method as early as possible in your checkout flow.
         */
        Checkout.preload(applicationContext)

        // Payment button created by you in XML layout
        val button = findViewById<Button>(R.id.btn_pay)

        button.setOnClickListener { startPayment() }
    }

    fun startPayment() {
        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        val activity = this

        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name", "Cable app")
            options.put("description", "Demoing Charges")
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("currency", "INR")
            options.put("amount", totalAmounttoPay * 100)

            val preFill = JSONObject()
            preFill.put("email", "test@razorpay.com")
            preFill.put("contact", "8269970959")

            options.put("prefill", preFill)

            co.open(this, options)
        } catch (e: Exception) {
            Toast.makeText(this, "Error in payment: " + e.message, Toast.LENGTH_SHORT)
                .show()
            e.printStackTrace()
        }

    }

}
