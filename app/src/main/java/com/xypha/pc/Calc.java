package com.xypha.pc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class Calc extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    View myView;

    TextView tcost , tweight;
    EditText einput;
    RadioGroup radioGroup;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tcost = (TextView)findViewById(R.id.editText4);
        tweight = (TextView)findViewById(R.id.textView6);
        einput = (EditText) findViewById(R.id.editText2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        ok = (Button) findViewById(R.id.button);


        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                float v1 = Float.valueOf(einput.getText().toString()) ;

                float c = v1+100;
                float b = v1+200;

                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    // no radio buttons are checked
                    Toast.makeText(Calc.this, "Please fill the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // one of the radio buttons is checked
                    tcost.setText(String.valueOf("     Rs. "+c+""));
                    tweight.setText(String.valueOf("    "+b+" gm"));

                }



            }


        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent home=new Intent(Calc.this,MainActivity.class);
            startActivity(home);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            android.os.Process.killProcess(android.os.Process.myPid());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id==R.id.home){

            Intent home=new Intent(Calc.this,MainActivity.class);
            startActivity(home);
            finish();
        }
        else if (id == R.id.calculator) {

        } else if (id == R.id.projects) {
            Intent proj=new Intent(Calc.this,Project.class);
            startActivity(proj);
            finish();

        } else if (id == R.id.product) {
            Intent prod=new Intent(Calc.this,Projects.class);
            startActivity(prod);
            finish();

        } else if (id == R.id.contact) {
            try{
                Intent cont= new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"prankat@proxbotcreatn.com"));
                startActivity(Intent.createChooser(cont,null));
            }
            catch (ActivityNotFoundException e){
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
            }

        } else if(id==R.id.about){

            Intent abt=new Intent(Calc.this,About.class);
            startActivity(abt);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
