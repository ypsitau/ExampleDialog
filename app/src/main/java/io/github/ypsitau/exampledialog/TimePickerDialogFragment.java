package io.github.ypsitau.exampledialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), this, hour, minute, true);
		return timePickerDialog;
	}

	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		App.Printf("Picked time: %02d:%02d\n", hourOfDay, minute);
	}

}