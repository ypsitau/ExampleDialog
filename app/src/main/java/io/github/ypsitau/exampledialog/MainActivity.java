package io.github.ypsitau.exampledialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button_date = findViewById(R.id.button_date);
		Button button_time = findViewById(R.id.button_time);
		Button button_alert = findViewById(R.id.button_alert);
		button_date.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DatePickerDialogFragment dlgFrag = new DatePickerDialogFragment();
				dlgFrag.show(getFragmentManager(), "datePicker");
			}
		});
		button_time.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TimePickerDialogFragment dlgFrag = new TimePickerDialogFragment();
				dlgFrag.show(getFragmentManager(), "timePicker");
			}
		});
		button_alert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
				dlg.setTitle("AlertDialog Test");
				dlg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				dlg.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				dlg.show();
			}
		});
		App.setLogEditText((EditText)findViewById(R.id.editText_log), false);
	}
}
