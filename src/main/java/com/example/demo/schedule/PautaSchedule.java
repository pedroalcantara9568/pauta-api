package com.example.demo.schedule;

import com.example.demo.domain.Pauta;
import com.example.demo.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class PautaSchedule {

    private final PautaService pautaService;

    @Autowired
    public PautaSchedule(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Scheduled(fixedDelay = 1000)
    public void verificarTempoPautas() {
        pautaService.consultarPautasAbertas().stream()
                .filter(Pauta::estahFechada)
                .forEach(pautaService::atualizarPauta);
    }
}
