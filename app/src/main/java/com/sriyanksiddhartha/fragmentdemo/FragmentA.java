package com.sriyanksiddhartha.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

	private static final String TAG = FragmentA.class.getSimpleName();

	private Button btnAdd;
	private TextView txvResult;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_a, container, false);

		// Retrieve the incoming Bundle Object
		Bundle bundle = getArguments();
		final int firstNumber = bundle.getInt("first_number", 0); // Assigned a default value as well
		final int secondNumber = bundle.getInt("second_number", 0);

		//or a better way
		/*final int firstNumber = bundle.getInt(Constants.FIRST_NUM, 0); // Assigned a default value as well
		final int secondNumber = bundle.getInt(Constants.SECOND_NUM, 0);*/

		txvResult = (TextView) view.findViewById(R.id.txvResult);

		btnAdd = (Button) view.findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				addTwoNumbers(firstNumber, secondNumber);
			}
		});

		return view;
	}

	private void addTwoNumbers(int firstNumber, int secondNumber) {

		int result = firstNumber + secondNumber;
		txvResult.setText("Result : " + result);
	}
}
