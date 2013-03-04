package eregister



import org.junit.*
import grails.test.mixin.*

@TestFor(RegisterentryController)
@Mock(Registerentry)
class RegisterentryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/registerentry/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.registerentryInstanceList.size() == 0
        assert model.registerentryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.registerentryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.registerentryInstance != null
        assert view == '/registerentry/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/registerentry/show/1'
        assert controller.flash.message != null
        assert Registerentry.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/registerentry/list'

        populateValidParams(params)
        def registerentry = new Registerentry(params)

        assert registerentry.save() != null

        params.id = registerentry.id

        def model = controller.show()

        assert model.registerentryInstance == registerentry
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/registerentry/list'

        populateValidParams(params)
        def registerentry = new Registerentry(params)

        assert registerentry.save() != null

        params.id = registerentry.id

        def model = controller.edit()

        assert model.registerentryInstance == registerentry
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/registerentry/list'

        response.reset()

        populateValidParams(params)
        def registerentry = new Registerentry(params)

        assert registerentry.save() != null

        // test invalid parameters in update
        params.id = registerentry.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/registerentry/edit"
        assert model.registerentryInstance != null

        registerentry.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/registerentry/show/$registerentry.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        registerentry.clearErrors()

        populateValidParams(params)
        params.id = registerentry.id
        params.version = -1
        controller.update()

        assert view == "/registerentry/edit"
        assert model.registerentryInstance != null
        assert model.registerentryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/registerentry/list'

        response.reset()

        populateValidParams(params)
        def registerentry = new Registerentry(params)

        assert registerentry.save() != null
        assert Registerentry.count() == 1

        params.id = registerentry.id

        controller.delete()

        assert Registerentry.count() == 0
        assert Registerentry.get(registerentry.id) == null
        assert response.redirectedUrl == '/registerentry/list'
    }
}
