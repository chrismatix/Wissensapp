package com.example.wissensapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IntroFragment extends Fragment
{
	OnModeSelectedListener Callback;
	
	public interface OnModeSelectedListener 
	{        
		public void OnModeSelect (View view);   
	}
	
	@Override    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,         
			Bundle savedInstanceState) 
	{   
		// Layout         
		return inflater.inflate(R.layout.intro, container, false);    
	}
	
	@Override
	public void onAttach(Activity activity) 
	{        
		super.onAttach(activity);                
		// This makes sure that the container activity has implemented        
		// the callback interface. If not, it throws an exception        
		try 
		{            
			Callback = (OnModeSelectedListener) activity;        
		} catch (ClassCastException e) 
		{            
			throw new ClassCastException(activity.toString()  + " must implement OnModeSelectedListener");       
		}    
	}
	
}
