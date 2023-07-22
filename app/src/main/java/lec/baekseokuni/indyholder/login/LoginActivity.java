package lec.baekseokuni.indyholder.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import lec.baekseokuni.indyholder.MainActivity;
import lec.baekseokuni.indyholder.credential.CredentialListActivity;
import lec.baekseokuni.indyholder.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBtn.setOnClickListener(v->{
            String name = binding.UserID.getText().toString();
            SharedPreferences pref = getSharedPreferences("NAME_PREFERENCE", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("NAME",name);
            editor.apply();
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
