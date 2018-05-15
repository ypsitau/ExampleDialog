package io.github.ypsitau.exampledialog;

import android.app.DialogFragment;
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
		{
			final Button view = findViewById(R.id.button_oneButton);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.MessageOK();
					dlgFrag.show(getFragmentManager(), "OneButton");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_twoButtons);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.MessageOKCancel();
					dlgFrag.show(getFragmentManager(), "TwoButtons");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_threeButtons);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.MessageYesNoCancel();
					dlgFrag.show(getFragmentManager(), "ThreeButtons");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_selector);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.Selector();
					dlgFrag.show(getFragmentManager(), "Selector");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_singleChoice);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.SingleChoice();
					dlgFrag.show(getFragmentManager(), "SingleChoice");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_multipleChoice);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.MultipleChoice();
					dlgFrag.show(getFragmentManager(), "MultipleChoice");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_date);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.DatePicker();
					dlgFrag.show(getFragmentManager(), "DatePicker");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_time);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new Popup.TimePicker();
					dlgFrag.show(getFragmentManager(), "TimePicker");
				}
			});
		}
		App.setLogEditText((EditText)findViewById(R.id.editText_log), false);
	}
}
