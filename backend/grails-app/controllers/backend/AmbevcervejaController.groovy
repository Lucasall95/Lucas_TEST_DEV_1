package backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AmbevcervejaController {

    AmbevcervejaService ambevcervejaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ambevcervejaService.list(params), model:[ambevcervejaCount: ambevcervejaService.count()]
    }

    def show(Long id) {
        respond ambevcervejaService.get(id)
    }

    def create() {
        respond new Ambevcerveja(params)
    }

    def save(Ambevcerveja ambevcerveja) {
        if (ambevcerveja == null) {
            notFound()
            return
        }

        try {
            ambevcervejaService.save(ambevcerveja)
        } catch (ValidationException e) {
            respond ambevcerveja.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ambevcerveja.label', default: 'Ambevcerveja'), ambevcerveja.id])
                redirect ambevcerveja
            }
            '*' { respond ambevcerveja, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ambevcervejaService.get(id)
    }

    def update(Ambevcerveja ambevcerveja) {
        if (ambevcerveja == null) {
            notFound()
            return
        }

        try {
            ambevcervejaService.save(ambevcerveja)
        } catch (ValidationException e) {
            respond ambevcerveja.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ambevcerveja.label', default: 'Ambevcerveja'), ambevcerveja.id])
                redirect ambevcerveja
            }
            '*'{ respond ambevcerveja, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ambevcervejaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ambevcerveja.label', default: 'Ambevcerveja'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ambevcerveja.label', default: 'Ambevcerveja'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
