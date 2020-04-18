package uz.ita.assistance.service;

import uz.ita.assistance.entity.InsuredEvent;
import uz.ita.assistance.entity.InsuredEventStatus;

public interface InsuredEventService {
    String NAME = "assistance_InsuredEventService";

    void setState (InsuredEvent insuredEvent, InsuredEventStatus insuredEventStatus);
}
