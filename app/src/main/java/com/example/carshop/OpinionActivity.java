package com.example.carshop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//Librerias de SQLite
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class OpinionActivity extends AppCompatActivity {

    //Declarar variables
    Spinner spSpinner;
    String[] comunas = new String[]{"Enlace", "Macul", "San Miguel", "Lampa", "La Florida"};
    EditText edtRut, edtNom;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);

        //Defino los campos del formulario
        edtRut = (EditText) findViewById(R.id.edtRut);
        edtNom = (EditText) findViewById(R.id.edtNom);
        lista = (ListView) findViewById(R.id.lstLista);

    }

    public void CargarLista(){
        DataHelper dh = new DataHelper(this, "alumno.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        Cursor c = bd.rawQuery("Select rut, nombre, direccion, comuna from alumno", null);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst() == true){
            int i = 0;
            do{
                String linea = "||" + c.getInt(0) + "||" + c.getString(1)
                        + "||" + c.getString(2) + "||" + c.getString(3) + "||";
                arr[i] = linea;
                i++;
            }while (c.moveToNext() == true);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_expandable_list_item_1, arr);
            lista.setAdapter(adapter);
            bd.close();
        }
    }

    public void onClickAgregar (View view){
        DataHelper dh=new DataHelper(this, "alumno.db", null, 1);
        SQLiteDatabase bd= dh.getWritableDatabase();
        ContentValues reg= new ContentValues();
        reg.put("rut", edtRut.getText().toString());
        reg.put("nombre", edtNom.getText().toString());
        long resp = bd.insert("alumno", null, reg);
        bd.close();
        if(resp==-1){
            Toast.makeText(this,"No se ´puede ingresar el alumno", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Registro Agregado", Toast.LENGTH_LONG).show();
        }
        CargarLista();
    }

    public void limpiar() {
        edtRut.setText("");
        edtNom.setText("");
    }

    public void onClickModificar(View view){
        //Conectamos la BDD para manipular la tabla y registro
        DataHelper dh = new DataHelper(this,"alumno.db",null,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        //Ingresa las nuevas datos a modificar de un rut especifico
        reg.put("rut", edtRut.getText().toString());
        reg.put("nombre",edtNom.getText().toString());
        //Actualizo el registro en la tabla de la 800
        long respuesta = bd.update("alumno",reg,"rut=?",new String[]{edtRut.getText().toString()});
        bd.close();
        //Se verifica la consulta se ejecuta
        if (respuesta == -1){
            Toast.makeText(this,"Dato no modificado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Dato modificado",Toast.LENGTH_LONG).show();
        }
        limpiar();
        CargarLista();
    }
    public void onClickEliminar(View view){
        //Conectamos la base de datos y la tabla registro
        DataHelper dh = new DataHelper(this,"alumno.db",null,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        //Guardar el rut ingresado
        String rutEliminar = edtRut.getText().toString();
        //Ejecuta la query DELETE para eliminar un registro
        long respuesta = bd.delete("alumno","rut=" + rutEliminar, null);
        bd.close();
        //Verifico si se ejecuta la consula SQL
        if (respuesta == -1){
            Toast.makeText(this,"Registro no eliminado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Registro eliminado",Toast.LENGTH_LONG).show();
        }
        limpiar();
        CargarLista();
    }
}
