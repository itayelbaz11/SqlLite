package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDB hlp;
    EditText etNAME, etADD, etNUM, etHNUM, etMNAME, etMNUM, etDNAME, etDNUM;
    EditText etNAME2, etQUAR, etGRADE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNAME = (EditText) findViewById(R.id.name);
        etADD = (EditText) findViewById(R.id.adress);
        etNUM = (EditText) findViewById(R.id.phone);
        etHNUM = (EditText) findViewById(R.id.homenum);
        etMNAME = (EditText) findViewById(R.id.mother);
        etMNUM = (EditText) findViewById(R.id.mothernum);
        etDNAME = (EditText) findViewById(R.id.father);
        etDNUM = (EditText) findViewById(R.id.fathernum);

        etNAME2 = (EditText) findViewById(R.id.name1);
        etQUAR = (EditText) findViewById(R.id.reva);
        etGRADE = (EditText) findViewById(R.id.grade);

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
    }

    /**
     * This mthod saves the information in the students edit texts on the data base
     * @param view
     */

    public void fstsub(View view) {


        String name, address, strNum, strHnum, mName, strMnum, dName, strDnum;
        int num, Hnum, Mnum, Dnum;
        name = etNAME.getText().toString();
        address = etADD.getText().toString();
        strNum = etNUM.getText().toString();
        num = Integer.parseInt(etNUM.getText().toString());
        strHnum = etHNUM.getText().toString();
        Hnum = Integer.parseInt(etHNUM.getText().toString());
        mName = etMNAME.getText().toString();
        strMnum = etMNUM.getText().toString();
        Mnum = Integer.parseInt(etMNUM.getText().toString());
        dName = etDNAME.getText().toString();
        strDnum = etDNUM.getText().toString();
        Dnum = Integer.parseInt(etDNUM.getText().toString());

        ContentValues cv = new ContentValues();
        cv.put(Users.NAME, name);
        cv.put(Users.ADDRESS, address);
        cv.put(Users.PHONE, num);
        cv.put(Users.HOME_P, Hnum);
        cv.put(Users.MOM_NAME, mName);
        cv.put(Users.MOM_NUM, Mnum);
        cv.put(Users.DAD_NAME, dName);
        cv.put(Users.DAD_NUM, Dnum);

        db = hlp.getWritableDatabase();
        db.insert(Users.TABLE_USERS, null, cv);
        db.close();



    }

    /**
     * This method saves the grades information on the data base
     * @param view
     */

    public void sndsub(View view) {

        String name, strQuar, strGrade;
        int Grade, Quar;
        name = etNAME2.getText().toString();
        strQuar = etQUAR.getText().toString();
        Quar = Integer.parseInt(strQuar);
        strGrade = etGRADE.getText().toString();
        Grade = Integer.parseInt(strGrade);

        ContentValues cv = new ContentValues();
        cv.put(Grades.NAMES,name);
        cv.put(Grades.QUARTER, Quar);
        cv.put(Grades.GRADE, Grade);

        db = hlp.getWritableDatabase();
        db.insert(Grades.TABLE_GRADES, null, cv);
        db.close();

    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("info")){
            Intent si = new Intent(this, info.class);
            startActivity(si);
        }
        if(st.equals("sort")){
            Intent si = new Intent(this,sort.class);
            startActivity(si);
        }
        if (st.equals("creds")){
            Intent si = new Intent(this,credits.class);
            startActivity(si);
        }
        return true;
    }
}
