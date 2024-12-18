package com.liquifysolutions.xyz.student_kotlin.service

import com.liquifysolutions.xyz.student_kotlin.model.Student
import com.liquifysolutions.xyz.student_kotlin.repository.CustomStudentRepository
import com.liquifysolutions.xyz.student_kotlin.repository.StudentRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val customStudentRepository: CustomStudentRepository
) {

    fun createStudent(student: Student): Student {
        val newStudent = student.copy(
            id = UUID.randomUUID().toString()
        )
        return studentRepository.save(newStudent)
    }

    fun getStudentById(id: String): Student {
        val studentInDb = studentRepository.findById(id)
        if (studentInDb.isPresent) {
            return studentInDb.get()
        } else {
            throw IllegalStateException("Student with id $id not found")
        }
    }

    fun listStudents(
        nameSearch: String? = null,
        age: Int? = null,
        assignedClass: String? = null,
    ): List<Student> {
        val students = customStudentRepository.searchAndFilter(
            name = nameSearch,
            age = age,
            assignedClass = assignedClass,
        )
        return students
    }
}