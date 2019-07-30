package sebo.rural.deploy

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BookController {

    BookService bookService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bookService.list(params)
    }

    def show(Long id) {
        respond bookService.get(id)
    }

    def save(Book book) {
        if (book == null) {
            render status: NOT_FOUND
            return
        }

        try {
            bookService.save(book)
        } catch (ValidationException e) {
            respond book.errors
        }

        respond book, [status: CREATE]
    }

    def update(Book book) {
        if (book == null) {
            render status: NOT_FOUND
            return
        }

        try {
            bookService.save(book)
        } catch (ValidationException e) {
            respond book.errors
            return
        }

        respond book, [status: OK]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        bookService.delete(id)

        render status: NO_CONTENT
    }
}
