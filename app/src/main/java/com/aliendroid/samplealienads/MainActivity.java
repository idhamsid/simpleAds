package com.aliendroid.samplealienads;

import static com.aliendroid.samplealienads.SettingAds.ADMOB_BANNER;
import static com.aliendroid.samplealienads.SettingAds.ADMOB_INTER;
import static com.aliendroid.samplealienads.SettingAds.ADMOB_REWARD;
import static com.aliendroid.samplealienads.SettingAds.BACKUP_ADS;
import static com.aliendroid.samplealienads.SettingAds.BACKUP_ADS_BANNER;
import static com.aliendroid.samplealienads.SettingAds.BACKUP_ADS_INTERTITIAL;
import static com.aliendroid.samplealienads.SettingAds.BACKUP_ADS_REWARDS;
import static com.aliendroid.samplealienads.SettingAds.DZONE_BANNER;
import static com.aliendroid.samplealienads.SettingAds.DZONE_INTERS;
import static com.aliendroid.samplealienads.SettingAds.FAN_BANNER;
import static com.aliendroid.samplealienads.SettingAds.FAN_INTERS;
import static com.aliendroid.samplealienads.SettingAds.HIGH_PAYING_KEYWORD1;
import static com.aliendroid.samplealienads.SettingAds.HIGH_PAYING_KEYWORD2;
import static com.aliendroid.samplealienads.SettingAds.HIGH_PAYING_KEYWORD3;
import static com.aliendroid.samplealienads.SettingAds.HIGH_PAYING_KEYWORD4;
import static com.aliendroid.samplealienads.SettingAds.HIGH_PAYING_KEYWORD5;
import static com.aliendroid.samplealienads.SettingAds.INITIALIZE_SDK;
import static com.aliendroid.samplealienads.SettingAds.INITIALIZE_SDK_BACKUPADS;
import static com.aliendroid.samplealienads.SettingAds.INTERVAL;
import static com.aliendroid.samplealienads.SettingAds.MAIN_ADS_BANNER;
import static com.aliendroid.samplealienads.SettingAds.MAIN_ADS_INTERTITIAL;
import static com.aliendroid.samplealienads.SettingAds.MAIN_ADS_REWARDS;
import static com.aliendroid.samplealienads.SettingAds.MAX_BANNER;
import static com.aliendroid.samplealienads.SettingAds.MAX_INTERS;
import static com.aliendroid.samplealienads.SettingAds.MAX_NATIVE;
import static com.aliendroid.samplealienads.SettingAds.NATIVE_ADS_ADMOB;
import static com.aliendroid.samplealienads.SettingAds.SELECT_ADS;
import static com.aliendroid.samplealienads.SettingAds.UNITY_BANNER;
import static com.aliendroid.samplealienads.SettingAds.UNITY_GAME_ID;
import static com.aliendroid.samplealienads.SettingAds.UNITY_INTERSTITIAL;
import static com.aliendroid.samplealienads.SettingAds.UNITY_REWARD;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aliendroid.alienads.AlienGDPR;
import com.aliendroid.alienads.AlienOpenAds;
import com.aliendroid.alienads.AliendroidBanner;
import com.aliendroid.alienads.AliendroidInitialize;
import com.aliendroid.alienads.AliendroidIntertitial;
import com.aliendroid.alienads.AliendroidMediumBanner;
import com.aliendroid.alienads.AliendroidNative;
import com.aliendroid.alienads.AliendroidReward;

public class MainActivity extends AppCompatActivity {
    private String BACKUP_NATIVE, BACKUP_INTERS, BACKUP_BANNER,BACKUP_REWARD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layAds = findViewById(R.id.layAds);
        FrameLayout nativeads = findViewById(R.id.laynative);
        RelativeLayout layAdsmall = findViewById(R.id.laysAdsmall);
        AlienGDPR.loadGdpr(MainActivity.this, SELECT_ADS, true);

