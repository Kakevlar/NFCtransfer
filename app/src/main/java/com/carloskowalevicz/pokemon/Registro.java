package com.carloskowalevicz.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    EditText username, password, ip,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ip = (EditText) findViewById(R.id.ip);
        a = (EditText)findViewById(R.id.a);
        b = (EditText)findViewById(R.id.b);
        c = (EditText)findViewById(R.id.c);
        d = (EditText)findViewById(R.id.d);
        e = (EditText)findViewById(R.id.e);
        f = (EditText)findViewById(R.id.f);
        g = (EditText)findViewById(R.id.g);
        h = (EditText)findViewById(R.id.h);
        i = (EditText)findViewById(R.id.i);
        j = (EditText)findViewById(R.id.j);
        k = (EditText)findViewById(R.id.k);
        l = (EditText)findViewById(R.id.l);
        m = (EditText)findViewById(R.id.m);
        n = (EditText)findViewById(R.id.n);
        o = (EditText)findViewById(R.id.o);
        p = (EditText)findViewById(R.id.p);
        q = (EditText)findViewById(R.id.q);

        username = (EditText)findViewById(R.id.pusername);
        password = (EditText)findViewById(R.id.ppassword);

            }
    public void onreg(View view){

        String susername = username.getText().toString();
        String spassword = password.getText().toString();
        String sa = a.getText().toString();
        String sb = b.getText().toString();
        String sc = c.getText().toString();
        String sd = d.getText().toString();
        String se = e.getText().toString();
        String sf = f.getText().toString();
        String sg = g.getText().toString();
        String sh = h.getText().toString();
        String si = i.getText().toString();
        String sj = j.getText().toString();
        String sk = k.getText().toString();
        String sl = l.getText().toString();
        String sm = m.getText().toString();
        String sn = n.getText().toString();
        String so = o.getText().toString();
        String sp = p.getText().toString();
        String sq = q.getText().toString();


        String tipo = "Registro";
        String ips = ip.getText().toString();
        
        ServerManager serverManager = new ServerManager(this);
        serverManager.execute(tipo, susername, spassword,ips,sa,sb,sc,sd,se,sf,sg,sh,si,sj,sk,sl,sm,sn,so,sp,sq);
    }
    }


