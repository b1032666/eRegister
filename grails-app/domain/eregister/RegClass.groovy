package eregister

class RegClass {

   String classId
   Instructor classInstructor
   Course course
   Set registerClass

   static hasMany=[registerClass:Enrollment, registerClass:Registrationsheet]
   static mappedBy=[registerClass:'regClass', registerClass:'regClass']

    static constraints = {
    }
}
