package cable.social.app.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import cable.social.app.utility.BaseActivity;
import cable.social.app.R;
import cable.social.app.databinding.ActivityThankYouBinding;

public class ThankYouActivity extends BaseActivity {
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private String bookinID;
    private ActivityThankYouBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_thank_you);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_thank_you);
        //setContentView(R.layout.activity_thank_you)
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    }

    // on click copy button
    void copyText(View view) {
        myClip = ClipData.newPlainText("text", binding.txtbookingID.getText().toString().trim());
        myClipboard.setPrimaryClip(myClip);

        Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();

    }

    /*// on click paste button
    fun pasteText(view: View) {
        val abc = myClipboard?.getPrimaryClip()
        val item = abc?.getItemAt(0)

        binding.txtbookingID.text = item?.text.toString()

        Toast.makeText(applicationContext, "Text Pasted", Toast.LENGTH_SHORT).show()
    }
*/


    @Override
    public void initData() {
        binding.toolBar.menuBtn.setVisibility(View.GONE);
        binding.toolBar.backBtn.setVisibility(View.VISIBLE);
        binding.toolBar.tvToolbarTitle.setText("THANK YOU");
    }

    @Override
    public void initListeners() {
        binding.toolBar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        binding.btnBacktohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThankYouActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

        binding.imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyText(v);
            }
        });

    }
}