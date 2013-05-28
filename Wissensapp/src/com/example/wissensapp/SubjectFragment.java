package com.example.wissensapp;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class SubjectFragment extends ListFragment 
{   
	// Der Callback zur Motheractivity
	OnSubjectSelectedListener	mCallback;
	
	public interface OnSubjectSelectedListener
	{
		public void OnSubjectSelected (String sSubject);
	}
	
	static String[] SubjectNames = 
		{ 
			"Mathematik", 
			"Deutsch", 
			"Physik", 
			"Chemie", 
			"Englisch", 
			"Französisch",
		};
	
	@Override 
	public void onCreate (Bundle savedInstanceState) 
	{    
		super.onCreate(savedInstanceState);
		
		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
		
		setListAdapter (new ArrayAdapter<String> (getActivity(), layout, SubjectNames));	
	}    
	
	@Override
    public void onAttach(Activity activity) 
	{
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnSubjectSelectedListener) activity;
        } catch (ClassCastException e) 
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }   
		
	protected void OnListItemClick (ListView lv, View v, int position, long id)
	{
		//super.onListItemClick(lv, v, position, id);	
		
		mCallback.OnSubjectSelected(SubjectNames[position]);
	}
}

