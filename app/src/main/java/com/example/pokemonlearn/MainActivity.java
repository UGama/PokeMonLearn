package com.example.pokemonlearn;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;

import org.litepal.crud.DataSupport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gama on 8/3/17 (Test Version) (Happy Birthday, Cloud!).
 * Created by Gama on 9/3/17 (First Version) (Happy Birthday, TaeYeon!).
 * Noted by Gama on 21/3/17 (Happy Birthday, MCX!).
 * Created by Gama on 7/4/17 (Second Version).
 */

public class MainActivity extends AppCompatActivity implements BaiduMap.OnMarkerClickListener, View.OnClickListener, View.OnTouchListener, BaiduMap.OnMapClickListener {
    public LocationClient mLocClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    private MapView mMapView;
    private BaiduMap mBaiduMap = null;
    private boolean isFirstLoc = true;
    private MyLocationConfiguration myLocationConfiguration;

    private Animation anim0;
    private Animation anim1;

    private PercentRelativeLayout mapMode;
    private Button SATELLITE;
    private Button FOLLOWING;
    private Button COMPASS;
    private int Open_Close = 0;
    private Button mapModeChose;

    private double OverlayPosition[][];

    private BDLocation myLocation;
    private Marker markerA;
    private Marker markerB;
    private Marker markerC;
    private Marker markerD;
    private Marker markerE;

    private Button littleMap;
    private Button setting;
    private Button Menu;
    private Animation animation1;
    private Animation animation2;

    private PercentRelativeLayout littleMapLayout;
    private Button finish;

    private PercentRelativeLayout MenuLayout;
    private Button myPet;
    private Button PokeDex;
    private Button myBag;
    private Button battle;
    private Button shop;
    private Button egg;
    private Button compete;
    private Button gym;

    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans1_in;
    private Animation trans2_in;
    private Animation transit;

    private ImageView warning;
    private Animation Warning;
    private Animation Warning2;
    private int WarningTimes;
    private ImageView Capture_trans;
    private List<ImageView> trans_left;
    private List<ImageView> trans_right;
    private Animation cap_left;
    private Animation cap_right;
    private ImageView temp;

    private Animation trans_out1;
    private Animation trans_out2;

    private Button Database;
    private PokeMon[] Pokemon;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        trans_out1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trans_out_down);
        transfer1.startAnimation(trans_out1);
        transfer2.startAnimation(trans_out2);
        trans_out2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                transfer1.setVisibility(View.GONE);
                transfer2.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mMapView = (MapView) findViewById(R.id.bmapView);

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setBuildingsEnabled(true);
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        mBaiduMap.setMyLocationEnabled(true);
        mBaiduMap.setMaxAndMinZoomLevel(20f, 19f);

        //mBaiduMap.getUiSettings().setScrollGesturesEnabled(false);

        myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING,
                true, null);
        mBaiduMap.setMyLocationConfigeration(myLocationConfiguration);
        mBaiduMap.setOnMapClickListener(this);

        mBaiduMap.setOnMarkerClickListener(this);

