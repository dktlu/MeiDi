package com.judi.meidi.activity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.base.BaseActivity;
import com.judi.meidi.fragment.ConsultationFragment;
import com.judi.meidi.fragment.IndexFragment;
import com.judi.meidi.fragment.OfferFragment;
import com.judi.meidi.fragment.PredictionFragment;
import com.judi.meidi.fragment.ProductFragment;

/**
 * 美迪装饰主界面
 *
 * @author dengkaitao
 * @date 2016年3月31日上午9:24:43
 */
@SuppressLint("NewApi")
public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private IndexFragment indexFragment;
    private ProductFragment productFragment;
    private OfferFragment offerFragment;
    private PredictionFragment predictionFragment;
    private ConsultationFragment consultationFragment;

    private static final String[] FRAGMENT_TAG = {"index", "product", "offer", "prediction", "consultation"};
    private static final String SAVEDSTATE = "savedstate";
    private int curPage = 0;

    private LinearLayout mTabButtonFirst;
    private LinearLayout mTabButtonSecond;
    private LinearLayout mTabButtonThird;
    private LinearLayout mTabButtonFour;
    private LinearLayout mTabButtonFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public void setBasicInfo(Bundle savedInstanceState) {
        fragmentManager = getFragmentManager();
        if (null != savedInstanceState) {
            curPage = savedInstanceState.getInt(SAVEDSTATE, curPage);
            indexFragment = (IndexFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            productFragment = (ProductFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            offerFragment = (OfferFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);
            predictionFragment = (PredictionFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[3]);
            consultationFragment = (ConsultationFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[4]);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVEDSTATE, curPage);
        super.onSaveInstanceState(outState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        mTabButtonFirst = (LinearLayout) findViewById(R.id.layout_tab_first);
        mTabButtonSecond = (LinearLayout) findViewById(R.id.layout_tab_second);
        mTabButtonThird = (LinearLayout) findViewById(R.id.layout_tab_third);
        mTabButtonFour = (LinearLayout) findViewById(R.id.layout_tab_four);
        mTabButtonFive = (LinearLayout) findViewById(R.id.layout_tab_five);
    }

    @Override
    public void bindViews() {
        mTabButtonFirst.setOnClickListener(this);
        mTabButtonSecond.setOnClickListener(this);
        mTabButtonThird.setOnClickListener(this);
        mTabButtonFour.setOnClickListener(this);
        mTabButtonFive.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setTabSelection(0);
    }

    @Override
    public void onClick(View view) {
        resetTabBtn();
        switch (view.getId()) {
            case R.id.layout_tab_first:
                setTabSelection(0);
                break;
            case R.id.layout_tab_second:
                setTabSelection(1);
                break;
            case R.id.layout_tab_third:
                setTabSelection(2);
                break;
            case R.id.layout_tab_four:
                setTabSelection(3);
                break;
            case R.id.layout_tab_five:
                setTabSelection(4);
                break;

            default:
                break;
        }
    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                curPage = 0;
                ((ImageView) findViewById(R.id.btn_tab_first))
                        .setImageResource(R.drawable.icon_bottom_index_press);
                ((TextView) findViewById(R.id.tv_tab_first))
                        .setTextColor(getResources().getColor(
                                R.color.bottom_pressed));
                if (null == indexFragment) {
                    indexFragment = new IndexFragment();
                    transaction.add(R.id.id_content, indexFragment, FRAGMENT_TAG[0]);
                } else {
                    transaction.show(indexFragment);
                }
                break;
            case 1:
                curPage = 1;
                ((ImageView) findViewById(R.id.btn_tab_second))
                        .setImageResource(R.drawable.icon_bottom_product_press);
                ((TextView) findViewById(R.id.tv_tab_second))
                        .setTextColor(getResources().getColor(
                                R.color.bottom_pressed));
                if (null == productFragment) {
                    productFragment = new ProductFragment();
                    transaction.add(R.id.id_content, productFragment, FRAGMENT_TAG[1]);
                } else {
                    transaction.show(productFragment);
                }
                break;
            case 2:
                curPage = 2;
                ((ImageView) findViewById(R.id.btn_tab_third))
                        .setImageResource(R.drawable.icon_bottom_offer_press);
                ((TextView) findViewById(R.id.tv_tab_third))
                        .setTextColor(getResources().getColor(
                                R.color.bottom_pressed));
                if (null == offerFragment) {
                    offerFragment = new OfferFragment();
                    transaction.add(R.id.id_content, offerFragment, FRAGMENT_TAG[2]);
                } else {
                    transaction.show(offerFragment);
                }
                break;
            case 3:
                curPage = 3;
                ((ImageView) findViewById(R.id.btn_tab_four))
                        .setImageResource(R.drawable.icon_bottom_prediction_press);
                ((TextView) findViewById(R.id.tv_tab_four))
                        .setTextColor(getResources().getColor(
                                R.color.bottom_pressed));
                if (null == predictionFragment) {
                    predictionFragment = new PredictionFragment();
                    transaction.add(R.id.id_content, predictionFragment, FRAGMENT_TAG[3]);
                } else {
                    transaction.show(predictionFragment);
                }
                break;
            case 4:
                curPage = 4;
                ((ImageView) findViewById(R.id.btn_tab_five))
                        .setImageResource(R.drawable.icon_bottom_consultation_press);
                ((TextView) findViewById(R.id.tv_tab_five))
                        .setTextColor(getResources().getColor(
                                R.color.bottom_pressed));
                if (null == consultationFragment) {
                    consultationFragment = new ConsultationFragment();
                    transaction.add(R.id.id_content, consultationFragment, FRAGMENT_TAG[4]);
                } else {
                    transaction.show(consultationFragment);
                }
                break;

            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏fragment
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (null != indexFragment) {
            transaction.hide(indexFragment);
        }

        if (null != productFragment) {
            transaction.hide(productFragment);
        }

        if (null != offerFragment) {
            transaction.hide(offerFragment);
        }

        if (null != predictionFragment) {
            transaction.hide(predictionFragment);
        }

        if (null != consultationFragment) {
            transaction.hide(consultationFragment);
        }
    }

    /**
     * 重置按钮样式
     */
    private void resetTabBtn() {
        ((ImageView) findViewById(R.id.btn_tab_first))
                .setImageResource(R.drawable.icon_bottom_index_normal);
        ((ImageView) findViewById(R.id.btn_tab_second))
                .setImageResource(R.drawable.icon_bottom_product_normal);
        ((ImageView) findViewById(R.id.btn_tab_third))
                .setImageResource(R.drawable.icon_bottom_offer_normal);
        ((ImageView) findViewById(R.id.btn_tab_four))
                .setImageResource(R.drawable.icon_bottom_prediction_normal);
        ((ImageView) findViewById(R.id.btn_tab_five))
                .setImageResource(R.drawable.icon_bottom_consultation_normal);
        ((TextView) findViewById(R.id.tv_tab_first))
                .setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.tv_tab_second))
                .setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.tv_tab_third))
                .setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.tv_tab_four))
                .setTextColor(getResources().getColor(R.color.white));
        ((TextView) findViewById(R.id.tv_tab_five))
                .setTextColor(getResources().getColor(R.color.white));
    }

}
