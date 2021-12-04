package com.pthl;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;


public class DatePickerDialogFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    //private Calendar myCalendar = Calendar.getInstance();



    static public DatePickerDialogFragment newInstance(DatePickerDialog.OnDateSetListener onDateSetListener) {
        DatePickerDialogFragment pickerFragment = new DatePickerDialogFragment();
        pickerFragment.setOnDateSetListener(onDateSetListener);

        //Pass the date in a bundle.
        Bundle bundle = new Bundle();
        pickerFragment.setArguments(bundle);
        return pickerFragment;
    }

   /* DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        }
        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), dateListener, myCalendar
            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH));

        //following line to restrict future date selection
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();

    };*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        Calendar cal = Calendar.getInstance();
        return new DatePickerDialog(getActivity(),
            onDateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH));
    }

  /*  @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Calendar c = Calendar.getInstance();
        int cyear = c.get(Calendar.YEAR);
        int cmonth = c.get(Calendar.MONTH);
        int cday = c.get(Calendar.DAY_OF_MONTH);

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                // set maximum date to be selected as today
                datePicker.getDatePicker().setMaxDate(cal.getTimeInMillis());

                // show the dialog
                datePicker.show();
            }
        }


    }*/





    private void setOnDateSetListener(DatePickerDialog.OnDateSetListener listener) {
        this.onDateSetListener = listener;
    }
}
