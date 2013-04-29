package eregister

class Student {

   String fullStudentName
   String studentNumber
   Set students

   static hasMany=[students:Enrollment, students:Registerentry]
   static mappedBy=[students:'student', students:'student']

    static constraints = {
    }
}