        /*AliendroidBanner.MediumBanner(MainActivity.this, layAds,SettingAds.SELECT_ADS, SettingAds.MAIN_ADS_BANNER,HIGH_PAYING_KEYWORD1
        ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5);
        AliendroidBanner.SmallBanner(MainActivity.this, layAdsmall,SettingAds.SELECT_ADS, SettingAds.MAIN_ADS_BANNER,HIGH_PAYING_KEYWORD1
                ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5);
        AliendroidIntertitial.LoadIntertitial(MainActivity.this, SettingAds.SELECT_ADS, SettingAds.MAIN_ADS_INTERTITIAL,HIGH_PAYING_KEYWORD1
                ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5 );
        AliendroidNative.SmallNativeAdmob(MainActivity.this,SELECT_ADS, SettingAds.BACKUP_ADS, nativeads, NATIVE_ADS_ADMOB,MAIN_ADS_BANNER, HIGH_PAYING_KEYWORD1
                ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5);
        AliendroidReward.LoadReward(MainActivity.this, SELECT_ADS, MAIN_ADS_REWARDS );
        AlienOpenAds.ShowOpen(MainActivity.this);
         */
        switch (BACKUP_ADS) {
            case "ADMOB":
                BACKUP_BANNER = ADMOB_BANNER;
                BACKUP_INTERS = ADMOB_INTER;
                BACKUP_REWARD = ADMOB_REWARD;
                break;
            case "APPLOVIN-M":
                BACKUP_BANNER = MAX_BANNER;
                BACKUP_INTERS = MAX_INTERS;
                BACKUP_NATIVE = MAX_NATIVE;
                break;
            case "APPLOVIN_D":
                BACKUP_BANNER = DZONE_BANNER;
                BACKUP_INTERS = DZONE_INTERS;
                break;
            case "FACEBOOK":
                BACKUP_BANNER = FAN_BANNER;
                BACKUP_INTERS = FAN_INTERS;
                break;
        }

