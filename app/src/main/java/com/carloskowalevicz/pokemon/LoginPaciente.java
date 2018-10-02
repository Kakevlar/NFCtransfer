package com.carloskowalevicz.pokemon;
import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPaciente extends Activity {

    private static final String TAG = "stickynotes";
    private boolean mResumed = false;
    NfcAdapter mNfcAdapter;
    EditText tupass,id;
    public long codigo = 0;
    public String propiedadCodigo;
    public CheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9,check10,check11,check12,check13,check14,check15,check16,check17,check18;
    public Button generarCodig;
    EditText text,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17;




    public String tipo,variables;
    PendingIntent mNfcPendingIntent;
    IntentFilter[] mNdefExchangeFilters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setContentView(R.layout.activity_login_paciente);

        tupass = (EditText) findViewById(R.id.pass);
        tupass.addTextChangedListener(mTextWatcher);
        id = (EditText)findViewById(R.id.id);
        mNfcPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        IntentFilter ndefDetected = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndefDetected.addDataType("text/plain");
        } catch (MalformedMimeTypeException e) { }
        mNdefExchangeFilters = new IntentFilter[] { ndefDetected };

        check1 =(CheckBox)findViewById(R.id.checkBox);
        check2 =(CheckBox)findViewById(R.id.checkBox2);
        check3 =(CheckBox)findViewById(R.id.checkBox3);
        check4 =(CheckBox)findViewById(R.id.checkBox4);
        check5 =(CheckBox)findViewById(R.id.checkBox5);
        check6 =(CheckBox)findViewById(R.id.checkBox6);
        check7 =(CheckBox)findViewById(R.id.checkBox7);
        check8 =(CheckBox)findViewById(R.id.checkBox8);
        check9 =(CheckBox)findViewById(R.id.checkBox9);
        check10 =(CheckBox)findViewById(R.id.checkBox10);
        check11 =(CheckBox)findViewById(R.id.checkBox11);
        check12 =(CheckBox)findViewById(R.id.checkBox12);
        check13 =(CheckBox)findViewById(R.id.checkBox13);
        check14 =(CheckBox)findViewById(R.id.checkBox14);
        check15 =(CheckBox)findViewById(R.id.checkBox15);
        check16 =(CheckBox)findViewById(R.id.checkBox16);
        check17 =(CheckBox)findViewById(R.id.checkBox17);
        check18 =(CheckBox)findViewById(R.id.checkBox18);


        text = (EditText)findViewById(R.id.textView2);
        text1 = (EditText)findViewById(R.id.textView3);
        text2 = (EditText)findViewById(R.id.textView4);
        text3 = (EditText)findViewById(R.id.textView5);
        text4 = (EditText)findViewById(R.id.textView6);
        text5 = (EditText)findViewById(R.id.textView7);
        text6 = (EditText)findViewById(R.id.textView8);
        text7 = (EditText)findViewById(R.id.textView9);
        text8 = (EditText)findViewById(R.id.textView10);
        text9 = (EditText)findViewById(R.id.textView11);
        text10 = (EditText)findViewById(R.id.textView12);
        text11 = (EditText)findViewById(R.id.textView13);
        text12 = (EditText)findViewById(R.id.textView14);
        text13 = (EditText)findViewById(R.id.textView15);
        text14 = (EditText)findViewById(R.id.textView16);
        text15 = (EditText)findViewById(R.id.textView17);
        text16 = (EditText)findViewById(R.id.textView18);
        text17 = (EditText)findViewById(R.id.textView19);



        tipo = "getData";
        String ids="";


        while (ServerManager.userId == null){

            //  alertDialog.setMessage();

            // alertDialog.show();
       }

        ids = ServerManager.userId.replace("null", "");
        ServerManager serverManager = new ServerManager(this);

        serverManager.execute(tipo ,ids);

        while (serverManager.var == null ){


        }


        variables = serverManager.var.replace("null", "");
        variables = variables.replace("[", "");
        variables = variables.replace("]", "");
        variables = variables.replace("\"", "");
      // variables = variables.trim(); no se si hacerlo por que va a alterar a ls array
       String[] variablesArray = variables.split(",");

        text.setText(variablesArray[0]);
        text1.setText(variablesArray[1]);
        text2.setText(variablesArray[2]);
        text3.setText(variablesArray[3]);
        text4.setText(variablesArray[4]);
        text5.setText(variablesArray[5]);
        text6.setText(variablesArray[6]);
        text7.setText(variablesArray[7]);
        text8.setText(variablesArray[8]);
        text9.setText(variablesArray[9]);
        text10.setText(variablesArray[10]);
        text11.setText(variablesArray[11]);
        text12.setText(variablesArray[12]);
        text13.setText(variablesArray[13]);
        text14.setText(variablesArray[14]);
        text15.setText(variablesArray[15]);
        text16.setText(variablesArray[16]);
        text17.setText(variablesArray[17]);



       id.setText(ids);
    }

    public void onGen(View View) {
      String v = ServerManager.userId.replace("null", "");

        codigo=  1000000000000000000l;

        if (check1.isChecked() == true) {
            codigo = codigo + 1;
        }if (check2.isChecked() == true) {
            codigo = codigo + 10;
        }if (check3.isChecked() == true) {
            codigo = codigo + 100;
        }if (check4.isChecked() == true) {
            codigo = codigo + 1000;
        }if (check5.isChecked() == true) {
            codigo = codigo + 10000;
        }if (check6.isChecked() == true) {
            codigo = codigo + 100000;
        }if (check7.isChecked() == true) {
            codigo = codigo + 1000000;
        }if (check8.isChecked() == true) {
            codigo = codigo + 10000000;
        }if (check9.isChecked() == true) {
            codigo = codigo + 100000000;
        }if (check10.isChecked() == true) {
            codigo = codigo + 1000000000l;
        }if (check11.isChecked() == true) {
            codigo = codigo + 10000000000l;
        }if (check12.isChecked() == true) {
            codigo = codigo + 100000000000l;
        }if (check13.isChecked() == true) {
            codigo = codigo + 1000000000000l;
        }if (check14.isChecked() == true) {
            codigo = codigo + 10000000000000l;
        }if (check15.isChecked() == true) {
            codigo = codigo + 100000000000000l;
        }if (check16.isChecked() == true) {
            codigo = codigo + 1000000000000000l;
        }if (check17.isChecked() == true) {
            codigo = codigo + 10000000000000000l;
        }if (check18.isChecked() == true) {
            codigo = codigo + 100000000000000000l;
        }

        this.propiedadCodigo = Long.toString(codigo);
       // propiedadCodigo= propiedadCodigo + v;

        tupass.setText(propiedadCodigo);



    }
    public void onEdit (View View){

        ServerManager serverManager1 = new ServerManager(this);
        tipo = "editarCodigo";
        String a = text1.getText().toString();
        String b = text2.getText().toString();
        String c = text3.getText().toString();
        String d = text4.getText().toString();
        String e = text5.getText().toString();
        String f = text6.getText().toString();
        String g = text7.getText().toString();
        String h = text8.getText().toString();
        String i = text9.getText().toString();
        String j = text10.getText().toString();
        String k = text11.getText().toString();
        String l = text12.getText().toString();
        String m = text13.getText().toString();
        String n = text14.getText().toString();
        String o = text15.getText().toString();
        String p = text16.getText().toString();
        String q = text17.getText().toString();
        String nombre = text.getText().toString();
        String ids = ServerManager.userId.replace("null", "");

        serverManager1.execute(tipo, nombre, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, ids);




    }



    @Override
    protected void onResume() {
        super.onResume();
        mResumed = true;
        // Sticky notes received from Android
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            NdefMessage[] messages = getNdefMessages(getIntent());
            byte[] payload = messages[0].getRecords()[0].getPayload();
            setNoteBody(new String(payload));
            setIntent(new Intent());
        }
        enableNdefExchangeMode();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mResumed = false;
        mNfcAdapter.disableForegroundNdefPush(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {


        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            NdefMessage[] msgs = getNdefMessages(intent);
            promptForContent(msgs[0]);
        }
    }
    private TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void afterTextChanged(Editable arg0) {
            if (mResumed) {
                mNfcAdapter.enableForegroundNdefPush(LoginPaciente.this, getPassAsNdef());
            }
        }
    };

    private void promptForContent(final NdefMessage msg) {
        new AlertDialog.Builder(this).setTitle("Replace current content?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        String body = new String(msg.getRecords()[0].getPayload());
                        setNoteBody(body);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                }).show();
    }


    private void setNoteBody(String body) {
        Editable text = tupass.getText();
        text.clear();
        text.append(body);
    }



    private NdefMessage getPassAsNdef() {
        byte[] textBytes =tupass.getText().toString().getBytes();
        NdefRecord textRecord = new NdefRecord(NdefRecord.TNF_MIME_MEDIA, "text/plain".getBytes(),
                new byte[] {}, textBytes);
        return new NdefMessage(new NdefRecord[] {
                textRecord
        });
    }


    NdefMessage[] getNdefMessages(Intent intent) {
        // Parse the intent
        NdefMessage[] msgs = null;
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            } else {
                // Unknown tag type
                byte[] empty = new byte[] {};
                NdefRecord record = new NdefRecord(NdefRecord.TNF_UNKNOWN, empty, empty, empty);
                NdefMessage msg = new NdefMessage(new NdefRecord[] {
                        record
                });
                msgs = new NdefMessage[] {
                        msg
                };
            }
        } else {
            Log.d(TAG, "Unknown intent.");
            finish();
        }
        return msgs;
    }

    private void enableNdefExchangeMode() {
        mNfcAdapter.enableForegroundNdefPush(LoginPaciente.this, getPassAsNdef());
        mNfcAdapter.enableForegroundDispatch(this, mNfcPendingIntent, mNdefExchangeFilters, null);
    }

    private void disableNdefExchangeMode() {
        mNfcAdapter.disableForegroundNdefPush(this);
        mNfcAdapter.disableForegroundDispatch(this);
    }








}