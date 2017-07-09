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
import android.widget.Button;
import android.widget.Toast;

public class Service extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        upload=(Button)findViewById(R.id.uplaod);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent cont= new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"prankat@proxbotcreatn.com"));
                    cont.putExtra(Intent.EXTRA_SUBJECT,"3D Printing Order");
                    startActivity(Intent.createChooser(cont,null));            }
                catch (ActivityNotFoundException e){
                    Toast.makeText(Service.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent home=new Intent(Service.this,MainActivity.class);
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
            Intent home=new Intent(Service.this,MainActivity.class);
            startActivity(home);
            finish();
        }
        else if (id == R.id.calculator) {
            Intent cal=new Intent(Service.this,Calc.class);
            startActivity(cal);
            finish();
        } else if (id == R.id.projects) {
            Intent proj=new Intent(Service.this,Project.class);
            startActivity(proj);
            finish();
        } else if (id == R.id.product) {
            Intent prod=new Intent(Service.this,Projects.class);
            startActivity(prod);
            finish();

        } else if (id == R.id.contact) {
            try{
                Intent cont= new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"prankat@proxbotcreatn.com"));
                startActivity(Intent.createChooser(cont,null));            }
            catch (ActivityNotFoundException e){
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
            }

        } else if(id==R.id.about){

            Intent abt=new Intent(Service.this,About.class);
            startActivity(abt);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
