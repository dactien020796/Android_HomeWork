package com.example.dactien.sgu_1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPlace;
    CheckBox cbBeef, cbChicken, cbFish, cbSeafood, cbCheese, cbRice, cbBean, cbPico, cbGuaca, cbLBT, cbSoda, cbCerveza, cbMargarita, cbTequila;
    RadioButton rdSizeM, rdSizeL, rdCorn, rdFlour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeOrder();
            }
        });
    }

    private void placeOrder() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED) {
            String mess = "Details of the order:\n" +
                    "Size: " + takeSize() + "\n" +
                    "Tortilla: " + takeTortilla() + "\n" +
                    "Fillings: " + takeFillings() + "\n" +
                    "Beverage: " + takeBeverage();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+841234020796", null, mess.toString(), null, null);
            Toast.makeText(this, "Placed order successfully.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, 1);
        }
    }

    private String takeSize() {
        String size = "";
        if (rdSizeL.isChecked()) {
            size = size + rdSizeL.getText();
        } else {
            size = size + rdSizeM.getText();
        }
        return size;
    }

    private String takeTortilla() {
        String tor = "";
        if (rdCorn.isChecked()) {
            tor = tor + rdCorn.getText();
        } else {
            tor = tor + rdFlour.getText();
        }
        return tor;
    }

    private String takeFillings() {
        String filling = "";
        if (cbBeef.isChecked()) {
            filling = filling + cbBeef.getText() + ", ";
        }
        if (cbSeafood.isChecked()) {
            filling = filling + cbSeafood.getText() + ", ";
        }
        if (cbBean.isChecked()) {
            filling = filling + cbBean.getText() + ", ";
        }
        if (cbCheese.isChecked()) {
            filling = filling + cbCheese.getText() + ", ";
        }
        if (cbChicken.isChecked()) {
            filling = filling + cbChicken.getText() + ", ";
        }
        if (cbFish.isChecked()) {
            filling = filling + cbFish.getText() + ", ";
        }
        if (cbLBT.isChecked()) {
            filling = filling + cbLBT.getText() + ", ";
        }
        if (cbPico.isChecked()) {
            filling = filling + cbPico.getText() + ", ";
        }
        if (cbGuaca.isChecked()) {
            filling = filling + cbGuaca.getText() + ", ";
        }
        if (cbRice.isChecked()) {
            filling = filling + cbRice.getText();
        }
        return filling;
    }

    private String takeBeverage() {
        String beve = "";
        if (cbSoda.isChecked()) {
            beve = beve + cbSoda.getText() + ", ";
        }
        if (cbTequila.isChecked()) {
            beve = beve + cbTequila.getText() + ", ";
        }
        if (cbMargarita.isChecked()) {
            beve = beve + cbMargarita.getText() + ", ";
        }
        if (cbCerveza.isChecked()) {
            beve = beve + cbCerveza.getText();
        }
        return beve;
    }

    private void addControls() {
        cbBean = (CheckBox) findViewById(R.id.cbBean);
        cbBeef = (CheckBox) findViewById(R.id.cbBeef);
        cbCerveza = (CheckBox) findViewById(R.id.cbCerveza);
        cbCheese = (CheckBox) findViewById(R.id.cbCheese);
        cbChicken = (CheckBox) findViewById(R.id.cbChicken);
        cbFish = (CheckBox) findViewById(R.id.cbFish);
        cbGuaca = (CheckBox) findViewById(R.id.cbGuaca);
        cbLBT = (CheckBox) findViewById(R.id.cbLBT);
        cbMargarita = (CheckBox) findViewById(R.id.cbMargarita);
        cbPico = (CheckBox) findViewById(R.id.cbPico);
        cbRice = (CheckBox) findViewById(R.id.cbRice);
        cbSeafood = (CheckBox) findViewById(R.id.cbSeafood);
        cbSoda = (CheckBox) findViewById(R.id.cbSoda);
        cbTequila = (CheckBox) findViewById(R.id.cbTequila);
        rdCorn = (RadioButton) findViewById(R.id.rdTorCorn);
        rdFlour = (RadioButton) findViewById(R.id.rdTorFlour);
        rdSizeM = (RadioButton) findViewById(R.id.rdSizeM);
        rdSizeL = (RadioButton) findViewById(R.id.rdSizeL);
        btnPlace = (Button) findViewById(R.id.btnPlaceOrder);
    }
}
