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
			final Button view = findViewById(R.id.button_MessageDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = MessageDialogFragment.newInstance(
							"sample title", "sample message");
					dlgFrag.show(getSupportFragmentManager(), "MessageDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_OKDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new OKDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "OKDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_OKCancelDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new OKCancelDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "OKCancelDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_YesNoCancelDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new YesNoCancelDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "YesNoCancelDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_SelectorDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new SelectorDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "SelectorDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_SingleChoiceDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new SingleChoiceDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "SingleChoiceDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_MultiplChoiceDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new MultipleChoiceDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "MultipleChoiceDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_DatePickerDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new DatePickerDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "DatePickerDialog");
				}
			});
		}
		{
			final Button view = findViewById(R.id.button_TimePickerDialog);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DialogFragment dlgFrag = new TimePickerDialogFragment();
					dlgFrag.show(getSupportFragmentManager(), "TimePickerDialog");
				}
			});
		}
		App.setLogEditText((EditText)findViewById(R.id.editText_log), false);
	}

	public static class MessageDialogFragment extends DialogFragment {
		static final String KEY_TITLE = "TITLE";
		static final String KEY_MESSAGE = "MESSAGE";
		public static DialogFragment newInstance(String title, String message) {
			DialogFragment dlgFrag = new MessageDialogFragment();
			Bundle args = new Bundle();
			args.putString(KEY_TITLE, title);
			args.putString(KEY_MESSAGE, message);
			dlgFrag.setArguments(args);
			return dlgFrag;
		}
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			Bundle args = getArguments();
			return new AlertDialog.Builder(activity)
					.setTitle(args.getString(KEY_TITLE))
					.setMessage(args.getString(KEY_MESSAGE))
					.setPositiveButton(android.R.string.ok, null)
					.create();
		}
	}

	public static class OKDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			Bundle args = getArguments();
			return new AlertDialog.Builder(activity)
					.setTitle("OK Dialog")
					.setMessage("message")
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_OKDialogFragment();
						}
					})
					.create();
		}
	}

	void onPositive_OKDialogFragment() {
		App.Printf("OK Dialog: Positive\n");
	}

	public static class OKCancelDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("OKCancel Dialog")
					.setMessage("Message")
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_OKCancelDialogFragment();
						}
					})
					.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onNegative_OKCancelDialogFragment();
						}
					})
					.create();
		}
	}

	void onPositive_OKCancelDialogFragment() {
		App.Printf("OKCancel Dialog: Positive\n");
	}

	void onNegative_OKCancelDialogFragment() {
		App.Printf("OKCancel Dialog: Negative\n");
	}

	public static class YesNoCancelDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final MainActivity activity = (MainActivity)getActivity();
			return new AlertDialog.Builder(activity)
					.setTitle("YesNoCancel Dialog")
					.setMessage("Message")
					.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onPositive_YesNoCancelDialogFragment();
						}
					})
					.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onNegative_YesNoCancelDialogFragment();
						}
					})
					.setNeutralButton(R.string.Cancel, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.onNeutral_YesNoCancelDialogFragment();
						}
					})
					.create();
		}
	}

	void onPositive_YesNoCancelDialogFragment() {
		App.Printf("YesNoCancel Dialog: Positive\n");
	}

	void onNegative_YesNoCancelDialogFragment() {
		App.Printf("YesNoCancel Dialog: Negative\n");
	}

	void onNeutral_YesNoCancelDialogFragment() {
		App.Printf("YesNoCancel Dialog: Neutral\n");
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
					.setTitle("Selector Dialog")
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
		App.Printf("Selector Dialog: %s\n", item);
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
					.setTitle("SingleChoice Dialog")
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
		App.Printf("SingleChoice Dialog: %s\n", item);
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
					.setTitle("MultipleChoice Dialog")
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
		App.Printf("MultipleChoice Dialog: %s\n", str);
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
		App.Printf("DatePicker Dialog: %04d-%02d-%02d\n", year, month + 1, day);
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
		App.Printf("TimePicker Dialog: %02d:%02d\n", hourOfDay, minute);
	}
}
