package id.ac.dutabangsa.mydicodingpertama;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String SIMPAN_HASIL = "simpan_hasil";
    @BindView(R.id.ed_lebar)
    EditText edlebar;
    @BindView(R.id.ed_tinggi)
    EditText edtinggi;
    @BindView(R.id.ed_panjang)
    EditText edpanjang;
    @BindView(R.id.tv_hasil)
    TextView tvhasil;
    @BindView(R.id.btn_hitung)
    Button btnhitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnhitung.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(SIMPAN_HASIL);
            tvhasil.setText(hasil);
        }
    }

    protected void onSaveInstanceState(Bundle simpanHasil) {
        simpanHasil.putString(SIMPAN_HASIL, tvhasil.getText().toString());
        super.onSaveInstanceState(simpanHasil);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String lebar = edlebar.getText().toString().trim();
            String tinggi = edtinggi.getText().toString().trim();
            String panjang = edpanjang.getText().toString().trim();
            boolean kotaktextkosong = false;
            if (TextUtils.isEmpty(lebar)) {
                kotaktextkosong = true;
                edlebar.setError("lebar tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggi)) {
                kotaktextkosong = true;
                edtinggi.setError("tinggi tidak boleh kosong");
            }
            if (TextUtils.isEmpty(panjang)) {
                kotaktextkosong = true;
                edpanjang.setError("panjang tidak boleh kosong");
            }
            if (!kotaktextkosong) {
                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double t = Double.parseDouble(tinggi);
                double volume = p * l * t;
                tvhasil.setText(String.valueOf(volume));
            }

        }

    }
}
