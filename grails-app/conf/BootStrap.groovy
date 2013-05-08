import eregister.*;

class BootStrap {

    def init = { servletContext ->
	
	println("bootstrap :: init");
	println("Insert all test/reference data! If it is needed..");

	def instructor_ian = Instructor.findByInstructorId('123654') ?: new Instructor(instructorId:'123654', instructorName:'Ian Ibbotson').save();
	def instructor_matthew = Instructor.findByInstructorId('456321') ?: new Instructor(instructorId:'456321', instructorName:'Matthew Love').save();

	def student_john = Student.findByStudentNumber('21032666') ?: new Student(studentNumber:'21032666', fullStudentName:'John Robert Halsey').save();
	def student_andrew = Student.findByStudentNumber('21002980') ?: new Student(studentNumber:'21002980', fullStudentName:'Andrew Christopher Robert Saxton').save();

	def course_webarch = Course.findByCourseId('1337') ?: new Course(courseId:'1337',
									 courseName:'Web Architectures',
									 courseDescription:'Damn this assignment!! It hard.').save();

	def new_class = RegClass.findByClassId('WebArchMon101') ?:new RegClass(classId:'WebArchMon101',classInstructor:instructor_ian, course:course_webarch).save();

     }
    def destroy = {
     }
}
