package com.example.expensetracker.data.local;
import androidx.lifecycle.LiveData; import androidx.room.*; import java.util.List;
@Dao public interface TransactionDao {
 @Insert void insert(TransactionEntity transaction);
 @Update void update(TransactionEntity transaction);
 @Delete void delete(TransactionEntity transaction);
 @Query("SELECT * FROM transactions ORDER BY date DESC, id DESC") LiveData<List<TransactionEntity>> getAll();
 @Query("SELECT * FROM transactions WHERE id = :id LIMIT 1") LiveData<TransactionEntity> getById(int id);
 @Query("SELECT * FROM transactions ORDER BY date DESC, id DESC LIMIT 5") LiveData<List<TransactionEntity>> getRecent();
 @Query("SELECT COALESCE(SUM(amount), 0) FROM transactions WHERE type = 'INCOME'") LiveData<Double> getTotalIncome();
 @Query("SELECT COALESCE(SUM(amount), 0) FROM transactions WHERE type = 'EXPENSE'") LiveData<Double> getTotalExpenses();
 @Query("SELECT COALESCE(SUM(amount), 0) FROM transactions WHERE type = 'EXPENSE' AND date LIKE :monthPrefix || '%' ") LiveData<Double> getMonthlyExpenses(String monthPrefix);
}
