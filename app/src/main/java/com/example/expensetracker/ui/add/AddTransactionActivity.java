package com.example.expensetracker.ui.add;
import android.os.Bundle; import android.widget.*; import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity; import androidx.lifecycle.ViewModelProvider;
import com.example.expensetracker.R; import com.example.expensetracker.data.local.TransactionEntity; import com.example.expensetracker.ui.dashboard.DashboardViewModel;
import com.google.android.material.button.MaterialButton; import com.google.android.material.textfield.TextInputEditText;
import java.text.SimpleDateFormat; import java.util.Date; import java.util.Locale;
public class AddTransactionActivity extends AppCompatActivity {
 private TextInputEditText title,amount,category,notes; private RadioGroup type; private DashboardViewModel vm; private int editId=-1;
 @Override protected void onCreate(Bundle state){super.onCreate(state);setContentView(R.layout.activity_add_transaction);
 title=findViewById(R.id.etTitle); amount=findViewById(R.id.etAmount); category=findViewById(R.id.etCategory); notes=findViewById(R.id.etNotes); type=findViewById(R.id.rgType);
 vm=new ViewModelProvider(this).get(DashboardViewModel.class); editId=getIntent().getIntExtra("transaction_id",-1);
 if(editId!=-1){setTitle("Edit transaction"); TextView heading=findViewById(R.id.tvFormHeading); if(heading!=null)heading.setText("Edit transaction"); vm.getRecent(); new ViewModelProvider(this).get(com.example.expensetracker.ui.transactions.TransactionViewModel.class).getById(editId).observe(this,t->{if(t!=null){title.setText(t.title);amount.setText(String.valueOf(t.amount));category.setText(t.category);notes.setText(t.notes);type.check("INCOME".equals(t.type)?R.id.rbIncome:R.id.rbExpense);}}); }
 ((MaterialButton)findViewById(R.id.btnSave)).setOnClickListener(v->save());
 int cancelId=getResources().getIdentifier("btnCancel","id",getPackageName()); if(cancelId!=0)findViewById(cancelId).setOnClickListener(v->finish());
 }
 private void save(){String t=text(title),a=text(amount),c=text(category),n=text(notes); if(t.isEmpty()){title.setError("Enter a description");return;} if(a.isEmpty()){amount.setError("Enter an amount");return;}
 double value;try{value=Double.parseDouble(a);}catch(Exception e){amount.setError("Enter a valid amount");return;} if(!Double.isFinite(value)||value<=0){amount.setError("Amount must be greater than zero");return;}
 String kind=type.getCheckedRadioButtonId()==R.id.rbIncome?"INCOME":"EXPENSE"; if(c.isEmpty())c="General";
 String date=new SimpleDateFormat("yyyy-MM-dd",Locale.US).format(new Date());
 if(editId==-1)vm.add(new TransactionEntity(t,value,kind,c,date,n));else{TransactionEntity updated=new TransactionEntity(t,value,kind,c,date,n);updated.id=editId;vm.update(updated);}
 Toast.makeText(this,editId==-1?"Transaction saved":"Transaction updated",Toast.LENGTH_SHORT).show();finish(); }
 private String text(TextInputEditText e){return e.getText()==null?"":e.getText().toString().trim();}
}
