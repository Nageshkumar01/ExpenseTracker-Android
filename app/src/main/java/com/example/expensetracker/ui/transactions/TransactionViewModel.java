package com.example.expensetracker.ui.transactions;
import android.app.Application; import androidx.annotation.NonNull; import androidx.lifecycle.*;
import com.example.expensetracker.data.local.TransactionEntity; import com.example.expensetracker.data.repository.TransactionRepository; import java.util.List;
public class TransactionViewModel extends AndroidViewModel {
 private final TransactionRepository repository;
 public TransactionViewModel(@NonNull Application app){super(app);repository=new TransactionRepository(app);}
 public LiveData<List<TransactionEntity>> getAll(){return repository.getAll();} public LiveData<TransactionEntity> getById(int id){return repository.getById(id);}
 public void delete(TransactionEntity t){repository.delete(t);}
}
