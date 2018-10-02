package com.carloskowalevicz.pokemon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.UUID;

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
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class LoginDoctor extends Activity {

    private static final String TAG = "stickynotes";
    private boolean mResumed = false;
    NfcAdapter mNfcAdapter;
    EditText tupass,nombreDoc,passDoc,idUsuario;
    EditText text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18;
    String tipo,id,sNombreDoc,sPassDoc;

    PendingIntent mNfcPendingIntent;
    IntentFilter[] mNdefExchangeFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setContentView(R.layout.activity_login_doctor);


        nombreDoc = ((EditText) findViewById(R.id.userDoc));
        passDoc = ((EditText) findViewById(R.id.passDoc));
        idUsuario = ((EditText) findViewById(R.id.idUsuario));
        text1 = ((EditText) findViewById(R.id.textView9));
        text2 = ((EditText) findViewById(R.id.textView11));
        text3 = ((EditText) findViewById(R.id.textView13));
        text4 = ((EditText) findViewById(R.id.textView15));
        text5 = ((EditText) findViewById(R.id.textView17));
        text6 = ((EditText) findViewById(R.id.textView19));
        text7 = ((EditText) findViewById(R.id.textView21));
        text8 = ((EditText) findViewById(R.id.textView23));
        text9 = ((EditText) findViewById(R.id.textView25));
        text10 = ((EditText) findViewById(R.id.textView27));
        text11 = ((EditText) findViewById(R.id.textView29));
        text12 = ((EditText) findViewById(R.id.textView31));
        text13 = ((EditText) findViewById(R.id.textView33));
        text14 = ((EditText) findViewById(R.id.textView35));
        text15 = ((EditText) findViewById(R.id.textView37));
        text16 = ((EditText) findViewById(R.id.textView39));
        text17 = ((EditText) findViewById(R.id.textView41));
        text18 = ((EditText) findViewById(R.id.textView43));






        tupass = ((EditText) findViewById(R.id.pass));
        tupass.addTextChangedListener(mTextWatcher);
        nombreDoc.setText(ServerManager.userDoctor);
        passDoc.setText(ServerManager.passDoctor);

        mNfcPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        IntentFilter ndefDetected = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndefDetected.addDataType("text/plain");
        } catch (MalformedMimeTypeException e) { }
        mNdefExchangeFilters = new IntentFilter[] { ndefDetected };




    }
    public void onDataFill(View View) {
        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);
        text3.setVisibility(View.INVISIBLE);
        text4.setVisibility(View.INVISIBLE);
        text5.setVisibility(View.INVISIBLE);
        text6.setVisibility(View.INVISIBLE);
        text7.setVisibility(View.INVISIBLE);
        text8.setVisibility(View.INVISIBLE);
        text9.setVisibility(View.INVISIBLE);
        text10.setVisibility(View.INVISIBLE);
        text11.setVisibility(View.INVISIBLE);
        text12.setVisibility(View.INVISIBLE);
        text13.setVisibility(View.INVISIBLE);
        text14.setVisibility(View.INVISIBLE);
        text15.setVisibility(View.INVISIBLE);
        text16.setVisibility(View.INVISIBLE);
        text17.setVisibility(View.INVISIBLE);
        text18.setVisibility(View.INVISIBLE);


        tipo = "codigDoc";
        id = idUsuario.getText().toString();
        tupass.setText(null);

        sNombreDoc = nombreDoc.getText().toString();
        sPassDoc = passDoc.getText().toString();

        ServerManager serverManager3 = new ServerManager(this);

        serverManager3.execute(tipo,id,sNombreDoc,sPassDoc);
        while(serverManager3.docIdResult == null){

        }


        tupass.setText(serverManager3.docIdResult.replace("null", ""));

        if (tupass.getText().toString() != null){
            String codigo = tupass.getText().toString();
            if (codigo != null)
            {
           // int value1 = Integer.parseInt(codigo.replace("null", ""));


                while (tupass == null)
                {

                }
                String [] arrayCodigo = codigo.trim().replace("null", "").split("");


                if( !codigo.equals("no conecto")) {
                    if (arrayCodigo[2].equals("1")) { //si esto se cumple quiere decir que el valor es 0 por tanto no se le otorga visibilidad
                        text1.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[3].equals("1")) {
                        text2.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[4].equals("1")) {
                        text3.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[5].equals("1")) {
                        text4.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[6].equals("1")) {
                        text5.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[7].equals("1")) {
                        text6.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[8].equals("1")) {
                        text7.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[9].equals("1")) {
                        text8.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[10].equals("1")) {
                        text9.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[11].equals("1")) {
                        text10.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[12].equals("1")) {
                        text11.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[13].equals("1")) {
                        text12.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[14].equals("1")) {
                        text13.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[15].equals("1")) {
                        text14.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[16].equals("1")) {
                        text15.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[17].equals("1")) {
                        text16.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[18].equals("1")) {
                        text17.setVisibility(View.VISIBLE);
                    }
                    if (arrayCodigo[19].equals("1")) {
                        text18.setVisibility(View.VISIBLE);
                    }
                }
                 tipo = "getData";
                 String ids = idUsuario.getText().toString();



                 ServerManager serverManager = new ServerManager(this);

                 serverManager.execute(tipo, ids);

                 while (serverManager.var == null) {


                 }
                 String variables = "";
                 variables = serverManager.var;

                    variables = variables.replace("[", "");
                    variables = variables.replace("]", "");
                    variables = variables.replace("\"", "");
                    variables = variables.trim();
                    String[] variablesArray = variables.split(",");
                    if (codigo.equals("no conecto")){}else {
                        text1.setText(variablesArray[0]);
                        text2.setText(variablesArray[1]);
                        text3.setText(variablesArray[2]);
                        text4.setText(variablesArray[3]);
                        text5.setText(variablesArray[4]);
                        text6.setText(variablesArray[5]);
                        text7.setText(variablesArray[6]);
                        text8.setText(variablesArray[7]);
                        text9.setText(variablesArray[8]);
                        text10.setText(variablesArray[9]);
                        text11.setText(variablesArray[10]);
                        text12.setText(variablesArray[11]);
                        text13.setText(variablesArray[12]);
                        text14.setText(variablesArray[13]);
                        text15.setText(variablesArray[14]);
                        text16.setText(variablesArray[15]);
                        text17.setText(variablesArray[16]);
                        text18.setText(variablesArray[17]);
                    }
             }
             }

 }
    public void onEdit (View View){

        ServerManager serverManager1 = new ServerManager(this);
        tipo = "editarCodigo";
        String a = text2.getText().toString();
        String b = text3.getText().toString();
        String c = text4.getText().toString();
        String d = text5.getText().toString();
        String e = text6.getText().toString();
        String f = text7.getText().toString();
        String g = text8.getText().toString();
        String h = text9.getText().toString();
        String i = text10.getText().toString();
        String j = text11.getText().toString();
        String k = text12.getText().toString();
        String l = text13.getText().toString();
        String m = text14.getText().toString();
        String n = text15.getText().toString();
        String o = text16.getText().toString();
        String p = text17.getText().toString();
        String q = text18.getText().toString();
        String nombre = text1.getText().toString();
        String ids = idUsuario.getText().toString();

        serverManager1.execute(tipo,nombre,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,ids);




    }

    public void onStore (View View) {



        ServerManager serverManager = new ServerManager(this);

        tipo = "guardarCodigo";
        sNombreDoc = nombreDoc.getText().toString();
        sPassDoc = passDoc.getText().toString();
        String id = idUsuario.getText().toString();
        String clave= tupass.getText().toString();

        serverManager.execute(tipo, sNombreDoc,sPassDoc,id,clave);



    }
    @Override
    protected void onResume() {
        super.onResume();
        mResumed = true;

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
                mNfcAdapter.enableForegroundNdefPush(LoginDoctor.this, getPassAsNdef());
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
        mNfcAdapter.enableForegroundNdefPush(LoginDoctor.this, getPassAsNdef());
        mNfcAdapter.enableForegroundDispatch(this, mNfcPendingIntent, mNdefExchangeFilters, null);
    }

    private void disableNdefExchangeMode() {
        mNfcAdapter.disableForegroundNdefPush(this);
        mNfcAdapter.disableForegroundDispatch(this);
    }








}