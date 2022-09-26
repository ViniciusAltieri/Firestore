package com.example.crud

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome: EditText = findViewById(R.id.nomeEdit)
        val edtEndereco: EditText = findViewById(R.id.enderecoEdit)
        val edtSobrenome: EditText = findViewById(R.id.sobrenomeEdit)
        val btnCadastrar: Button = findViewById(R.id.btnCadastro)

        btnCadastrar.setOnClickListener {
            val pessoa = hashMapOf(
                "nome" to edtNome.text.toString(),
                "endereco" to edtEndereco.text.toString(),
                "sobrenome" to edtSobrenome.text.toString(),
            )

            db.collection("cadastro")
                .add(pessoa)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    Toast.makeText(this, "Pessoa cadastrada com ID: ${documentReference.id}", Toast.LENGTH_SHORT).show()
                }
    }
}
}