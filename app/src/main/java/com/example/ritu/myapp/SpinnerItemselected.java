package com.example.ritu.myapp;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by ritu on 16-07-2015.
 */


    public class SpinnerItemselected implements AdapterView.OnItemSelectedListener {

    String SelectedText=null;

    public String getSelectedText() {
        return SelectedText;
    }

    public void setSelectedText(String selectedText) {
        SelectedText = selectedText;
    }

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p/>
     * Impelmenters can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    this.SelectedText= parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
