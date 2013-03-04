package eregister



import org.junit.*
import grails.test.mixin.*

@TestFor(RegistrationsheetController)
@Mock(Registrationsheet)
class RegistrationsheetControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/registrationsheet/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.registrationsheetInstanceList.size() == 0
        assert model.registrationsheetInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.registrationsheetInstance != null
    }

    void testSave() {
        controller.save()

        assert model.registrationsheetInstance != null
        assert view == '/registrationsheet/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/registrationsheet/show/1'
        assert controller.flash.message != null
        assert Registrationsheet.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/registrationsheet/list'

        populateValidParams(params)
        def registrationsheet = new Registrationsheet(params)

        assert registrationsheet.save() != null

        params.id = registrationsheet.id

        def model = controller.show()

        assert model.registrationsheetInstance == registrationsheet
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/registrationsheet/list'

        populateValidParams(params)
        def registrationsheet = new Registrationsheet(params)

        assert registrationsheet.save() != null

        params.id = registrationsheet.id

        def model = controller.edit()

        assert model.registrationsheetInstance == registrationsheet
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/registrationsheet/list'

        response.reset()

        populateValidParams(params)
        def registrationsheet = new Registrationsheet(params)

        assert registrationsheet.save() != null

        // test invalid parameters in update
        params.id = registrationsheet.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/registrationsheet/edit"
        assert model.registrationsheetInstance != null

        registrationsheet.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/registrationsheet/show/$registrationsheet.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        registrationsheet.clearErrors()

        populateValidParams(params)
        params.id = registrationsheet.id
        params.version = -1
        controller.update()

        assert view == "/registrationsheet/edit"
        assert model.registrationsheetInstance != null
        assert model.registrationsheetInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/registrationsheet/list'

        response.reset()

        populateValidParams(params)
        def registrationsheet = new Registrationsheet(params)

        assert registrationsheet.save() != null
        assert Registrationsheet.count() == 1

        params.id = registrationsheet.id

        controller.delete()

        assert Registrationsheet.count() == 0
        assert Registrationsheet.get(registrationsheet.id) == null
        assert response.redirectedUrl == '/registrationsheet/list'
    }
}
