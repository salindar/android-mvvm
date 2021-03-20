package com.salinda.android_mvvm.data.api.enpoint;

import android.os.Bundle;

import com.salinda.android_mvvm.data.api.core.APIResponseCallBack;
import com.salinda.android_mvvm.data.api.core.RetrofitModule;
import com.salinda.android_mvvm.data.api.enpoint.API;
import com.salinda.android_mvvm.data.model.SampleModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 *  * Created by Salinda Rathnayeka May 2021
 *  * salindakrishantha@gmail.com
 * This is the handle class for the APIs. API can be executed by providing
 * BUS events. If fragment or Activity want to send an API call, that particular activity
 * or the fragment need to be implemented the EventBus subscribe mechanism in the activity
 * or fragment
 */
public class ApiExecutor {
   // private static final String API_KEY = BuildConfig.API_KEY;

    public enum API_ENUM {
        CREATE_USER,
        UPDATE_ACCOUNT,
        UPDATE_USER,
        SIGN_IN,
        GOOGLE_IAP_RECEIPT_SIGN_IN,
        VERIFY_CODE,
        RESEND_CODE,
        GET_TERMS,
        GET_SESSION_INFO,
        GET_HOURS,
        REQUEST_A_CALL_BACK,
    }

    @Inject
     RetrofitModule<API> retrofitModule;
    @Inject
    public APIResponseCallBack<List<SampleModel>> sampleModelAPIResponseCallBack;

    @Inject
    public ApiExecutor() {
      //  retrofitModule = new RetrofitModule();

    }

    public void executeSampleApiRequest(){
        Bundle bundle = new Bundle();
        bundle.putString("Content-Type", "application/json");
        API api = retrofitModule.getRestClient(API.class, null, bundle);
        Call<List<SampleModel>> call = api.getUsers();
                   // APIResponseCallBack<List<SampleModel>> sampleModelAPIResponseCallBack = new APIResponseCallBack<>();
                    call.enqueue(sampleModelAPIResponseCallBack);
    }

//    @Subscribe
//    public void onApiExecute(ApiEvent event) {
//        if (event != null) {
//            switch (event.getApiEnum()) {
//                case CREATE_USER:
//
//                    User userModel = (User) event.getModel();
//                    //TODO fix this
//                    userModel.setApiKey(API_KEY);
//                    Call<SimpleAPIResponse> call = api.createUser(userModel);
//                    APIResponseCallBack<SimpleAPIResponse> sampleModelAPIResponseCallBack = new APIResponseCallBack<>();
//                    sampleModelAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    call.enqueue(sampleModelAPIResponseCallBack);
//                    break;
//
//                case GET_TERMS:
//
//                    Call<TermsOfUse> termsCall = api.getTerms();
//                    APIResponseCallBack<TermsOfUse> termsAPIResponseCallBack = new APIResponseCallBack<>();
//                    termsCall.enqueue(termsAPIResponseCallBack);
//                    break;
//
//                case VERIFY_CODE:
//                    VerificationCode verificationCode = (VerificationCode) event.getModel();
//                    //TODO fix this
//                    verificationCode.setApiKey(API_KEY);
//                    Call<Session> verifyEmailCall = api.verifyEmail(verificationCode);
//                    APIResponseCallBack<Session> verifyEmailAPIResponseCallBack = new APIResponseCallBack<>();
//                    verifyEmailAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    verifyEmailCall.enqueue(verifyEmailAPIResponseCallBack);
//                    break;
//
//                case SIGN_IN:
//                    LoginCredentials loginCredentials = (LoginCredentials) event.getModel();
//                    //TODO fix this
//                    loginCredentials.setApiKey(API_KEY);
//                    Call<Session> loginCall = api.login(loginCredentials);
//                    APIResponseCallBack<Session> loginAPIResponseCallBack = new APIResponseCallBack<>();
//                    loginAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    loginCall.enqueue(loginAPIResponseCallBack);
//                    break;
//
//                case GOOGLE_IAP_RECEIPT_SIGN_IN:
//                    ReceiptLoginCredentials receiptLoginCredentials = (ReceiptLoginCredentials) event.getModel();
//
//                    receiptLoginCredentials.setApiKey(API_KEY);
//                    Call<Session> receiptLoginCall = api.loginByGoogleIapReceipt(receiptLoginCredentials);
//                    APIResponseCallBack<Session> receiptLoginAPIResponseCallBack = new APIResponseCallBack<>();
//                    receiptLoginAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    receiptLoginCall.enqueue(receiptLoginAPIResponseCallBack);
//                    break;
//
//                case RESEND_CODE:
//                    ResendVerificationCode resendVerificationCode = (ResendVerificationCode) event.getModel();
//                    //TODO fix this
//                    resendVerificationCode.setApiKey(API_KEY);
//                    Call<SimpleAPIResponse> resendVerificationCodeCall = api.resendVerificationCode(resendVerificationCode);
//                    APIResponseCallBack<SimpleAPIResponse> resendVerificationCodeCallAPIResponseCallBack = new APIResponseCallBack<>();
//                    resendVerificationCodeCallAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    resendVerificationCodeCall.enqueue(resendVerificationCodeCallAPIResponseCallBack);
//                    break;
//
//                case UPDATE_ACCOUNT:
//                    Account account = (Account) event.getModel();
//                    //TODO fix this
//                    account.setApiKey(API_KEY);
//                    Call<SimpleAPIResponse> accountUpdateCall = api.updateAccount(account);
//                    APIResponseCallBack<SimpleAPIResponse> accountUpdateCallAPIResponseCallBack = new APIResponseCallBack<>();
//                    accountUpdateCallAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    accountUpdateCall.enqueue(accountUpdateCallAPIResponseCallBack);
//                    break;
//
//                case UPDATE_USER:
//                    User user = (User) event.getModel();
//                    //TODO fix this
//                    user.setApiKey(API_KEY);
//                    Call<SimpleAPIResponse> userUpdateCall = api.updateAccount(user);
//                    APIResponseCallBack<SimpleAPIResponse> userUpdateCallAPIResponseCallBack = new APIResponseCallBack<>();
//                    userUpdateCallAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    userUpdateCall.enqueue(userUpdateCallAPIResponseCallBack);
//                    break;
//
//                case GET_SESSION_INFO:
//                    Session session = (Session) event.getModel();
//                    //TODO fix this
//                    session.setApiKey(API_KEY);
//
//                    Call<User> getSessionCall = api.getSessionInfo(session);
//                    APIResponseCallBack<User> getSessionAPIResponseCallBack = new APIResponseCallBack<>();
//                    getSessionAPIResponseCallBack.setRequestCode(event.getRequestCode());
//                    getSessionCall.enqueue(getSessionAPIResponseCallBack);
//                    break;
//
//                case REQUEST_A_CALL_BACK:
//                    CallBackRequest callBackRequest = (CallBackRequest) event.getModel();
//                    //TODO fix this
//                    callBackRequest.setApiKey(API_KEY);
//                    Call<CallBackResponse> callBackRequestCall = api.requestCallBack(callBackRequest);
//                    APIResponseCallBack<CallBackResponse> callBackRequestCallCallBack = new APIResponseCallBack<>();
//                    callBackRequestCallCallBack.setRequestCode(event.getRequestCode());
//                    callBackRequestCall.enqueue(callBackRequestCallCallBack);
//                    break;
//
//            }
//        }
//    }

}
