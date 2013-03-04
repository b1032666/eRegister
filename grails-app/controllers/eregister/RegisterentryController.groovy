package eregister

import org.springframework.dao.DataIntegrityViolationException

class RegisterentryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [registerentryInstanceList: Registerentry.list(params), registerentryInstanceTotal: Registerentry.count()]
    }

    def create() {
        [registerentryInstance: new Registerentry(params)]
    }

    def save() {
        def registerentryInstance = new Registerentry(params)
        if (!registerentryInstance.save(flush: true)) {
            render(view: "create", model: [registerentryInstance: registerentryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), registerentryInstance.id])
        redirect(action: "show", id: registerentryInstance.id)
    }

    def show(Long id) {
        def registerentryInstance = Registerentry.get(id)
        if (!registerentryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), id])
            redirect(action: "list")
            return
        }

        [registerentryInstance: registerentryInstance]
    }

    def edit(Long id) {
        def registerentryInstance = Registerentry.get(id)
        if (!registerentryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), id])
            redirect(action: "list")
            return
        }

        [registerentryInstance: registerentryInstance]
    }

    def update(Long id, Long version) {
        def registerentryInstance = Registerentry.get(id)
        if (!registerentryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (registerentryInstance.version > version) {
                registerentryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'registerentry.label', default: 'Registerentry')] as Object[],
                          "Another user has updated this Registerentry while you were editing")
                render(view: "edit", model: [registerentryInstance: registerentryInstance])
                return
            }
        }

        registerentryInstance.properties = params

        if (!registerentryInstance.save(flush: true)) {
            render(view: "edit", model: [registerentryInstance: registerentryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), registerentryInstance.id])
        redirect(action: "show", id: registerentryInstance.id)
    }

    def delete(Long id) {
        def registerentryInstance = Registerentry.get(id)
        if (!registerentryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), id])
            redirect(action: "list")
            return
        }

        try {
            registerentryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'registerentry.label', default: 'Registerentry'), id])
            redirect(action: "show", id: id)
        }
    }
}
