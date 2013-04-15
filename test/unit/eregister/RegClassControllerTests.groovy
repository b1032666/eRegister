package eregister



import org.junit.*
import grails.test.mixin.*

@TestFor(RegClassController)
@Mock(RegClass)
class RegClassControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/regClass/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.regClassInstanceList.size() == 0
        assert model.regClassInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.regClassInstance != null
    }

    void testSave() {
        controller.save()

        assert model.regClassInstance != null
        assert view == '/regClass/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/regClass/show/1'
        assert controller.flash.message != null
        assert RegClass.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/regClass/list'

        populateValidParams(params)
        def regClass = new RegClass(params)

        assert regClass.save() != null

        params.id = regClass.id

        def model = controller.show()

        assert model.regClassInstance == regClass
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/regClass/list'

        populateValidParams(params)
        def regClass = new RegClass(params)

        assert regClass.save() != null

        params.id = regClass.id

        def model = controller.edit()

        assert model.regClassInstance == regClass
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/regClass/list'

        response.reset()

        populateValidParams(params)
        def regClass = new RegClass(params)

        assert regClass.save() != null

        // test invalid parameters in update
        params.id = regClass.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/regClass/edit"
        assert model.regClassInstance != null

        regClass.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/regClass/show/$regClass.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        regClass.clearErrors()

        populateValidParams(params)
        params.id = regClass.id
        params.version = -1
        controller.update()

        assert view == "/regClass/edit"
        assert model.regClassInstance != null
        assert model.regClassInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/regClass/list'

        response.reset()

        populateValidParams(params)
        def regClass = new RegClass(params)

        assert regClass.save() != null
        assert RegClass.count() == 1

        params.id = regClass.id

        controller.delete()

        assert RegClass.count() == 0
        assert RegClass.get(regClass.id) == null
        assert response.redirectedUrl == '/regClass/list'
    }
}
