package com.example.wissensapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 

implements 
IntroFragment.OnModeSelectedListener,
SubjectFragment.OnSubjectSelectedListener
{
	
	// Fragments
	IntroFragment	Intro;
	SubjectFragment Subjects;
	
	// andere Variabeln
	private int			smode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if ( findViewById(R.id.fragment_container) != null)
		{
			if ( savedInstanceState != null)
				return;
			
			Intro = new IntroFragment ();
			
			getFragmentManager().beginTransaction()
			.add(R.id.fragment_container, Intro).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// Callback des IntroFragments
	public void OnModeSelect (View view)
	{
		// Das Subjects Fragment initialisieren
		Subjects = new SubjectFragment ();
		
		// Der geklickte Button wird mittels seiner Id identifiziert
		smode = view.getId();
		
		if ( smode != R.id.SonstigesButton )
		{
			// Fragments auswechseln
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
		
			transaction.replace(R.id.fragment_container, Subjects);
			transaction.addToBackStack(null);
		
			transaction.commit ();
		} 
	}
	
	// Callback des Subject Fragments
	public void OnSubjectSelected (String sSubject)
	{
		
	}

}
