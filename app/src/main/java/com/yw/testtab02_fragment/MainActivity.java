package com.yw.testtab02_fragment;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener, HomeFragment.OnFragmentInteractionListener, NearbyFragment.OnFragmentInteractionListener, RelexFragment.OnFragmentInteractionListener, MineFragment.OnFragmentInteractionListener {

    private LinearLayout mTabHome;
    private LinearLayout mTabNearby;
    private LinearLayout mTabRelex;
    private LinearLayout mTabMine;

    private ImageButton mImgHome;
    private ImageButton mImgNearby;
    private ImageButton mImgRelex;
    private ImageButton mImgMine;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
        setSelect(0);
    }

    private void initEvents() {
        mTabHome.setOnClickListener(this);
        mTabNearby.setOnClickListener(this);
        mTabRelex.setOnClickListener(this);
        mTabMine.setOnClickListener(this);
    }

    private void initViews() {
        mTabHome = (LinearLayout)findViewById(R.id.id_tab_home);
        mTabNearby = (LinearLayout)findViewById(R.id.id_tab_nearby);
        mTabRelex = (LinearLayout)findViewById(R.id.id_tab_relex);
        mTabMine = (LinearLayout)findViewById(R.id.id_tab_mine);

        mImgHome = (ImageButton)findViewById(R.id.id_tab_home_img);
        mImgNearby = (ImageButton)findViewById(R.id.id_tab_nearby_img);
        mImgRelex = (ImageButton)findViewById(R.id.id_tab_relex_img);
        mImgMine = (ImageButton)findViewById(R.id.id_tab_mine_img);

    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_home:
                setSelect(0);
                break;
            case R.id.id_tab_nearby:
                setSelect(1);
                break;
            case R.id.id_tab_relex:
                setSelect(2);
                break;
            case R.id.id_tab_mine:
                setSelect(3);
                break;

        }
    }

    /**
     * 把图片设置为亮色，并设置内容区域
     */
    private void setSelect(int i){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();
        hideFragment(tran);
        switch (i){
            case 0:
                if(mTab01 == null){
                    mTab01 = HomeFragment.newInstance(null, null);
                    tran.add(R.id.content, mTab01);
                }else {
                    tran.show(mTab01);
                }
                mImgHome.setImageResource(R.mipmap.tab_bar_home_selected);
                break;
            case 1:
                if(mTab02 == null){
                    mTab02 = NearbyFragment.newInstance(null, null);
                    tran.add(R.id.content, mTab02);
                }
                tran.show(mTab02);
                mImgNearby.setImageResource(R.mipmap.tab_bar_nearby_selected);
                break;
            case 2:
                if(mTab03 == null){
                    mTab03 = RelexFragment.newInstance(null, null);
                    tran.add(R.id.content, mTab03);
                }
                tran.show(mTab03);
                mImgRelex.setImageResource(R.mipmap.tab_bar_relex_selected);
                break;
            case 3:
                if(mTab04 == null){
                    mTab04 = MineFragment.newInstance(null, null);
                    tran.add(R.id.content, mTab04);
                }
                tran.show(mTab04);
                mImgMine.setImageResource(R.mipmap.tab_bar_mine_selected);
                break;
        }
        tran.commit();
    }

    /**
     * 把所有的fragment隐藏
     * @param tran
     */
    private void hideFragment(FragmentTransaction tran){
        if(mTab01 != null){
            tran.hide(mTab01);
        }
        if(mTab02 != null){
            tran.hide(mTab02);
        }
        if(mTab03 != null){
            tran.hide(mTab03);
        }
        if(mTab04 != null){
            tran.hide(mTab04);
        }
    }
    /**
     * 切换图片至暗色
     */
    private void resetImgs() {
        mImgHome.setImageResource(R.mipmap.tab_bar_home_un_selected);
        mImgNearby.setImageResource(R.mipmap.tab_bar_nearby_un_selected);
        mImgRelex.setImageResource(R.mipmap.tab_bar_relex_un_selected);
        mImgMine.setImageResource(R.mipmap.tab_bar_mine_un_selected);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.e("onFragmentInteraction", "uri = " + uri);
    }
}
