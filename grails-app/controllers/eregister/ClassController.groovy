package eregister

import org.springframework.dao.DataIntegrityViolationException

class ClassController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [classInstanceList: Class.list(params), classInstanceTotal: Class.count()]
    }

    def create() {
        [classInstance: new Class(params)]
    }

    def save() {
        def classInstance = new Class(params)
        if (!classInstance.save(flush: true)) {
            render(view: "create", model: [classInstance: classInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'class.label', default: 'Class'), classInstance.id])
        redirect(action: "show", id: classInstance.id)
    }

    def show(Long id) {
        def classInstance = Class.get(id)
        if (!classInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'class.label', default: 'Class'), id])
            redirect(action: "list")
            return
        }

        [classInstance: classInstance]
    }

    def edit(Long id) {
        def classInstance = Class.get(id)
        if (!classInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'class.label', default: 'Class'), id])
            redirect(action: "list")
            return
        }

        [classInstance: classInstance]
    }

    def update(Long id, Long version) {
        def classInstance = Class.get(id)
        if (!classInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'class.label', default: 'Class'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (classInstance.version > version) {
                classInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'class.label', default: 'Class')] as Object[],
                          "Another user has updated this Class while you were editing")
                render(view: "edit", model: [classInstance: classInstance])
                return
            }
        }

        classInstance.properties = params

        if (!classInstance.save(flush: true)) {
            render(view: "edit", model: [classInstance: classInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'class.label', default: 'Class'), classInstance.id])
        redirect(action: "show", id: classInstance.id)
    }

    def delete(Long id) {
        def classInstance = Class.get(id)
        if (!classInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'class.label', default: 'Class'), id])
            redirect(action: "list")
            return
        }

        try {
            classInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'class.label', default: 'Class'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'class.label', default: 'Class'), id])
            redirect(action: "show", id: id)
        }
    }
}
