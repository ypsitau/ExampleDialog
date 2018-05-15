package io.github.ypsitau.exampledialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;

public class Popup {
	public static class OneButtonDlgFrag extends DialogFragment implements DialogInterface.OnClickListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
					.setTitle("Title")
					.setMessage("Message")
					.setPositiveButton("OK", this)
					.create();
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == DialogInterface.BUTTON_POSITIVE) {
				App.Printf("One Button: POSITIVE\n");
			}
		}
	}

	public static class TwoButtonsDlgFrag extends DialogFragment implements DialogInterface.OnClickListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
					.setTitle("Title")
					.setMessage("Message")
					.setPositiveButton("OK", this)
					.setNegativeButton("Cancel", this)
					.create();
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == DialogInterface.BUTTON_POSITIVE) {
				App.Printf("Two Buttons: POSITIVE\n");
			} else if (which == DialogInterface.BUTTON_NEGATIVE) {
				App.Printf("Two Buttons: NEGATIVE\n");
			}
		}
	}

	public static class ThreeButtonsDlgFrag extends DialogFragment implements DialogInterface.OnClickListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
					.setTitle("Title")
					.setMessage("Message")
					.setPositiveButton("OK", this)
					.setNegativeButton("Cancel", this)
					.setNeutralButton("Later", this)
					.create();
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == DialogInterface.BUTTON_POSITIVE) {
				App.Printf("Three Buttons: POSITIVE\n");
			} else if (which == DialogInterface.BUTTON_NEGATIVE) {
				App.Printf("Three Buttons: NEGATIVE\n");
			} else if (which == DialogInterface.BUTTON_NEUTRAL) {
				App.Printf("Three Buttons: NEUTRAL\n");
			}
		}
	}

	public static class SelectorDlgFrag extends DialogFragment implements DialogInterface.OnClickListener {
		static final String[] items = new String[]{
				"item #1",
				"item #2",
				"item #3",
				"item #4",
				"item #5",
		};

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
					.setTitle("Title")
					.setItems(items, this)
					.create();
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			App.Printf("Selector: %s\n", items[which]);
		}
	}

	public static class SingleChoiceDlgFrag extends DialogFragment implements DialogInterface.OnClickListener {
		static final String[] items = new String[]{
				"item #1",
				"item #2",
				"item #3",
				"item #4",
				"item #5",
		};

		int checkedItem = 0;

		@Override
		public Dialog onCreateDialog(Bundle savedInstancezState) {
			return new AlertDialog.Builder(getActivity())
					.setTitle("Title")
					.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							checkedItem = which;
						}
					})
					.setPositiveButton("OK", this)
					.create();
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			App.Printf("Choice: %s\n", items[checkedItem]);
		}
	}

	public static class DatePickerDlgFrag extends DialogFragment implements DatePickerDialog.OnDateSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), this, year, month, dayOfMonth);
		}

		@Override
		public void onDateSet(DatePicker view, int year, int month, int day) {
			App.Printf("Picked data: %04d-%02d-%02d\n", year, month + 1, day);
		}
	}

	public static class TimePickerDlgFrag extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			return new TimePickerDialog(getActivity(), this, hour, minute, true);
		}

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			App.Printf("Picked time: %02d:%02d\n", hourOfDay, minute);
		}

	}

}
