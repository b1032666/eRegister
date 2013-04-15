package eregister

import org.springframework.dao.DataIntegrityViolationException

class RegClassController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [regClassInstanceList: RegClass.list(params), regClassInstanceTotal: RegClass.count()]
    }

    def create() {
        [regClassInstance: new RegClass(params)]
    }

    def save() {
        def regClassInstance = new RegClass(params)
        if (!regClassInstance.save(flush: true)) {
            render(view: "create", model: [regClassInstance: regClassInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'regClass.label', default: 'RegClass'), regClassInstance.id])
        redirect(action: "show", id: regClassInstance.id)
    }

    def show(Long id) {
        def regClassInstance = RegClass.get(id)
        if (!regClassInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regClass.label', default: 'RegClass'), id])
            redirect(action: "list")
            return
        }

        [regClassInstance: regClassInstance]
    }

    def edit(Long id) {
        def regClassInstance = RegClass.get(id)
        if (!regClassInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regClass.label', default: 'RegClass'), id])
            redirect(action: "list")
            return
        }

        [regClassInstance: regClassInstance]
    }

    def update(Long id, Long version) {
        def regClassInstance = RegClass.get(id)
        if (!regClassInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regClass.label', default: 'RegClass'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (regClassInstance.version > version) {
                regClassInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'regClass.label', default: 'RegClass')] as Object[],
                          "Another user has updated this RegClass while you were editing")
                render(view: "edit", model: [regClassInstance: regClassInstance])
                return
            }
        }

        regClassInstance.properties = params

        if (!regClassInstance.save(flush: true)) {
            render(view: "edit", model: [regClassInstance: regClassInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'regClass.label', default: 'RegClass'), regClassInstance.id])
        redirect(action: "show", id: regClassInstance.id)
    }

    def delete(Long id) {
        def regClassInstance = RegClass.get(id)
        if (!regClassInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regClass.label', default: 'RegClass'), id])
            redirect(action: "list")
            return
        }

        try {
            regClassInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'regClass.label', default: 'RegClass'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'regClass.label', default: 'RegClass'), id])
            redirect(action: "show", id: id)
        }
    }
}
