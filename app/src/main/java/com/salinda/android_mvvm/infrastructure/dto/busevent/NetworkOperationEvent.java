package com.salinda.android_mvvm.infrastructure.dto.busevent;
/**
 * Created by Salinda Rathnayeka May 2021
 * salindakrishantha@gmail.com
 * */

public class NetworkOperationEvent {
    private boolean networkOperationInProgress;

    public boolean isNetworkOperationInProgress() {
        return networkOperationInProgress;
    }

    public void setNetworkOperationInProgress(boolean networkOperationInProgress) {
        this.networkOperationInProgress = networkOperationInProgress;
    }

    public NetworkOperationEvent(boolean networkOperationInProgress) {
        this.networkOperationInProgress = networkOperationInProgress;
    }
}
