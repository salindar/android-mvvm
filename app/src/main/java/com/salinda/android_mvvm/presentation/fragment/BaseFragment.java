package com.salinda.android_mvvm.presentation.fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salinda.android_mvvm.R;
import com.salinda.android_mvvm.domain.BaseViewModel;


public abstract class BaseFragment extends Fragment {
    private BaseViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.registerEventBus();
    }

    @Override
    public void onPause() {
        super.onPause();
        mViewModel.unRegisterEventBus();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = getViewModel();
        final Observer<Boolean> loading = loading1 -> {
            updateLoadingState(loading1);
        };
        mViewModel.getLoadingState().observe(this, loading);
    }

    protected abstract BaseViewModel getViewModel();

    /**
     * Provide the necessary loading indicator based on the status.
     * @param loading
     */
    protected  void updateLoadingState(boolean loading){

    }
}