package com.goldragriff.wetalk



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MessageGroupController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MessageGroup.list(params), model:[messageGroupInstanceCount: MessageGroup.count()]
    }

    def show(MessageGroup messageGroupInstance) {
        respond messageGroupInstance
    }

    def create() {
        respond new MessageGroup(params)
    }

    @Transactional
    def save(MessageGroup messageGroupInstance) {
        if (messageGroupInstance == null) {
            notFound()
            return
        }

        if (messageGroupInstance.hasErrors()) {
            respond messageGroupInstance.errors, view:'create'
            return
        }

        messageGroupInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'messageGroup.label', default: 'MessageGroup'), messageGroupInstance.id])
                redirect messageGroupInstance
            }
            '*' { respond messageGroupInstance, [status: CREATED] }
        }
    }

    def edit(MessageGroup messageGroupInstance) {
        respond messageGroupInstance
    }

    @Transactional
    def update(MessageGroup messageGroupInstance) {
        if (messageGroupInstance == null) {
            notFound()
            return
        }

        if (messageGroupInstance.hasErrors()) {
            respond messageGroupInstance.errors, view:'edit'
            return
        }

        messageGroupInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MessageGroup.label', default: 'MessageGroup'), messageGroupInstance.id])
                redirect messageGroupInstance
            }
            '*'{ respond messageGroupInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MessageGroup messageGroupInstance) {

        if (messageGroupInstance == null) {
            notFound()
            return
        }

        messageGroupInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MessageGroup.label', default: 'MessageGroup'), messageGroupInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'messageGroup.label', default: 'MessageGroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
