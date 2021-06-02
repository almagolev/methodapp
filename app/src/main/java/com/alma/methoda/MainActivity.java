package com.alma.methoda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Call<List<StatusDataModel>> callS;
    private Call<List<TransactionDataModel>> callT;
    private List<StatusDataModel> statusDataModelList;
    private List<TransactionDataModel> transactionDataModelList;
    private RecyclerView recyclerView_s,recyclerView_t;
    private StatusAdapter statusAdapter;
    private TransactionAdapter transactionAdapter;
    private ApiInterface apiService;
    private TextView status_name, transaction_name;
    private Spinner spinner_s, spinner_t;
    private Button btn_add_s, btn_add_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_s = findViewById(R.id.recyclerV_s);
        recyclerView_t = findViewById(R.id.recyclerV_t);

        findViewById(R.id.btn_red).setOnClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerT = new LinearLayoutManager(this);
        recyclerView_s.setLayoutManager(layoutManager);
        recyclerView_t.setLayoutManager(layoutManagerT);

        statusAdapter = new StatusAdapter(this,statusDataModelList);
        transactionAdapter = new TransactionAdapter(this,transactionDataModelList);

        recyclerView_s.setAdapter(statusAdapter);
        recyclerView_t.setAdapter(transactionAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView_s.addItemDecoration(dividerItemDecoration);
        recyclerView_t.addItemDecoration(dividerItemDecoration);

        apiService = Api.getApi().create(ApiInterface.class);
        recyclerView_s.setHasFixedSize(true);
        recyclerView_t.setHasFixedSize(true);

        callS = apiService.getAllStatuses();
        callT = apiService.getAllTransactions();

        status_name = findViewById(R.id.status_name);
        transaction_name = findViewById(R.id.transaction_name);
        btn_add_s = findViewById(R.id.btn_add_s);
        btn_add_s.setOnClickListener(this);
        callEnqueueT();
        callEnqueueS();

    }

    public void callEnqueueS() {
        callS.enqueue(new Callback<List<StatusDataModel>>() {
            @Override
            public void onResponse(Call<List<StatusDataModel>> callS, Response<List<StatusDataModel>> response) {
                statusDataModelList = response.body();
                statusAdapter.setStatusDataModelList(statusDataModelList);
            }

            @Override
            public void onFailure(Call<List<StatusDataModel>> callS, Throwable t) {
                callS.request(); }
        });
    }

    public void callEnqueueT() {
        callT.enqueue(new Callback<List<TransactionDataModel>>() {
            @Override
            public void onResponse(Call<List<TransactionDataModel>> callT, Response<List<TransactionDataModel>> response) {
                transactionDataModelList = response.body();
                transactionAdapter.setTransactionDataModelList(transactionDataModelList);
            }

            @Override
            public void onFailure(Call<List<TransactionDataModel>> callT, Throwable t) {
                callT.request(); }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_s:
            StatusDataModel statusDataModel = new StatusDataModel();
            statusDataModel.setName_s(status_name.getText().toString());
            Api.getApi().create(ApiInterface.class).addStatus(statusDataModel).enqueue(new Callback<StatusDataModel>() {
                @Override
                public void onResponse(Call<StatusDataModel> call, Response<StatusDataModel> response) {

                }

                @Override
                public void onFailure(Call<StatusDataModel> call, Throwable t) {

                }
            });
            status_name.setText("");
            break;
        }
        callS = apiService.getAllStatuses();
        callEnqueueS();
        callT = apiService.getAllTransactions();
        callEnqueueT();
    }
}