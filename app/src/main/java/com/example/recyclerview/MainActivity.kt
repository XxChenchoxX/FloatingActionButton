package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvAlumnos: RecyclerView
    private lateinit var alumnoAdapter: AlumnoAdapter
    private val alumnos = mutableListOf<Alumno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAlumnos = findViewById(R.id.rvAlumnos)
        rvAlumnos.layoutManager = LinearLayoutManager(this)
        alumnoAdapter = AlumnoAdapter(alumnos)
        rvAlumnos.adapter = alumnoAdapter

        // Add some sample data
        alumnos.add(Alumno("Ricardo Contreras", "20101545", "ricardo@example.com", R.drawable.bodoke))
        alumnos.add(Alumno("Humberto Gonzalez", "20162030", "humberto@example.com", R.drawable.tulio))
        alumnoAdapter.notifyDataSetChanged()

        val fabAddAlumno: FloatingActionButton = findViewById(R.id.fabAddAlumno)
        fabAddAlumno.setOnClickListener {

            alumnos.add(Alumno("New Student", "20200000", "new@example.com", R.drawable.default_image))
            alumnoAdapter.notifyItemInserted(alumnos.size - 1)
        }
    }
}