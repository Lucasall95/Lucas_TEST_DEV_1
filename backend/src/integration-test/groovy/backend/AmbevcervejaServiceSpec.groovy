package backend

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AmbevcervejaServiceSpec extends Specification {

    AmbevcervejaService ambevcervejaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ambevcerveja(...).save(flush: true, failOnError: true)
        //new Ambevcerveja(...).save(flush: true, failOnError: true)
        //Ambevcerveja ambevcerveja = new Ambevcerveja(...).save(flush: true, failOnError: true)
        //new Ambevcerveja(...).save(flush: true, failOnError: true)
        //new Ambevcerveja(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ambevcerveja.id
    }

    void "test get"() {
        setupData()

        expect:
        ambevcervejaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ambevcerveja> ambevcervejaList = ambevcervejaService.list(max: 2, offset: 2)

        then:
        ambevcervejaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ambevcervejaService.count() == 5
    }

    void "test delete"() {
        Long ambevcervejaId = setupData()

        expect:
        ambevcervejaService.count() == 5

        when:
        ambevcervejaService.delete(ambevcervejaId)
        sessionFactory.currentSession.flush()

        then:
        ambevcervejaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ambevcerveja ambevcerveja = new Ambevcerveja()
        ambevcervejaService.save(ambevcerveja)

        then:
        ambevcerveja.id != null
    }
}
