package io.github.ypsitau.exampledialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, dayOfMonth);
		return datePickerDialog;
	}

	public void onDateSet(DatePicker view, int year, int month, int day) {
		App.Printf("Picked data: %04d-%02d-%02d\n", year, month + 1, day);
	}
}
