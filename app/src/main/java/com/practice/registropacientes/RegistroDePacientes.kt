package com.practice.registropacientes

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RegistroDePacientes : AppCompatActivity() {
    lateinit var nombre:EditText
    lateinit var edad:EditText
    lateinit var registro:EditText
    lateinit var dni:EditText
    lateinit var btnRegistrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_de_pacientes)


        nombre = findViewById(R.id.etNombre)
        edad = findViewById(R.id.etEdad)
        registro = findViewById(R.id.etRegistro)
        dni = findViewById(R.id.etDni)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        val fab2 = findViewById<FloatingActionButton>(R.id.fab2)
        fab2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        enviar()

    }
    fun enviar(){
        btnRegistrar.setOnClickListener{
            if (nombre.text.isEmpty()){
                Toast.makeText(this, "Ponga un nombre por favor", Toast.LENGTH_SHORT).show()
            }else if (nombre.text.toString() == "Nadie"){
                Toast.makeText(this, "No se acepta la palabra Nadie", Toast.LENGTH_SHORT).show()
            }else if (edad.text.toString().isEmpty()){
                Toast.makeText(this, "Ponga su edad por favor", Toast.LENGTH_SHORT).show()
            }else if (edad.text.toString().toInt() < 18){
                Toast.makeText(this, "Tiene que ser mayor de edad para registrarse", Toast.LENGTH_SHORT).show()
            }else if (dni.text.length != 8){
                Toast.makeText(this, "EL dni tiene que ser de 8 digitos", Toast.LENGTH_SHORT).show()
            }else{
                val builder = AlertDialog.Builder(this)

                builder?.setMessage("¿Esta seguro de ingresar al paciente?")

                builder?.setPositiveButton(R.string.optionSi,
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(this, "Paciente registrado con éxito", Toast.LENGTH_LONG).show()
                        nombre.setText("")
                        edad.setText("")
                        registro.setText("")
                        dni.setText("")
                    })

                builder?.setNegativeButton(R.string.optionNo, null)

                val dialog: AlertDialog? = builder?.create()
                dialog?.show()

            }
        }
    }

}
