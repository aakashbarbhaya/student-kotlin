package com.liquifysolutions.xyz.student_kotlin.repository

import com.liquifysolutions.xyz.student_kotlin.model.Student
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : MongoRepository<Student, String>

@Component
class CustomStudentRepository(private val mongoTemplate: MongoTemplate) {
    fun searchAndFilter(
        name: String?,
        age: Int?,
        assignedClass: String?
    ): List<Student> {
        val query = Query()
        if (!name.isNullOrEmpty()) {
            query.addCriteria(Criteria.where("name").regex(name, "i"))
        }
        if (age != null) {
            query.addCriteria(Criteria.where("age").`is`(age))
        }
        if (!assignedClass.isNullOrEmpty()) {
            query.addCriteria(Criteria.where("assignedClass").`is`(assignedClass))
        }
        return mongoTemplate.find(query, Student::class.java)
    }
}