package com.tender.database.info.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("/api/{code}/tenders/{id}")
    public Call<Answer> getHun(@Path("id") String id, @Path("code") String code);

}
