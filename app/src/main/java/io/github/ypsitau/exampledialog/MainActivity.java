package io.github.ypsitau.exampledialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

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
					DialogFragment dlgFrag = new OneButtonDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "OneButton");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_twoButtons);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new TwoButtonsDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "TwoButtons");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_threeButtons);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new ThreeButtonsDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "ThreeButtons");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_selector);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new SelectorDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "Selector");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_singleChoice);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new SingleChoiceDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "SingleChoice");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_multipleChoice);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new MultipleChoiceDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "MultipleChoice");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_date);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new DatePickerDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "DatePicker");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_time);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new TimePickerDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "TimePicker");
				}
			});
		}
		App.setLogEditText((EditText)findViewById(R.id.editText_log), false);
	}

	public static class OneButtonDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("Title")
					.setMessage("Message")
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_OneButtonDialogFragment();
						}
					})
					.create();
		}
	}

	void onPositive_OneButtonDialogFragment() {
		App.Printf("One Button: Positive\n");
	}

	public static class TwoButtonsDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("Title")
					.setMessage("Message")
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_TwoButtonsDialogFragment();
						}
					})
					.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onNegative_TwoButtonsDialogFragment();
						}
					})
					.create();
		}
	}

	void onPositive_TwoButtonsDialogFragment() {
		App.Printf("Two Buttons: Positive\n");
	}

	void onNegative_TwoButtonsDialogFragment() {
		App.Printf("Two Buttons: Negative\n");
	}

	public static class ThreeButtonsDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("Title")
					.setMessage("Message")
					.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_ThreeButtonsDialogFragment();
						}
					})
					.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onNegative_ThreeButtonsDialogFragment();
						}
					})
					.setNeutralButton(R.string.Cancel, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onNeutral_ThreeButtonsDialogFragment();
						}
					})
					.create();
		}
	}

	void onPositive_ThreeButtonsDialogFragment() {
		App.Printf("Three Buttons: Positive\n");
	}

	void onNegative_ThreeButtonsDialogFragment() {
		App.Printf("Three Buttons: Negative\n");
	}

	void onNeutral_ThreeButtonsDialogFragment() {
		App.Printf("Three Buttons: Neutral\n");
	}

	public static class SelectorDialogFragment extends DialogFragment {
		static final String[] items = new String[]{
				"item #1",
				"item #2",
				"item #3",
				"item #4",
				"item #5",
		};

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("Title")
					.setItems(items, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_SelectorDialogFragment(items[which]);
						}
					})
					.create();
		}
	}

	void onPositive_SelectorDialogFragment(String item) {
		App.Printf("Selector: %s\n", item);
	}

	public static class SingleChoiceDialogFragment extends DialogFragment {
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
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("Title")
					.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							checkedItem = which;
						}
					})
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_SingleChoiceDialogFragment(items[checkedItem]);
						}
					})
					.create();
		}
	}

	void onPositive_SingleChoiceDialogFragment(String item) {
		App.Printf("Single Choice: %s\n", item);
	}

	public static class MultipleChoiceDialogFragment extends DialogFragment {
		static final String[] items = new String[]{
				"item #1",
				"item #2",
				"item #3",
				"item #4",
				"item #5",
		};

		ArrayList<Integer> selectedItems;

		@Override
		public Dialog onCreateDialog(Bundle savedInstancezState) {
			selectedItems = new ArrayList<Integer>();
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("Title")
					.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							if (isChecked) {
								selectedItems.add(which);
							} else {
								selectedItems.remove(Integer.valueOf(which));
							}
						}
					})
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_MultipleChoiceDialogFragment(selectedItems);
						}
					})
					.create();
		}
	}

	void onPositive_MultipleChoiceDialogFragment(ArrayList<Integer> selectedItems) {
		String str = "";
		for (Integer selectedItem : selectedItems) {
			if (!str.isEmpty()) str += ",";
			str += MultipleChoiceDialogFragment.items[selectedItem];
		}
		App.Printf("Multiple Choice: %s\n", str);
	}

	public static class DatePickerDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			final Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
					activity.onPositive_DatePickerDialogFragment(year, month, dayOfMonth);
				}
			}, year, month, dayOfMonth);
		}
	}

	void onPositive_DatePickerDialogFragment(int year, int month, int day) {
		App.Printf("Date Picker: %04d-%02d-%02d\n", year, month + 1, day);
	}

	public static class TimePickerDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			final Calendar calendar = Calendar.getInstance();
			int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					activity.onPositive_TimePickerDialogFragment(hourOfDay, minute);
				}
			}, hourOfDay, minute, true);
		}
	}

	void onPositive_TimePickerDialogFragment(int hourOfDay, int minute) {
		App.Printf("Time Picker: %02d:%02d\n", hourOfDay, minute);
	}
}
