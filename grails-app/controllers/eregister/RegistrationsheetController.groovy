package eregister

import org.springframework.dao.DataIntegrityViolationException

class RegistrationsheetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [registrationsheetInstanceList: Registrationsheet.list(params), registrationsheetInstanceTotal: Registrationsheet.count()]
    }

    def create() {
        [registrationsheetInstance: new Registrationsheet(params)]
    }

    def save() {
        def registrationsheetInstance = new Registrationsheet(params)
        if (!registrationsheetInstance.save(flush: true)) {
            render(view: "create", model: [registrationsheetInstance: registrationsheetInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), registrationsheetInstance.id])
        redirect(action: "show", id: registrationsheetInstance.id)
    }

    def show(Long id) {
        def registrationsheetInstance = Registrationsheet.get(id)
        if (!registrationsheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), id])
            redirect(action: "list")
            return
        }

        [registrationsheetInstance: registrationsheetInstance]
    }

    def edit(Long id) {
        def registrationsheetInstance = Registrationsheet.get(id)
        if (!registrationsheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), id])
            redirect(action: "list")
            return
        }

        [registrationsheetInstance: registrationsheetInstance]
    }

    def update(Long id, Long version) {
        def registrationsheetInstance = Registrationsheet.get(id)
        if (!registrationsheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (registrationsheetInstance.version > version) {
                registrationsheetInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'registrationsheet.label', default: 'Registrationsheet')] as Object[],
                          "Another user has updated this Registrationsheet while you were editing")
                render(view: "edit", model: [registrationsheetInstance: registrationsheetInstance])
                return
            }
        }

        registrationsheetInstance.properties = params

        if (!registrationsheetInstance.save(flush: true)) {
            render(view: "edit", model: [registrationsheetInstance: registrationsheetInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), registrationsheetInstance.id])
        redirect(action: "show", id: registrationsheetInstance.id)
    }

    def delete(Long id) {
        def registrationsheetInstance = Registrationsheet.get(id)
        if (!registrationsheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), id])
            redirect(action: "list")
            return
        }

        try {
            registrationsheetInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet'), id])
            redirect(action: "show", id: id)
        }
    }
}
