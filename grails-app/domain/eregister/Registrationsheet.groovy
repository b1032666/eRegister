package eregister

class Registrationsheet {

   Date dateSigned
   RegClass regClass
   Set registerSheet

   static hasMany=[registersheet:Registerentry]
   static mappedBy=[registersheet:'registrationsheet']

    static constraints = {
    }
}
