package uz.ita.assistance.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;
import uz.ita.assistance.entity.InsuredEvent;
import uz.ita.assistance.entity.InsuredEventStatus;

import javax.inject.Inject;
import java.util.Objects;

@Service(InsuredEventService.NAME)
public class InsuredEventServiceBean implements InsuredEventService {

    @Inject
    private Persistence persistence;

    public void setState (InsuredEvent insuredEvent, InsuredEventStatus insuredEventStatus) {
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            insuredEvent.setStatus(insuredEventStatus);
            em.merge(insuredEvent);
            tx.commit();
        }
    }

}
