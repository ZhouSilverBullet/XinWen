package com.zhousaito.news.ui.fragment;


import android.view.ViewGroup;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.zhousaito.news.R;
import com.zhousaito.news.base.BaseMvpFragment;
import com.zhousaito.news.presenter.HomeFragmentPresenter;
import com.zhousaito.news.presenter.contract.HomeFragmentContract;
import com.zhousaito.news.ui.adapter.HomePagerAdapter;
import com.zhousaito.news.ui.widget.ColorTrackTabLayout;
import com.zhousaito.news.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * A simple {@link HomeFragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeFragmentPresenter> implements HomeFragmentContract.IView {

    @BindView(R.id.ctt_tab)
    ColorTrackTabLayout mTabLayout;
    @BindView(R.id.iv_operation)
    ImageView mIvAddChannel;
    @BindView(R.id.vp_pager)
    ViewPager mViewPager;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initView() {
        super.initView();
        List<String> titleList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String title = "新闻" + (i + 1);
            titleList.add(title);
            fragmentList.add(NewsListFragment.newInstance(title));
        }
        mViewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager(), titleList, fragmentList));
        mTabLayout.setTabPaddingLeftAndRight(UIUtils.dip2px(10), UIUtils.dip2px(10));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                //设置最小宽度，使其可以在滑动一部分距离
                ViewGroup slidingTabStrip = (ViewGroup) mTabLayout.getChildAt(0);
                slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth() + mIvAddChannel.getMeasuredWidth());
            }
        });
        //隐藏指示器
        mTabLayout.setSelectedTabIndicatorHeight(0);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadData();
    }

    @Override
    public void showError(String error) {
//        mTextView.setText(error);
    }

    @Override
    public void showData(String data) {
        Logger.e(data);
//        mTextView.setText(data);
    }
}