        switch (SELECT_ADS) {
            case "ADMOB":
                AliendroidInitialize.SelectAdsAdmob(MainActivity.this, BACKUP_ADS, INITIALIZE_SDK_BACKUPADS);
                AliendroidMediumBanner.MediumBannerAdmob(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER, HIGH_PAYING_KEYWORD1,
                        HIGH_PAYING_KEYWORD2, HIGH_PAYING_KEYWORD3, HIGH_PAYING_KEYWORD4, HIGH_PAYING_KEYWORD5);
                AliendroidIntertitial.LoadIntertitialAdmob(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, HIGH_PAYING_KEYWORD1,
                        HIGH_PAYING_KEYWORD2, HIGH_PAYING_KEYWORD3, HIGH_PAYING_KEYWORD4, HIGH_PAYING_KEYWORD5);
                AliendroidReward.LoadRewardAdmob(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                AliendroidNative.MediumNative(MainActivity.this,SELECT_ADS,BACKUP_ADS,nativeads,NATIVE_ADS_ADMOB,BACKUP_NATIVE,"","",
                        "","", "",Color.WHITE);
                break;
            case "APPLOVIN-M":
                AliendroidInitialize.SelectAdsApplovinMax(MainActivity.this, BACKUP_ADS, INITIALIZE_SDK_BACKUPADS);
                AliendroidBanner.SmallBannerApplovinMax(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                AliendroidReward.LoadRewardApplovinMax(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                AliendroidIntertitial.LoadIntertitialApplovinMax(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                AliendroidNative.MediumNative(MainActivity.this, SELECT_ADS, BACKUP_ADS, nativeads, MAX_NATIVE, NATIVE_ADS_ADMOB, "", "", "", "", "", Color.WHITE);
                break;
            case "APPLOVIN-D":
                AliendroidBanner.SmallBannerApplovinDis(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                AliendroidIntertitial.LoadIntertitialApplovinDis(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case "STARTAPP":
                AliendroidBanner.SmallBannerStartApp(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                AliendroidIntertitial.LoadIntertitialStartApp(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case "IRON":
                AliendroidInitialize.SelectAdsIron(MainActivity.this, BACKUP_ADS, INITIALIZE_SDK, INITIALIZE_SDK_BACKUPADS);
                AliendroidBanner.SmallBannerIron(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                AliendroidIntertitial.LoadIntertitialIron(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case "FACEBOOK":
                AliendroidInitialize.SelectAdsFAN(MainActivity.this, SELECT_ADS, INITIALIZE_SDK_BACKUPADS);
                AliendroidBanner.SmallBannerFAN(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                AliendroidIntertitial.LoadIntertitialFAN(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case "GOOGLE-ADS":
                AliendroidInitialize.SelectAdsGoogleAds(MainActivity.this, BACKUP_ADS, INITIALIZE_SDK_BACKUPADS);
                AliendroidBanner.SmallBannerGoogleAds(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                AliendroidIntertitial.LoadIntertitialGoogleAds(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                AliendroidReward.LoadRewardGoogleAds(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                AliendroidNative.MediumNativeGoogleAds(MainActivity.this, SELECT_ADS, BACKUP_ADS, nativeads, NATIVE_ADS_ADMOB, BACKUP_ADS_BANNER);
                break;
            case "UNITY":
                AliendroidInitialize.SelectAdsUnity(MainActivity.this, BACKUP_ADS, UNITY_GAME_ID, "");
                AliendroidBanner.SmallBannerUnity(MainActivity.this, layAds, BACKUP_ADS, "", BACKUP_BANNER);
                AliendroidIntertitial.LoadIntertitialUnity(MainActivity.this,BACKUP_ADS,UNITY_INTERSTITIAL,BACKUP_INTERS);
                AliendroidReward.LoadRewardUnity(MainActivity.this,BACKUP_ADS,UNITY_REWARD,BACKUP_REWARD);
                break;

        }

    }

    public void munculiklan(View view) {
        switch (SELECT_ADS) {
            case "ADMOB":
                AliendroidIntertitial.ShowIntertitialAdmob(MainActivity.this, BACKUP_ADS, ADMOB_INTER, BACKUP_INTERS, INTERVAL,
                        HIGH_PAYING_KEYWORD1, HIGH_PAYING_KEYWORD2, HIGH_PAYING_KEYWORD3, HIGH_PAYING_KEYWORD4, HIGH_PAYING_KEYWORD5);
                break;
            case "APPLOVIN-D":
                AliendroidIntertitial.ShowIntertitialApplovinDis(MainActivity.this, BACKUP_ADS, DZONE_INTERS, BACKUP_INTERS, INTERVAL);
                break;
            case "APPLOVIN-M":
                AliendroidIntertitial.ShowIntertitialApplovinMax(MainActivity.this, BACKUP_ADS, MAX_INTERS, BACKUP_INTERS, INTERVAL);
                break;
            case "IRON":
                AliendroidIntertitial.ShowIntertitialIron(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_INTERS, INTERVAL);
                break;
            case "STARTAPP":
                AliendroidIntertitial.ShowIntertitialSartApp(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_INTERS, INTERVAL);
                break;
            case "FACEBOOK":
                AliendroidIntertitial.ShowIntertitialFAN(MainActivity.this, BACKUP_ADS, FAN_INTERS, BACKUP_INTERS, INTERVAL);

                break;
            case "GOOGLE-ADS":
                AliendroidIntertitial.ShowIntertitialGoogleAds(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "UNITY":
                AliendroidIntertitial.ShowIntertitialUnity(MainActivity.this, BACKUP_ADS, UNITY_INTERSTITIAL, BACKUP_INTERS, INTERVAL);
                break;
        }

    }

    public void munculreward(View view) {
        switch (SELECT_ADS) {
            case "ADMOB":
                AliendroidReward.ShowRewardAdmob(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "APPLOVIN-M":
                AliendroidReward.ShowRewardApplovinMax(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "GOOGLE-ADS":
                AliendroidReward.ShowRewardGoogleAds(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "UNITY":
                AliendroidReward.ShowRewardUnity(MainActivity.this, BACKUP_ADS, UNITY_REWARD, BACKUP_ADS_REWARDS);
                break;


        }
    }

    public void onResume() {
        super.onResume();
        if (AliendroidReward.unlockreward) {
            Toast.makeText(getApplicationContext(), "OK Berhasil", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
        super.onBackPressed();
    }
}