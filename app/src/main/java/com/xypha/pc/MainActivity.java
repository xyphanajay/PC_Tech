package com.xypha.pc;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView robo,print,auto,works,train,intern;
    Button robob,printb,autob, worksb,trainb,internb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        robob=(Button)findViewById(R.id.robob);
        printb=(Button)findViewById(R.id.printb);
        autob=(Button)findViewById(R.id.autob);
        worksb=(Button)findViewById(R.id.worksb);
        trainb=(Button)findViewById(R.id.trainb);
        internb=(Button)findViewById(R.id.internb);
        train=(ImageView)findViewById(R.id.train);
        intern=(ImageView)findViewById(R.id.intern);
        robo=(ImageView) findViewById(R.id.robo);
        print=(ImageView) findViewById(R.id.print);
        auto=(ImageView) findViewById(R.id.auto);
        works=(ImageView) findViewById(R.id.works);
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent work=new Intent(MainActivity.this,Train.class);
                startActivity(work);
                finish();
            }
        });
        trainb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent work=new Intent(MainActivity.this,Train.class);
                startActivity(work);
                finish();
            }
        });
        worksb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent work=new Intent(MainActivity.this,Works.class);
                startActivity(work);
                finish();
            }
        });
        works.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent work=new Intent(MainActivity.this,Works.class);
                startActivity(work);
                finish();
            }
        });
        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intern=new Intent(MainActivity.this,Intern.class);
                startActivity(intern);
                finish();
            }
        });
        autob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aut=new Intent(MainActivity.this,Autom.class);
                startActivity(aut);
                finish();
            }
        });
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aut=new Intent(MainActivity.this,Autom.class);
                startActivity(aut);
                finish();
            }
        });
        printb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent printing=new Intent(MainActivity.this,Print.class);
                startActivity(printing);
                finish();
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent printing=new Intent(MainActivity.this,Print.class);
                        startActivity(printing);
                        finish();
            }
        });
        robob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent robo=new Intent(MainActivity.this,Robo.class);
                startActivity(robo);
                finish();
            }
        });
        robo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent robo=new Intent(MainActivity.this,Robo.class);
                startActivity(robo);
                finish();

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
            android.os.Process.killProcess(android.os.Process.myPid());
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

        }
        else if (id == R.id.calculator) {
            Intent cal=new Intent(MainActivity.this,Calc.class);
            startActivity(cal);
            finish();
        } else if (id == R.id.projects) {
            Intent proj=new Intent(MainActivity.this,Project.class);
            startActivity(proj);
            finish();

        } else if (id == R.id.product) {
            Intent prod=new Intent(MainActivity.this,Projects.class);
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
            Intent abt=new Intent(MainActivity.this,About.class);
            startActivity(abt);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
