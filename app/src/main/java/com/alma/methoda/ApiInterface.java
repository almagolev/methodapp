package com.alma.methoda;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/api/statuses")
    Call<List<StatusDataModel>> getAllStatuses();

    @PUT("/api/statuses/")
    Call<StatusDataModel> addStatus(@Body StatusDataModel statusDataModel);

    @DELETE("/api/statuses/{id}")
    Call<Void> deleteStatusById(@Path("id") int id);

    @GET("/api/transactions")
    Call<List<TransactionDataModel>> getAllTransactions();

    @PUT("/api/transactions/")
    Call<TransactionDataModel> addTransaction(@Body TransactionDataModel transactionDataModel);
}
