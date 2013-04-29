package eregister

class Instructor {

   String instructorId
   String instructorName
   Set classesTaught

   static hasMany=[classesTaught:RegClass]
   static mappedBy=[classesTaught:'classInstructor']

    static constraints = {
    }
}
