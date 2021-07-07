package com.cristiano.app10_cadastrotarefas

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*

class CadastroActivity : AppCompatActivity() {

    lateinit var edtTitulo: EditText
    lateinit var edtDescricao: EditText
    lateinit var btnSalvar: Button
    lateinit var imvFoto: ImageView
    var foto: Bitmap?=null
    lateinit var swtFinalizado: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        edtTitulo = findViewById(R.id.edtTitulo)
        edtDescricao = findViewById(R.id.edtDescricao)
        btnSalvar = findViewById(R.id.btnSalvar)
        imvFoto = findViewById(R.id.imvFoto)
        swtFinalizado = findViewById(R.id.swtFinalizado)

        imvFoto.setOnClickListener(){
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(packageManager) != null)
                startActivityForResult(intent, RC_CAMERA)
        }

        btnSalvar.setOnClickListener(){
            val tarefa = Tarefa(foto, edtTitulo.text.toString(), edtDescricao.text.toString(), swtFinalizado.isChecked)
            MainActivity.lista.add(tarefa)
            finish()
        }
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