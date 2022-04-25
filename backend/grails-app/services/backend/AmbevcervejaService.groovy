package backend

import grails.gorm.services.Service

@Service(Ambevcerveja)
interface AmbevcervejaService {

    Ambevcerveja get(Serializable id)

    List<Ambevcerveja> list(Map args)

    Long count()

    void delete(Serializable id)

    Ambevcerveja save(Ambevcerveja ambevcerveja)

}