package com.salinda.android_mvvm.presentation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.salinda.android_mvvm.R;
import com.salinda.android_mvvm.data.model.SampleModel;
import com.salinda.android_mvvm.domain.BaseViewModel;
import com.salinda.android_mvvm.domain.SampleViewModel;

import java.util.List;


public class SampleFragment extends BaseFragment {
    private SampleViewModel mViewModel;
    private ListView listView;
    private ProgressBar progressBar;


    public static SampleFragment newInstance() {
        return new SampleFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listview);
        progressBar = view.findViewById(R.id.progressBar);
    }

    private void initializeList(String[] data) {
        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_row, data);
        listView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        mViewModel.getData();
        super.onActivityCreated(savedInstanceState);

        // Create the observer which updates the UI.
        final Observer<List<SampleModel>> nameObserver = new Observer<List<SampleModel>>() {
            @Override
            public void onChanged(@Nullable final List<SampleModel> list) {
                initializeList(convertToArray(list));
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mViewModel.getSampleList().observe(this, nameObserver);
    }

    private String[] convertToArray(List<SampleModel> list) {
        String[] arr = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            arr[x] = list.get(x).getName();
        }
        return arr;
    }

    @Override
    protected BaseViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected void updateLoadingState(boolean loading) {
        if(loading){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}