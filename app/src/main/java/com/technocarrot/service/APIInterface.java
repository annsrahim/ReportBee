package com.technocarrot.service;

import com.technocarrot.beans.TokenBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Anns on 08/02/18.
 */

public interface APIInterface {
    @FormUrlEncoded
    @POST("oauth/token")
    Call<TokenBean> doLoginCheck(@Field("grant_type") String grant_type,
                                        @Field("client_id") String client_id,
                                        @Field("client_secret") String client_secret,
                                        @Field("username") String user_name,
                                        @Field("password") String password,
                                        @Field("scope") String scope
    );
}
