package com.zhousaito.news.ui.fragment;


import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zhousaito.news.R;
import com.zhousaito.news.base.BaseMvpFragment;
import com.zhousaito.news.presenter.HomeFragmentPresenter;
import com.zhousaito.news.presenter.contract.HomeFragmentContract;

import androidx.fragment.app.Fragment;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeFragmentPresenter> implements HomeFragmentContract.IView {

    @BindView(R.id.tv_home_fragment)
    TextView mTextView;

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
        mPresenter.loadData();
    }

    @Override
    public void showError(String error) {
        mTextView.setText(error);
    }

    @Override
    public void showData(String data) {
        Logger.e(data);
        mTextView.setText(data);
    }
}
