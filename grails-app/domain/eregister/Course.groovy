package eregister

class Course {

   String courseId
   String courseName
   String courseDescription
   Set courseClasses

   static hasMany=[courseClasses:RegClass]
   static mappedBy=[courseClasses:'course']

    static constraints = {
    }
}
