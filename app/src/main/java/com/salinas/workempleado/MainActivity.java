package com.salinas.workempleado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.salinas.workempleado.model.Empleado;

public class MainActivity extends AppCompatActivity {
    private EditText nombreEditText;
    private Spinner tipoEmpleadoSpinner;
    private EditText horasTrabajadasEditText;
    private EditText cuotaPorHoraEditText;
    private TextView sueldoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEditText = findViewById(R.id.nombre_edit_text);
        tipoEmpleadoSpinner = findViewById(R.id.tipo_empleado_spinner);
        horasTrabajadasEditText = findViewById(R.id.horas_trabajadas_edit_text);
        cuotaPorHoraEditText = findViewById(R.id.cuota_por_hora_edit_text);
        sueldoTextView = findViewById(R.id.sueldo_text_view);

        ArrayAdapter<CharSequence> tipoEmpleadoAdapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_empleado_array, android.R.layout.simple_spinner_item);
        tipoEmpleadoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoEmpleadoSpinner.setAdapter(tipoEmpleadoAdapter);

        findViewById(R.id.calcular_button).setOnClickListener(v -> calcularSueldo());
    }

    private void calcularSueldo() {
        String nombre = nombreEditText.getText().toString();
        int tipoEmpleado = tipoEmpleadoSpinner.getSelectedItemPosition() + 1;
        int horasTrabajadas = Integer.parseInt(horasTrabajadasEditText.getText().toString());
        double cuotaPorHora = Double.parseDouble(cuotaPorHoraEditText.getText().toString());

        Empleado empleado = new Empleado(nombre, tipoEmpleado, horasTrabajadas, cuotaPorHora);
        double sueldo = empleado.calcularSueldo();
        sueldoTextView.setText(String.format("El sueldo a pagar es: $%.2f", sueldo));
    }
}
