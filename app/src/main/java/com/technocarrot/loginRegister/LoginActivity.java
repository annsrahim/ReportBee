package com.technocarrot.loginRegister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.technocarrot.Config;
import com.technocarrot.utils.Utilities;
import com.technocarrot.beans.TokenBean;
import com.technocarrot.reportbee.R;
import com.technocarrot.service.APIClient;
import com.technocarrot.service.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = APIClient.getClient(this).create(APIInterface.class);
    }

    public void doSignIn(View view) {
        if(Utilities.isNetworkConnected(this))
        {
            Call<TokenBean> loginCall = apiInterface.doLoginCheck("password",
                                                            Config.clientId,
                                                            Config.clientSecret,
                                                            "samreiah@gmail.com",
                                                            "Admin@123",
                                                                "*");
            loginCall.enqueue(new Callback<TokenBean>() {
                @Override
                public void onResponse(Call<TokenBean> call, Response<TokenBean> response) {
                    Log.d("ResponseTest","Done");
                }

                @Override
                public void onFailure(Call<TokenBean> call, Throwable t) {
                    Log.d("ResponseTest","Failed");
                }
            });
        }
    }
}
