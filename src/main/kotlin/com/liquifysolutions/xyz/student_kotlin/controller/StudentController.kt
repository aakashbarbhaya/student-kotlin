package com.liquifysolutions.xyz.student_kotlin.controller

import com.liquifysolutions.xyz.student_kotlin.model.Student
import com.liquifysolutions.xyz.student_kotlin.service.StudentService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api/v1/students")
class StudentController(
    private val studentService: StudentService
) {
    @GetMapping("/get/{id}")
    fun getStudentById(
        @PathVariable id: String
    ): ResponseEntity<Student> {
        try {
            val student = studentService.getStudentById(id=id)
            return ResponseEntity.ok(student)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }



    @PostMapping("/create")
    fun createStudent(@RequestBody student: Student): Student {
        return studentService.createStudent(student)
    }
}