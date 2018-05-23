package com.example.administrator.thaythuoc.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.thaythuoc.R;
import com.example.administrator.thaythuoc.adapter.AdapterListAlpha;
import com.example.administrator.thaythuoc.adapter.AdapterTenThuoc;
import com.example.administrator.thaythuoc.database.Database;
import com.example.administrator.thaythuoc.database.DatabaseManager;
import com.example.administrator.thaythuoc.database.ListAlpha;

import java.util.ArrayList;
import java.util.List;

public class DongyActivity extends AppCompatActivity implements AdapterListAlpha.IGetAdapterAlpha, AdapterTenThuoc.IGetAdapterA {
//    private Toolbar toolbar;
    private RecyclerView rcAlpha;

    private ActionBar actionBar;
    //    private NavigationView navigationView;
    private AdapterListAlpha aDapterListAlpha;
    private AdapterTenThuoc adapterTenThuoc;
    private DatabaseManager databaseManager;
    private ListAlpha listAlpha;
    private List<ListAlpha> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongy);
        inistView();
//        inits();
        databaseManager = new DatabaseManager(this);
        databaseManager.databaseList();
        aDapterListAlpha = new AdapterListAlpha(this);
        initsListAlph();

        rcAlpha.setLayoutManager(new LinearLayoutManager(this));
        rcAlpha.setAdapter(aDapterListAlpha);
        Log.d("", "onCreate: ");

    }

    private void initsListAlph() {
        list = new ArrayList<>();
        ListAlpha l1 = new ListAlpha("Đông y chữa bệnh vần A ");
        ListAlpha l2 = new ListAlpha("Đông y chữa bệnh vần B ");
        ListAlpha l3 = new ListAlpha("Đông y chữa bệnh vần C ");
        ListAlpha l4 = new ListAlpha("Đông y chữa bệnh vần D ");
        ListAlpha l5 = new ListAlpha("Đông y chữa bệnh vần Đ ");
        ListAlpha l6 = new ListAlpha("Đông y chữa bệnh vần E ");
        ListAlpha l7 = new ListAlpha("Đông y chữa bệnh vần G ");
        ListAlpha l8 = new ListAlpha("Đông y chữa bệnh vần H ");
        ListAlpha l9 = new ListAlpha("Đông y chữa bệnh vần I ");
        ListAlpha l10 = new ListAlpha("Đông y chữa bệnh vần K ");
        ListAlpha l11 = new ListAlpha("Đông y chữa bệnh vần L ");
        ListAlpha l12 = new ListAlpha("Đông y chữa bệnh vần M ");
        ListAlpha l13 = new ListAlpha("Đông y chữa bệnh vần N ");
        ListAlpha l14 = new ListAlpha("Đông y chữa bệnh vần O ");
        ListAlpha l15 = new ListAlpha("Đông y chữa bệnh vần P ");
        ListAlpha l16 = new ListAlpha("Đông y chữa bệnh vần Q ");
        ListAlpha l17 = new ListAlpha("Đông y chữa bệnh vần R ");
        ListAlpha l18 = new ListAlpha("Đông y chữa bệnh vần S ");
        ListAlpha l19 = new ListAlpha("Đông y chữa bệnh vần T ");
        ListAlpha l20 = new ListAlpha("Đông y chữa bệnh vần U ");
        ListAlpha l21 = new ListAlpha("Đông y chữa bệnh vần V ");
        ListAlpha l22 = new ListAlpha("Đông y chữa bệnh vần X ");
        ListAlpha l23 = new ListAlpha("Đông y chữa bệnh vần Z ");

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        list.add(l7);
        list.add(l8);
        list.add(l9);
        list.add(l10);
        list.add(l11);
        list.add(l12);
        list.add(l13);
        list.add(l14);
        list.add(l15);
        list.add(l16);
        list.add(l17);
        list.add(l18);
        list.add(l19);
        list.add(l20);
        list.add(l21);
        list.add(l22);
        list.add(l23);
    }

//    private void inits() {
//        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close);
//        abdt.syncState();
//        actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerlayout.openDrawer(Gravity.START);
//            }
//        });
//
//    }

    private void inistView() {
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        rcAlpha = findViewById(R.id.rc_alpha);
//        drawerlayout = findViewById(R.id.drawerlayout);
//        navigationView = findViewById(R.id.navigation);
//        navigationView.setNavigationItemSelectedListener(this);
//        rcView = findViewById(R.id.recycle_view);
    }

    @Override
    public ListAlpha getItems(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Database getItem(int position) {
        if (databaseManager==null){
            return null ;
        }

       return databaseManager.getDatabases().get(position);
    }


    @Override
    public void onClickItem( int position) {

        int i = position+1;
        Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();
                databaseManager.getList(6);
                setAdapter();
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_a:
//                databaseManager.getList(1);
//
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_b:
//                databaseManager.getList(2);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_c:
//                databaseManager.getList(3);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_d:
//                databaseManager.getList(4);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_đ:
//                databaseManager.getList(5);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_e:
//                databaseManager.getList(6);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_g:
//                databaseManager.getList(7);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_h:
//                databaseManager.getList(8);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_i:
//                databaseManager.getList(9);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_k:
//                databaseManager.getList(10);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_l:
//                databaseManager.getList(11);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_m:
//                databaseManager.getList(12);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_n:
//                databaseManager.getList(13);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_o:
//                databaseManager.getList(14);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_p:
//                databaseManager.getList(15);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_q:
//                databaseManager.getList(16);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_r:
//                databaseManager.getList(17);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_s:
//                databaseManager.getList(18);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_t:
//                databaseManager.getList(19);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_u:
//                databaseManager.getList(20);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_v:
//                databaseManager.getList(21);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_x:
//                databaseManager.getList(22);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            case R.id.menu_z:
//                databaseManager.getList(23);
//                setAdapter();
//                drawerlayout.closeDrawer(Gravity.START);
//                break;
//            default:
//                break;
//        }
//        return true;
//    }

    private void setAdapter() {
        adapterTenThuoc = new AdapterTenThuoc(this);
        rcAlpha.setLayoutManager(new LinearLayoutManager(this));
        rcAlpha.setAdapter(adapterTenThuoc);
    }


}
