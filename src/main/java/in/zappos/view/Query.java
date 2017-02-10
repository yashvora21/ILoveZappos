package in.zappos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.zappos.controller.MainActivity;
import in.zappos.R;

public class Query extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        final EditText editText = (EditText) findViewById(R.id.edit_query);
        Button button = (Button) findViewById(R.id.bt_query);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("query", editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}
