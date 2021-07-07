package com.cristiano.app10_cadastrodevs

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var stack: Stack
    lateinit var nivel: Nivel
    lateinit var spinnerNivel: Spinner
    lateinit var edtNome: EditText
    lateinit var edtEmail: EditText
    lateinit var btnSalvar: Button
    lateinit var imvFoto: ImageView
    var foto: Bitmap?=null
    lateinit var swtEmpregado: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        edtNome = findViewById(R.id.edtNome)
        edtEmail = findViewById(R.id.edtEmail)
        spinnerNivel = findViewById(R.id.spnSenioridade)
        btnSalvar = findViewById(R.id.btnSalvar)
        imvFoto = findViewById(R.id.imvFoto)
        swtEmpregado = findViewById(R.id.swtEmpregado)
        imvFoto.setOnClickListener(){
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null)
                startActivityForResult(intent, RC_CAMERA)
        }

        ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerNivel.adapter = arrayAdapter
        }
        spinnerNivel.onItemSelectedListener = this

        btnSalvar.setOnClickListener(){
            val usuario = User(foto, edtNome.text.toString(), edtEmail.text.toString(), stack, nivel, swtEmpregado.isChecked)
            MainActivity.lista.add(usuario)
            finish()
        }
    }

    fun OnStackClick(view: View){
        if (view is RadioButton){
            var checked = view.isChecked

            when (view.id){
                R.id.rdbFrontEnd -> { if (checked) {stack = Stack.FRONTEND}}
                R.id.rdbBackEnd -> { if (checked) {stack = Stack.BACKEND}}
                R.id.rdbFullStack -> { if (checked) {stack = Stack.FULLSTACK}}
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2){
            0 -> {nivel = Nivel.JUNIOR}
            1 -> {nivel = Nivel.PLENO}
            2 -> {nivel = Nivel.SENIOR}
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((resultCode == RESULT_OK) && (requestCode == RC_CAMERA)){
            foto = data?.extras?.get("data") as Bitmap
            imvFoto.setImageBitmap(foto)
        }
    }

    companion object{
        const val RC_CAMERA  = 12345
        const val RC_GALERIA = 67890
    }
}
