package com.example.expensetracker.ui.dashboard;
import android.app.Application; import androidx.annotation.NonNull; import androidx.lifecycle.*;
import com.example.expensetracker.data.local.TransactionEntity; import com.example.expensetracker.data.repository.TransactionRepository; import java.util.List;
public class DashboardViewModel extends AndroidViewModel {
 private final TransactionRepository repository;
 public DashboardViewModel(@NonNull Application app){super(app);repository=new TransactionRepository(app);}
 public LiveData<List<TransactionEntity>> getRecent(){return repository.getRecent();} public LiveData<Double> getIncome(){return repository.getIncome();}
 public LiveData<Double> getExpenses(){return repository.getExpenses();} public LiveData<Double> getMonthlyExpenses(String month){return repository.getMonthlyExpenses(month);}
 public void add(TransactionEntity t){repository.insert(t);} public void update(TransactionEntity t){repository.update(t);} public void delete(TransactionEntity t){repository.delete(t);}
}