// 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);

        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);// 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        //option.setScanSpan(1000);

        mLocClient.setLocOption(option);
        mLocClient.start();

        initOverlay();

        anim0 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim0);
        anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim1);

        littleMap = (Button) findViewById(R.id.littlemap);
        littleMap.setOnClickListener(this);
        littleMap.setOnTouchListener(this);

        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(this);
        setting.setOnTouchListener(this);

        Menu = (Button) findViewById(R.id.menu);
        Menu.setOnTouchListener(this);
        Menu.setOnClickListener(this);
        animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.up);
        animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.down);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Menu.startAnimation(animation2);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Menu.startAnimation(animation1);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        Menu.startAnimation(animation1);

        littleMapLayout = (PercentRelativeLayout) findViewById(R.id.littlemapLayout);
        littleMapLayout.setVisibility(View.GONE);
        littleMapLayout.getBackground().setAlpha(125);

        finish = (Button) findViewById(R.id.finish);
        finish.setOnClickListener(this);
        finish.setOnTouchListener(this);

        MenuLayout = (PercentRelativeLayout) findViewById(R.id.menuFrame);
        MenuLayout.setVisibility(View.GONE);
        MenuLayout.getBackground().setAlpha(125);

        myPet = (Button) findViewById(R.id.myPet);
        myPet.setOnClickListener(this);
        myPet.setOnTouchListener(this);

        PokeDex = (Button) findViewById(R.id.pokeDex);
        PokeDex.setOnClickListener(this);
        PokeDex.setOnTouchListener(this);

        myBag = (Button) findViewById(R.id.myBag);
        myBag.setOnClickListener(this);
        myBag.setOnTouchListener(this);

        battle = (Button) findViewById(R.id.battle);
        battle.setOnClickListener(this);
        battle.setOnTouchListener(this);

        shop = (Button) findViewById(R.id.shop);
        shop.setOnClickListener(this);
        shop.setOnTouchListener(this);

        egg = (Button) findViewById(R.id.egg);
        egg.setOnClickListener(this);
        egg.setOnTouchListener(this);

        compete = (Button) findViewById(R.id.compete);
        compete.setOnClickListener(this);
        compete.setOnTouchListener(this);

        gym = (Button) findViewById(R.id.gym);
        gym.setOnClickListener(this);
        gym.setOnTouchListener(this);

        Button pretend = (Button) findViewById(R.id.pretend);
        pretend.setOnClickListener(this);

        warning = (ImageView) findViewById(R.id.warning);
        warning.getBackground().setAlpha(200);
        warning.setVisibility(View.GONE);

        trans_left = new ArrayList<>();
        trans_right = new ArrayList<>();
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_01);
        Capture_trans.setVisibility(View.GONE);
        trans_left.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_02);
        Capture_trans.setVisibility(View.GONE);
        trans_right.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_03);
        Capture_trans.setVisibility(View.GONE);
        trans_left.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_04);
        Capture_trans.setVisibility(View.GONE);
        trans_right.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_05);
        Capture_trans.setVisibility(View.GONE);
        trans_left.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_06);
        Capture_trans.setVisibility(View.GONE);
        trans_right.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_07);
        Capture_trans.setVisibility(View.GONE);
        trans_left.add(Capture_trans);
        Capture_trans = (ImageView) findViewById(R.id.fight_trans_08);
        Capture_trans.setVisibility(View.GONE);
        trans_right.add(Capture_trans);

        SATELLITE = (Button) findViewById(R.id.satellite);
        SATELLITE.setOnClickListener(this);
        SATELLITE.setOnTouchListener(this);
        FOLLOWING = (Button) findViewById(R.id.following);
        FOLLOWING.setOnClickListener(this);
        FOLLOWING.setOnTouchListener(this);
        COMPASS = (Button) findViewById(R.id.compass);
        COMPASS.setOnClickListener(this);
        COMPASS.setOnTouchListener(this);

        mapMode = (PercentRelativeLayout) findViewById(R.id.mapMode_background);
        mapMode.getBackground().setAlpha(140);
        mapModeChose = (Button) findViewById(R.id.map_mode);

        ValueAnimator animator = ValueAnimator.ofFloat(0, -380);
        animator.setTarget(mapMode);
        animator.setDuration(500).start();
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                mapMode.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        mapModeChose.setOnClickListener(this);

        Database = (Button) findViewById(R.id.dataBase);
        Database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseOperate.class);
                startActivity(intent);
            }
        });
    }

    public void initOverlay() {
        OverlayPosition = new double[5][2];
        OverlayPosition = getRandomPosition(5);


        //LatLng llA = new LatLng(30.318462, 120.385653);//寝室
        //LatLng llA = new LatLng(30.314638, 120.392251);//经济楼
        LatLng llA = new LatLng(OverlayPosition[0][0], OverlayPosition[0][1]);
        LatLng llB = new LatLng(OverlayPosition[1][0], OverlayPosition[1][1]);
        LatLng llC = new LatLng(OverlayPosition[2][0], OverlayPosition[2][1]);
        LatLng llD = new LatLng(OverlayPosition[3][0], OverlayPosition[3][1]);
        LatLng llE = new LatLng(OverlayPosition[4][0], OverlayPosition[4][1]);

        Pokemon = getRandomPokemon(5);
        int i = 0;

        BitmapDescriptor BDA = BitmapDescriptorFactory.fromResource(Pokemon[i++].getMapId());
        BitmapDescriptor BDB = BitmapDescriptorFactory.fromResource(Pokemon[i++].getMapId());
        BitmapDescriptor BDC = BitmapDescriptorFactory.fromResource(Pokemon[i++].getMapId());
        BitmapDescriptor BDD = BitmapDescriptorFactory.fromResource(Pokemon[i++].getMapId());
        BitmapDescriptor BDE = BitmapDescriptorFactory.fromResource(Pokemon[i].getMapId());

        MarkerOptions ooA = new MarkerOptions().position(llA).icon(BDA)
                .zIndex(1).draggable(false);
        MarkerOptions ooB = new MarkerOptions().position(llB).icon(BDB)
                .zIndex(1).draggable(false);
        MarkerOptions ooC = new MarkerOptions().position(llC).icon(BDC)
                .zIndex(1).draggable(false);
        MarkerOptions ooD = new MarkerOptions().position(llD).icon(BDD)
                .zIndex(1).draggable(false);
        MarkerOptions ooE = new MarkerOptions().position(llE).icon(BDE)
                .zIndex(1).draggable(false);

        ooA.animateType(MarkerOptions.MarkerAnimateType.grow);
        ooB.animateType(MarkerOptions.MarkerAnimateType.grow);
        ooC.animateType(MarkerOptions.MarkerAnimateType.grow);
        ooD.animateType(MarkerOptions.MarkerAnimateType.grow);
        ooE.animateType(MarkerOptions.MarkerAnimateType.grow);

        markerA = (Marker) mBaiduMap.addOverlay(ooA);
        markerB = (Marker) mBaiduMap.addOverlay(ooB);
        markerC = (Marker) mBaiduMap.addOverlay(ooC);
        markerD = (Marker) mBaiduMap.addOverlay(ooD);
        markerE = (Marker) mBaiduMap.addOverlay(ooE);

    }

    private void navigateTo(BDLocation location) {
        if (isFirstLoc) {
            LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.zoomTo(18f);
            mBaiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.newLatLng(point);
            mBaiduMap.animateMapStatus(update);
            isFirstLoc = false;
//30.318489 120.385657
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        LatLng myPosition = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
        if (marker == markerA) {
            if (DistanceUtil.getDistance(myPosition, markerA.getPosition()) < 25) {
                WarningTimes = 0;
                warning.setVisibility(View.VISIBLE);
                Warning = AnimationUtils.loadAnimation(MainActivity.this, R.anim.warning);
                Warning2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.warning2);
                warning.startAnimation(Warning);
                Warning.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        warning.startAnimation(Warning2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                Warning2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (WarningTimes < 2) {
                            WarningTimes++;
                            warning.startAnimation(Warning);
                        } else {
                            warning.setVisibility(View.GONE);
                            cap_left = AnimationUtils.loadAnimation(MainActivity.this, R.anim.cap_trans_left);
                            cap_right = AnimationUtils.loadAnimation(MainActivity.this, R.anim.cap_trans_right);
                            for (int i = 0; i < 4; i++) {
                                temp = trans_left.get(i);
                                temp.setVisibility(View.VISIBLE);
                                temp.startAnimation(cap_left);
                                temp = trans_right.get(i);
                                temp.setVisibility(View.VISIBLE);
                                temp.startAnimation(cap_right);
                            }
                            cap_left.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    String pokeMonName = Pokemon[0].Name;
                                    Intent intent3 = new Intent(MainActivity.this, Capture.class);
                                    intent3.putExtra("Name", pokeMonName);
                                    startActivity(intent3);
                                    overridePendingTransition(0, 0);
                                    transit = AnimationUtils.loadAnimation(MainActivity.this, R.anim.transit);
                                    for (int i = 0; i < 4; i++) {
                                        temp = trans_left.get(i);
                                        temp.setVisibility(View.GONE);
                                        temp.startAnimation(transit);
                                        temp = trans_right.get(i);
                                        temp.setVisibility(View.GONE);
                                        temp.startAnimation(transit);
                                    }
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                //Toast.makeText(this, String.valueOf(distanceUtil.getDistance(myPosition, markerA.getPosition())), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, String.valueOf(DistanceUtil.getDistance(myPosition, markerA.getPosition())),Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Getting a little closer.", Toast.LENGTH_SHORT).show();
            }
        } else if (marker == markerB) {
            if (DistanceUtil.getDistance(myPosition, markerB.getPosition()) < 25) {
                Intent intent = new Intent(MainActivity.this, Capture.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, String.valueOf(DistanceUtil.getDistance(myPosition, markerB.getPosition())),Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Getting a little closer.", Toast.LENGTH_SHORT).show();
            }
        } else if (marker == markerC) {
            if (DistanceUtil.getDistance(myPosition, markerC.getPosition()) < 25) {
                Intent intent = new Intent(MainActivity.this, Capture.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, String.valueOf(DistanceUtil.getDistance(myPosition, markerC.getPosition())),Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Getting a little closer.", Toast.LENGTH_SHORT).show();
            }
        } else if (marker == markerD) {
            if (DistanceUtil.getDistance(myPosition, markerD.getPosition()) < 25) {
                Intent intent = new Intent(MainActivity.this, Capture.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, String.valueOf(DistanceUtil.getDistance(myPosition, markerD.getPosition())),Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Getting a little closer.", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (DistanceUtil.getDistance(myPosition, markerE.getPosition()) < 25) {
                Intent intent = new Intent(MainActivity.this, Capture.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, String.valueOf(DistanceUtil.getDistance(myPosition, markerE.getPosition())),Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Getting a little closer.", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.littlemap:
                MenuLayout.setVisibility(View.GONE);
                littleMapLayout.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
                littleMapLayout.startAnimation(anim);
                break;
            case R.id.finish:
                littleMapLayout.setVisibility(View.GONE);
                MenuLayout.setVisibility(View.GONE);
                break;
            case R.id.menu:
                Menu.startAnimation(animation1);
                littleMapLayout.setVisibility(View.GONE);
                MenuLayout.setVisibility(View.VISIBLE);
                Animation anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
                MenuLayout.startAnimation(anim1);
                break;
            case R.id.myBag:
                /*Intent intent = new Intent(MainActivity.this, Bag.class);
                startActivity(intent);
                overridePendingTransition(0, 0);*/
                trans1_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trans_in_up);
                trans2_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trans_in_down);
                transfer1.setVisibility(View.VISIBLE);
                transfer1.startAnimation(trans1_in);
                transfer2.setVisibility(View.VISIBLE);
                transfer2.startAnimation(trans2_in);
                trans1_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(MainActivity.this, Bag.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        transit = AnimationUtils.loadAnimation(MainActivity.this, R.anim.transit);
                        transfer1.startAnimation(transit);
                        transit.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                transfer1.setVisibility(View.GONE);
                                transfer2.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.pokeDex:
                Intent intent1 = new Intent(MainActivity.this, PokeDex.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;
            case R.id.myPet:
                Intent intent2 = new Intent(MainActivity.this, MyPet.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                break;
            case R.id.pretend:
                WarningTimes = 0;
                warning.setVisibility(View.VISIBLE);
                Warning = AnimationUtils.loadAnimation(MainActivity.this, R.anim.warning);
                Warning2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.warning2);
                warning.startAnimation(Warning);
                Warning.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        warning.startAnimation(Warning2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                Warning2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (WarningTimes < 2) {
                            WarningTimes++;
                            warning.startAnimation(Warning);
                        } else {
                            warning.setVisibility(View.GONE);
                            cap_left = AnimationUtils.loadAnimation(MainActivity.this, R.anim.cap_trans_left);
                            cap_right = AnimationUtils.loadAnimation(MainActivity.this, R.anim.cap_trans_right);
                            for (int i = 0; i < 4; i++) {
                                temp = trans_left.get(i);
                                temp.setVisibility(View.VISIBLE);
                                temp.startAnimation(cap_left);
                                temp = trans_right.get(i);
                                temp.setVisibility(View.VISIBLE);
                                temp.startAnimation(cap_right);
                            }
                            cap_left.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    Intent intent3 = new Intent(MainActivity.this, Capture.class);
                                    startActivity(intent3);
                                    overridePendingTransition(0, 0);
                                    transit = AnimationUtils.loadAnimation(MainActivity.this, R.anim.transit);
                                    for (int i = 0; i < 4; i++) {
                                        temp = trans_left.get(i);
                                        temp.setVisibility(View.GONE);
                                        temp.startAnimation(transit);
                                        temp = trans_right.get(i);
                                        temp.setVisibility(View.GONE);
                                        temp.startAnimation(transit);
                                    }
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.map_mode:
                if (Open_Close == 0) {
                    ValueAnimator animator = ValueAnimator.ofFloat(-380, 0);
                    animator.setTarget(mapMode);
                    animator.setDuration(500).start();
                    animator.setInterpolator(new LinearInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                    {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation)
                        {
                            mapMode.setTranslationX((Float) animation.getAnimatedValue());
                        }
                    });
                    Open_Close = 1;
                } else {
                    ValueAnimator animator = ValueAnimator.ofFloat(0, -380);
                    animator.setTarget(mapMode);
                    animator.setDuration(500).start();
                    animator.setInterpolator(new LinearInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                    {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation)
                        {
                            mapMode.setTranslationX((Float) animation.getAnimatedValue());
                        }
                    });
                    Open_Close = 0;
                }
                break;
            case R.id.satellite:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.compass:
                mBaiduMap
                        .setMyLocationConfigeration(new MyLocationConfiguration(
                                MyLocationConfiguration.LocationMode.COMPASS, true, null));
                break;
            case R.id.following:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                mBaiduMap
                        .setMyLocationConfigeration(new MyLocationConfiguration(
                                MyLocationConfiguration.LocationMode.FOLLOWING, true, null));
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.finish:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.finish2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.finish);
                }
                break;
            case R.id.myPet:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.pet2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.pet);
                }
                break;
            case R.id.pokeDex:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.pokedex2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.pokedex);
                }
                break;
            case R.id.myBag:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.mybag2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.mybag);
                }
                break;
            case R.id.battle:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.battle2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.battle);
                }
                break;
            case R.id.shop:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.shop2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.setBackgroundResource(R.drawable.shop);
                }
                break;
            case R.id.egg:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.egg2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.egg);
                }
                break;
            case R.id.compete:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.compete2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.compete);
                }
                break;
            case R.id.gym:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.gym2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.gym);
                }
                break;
            case R.id.littlemap:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.littlemap2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.littlemap);
                }
                break;
            case R.id.setting:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.setting2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.setting);
                }
                break;
            case R.id.satellite:
                if (event.getAction() == MotionEvent.ACTION_DOWN && Open_Close == 1) {

                    v.startAnimation(anim1);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP && Open_Close == 1) {

                        v.startAnimation(anim0);
                    }
                }
                break;
            case R.id.compass:
                if (event.getAction() == MotionEvent.ACTION_DOWN && Open_Close == 1) {
                    v.startAnimation(anim1);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP && Open_Close == 1) {
                        v.startAnimation(anim0);
                    }
                }
                break;
            case R.id.following:
                if (event.getAction() == MotionEvent.ACTION_DOWN && Open_Close == 1) {
                    v.startAnimation(anim1);
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP && Open_Close == 1) {
                        v.startAnimation(anim0);
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        MenuLayout.setVisibility(View.GONE);
    }

    @Override
    public boolean onMapPoiClick(MapPoi mapPoi) {
        return false;
    }

    private class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null)
                return;
            myLocation = location;
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            Log.i("MainActivity", String.valueOf(location.getLatitude()) + " " + String.valueOf(location.getLongitude()));



            //30.318594 120.385722
            //30.318387 120.385538

            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(19f);
                MapStatusUpdate u2 = MapStatusUpdateFactory.newLatLng(ll);
                mBaiduMap.animateMapStatus(u);
                mBaiduMap.animateMapStatus(u2);



            }

        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

        public void onReceivePoi(BDLocation poiLocation) {
        }
    }

    public double[][] getRandomPosition(int Number) {//30.316634 30.312634  120.401974 120.388364
        int[][] result = new int[Number][2];
        double[][] results=new double[Number][2];
        int i=0;
        while (i < Number) {
            int a = (int) (Math.random() * 4000);
            int b = (int) (Math.random() * 13610);
            int d = 0;
            for(int j=0;j<i;j++) {
                if (Math.abs(result[j][0] - a) < 10 && Math.abs(result[j][1] - b) < 20) {
                    d = 1;
                }
            }
            if (d == 0) {
                result[i][0] = a;
                result[i][1] = b;
                i++;
            }
        }

        for (int k = 0; k < Number; k++) {

            results[k][0] = result[k][0] * 0.000001 + 30.312634;
            results[k][1] = result[k][1] * 0.000001 + 120.388364;
            BigDecimal a = new BigDecimal(results[k][0]);
            results[k][0] = a.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
            BigDecimal b = new BigDecimal(results[k][1]);
            results[k][1] = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        return results;
    }

    public PokeMon[] getRandomPokemon(int Number) {
        List<PokeMon> list = DataSupport.findAll(PokeMon.class);
        int sumWeight = 0;
        for (PokeMon pokeMon1 : list) {
            sumWeight += pokeMon1.Weight;
        }
        Log.i("sumWeight", String.valueOf(sumWeight));
        PokeMon pokeMon[] = new PokeMon[5];
        int mPokeMon = 0;
        for (int i = 0; i < Number; i ++) {
            int Random = (int) (Math.random() * sumWeight);
            for (PokeMon pokeMon2 : list) {
                int Count = Random - pokeMon2.Weight;
                if (Count > 0) {
                    Random = Count;
                } else {
                    boolean repeat = false;
                    for (int j=0;j<mPokeMon;j++) {
                        if (pokeMon2.Name.equals(pokeMon[j].getName())) {
                            repeat = true;
                            break;
                        }
                    }
                    if (repeat) {
                        i--;
                        break;
                    } else {
                        pokeMon[mPokeMon] = pokeMon2;
                        mPokeMon++;
                        Log.i("Count", String.valueOf(Random) + "  " + pokeMon2.Name);
                        break;
                    }
                }
            }
        }
        return pokeMon;
    }


    /*public class MyLocationListener implements BDLocationListener {
        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

        @Override
        public void onReceiveLocation(BDLocation location) {

            Log.i("MainActivity", "7");

            //获取定位结果
            StringBuffer sb = new StringBuffer(256);

            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息

            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度

            if (location.getLocType() == BDLocation.TypeGpsLocation){

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }

            Log.i("MainActivity", "8");
            Log.i("BaiduLocationApiDem", sb.toString());
        }
    }*/
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        //退出时销毁定位
        if (mLocClient != null)
        {
            mLocClient.stop();
        }
        mMapView.onDestroy();
        super.onDestroy();
    }
}

