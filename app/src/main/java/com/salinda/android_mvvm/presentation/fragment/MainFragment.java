package com.salinda.android_mvvm.presentation.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salinda.android_mvvm.R;
import com.salinda.android_mvvm.data.api.enpoint.ApiExecutor;
import com.salinda.android_mvvm.domain.BaseViewModel;
import com.salinda.android_mvvm.presentation.App;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class MainFragment extends Fragment {
    @Inject
    public EventBus bus;
    @Inject
    public ApiExecutor apiExecutor;
    private BaseViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BaseViewModel.class);
     //   mViewModel.initializeDependencyTree();
        mViewModel.getData();
        // TODO: Use the ViewModel
        //apiExecutor.executeSampleApiRequest();
       /// new ApiExecutor().executeSampleApiRequest();
    }

}