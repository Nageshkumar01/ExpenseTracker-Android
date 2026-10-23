package com.example.expensetracker.data.repository;
import android.content.Context; import androidx.lifecycle.LiveData;
import com.example.expensetracker.data.local.*; import java.util.List; import java.util.concurrent.*;
public class TransactionRepository {
 private final TransactionDao dao; private final ExecutorService executor=Executors.newSingleThreadExecutor();
 public TransactionRepository(Context context){dao=AppDatabase.getInstance(context).transactionDao();}
 public LiveData<List<TransactionEntity>> getAll(){return dao.getAll();} public LiveData<TransactionEntity> getById(int id){return dao.getById(id);}
 public LiveData<List<TransactionEntity>> getRecent(){return dao.getRecent();} public LiveData<Double> getIncome(){return dao.getTotalIncome();}
 public LiveData<Double> getExpenses(){return dao.getTotalExpenses();} public LiveData<Double> getMonthlyExpenses(String month){return dao.getMonthlyExpenses(month);}
 public void insert(TransactionEntity t){executor.execute(()->dao.insert(t));} public void update(TransactionEntity t){executor.execute(()->dao.update(t));}
 public void delete(TransactionEntity t){executor.execute(()->dao.delete(t));}
}
