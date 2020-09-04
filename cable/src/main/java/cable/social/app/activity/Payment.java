package cable.social.app.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import cable.social.app.R;
import cable.social.app.razorpaymentgateway.RozorPayActivity;

public class Payment extends AppCompatActivity {
    Button payment;
    TextView tital_name, price;
    private RadioGroup paymentvia;
    private String result;
    private RadioButton radiopaymentselectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        paymentvia = findViewById(R.id.rdgroup);
        payment = findViewById(R.id.paymentt);

        tital_name = findViewById(R.id.tital_name);
        price = findViewById(R.id.price);
        String tital_ = getIntent().getStringExtra("tital_");
        String price_ = getIntent().getStringExtra("price_");

        tital_name.setText(tital_);
        price.setText("$" + price_);

        paymentvia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    Toast.makeText(Payment.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = paymentvia.getCheckedRadioButtonId();
                radiopaymentselectedButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(Payment.this, radiopaymentselectedButton.getText().toString(), Toast.LENGTH_SHORT).show();

                if (radiopaymentselectedButton.getText().toString().equalsIgnoreCase("Credit/Debit Card")) {
                    Intent i = new Intent(Payment.this, RozorPayActivity.class);
                    i.putExtra("totalAmounttoPay", 10);
                    startActivityForResult(i, 1);

                } else {
                    Toast.makeText(Payment.this, "Coming Soon...", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                result = data.getStringExtra("result");
                Toast.makeText(Payment.this, result, Toast.LENGTH_LONG).show();

                new AlertDialog.Builder(Payment.this)
                        .setMessage("Successfully, Payment has been done.")
                        .setIcon(R.drawable.logo)
                        .setTitle(R.string.app_name)
                        .setCancelable(false)

                        /* .setNegativeButton("No", new DialogInterface.OnClickListener() {
 
                             @Override
                             public void onClick(DialogInterface arg0, int arg1) {
                                 Toast.makeText(Payment.this(), "Did not reset!", 5).show();
                             }
                         })*/
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(Payment.this, "Successfully, Payment has been done.", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Payment.this, ThankYouActivity.class);
                                i.putExtra("bookinID", result);
                                startActivity(i);

                            }
                        })

                        .create().show();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }


}

